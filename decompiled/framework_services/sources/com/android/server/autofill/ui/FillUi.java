package com.android.server.autofill.ui;

import android.R;
import android.app.PendingIntent;
import android.content.Context;
import android.content.IntentSender;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.pico.utils.ExtImplFactory;
import android.service.autofill.Dataset;
import android.service.autofill.FillResponse;
import android.text.TextUtils;
import android.util.PluralsMessageFormatter;
import android.util.Slog;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.view.autofill.AutofillId;
import android.view.autofill.AutofillValue;
import android.view.autofill.IAutofillWindowPresenter;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RemoteViews;
import android.widget.TextView;
import com.android.server.UiThread;
import com.android.server.am.AssistDataRequester;
import com.android.server.autofill.AutofillManagerService;
import com.android.server.autofill.Helper;
import com.android.server.pm.PackageManagerService;
import com.android.server.utils.Slogf;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/* JADX INFO: loaded from: classes.dex */
final class FillUi {
    private static final String TAG = "FillUi";
    private static final int THEME_ID_DARK = 16975023;
    private static final int THEME_ID_LIGHT = 16975036;
    private static final TypedValue sTempTypedValue = null;
    private final ItemsAdapter mAdapter;
    private AnnounceFilterResult mAnnounceFilterResult;
    private final Callback mCallback;
    private int mContentHeight;
    private int mContentWidth;
    private final Context mContext;
    private boolean mDestroyed;
    private IExtFillUi mExt;
    private String mFilterText;
    private View mFooter;
    private final boolean mFullScreen;
    private final View mHeader;
    private final boolean mIsCredmanAutofillSession;
    private final ListView mListView;
    private int mMaxInputLengthForAutofill;
    private final Point mTempPoint;
    private final int mThemeId;
    private final Context mUserContext;
    private final int mVisibleDatasetsMaxCount;
    private final AnchoredWindow mWindow;
    private final WindowManager mWindowManager;
    private final AutofillWindowPresenter mWindowPresenter;

    final class AnchoredWindow {
        private final View mContentView;
        private final OverlayControl mOverlayControl;
        private WindowManager.LayoutParams mShowParams;
        private boolean mShowing;
        private final WindowManager mWm;
        final /* synthetic */ FillUi this$0;

        /* JADX INFO: renamed from: -$$Nest$fgetmContentView, reason: not valid java name */
        static /* bridge */ /* synthetic */ View m2437$$Nest$fgetmContentView(AnchoredWindow r0) {
            return r0.mContentView;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmShowParams, reason: not valid java name */
        static /* bridge */ /* synthetic */ WindowManager.LayoutParams m2438$$Nest$fgetmShowParams(AnchoredWindow r0) {
            return r0.mShowParams;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmShowing, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m2439$$Nest$fgetmShowing(AnchoredWindow r0) {
            return r0.mShowing;
        }

        AnchoredWindow(FillUi this$0, View contentView, OverlayControl overlayControl) {
            this.this$0 = this$0;
            this.mWm = (WindowManager) contentView.getContext().getSystemService(WindowManager.class);
            this.mContentView = contentView;
            this.mOverlayControl = overlayControl;
        }

        public void show(WindowManager.LayoutParams params) {
            this.mShowParams = params;
            if (Helper.sVerbose == false) goto L24;
            Slog.v(FillUi.TAG, "show(): showing=" + this.mShowing + ", params=" + Helper.paramsToString(params));
        L24:
            params.packageName = PackageManagerService.PLATFORM_PACKAGE_NAME;     // Catch: IllegalStateException -> L12 WindowManager.BadTokenException -> L14
            params.setTitle("Autofill UI");     // Catch: IllegalStateException -> L12 WindowManager.BadTokenException -> L14
            if (this.mShowing == true) goto L16;
            params.accessibilityTitle = this.mContentView.getContext().getString(R.string.back_button_label);     // Catch: IllegalStateException -> L12 WindowManager.BadTokenException -> L14
            this.mWm.addView(this.mContentView, params);     // Catch: IllegalStateException -> L12 WindowManager.BadTokenException -> L14
            this.mOverlayControl.hideOverlays();     // Catch: IllegalStateException -> L12 WindowManager.BadTokenException -> L14
            this.mShowing = true;     // Catch: IllegalStateException -> L12 WindowManager.BadTokenException -> L14
            if (FillUi.m2430$$Nest$fgetmAdapter(this.this$0) != null) goto L10;
            int numShownDatasets = 0;
        L11:
            FillUi.m2431$$Nest$fgetmCallback(this.this$0).onShown(numShownDatasets);     // Catch: IllegalStateException -> L12 WindowManager.BadTokenException -> L14
            return;
        L10:
            numShownDatasets = FillUi.m2430$$Nest$fgetmAdapter(this.this$0).getCount();     // Catch: IllegalStateException -> L12 WindowManager.BadTokenException -> L14
            goto L11
        L16:
            this.mWm.updateViewLayout(this.mContentView, params);     // Catch: IllegalStateException -> L12 WindowManager.BadTokenException -> L14
            return;
        L12:
            e = move-exception;
            Slog.wtf(FillUi.TAG, "Exception showing window " + params, e);
            FillUi.m2431$$Nest$fgetmCallback(this.this$0).onDestroy();
            return;
        L20:
            if (Helper.sDebug == false) goto L22;
            Slog.d(FillUi.TAG, "Filed with with token " + params.token + " gone.");
        L22:
            FillUi.m2431$$Nest$fgetmCallback(this.this$0).onDestroy();
        }

        void hide() {
            hide(true);
        }

        void hide(boolean destroyCallbackOnError) {
            /*  JADX ERROR: Simple mode code generation failed
                java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
                	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
                	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
                	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
                	at java.base/java.util.Objects.checkIndex(Objects.java:365)
                	at java.base/java.util.ArrayList.get(ArrayList.java:428)
                	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:354)
                	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
                	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
                	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
                	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
                	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
                	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
                	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:297)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
                	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
                	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
                	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
                	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
                	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
                	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
                	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
                	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
                	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
                	at jadx.core.ProcessClass.process(ProcessClass.java:89)
                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
                	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
                	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
                */
            /*
                this = this;
                boolean r0 = r3.mShowing     // Catch: java.lang.Throwable -> Lf java.lang.IllegalStateException -> L11
                if (r0 == 0) goto L13
                android.view.WindowManager r0 = r3.mWm     // Catch: java.lang.Throwable -> Lf java.lang.IllegalStateException -> L11
                android.view.View r1 = r3.mContentView     // Catch: java.lang.Throwable -> Lf java.lang.IllegalStateException -> L11
                r0.removeView(r1)     // Catch: java.lang.Throwable -> Lf java.lang.IllegalStateException -> L11
                r0 = 0
                r3.mShowing = r0     // Catch: java.lang.Throwable -> Lf java.lang.IllegalStateException -> L11
                goto L13
            Lf:
                r0 = move-exception
                goto L2e
            L11:
                r0 = move-exception
                goto L19
            L13:
                com.android.server.autofill.ui.OverlayControl r0 = r3.mOverlayControl
                r0.showOverlays()
                goto L2d
            L19:
                java.lang.String r1 = "FillUi"
                java.lang.String r2 = "Exception hiding window "
                android.util.Slog.e(r1, r2, r0)     // Catch: java.lang.Throwable -> Lf
                if (r4 == 0) goto L13
                com.android.server.autofill.ui.FillUi r1 = r3.this$0     // Catch: java.lang.Throwable -> Lf
                com.android.server.autofill.ui.FillUi$Callback r1 = com.android.server.autofill.ui.FillUi.m2431$$Nest$fgetmCallback(r1)     // Catch: java.lang.Throwable -> Lf
                r1.onDestroy()     // Catch: java.lang.Throwable -> Lf
                goto L13
            L2d:
                return
            L2e:
                com.android.server.autofill.ui.OverlayControl r1 = r3.mOverlayControl
                r1.showOverlays()
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.android.server.autofill.ui.FillUi.AnchoredWindow.hide(boolean):void");
        }
    }

    private final class AnnounceFilterResult implements Runnable {
        private static final int SEARCH_RESULT_ANNOUNCEMENT_DELAY = 1000;
        final /* synthetic */ FillUi this$0;

        /* synthetic */ AnnounceFilterResult(FillUi r1, FillUiIA r2) {
            this(r1);
        }

        private AnnounceFilterResult(FillUi r1) {
            this.this$0 = r1;
        }

        public void post() {
            remove();
            FillUi.m2434$$Nest$fgetmListView(this.this$0).postDelayed(this, 1000);
        }

        public void remove() {
            FillUi.m2434$$Nest$fgetmListView(this.this$0).removeCallbacks(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            int count = FillUi.m2434$$Nest$fgetmListView(this.this$0).getAdapter().getCount();
            if (count > 0) goto L5;
            String text = FillUi.m2432$$Nest$fgetmContext(this.this$0).getString(R.string.badPin);
        L6:
            FillUi.m2434$$Nest$fgetmListView(this.this$0).announceForAccessibility(text);
            return;
        L5:
            Map<String, Object> arguments = new HashMap();
            arguments.put(AssistDataRequester.KEY_RECEIVER_EXTRA_COUNT, Integer.valueOf(count));
            text = PluralsMessageFormatter.format(FillUi.m2432$$Nest$fgetmContext(this.this$0).getResources(), arguments, R.string.badPuk);
            goto L6
        }
    }

    private final class AutofillWindowPresenter extends IAutofillWindowPresenter.Stub {
        final /* synthetic */ FillUi this$0;

        public static /* synthetic */ void $r8$lambda$H_bip79jnR6ykgyoL7RtpFv3ujg(AutofillWindowPresenter r0) {
            r0.lambda$hide$1();
        }

        public static /* synthetic */ void $r8$lambda$rayRxR7zWVCJ_EZ9KlZ9jO79cqM(AutofillWindowPresenter r0, WindowManager.LayoutParams r1) {
            r0.lambda$show$0(r1);
        }

        /* synthetic */ AutofillWindowPresenter(FillUi r1, FillUiIA r2) {
            this(r1);
        }

        private AutofillWindowPresenter(FillUi r1) {
            this.this$0 = r1;
        }

        public void show(final WindowManager.LayoutParams p, Rect transitionEpicenter, boolean fitsSystemWindows, int layoutDirection) {
            if (Helper.sVerbose == false) goto L5;
            Slog.v(FillUi.TAG, "AutofillWindowPresenter.show(): fit=" + fitsSystemWindows + ", params=" + Helper.paramsToString(p));
        L5:
            UiThread.getHandler().post(new FillUi$AutofillWindowPresenter$$ExternalSyntheticLambda1(this, p));
        }

        private /* synthetic */ void lambda$show$0(WindowManager.LayoutParams p) {
            if (FillUi.m2435$$Nest$fgetmWindow(this.this$0) == null) goto L6;
            FillUi.m2433$$Nest$fgetmExt(this.this$0).setFillHeight(p);
            FillUi.m2435$$Nest$fgetmWindow(this.this$0).show(p);
            return;
        }

        public void hide(Rect transitionEpicenter) {
            UiThread.getHandler().post(new FillUi$AutofillWindowPresenter$$ExternalSyntheticLambda0(this));
        }

        private /* synthetic */ void lambda$hide$1() {
            if (FillUi.m2435$$Nest$fgetmWindow(this.this$0) == null) goto L6;
            FillUi.m2435$$Nest$fgetmWindow(this.this$0).hide();
            return;
        }
    }

    interface Callback {
        void cancelSession();

        void dispatchUnhandledKey(KeyEvent r1);

        void onCanceled();

        void onDatasetPicked(Dataset r1);

        void onDestroy();

        void onResponsePicked(FillResponse r1);

        void onShown(int r1);

        void requestHideFillUi();

        void requestHideFillUiWhenDestroyed();

        void requestShowFillUi(int r1, int r2, IAutofillWindowPresenter r3);

        void startIntentSender(IntentSender r1);
    }

    private final class ItemsAdapter extends BaseAdapter implements Filterable {
        private final List<ViewItem> mAllItems;
        private final List<ViewItem> mFilteredItems;
        final /* synthetic */ FillUi this$0;

        /* JADX INFO: renamed from: com.android.server.autofill.ui.FillUi$ItemsAdapter$1, reason: invalid class name */
        class AnonymousClass1 extends Filter {
            final /* synthetic */ ItemsAdapter this$1;

            /* JADX INFO: renamed from: $r8$lambda$cSWGi-IC5P3ZQdNhbkMK4A9sHwU, reason: not valid java name */
            public static /* synthetic */ boolean m2442$r8$lambda$cSWGiIC5P3ZQdNhbkMK4A9sHwU(CharSequence r0, ViewItem r1) {
                return lambda$performFiltering$0(r0, r1);
            }

            AnonymousClass1(ItemsAdapter this$1) {
                this.this$1 = this$1;
            }

            @Override // android.widget.Filter
            protected Filter.FilterResults performFiltering(final CharSequence filterText) {
                List<ViewItem> filtered = (List) ItemsAdapter.m2440$$Nest$fgetmAllItems(this.this$1).stream().filter(new FillUi$ItemsAdapter$1$$ExternalSyntheticLambda0(filterText)).collect(Collectors.toList());
                Filter.FilterResults results = new Filter.FilterResults();
                results.values = filtered;
                results.count = filtered.size();
                return results;
            }

            private static /* synthetic */ boolean lambda$performFiltering$0(CharSequence filterText, ViewItem item) {
                return item.matches(filterText);
            }

            @Override // android.widget.Filter
            protected void publishResults(CharSequence constraint, Filter.FilterResults results) {
                int oldItemCount = ItemsAdapter.m2441$$Nest$fgetmFilteredItems(this.this$1).size();
                ItemsAdapter.m2441$$Nest$fgetmFilteredItems(this.this$1).clear();
                if (results.count <= 0) goto L6;
                List<ViewItem> items = (List) results.values;
                ItemsAdapter.m2441$$Nest$fgetmFilteredItems(this.this$1).addAll(items);
            L6:
                if (oldItemCount == ItemsAdapter.m2441$$Nest$fgetmFilteredItems(this.this$1).size()) goto L8;
                boolean resultCountChanged = true;
            L9:
                if (resultCountChanged == false) goto L11;
                FillUi.m2436$$Nest$mannounceSearchResultIfNeeded(this.this$1.this$0);
            L11:
                this.this$1.notifyDataSetChanged();
                return;
            L8:
                resultCountChanged = false;
                goto L9
            }
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmAllItems, reason: not valid java name */
        static /* bridge */ /* synthetic */ List m2440$$Nest$fgetmAllItems(ItemsAdapter r0) {
            return r0.mAllItems;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmFilteredItems, reason: not valid java name */
        static /* bridge */ /* synthetic */ List m2441$$Nest$fgetmFilteredItems(ItemsAdapter r0) {
            return r0.mFilteredItems;
        }

        @Override // android.widget.Adapter
        public /* bridge */ /* synthetic */ Object getItem(int r1) {
            return getItem(r1);
        }

        ItemsAdapter(FillUi r1, List<ViewItem> items) {
            this.this$0 = r1;
            this.mFilteredItems = new ArrayList();
            this.mAllItems = Collections.unmodifiableList(new ArrayList(items));
            this.mFilteredItems.addAll(items);
        }

        @Override // android.widget.Filterable
        public Filter getFilter() {
            return new AnonymousClass1(this);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.mFilteredItems.size();
        }

        @Override // android.widget.Adapter
        public ViewItem getItem(int position) {
            return this.mFilteredItems.get(position);
        }

        @Override // android.widget.Adapter
        public long getItemId(int position) {
            return position;
        }

        @Override // android.widget.Adapter
        public View getView(int position, View convertView, ViewGroup parent) {
            return getItem(position).view;
        }

        public String toString() {
            return "ItemsAdapter: [all=" + this.mAllItems + ", filtered=" + this.mFilteredItems + "]";
        }
    }

    private static class ViewItem {
        public final Dataset dataset;
        public final Pattern filter;
        public final boolean filterable;
        public final String value;
        public final View view;

        ViewItem(Dataset dataset, Pattern filter, boolean filterable, String value, View view) {
            this.dataset = dataset;
            this.value = value;
            this.view = view;
            this.filter = filter;
            this.filterable = filterable;
        }

        public boolean matches(CharSequence filterText) {
            if (TextUtils.isEmpty(filterText) == false) goto L6;
            return true;
        L6:
            if (this.filterable == true) goto L8;
            return false;
        L8:
            String constraintLowerCase = filterText.toString().toLowerCase();
            if (this.filter == null) goto L13;
            return this.filter.matcher(constraintLowerCase).matches();
        L13:
            if (this.value != null) goto L19;
            if (this.dataset.getAuthentication() != null) goto L20;
            return true;
        L20:
            return false;
        L19:
            return this.value.toLowerCase().startsWith(constraintLowerCase);
        }

        public String toString() {
            StringBuilder builder = new StringBuilder("ViewItem:[view=").append(this.view.getAutofillId());
            if (this.dataset != null) goto L5;
            String datasetId = null;
        L6:
            if (datasetId == null) goto L9;
            builder.append(", dataset=");
            builder.append(datasetId);
        L9:
            if (this.value == null) goto L12;
            builder.append(", value=");
            builder.append(this.value.length());
            builder.append("_chars");
        L12:
            if (this.filterable == false) goto L15;
            builder.append(", filterable");
        L15:
            if (this.filter == null) goto L17;
            builder.append(", filter=");
            builder.append(this.filter.pattern().length());
            builder.append("_chars");
        L17:
            builder.append(']');
            return builder.toString();
        L5:
            datasetId = this.dataset.getId();
            goto L6
        }
    }

    public static /* synthetic */ boolean $r8$lambda$34G_vgWdPNb_VNs6BEExHzv5Pk8(View r0, PendingIntent r1, RemoteViews.RemoteResponse r2) {
        return lambda$newInteractionBlocker$6(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$7F2rvuaWbO6qvVHwfQ3qB74qekA(FillUi r0, FillResponse r1, View r2) {
        r0.lambda$new$2(r1, r2);
    }

    public static /* synthetic */ boolean $r8$lambda$8YFNiTVCPCYpyFFOF5e2Jdn6KRc(FillUi r0, View r1, KeyEvent r2) {
        return r0.lambda$new$0(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$KryltzAJDRfLvAXPjRUB95Qbh0Q(FillUi r0, Dataset r1, View r2) {
        r0.lambda$new$3(r1, r2);
    }

    public static /* synthetic */ boolean $r8$lambda$XCOe_IjVqT1Jpeqy78g9tVUVGAg(FillUi r0, View r1, PendingIntent r2, RemoteViews.RemoteResponse r3) {
        return r0.lambda$new$1(r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$hlZkhNRIhvgVnuIz4QbJ_CPrMCs(FillUi r0, int r1, int r2) {
        r0.lambda$applyNewFilterText$7(r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$sWAG5jaC8KAFACD7R8-PM4Zjm9s, reason: not valid java name */
    public static /* synthetic */ void m2429$r8$lambda$sWAG5jaC8KAFACD7R8PM4Zjm9s(FillUi r0, AdapterView r1, View r2, int r3, long r4) {
        r0.lambda$new$4(r1, r2, r3, r4);
    }

    public static /* synthetic */ void $r8$lambda$urMFEkR1A2bMKiddnOYc1HMe0Ec(FillUi r0, View r1) {
        r0.lambda$applyCancelAction$5(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAdapter, reason: not valid java name */
    static /* bridge */ /* synthetic */ ItemsAdapter m2430$$Nest$fgetmAdapter(FillUi r0) {
        return r0.mAdapter;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCallback, reason: not valid java name */
    static /* bridge */ /* synthetic */ Callback m2431$$Nest$fgetmCallback(FillUi r0) {
        return r0.mCallback;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m2432$$Nest$fgetmContext(FillUi r0) {
        return r0.mContext;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmExt, reason: not valid java name */
    static /* bridge */ /* synthetic */ IExtFillUi m2433$$Nest$fgetmExt(FillUi r0) {
        return r0.mExt;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmListView, reason: not valid java name */
    static /* bridge */ /* synthetic */ ListView m2434$$Nest$fgetmListView(FillUi r0) {
        return r0.mListView;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmWindow, reason: not valid java name */
    static /* bridge */ /* synthetic */ AnchoredWindow m2435$$Nest$fgetmWindow(FillUi r0) {
        return r0.mWindow;
    }

    /* JADX INFO: renamed from: -$$Nest$mannounceSearchResultIfNeeded, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2436$$Nest$mannounceSearchResultIfNeeded(FillUi r0) {
        r0.announceSearchResultIfNeeded();
    }

    static {
        sTempTypedValue = new TypedValue();
    }

    public static boolean isFullScreen(Context context) {
        if (Helper.sFullScreenMode == null) goto L10;
        if (Helper.sVerbose == false) goto L8;
        Slog.v(TAG, "forcing full-screen mode to " + Helper.sFullScreenMode);
    L8:
        return Helper.sFullScreenMode.booleanValue();
    L10:
        return context.getPackageManager().hasSystemFeature("android.software.leanback");
    }

    FillUi(Context context, final FillResponse response, AutofillId focusedViewId, String filterText, OverlayControl overlayControl, CharSequence serviceLabel, Drawable serviceIcon, boolean nightMode, int maxInputLengthForAutofill, Callback callback) {
        this.mTempPoint = new Point();
        this.mWindowPresenter = new AutofillWindowPresenter(this, null);
        this.mExt = (IExtFillUi) ExtImplFactory.getImpl(IExtFillUi.class, new Object[]{this});
        if (Helper.sVerbose == false) goto L5;
        Slogf.v(TAG, "nightMode: %b displayId: %d", new Object[]{Boolean.valueOf(nightMode), Integer.valueOf(context.getDisplayId())});
    L5:
        if (nightMode == false) goto L7;
        int r0 = 16975023;
    L8:
        this.mThemeId = r0;
        this.mCallback = callback;
        this.mFullScreen = isFullScreen(context);
        this.mContext = new ContextThemeWrapper(context, this.mThemeId);
        this.mUserContext = Helper.getUserContext(this.mContext);
        this.mMaxInputLengthForAutofill = maxInputLengthForAutofill;
        if ((response.getFlags() & 8) == 0) goto L11;
        boolean r1 = true;
    L12:
        this.mIsCredmanAutofillSession = r1;
        this.mWindowManager = (WindowManager) this.mContext.getSystemService(WindowManager.class);
        LayoutInflater inflater = LayoutInflater.from(this.mContext);
        RemoteViews headerPresentation = Helper.sanitizeRemoteView(response.getHeader());
        RemoteViews footerPresentation = Helper.sanitizeRemoteView(response.getFooter());
        if (this.mFullScreen == false) goto L15;
        ViewGroup decor = (ViewGroup) inflater.inflate(R.layout.autofill_save, null);
    L22:
        decor.setClipToOutline(true);
        TextView titleView = (TextView) decor.findViewById(R.id.autofill_dialog_container);
        if (titleView == null) goto L25;
        titleView.setText(this.mContext.getString(R.string.biometric_or_screen_lock_app_setting_name, new Object[]{serviceLabel}));
    L25:
        ImageView iconView = (ImageView) decor.findViewById(R.id.autofill_dataset_list);
        if (iconView == null) goto L30;
        iconView.setImageDrawable(serviceIcon);
    L30:
        if (this.mFullScreen == false) goto L35;
        Point outPoint = this.mTempPoint;
        this.mContext.getDisplayNoVerify().getSize(outPoint);
        this.mContentWidth = -1;
        this.mContentHeight = outPoint.y / 2;
        if (Helper.sVerbose == false) goto L35;
        Slog.v(TAG, "initialized fillscreen LayoutParams " + this.mContentWidth + "," + this.mContentHeight);
    L35:
        decor.addOnUnhandledKeyEventListener(new FillUi$$ExternalSyntheticLambda3(this));
        if (AutofillManagerService.getVisibleDatasetsMaxCount() <= 0) goto L40;
        this.mVisibleDatasetsMaxCount = AutofillManagerService.getVisibleDatasetsMaxCount();
        if (Helper.sVerbose == false) goto L41;
        Slog.v(TAG, "overriding maximum visible datasets to " + this.mVisibleDatasetsMaxCount);
    L41:
        RemoteViews.InteractionHandler interceptionHandler = new FillUi$$ExternalSyntheticLambda4(this);
        if (response.getAuthentication() == null) goto L68;
        this.mHeader = null;
        this.mListView = null;
        this.mFooter = null;
        this.mAdapter = null;
        ViewGroup container = (ViewGroup) decor.findViewById(R.id.autofill_dataset_title);
    L60:
        e = e;
    L66:
        callback.onCanceled();
        Slog.e(TAG, "Error inflating remote views", e);
        this.mWindow = null;
        return;
    L45:
        if (Helper.sanitizeRemoteView(response.getPresentation()) == null) goto L162;
        View content = response.getPresentation().applyWithTheme(this.mUserContext, decor, interceptionHandler, this.mThemeId);     // Catch: RuntimeException -> L58
        container.addView(content);     // Catch: RuntimeException -> L58
        container.setFocusable(true);
        container.setOnClickListener(new FillUi$$ExternalSyntheticLambda5(this, response));
        if (this.mFullScreen == true) goto L57;
        Point maxSize = this.mTempPoint;
        resolveMaxWindowSize(this.mContext, maxSize);
        ViewGroup.LayoutParams r7 = content.getLayoutParams();
        if (this.mFullScreen == false) goto L54;
        int r10 = maxSize.x;
    L55:
        r7.width = r10;
        content.getLayoutParams().height = -2;
        int widthMeasureSpec = View.MeasureSpec.makeMeasureSpec(maxSize.x, Integer.MIN_VALUE);
        int heightMeasureSpec = View.MeasureSpec.makeMeasureSpec(maxSize.y, Integer.MIN_VALUE);
        decor.measure(widthMeasureSpec, heightMeasureSpec);
        this.mContentWidth = content.getMeasuredWidth();
        this.mContentHeight = content.getMeasuredHeight();
        goto L57
    L54:
        r10 = -2;
    L57:
        this.mWindow = new AnchoredWindow(this, decor, overlayControl);
        requestShowFillUi();
        return;
    L58:
        e = e;
        goto L66
    L162:
    L65:
        e = e;
        goto L66
    L64:
        throw new RuntimeException("Permission error accessing RemoteView");     // Catch: RuntimeException -> L65
    L68:
        int datasetCount = response.getDatasets().size();
        if (Helper.sVerbose == false) goto L71;
        Slog.v(TAG, "Number datasets: " + datasetCount + " max visible: " + this.mVisibleDatasetsMaxCount);
    L71:
        RemoteViews.InteractionHandler interactionBlocker = null;
        if (headerPresentation == null) goto L77;
        interactionBlocker = newInteractionBlocker();
        this.mHeader = headerPresentation.applyWithTheme(this.mUserContext, null, interactionBlocker, this.mThemeId);
        LinearLayout headerContainer = (LinearLayout) decor.findViewById(R.id.autofill_dataset_icon);
        applyCancelAction(this.mHeader, response.getCancelIds());
        if (Helper.sVerbose == false) goto L76;
        Slog.v(TAG, "adding header");
    L76:
        headerContainer.addView(this.mHeader);
        headerContainer.setVisibility(0);
    L79:
        if (footerPresentation != null) goto L81;
    L92:
        this.mFooter = null;
        RemoteViews.InteractionHandler interactionBlocker2 = interactionBlocker;
    L93:
        ArrayList<ViewItem> items = new ArrayList(datasetCount);
        int i = 0;
    L94:
        if (i >= datasetCount) goto L146;
        final Dataset dataset = (Dataset) response.getDatasets().get(i);
        int datasetCount2 = datasetCount;
        int index = dataset.getFieldIds().indexOf(focusedViewId);
        if (index < 0) goto L144;
        RemoteViews.InteractionHandler interactionBlocker3 = interactionBlocker2;
        RemoteViews presentation = Helper.sanitizeRemoteView(dataset.getFieldPresentation(index));
        if (presentation != null) goto L100;
        StringBuilder r2 = new StringBuilder();
        int i2 = i;
        r2.append("not displaying UI on field ");
        r2.append(focusedViewId);
        r2.append(" because service didn't provide a presentation for it on ");
        r2.append(dataset);
        Slog.w(TAG, r2.toString());
        interceptionHandler = interceptionHandler;
        RemoteViews footerPresentation2 = footerPresentation;
    L145:
        i = i2 + 1;
        datasetCount = datasetCount2;
        interactionBlocker2 = interactionBlocker3;
        footerPresentation = footerPresentation2;
        interceptionHandler = interceptionHandler;
        goto L94
    L100:
        i2 = i;
    L141:
        e = e;
        footerPresentation2 = footerPresentation;
    L143:
        Slog.e(TAG, "Error inflating remote views", e);
        goto L145
    L102:
        if (Helper.sVerbose == true) goto L152;
    L107:
        footerPresentation2 = footerPresentation;
        View view = presentation.applyWithTheme(this.mUserContext, null, interceptionHandler, this.mThemeId);     // Catch: RuntimeException -> L139
        Dataset.DatasetFieldFilter filter = dataset.getFilter(index);
        String valueText = null;
        if (filter != null) goto L118;
        interceptionHandler = interceptionHandler;
        AutofillValue value = (AutofillValue) dataset.getFieldValues().get(index);
        if (value != null) goto L115;
    L117:
        Pattern filterPattern = null;
        String valueText2 = valueText;
        boolean filterable = true;
    L126:
        applyCancelAction(view, response.getCancelIds());
        if ("PINNED_DATASET_ID".equals(dataset.getId()) == false) goto L138;
        if (this.mIsCredmanAutofillSession == false) goto L138;
        if (items.isEmpty() == true) goto L138;
        LinearLayout footerContainer = (LinearLayout) decor.findViewById(R.id.autofill_dataset_header);
        if (Helper.sVerbose == false) goto L135;
        Slog.v(TAG, "adding footer");
    L135:
        this.mFooter = view;
        footerContainer.addView(this.mFooter);
        footerContainer.setVisibility(0);
        footerContainer.setClickable(true);
        footerContainer.setOnClickListener(new FillUi$$ExternalSyntheticLambda6(this, dataset));
    L138:
        items.add(new ViewItem(dataset, filterPattern, filterable, valueText2, view));
        goto L145
    L115:
        if (value.isText() == false) goto L117;
        valueText = value.getTextValue().toString().toLowerCase();
        goto L117
    L118:
        interceptionHandler = interceptionHandler;
        Pattern filterPattern2 = filter.pattern;
        if (filterPattern2 == null) goto L121;
        filterPattern = filterPattern2;
        valueText2 = null;
        filterable = true;
        goto L126
    L121:
        if (Helper.sVerbose == false) goto L124;
        Slog.v(TAG, "Explicitly disabling filter at id " + focusedViewId + " for dataset #" + index);
    L124:
        filterPattern = filterPattern2;
        valueText2 = null;
        filterable = false;
    L139:
        e = e;
        goto L143
    L152:
        Slog.v(TAG, "setting remote view for " + focusedViewId);     // Catch: RuntimeException -> L105
    L105:
        e = e;
        footerPresentation2 = footerPresentation;
        goto L143
    L144:
        interceptionHandler = interceptionHandler;
        interactionBlocker3 = interactionBlocker2;
        i2 = i;
        footerPresentation2 = footerPresentation;
        goto L145
    L146:
        this.mAdapter = new ItemsAdapter(this, items);
        this.mListView = (ListView) decor.findViewById(R.id.autofill_dataset_picker);
        this.mListView.setAdapter(this.mAdapter);
        this.mListView.setVisibility(0);
        this.mListView.setOnItemClickListener(new FillUi$$ExternalSyntheticLambda7(this));
        this.mExt.setListViewDivider(this.mListView, context);
        if (filterText != null) goto L149;
        this.mFilterText = null;
    L150:
        applyNewFilterText();
        this.mWindow = new AnchoredWindow(this, decor, overlayControl);
        return;
    L149:
        this.mFilterText = filterText.toLowerCase();
        goto L150
    L81:
        if (this.mIsCredmanAutofillSession == true) goto L92;
        LinearLayout footerContainer2 = (LinearLayout) decor.findViewById(R.id.autofill_dataset_header);
        if (footerContainer2 == null) goto L90;
        if (interactionBlocker != null) goto L86;
        interactionBlocker = newInteractionBlocker();
    L86:
        this.mFooter = footerPresentation.applyWithTheme(this.mUserContext, null, interactionBlocker, this.mThemeId);
        applyCancelAction(this.mFooter, response.getCancelIds());
        if (Helper.sVerbose == false) goto L89;
        Slog.v(TAG, "adding footer");
    L89:
        footerContainer2.addView(this.mFooter);
        footerContainer2.setVisibility(0);
    L91:
        interactionBlocker2 = interactionBlocker;
        goto L93
    L90:
        this.mFooter = null;
        goto L91
    L77:
        this.mHeader = null;
        goto L79
    L40:
        this.mVisibleDatasetsMaxCount = this.mContext.getResources().getInteger(R.integer.autofill_max_visible_datasets);
        goto L41
    L15:
        if (headerPresentation != null) goto L21;
        if (footerPresentation != null) goto L21;
        if (this.mIsCredmanAutofillSession == true) goto L21;
        decor = (ViewGroup) inflater.inflate(R.layout.autofill_fill_dialog, null);
    L21:
        decor = (ViewGroup) inflater.inflate(R.layout.breadcrumbs_in_fragment, null);
        goto L22
    L11:
        r1 = false;
        goto L12
    L7:
        r0 = 16975036;
        goto L8
    }

    private /* synthetic */ boolean lambda$new$0(View view, KeyEvent event) {
        switch(event.getKeyCode()) {
            case 4: goto L6;
            case 19: goto L6;
            case 20: goto L6;
            case 21: goto L6;
            case 22: goto L6;
            case 23: goto L6;
            case 66: goto L6;
            case 111: goto L6;
            default: goto L4;
        };
    L4:
        this.mCallback.dispatchUnhandledKey(event);
        return true;
    L6:
        return false;
    }

    private /* synthetic */ boolean lambda$new$1(View view, PendingIntent pendingIntent, RemoteViews.RemoteResponse r) {
        if (pendingIntent == null) goto L6;
        this.mCallback.startIntentSender(pendingIntent.getIntentSender());
        return true;
    L6:
        return true;
    }

    private /* synthetic */ void lambda$new$2(FillResponse response, View v) {
        this.mCallback.onResponsePicked(response);
    }

    private /* synthetic */ void lambda$new$3(Dataset dataset, View v) {
        this.mCallback.onDatasetPicked(dataset);
    }

    private /* synthetic */ void lambda$new$4(AdapterView adapter, View view, int position, long id) {
        ViewItem vi = this.mAdapter.getItem(position);
        this.mCallback.onDatasetPicked(vi.dataset);
    }

    private void applyCancelAction(View rootView, int[] ids) {
        if (ids != null) goto L5;
        return;
    L5:
        if (Helper.sDebug == false) goto L8;
        Slog.d(TAG, "fill UI has " + ids.length + " actions");
    L8:
        if ((rootView instanceof ViewGroup) == true) goto L11;
        Slog.w(TAG, "cannot apply actions because fill UI root is not a ViewGroup: " + rootView);
        return;
    L11:
        ViewGroup root = (ViewGroup) rootView;
        int i = 0;
    L13:
        if (i >= ids.length) goto L20;
        int id = ids[i];
        View child = root.findViewById(id);
        if (child != null) goto L17;
        Slog.w(TAG, "Ignoring cancel action for view " + id + " because it's not on " + root);
    L18:
        i = i + 1;
        goto L13
    L17:
        child.setOnClickListener(new FillUi$$ExternalSyntheticLambda1(this));
        goto L18
    }

    private /* synthetic */ void lambda$applyCancelAction$5(View v) {
        if (Helper.sVerbose == false) goto L5;
        Slog.v(TAG, " Cancelling session after " + v + " clicked");
    L5:
        this.mCallback.cancelSession();
    }

    void requestShowFillUi() {
        this.mCallback.requestShowFillUi(this.mContentWidth, this.mContentHeight, this.mWindowPresenter);
    }

    private RemoteViews.InteractionHandler newInteractionBlocker() {
        return new FillUi$$ExternalSyntheticLambda0();
    }

    private static /* synthetic */ boolean lambda$newInteractionBlocker$6(View view, PendingIntent pendingIntent, RemoteViews.RemoteResponse response) {
        if (Helper.sVerbose == false) goto L7;
        Slog.v(TAG, "Ignoring click on " + view);
        return true;
    L7:
        return true;
    }

    private void applyNewFilterText() {
        final int oldCount = this.mAdapter.getCount();
        this.mAdapter.getFilter().filter(this.mFilterText, new FillUi$$ExternalSyntheticLambda2(this, oldCount));
    }

    private /* synthetic */ void lambda$applyNewFilterText$7(int oldCount, int count) {
        if (this.mDestroyed == false) goto L6;
        return;
    L6:
        if (this.mFilterText != null) goto L8;
        int size = 0;
    L10:
        if (count > 0) goto L16;
        if (Helper.sDebug == false) goto L14;
        Slog.d(TAG, "No dataset matches filter with " + size + " chars");
    L14:
        this.mCallback.requestHideFillUi();
        return;
    L16:
        if (size <= this.mMaxInputLengthForAutofill) goto L22;
        if (Helper.sDebug == false) goto L20;
        Slog.d(TAG, "Not showing fill UI because user entered more than " + this.mMaxInputLengthForAutofill + " characters");
    L20:
        this.mCallback.requestHideFillUi();
        return;
    L22:
        if (updateContentSize() == false) goto L24;
        requestShowFillUi();
    L24:
        this.mListView.setVerticalScrollBarEnabled(true);
        this.mListView.onVisibilityAggregated(true);
        if (this.mAdapter.getCount() == oldCount) goto L30;
        this.mListView.requestLayout();
        return;
    L30:
        return;
    L8:
        size = this.mFilterText.length();
        goto L10
    }

    public void setFilterText(String filterText) {
        throwIfDestroyed();
        if (this.mAdapter == null) goto L5;
        if (filterText != null) goto L11;
        String filterText2 = null;
    L13:
        if (Objects.equals(this.mFilterText, filterText2) == false) goto L15;
        return;
    L15:
        this.mFilterText = filterText2;
        applyNewFilterText();
        return;
    L11:
        filterText2 = filterText.toLowerCase();
        goto L13
    L5:
        if (TextUtils.isEmpty(filterText) == false) goto L7;
        requestShowFillUi();
        return;
    L7:
        this.mCallback.requestHideFillUi();
    }

    public void destroy(boolean notifyClient) {
        throwIfDestroyed();
        if (this.mWindow == null) goto L5;
        this.mWindow.hide(false);
    L5:
        this.mCallback.onDestroy();
        if (notifyClient == false) goto L8;
        this.mCallback.requestHideFillUiWhenDestroyed();
    L8:
        this.mDestroyed = true;
    }

    private boolean updateContentSize() {
        if (this.mAdapter != null) goto L6;
        return false;
    L6:
        if (this.mFullScreen == false) goto L9;
        return true;
    L9:
        boolean changed = false;
        if (this.mAdapter.getCount() <= 0) goto L12;
        Point maxSize = this.mTempPoint;
        resolveMaxWindowSize(this.mContext, maxSize);
        this.mContentWidth = 0;
        this.mContentHeight = 0;
        int widthMeasureSpec = View.MeasureSpec.makeMeasureSpec(maxSize.x, Integer.MIN_VALUE);
        int heightMeasureSpec = View.MeasureSpec.makeMeasureSpec(maxSize.y, Integer.MIN_VALUE);
        int itemCount = this.mAdapter.getCount();
        if (this.mHeader == null) goto L21;
        this.mHeader.measure(widthMeasureSpec, heightMeasureSpec);
        changed = (false | updateWidth(this.mHeader, maxSize)) | updateHeight(this.mHeader, maxSize);
    L21:
        int i = 0;
    L22:
        if (i >= itemCount) goto L28;
        View view = this.mAdapter.getItem(i).view;
        view.measure(widthMeasureSpec, heightMeasureSpec);
        changed = changed | updateWidth(view, maxSize);
        if (i >= this.mVisibleDatasetsMaxCount) goto L26;
        changed = changed | updateHeight(view, maxSize);
    L26:
        i = i + 1;
        goto L22
    L28:
        if (this.mFooter == null) goto L35;
        this.mFooter.measure(widthMeasureSpec, heightMeasureSpec);
        return (changed | updateWidth(this.mFooter, maxSize)) | updateHeight(this.mFooter, maxSize);
    L35:
        return changed;
    L12:
        if (this.mContentWidth == 0) goto L15;
        this.mContentWidth = 0;
        changed = true;
    L15:
        if (this.mContentHeight == 0) goto L34;
        this.mContentHeight = 0;
        return true;
    L34:
        return changed;
    }

    private boolean updateWidth(View view, Point maxSize) {
        int clampedMeasuredWidth = Math.min(view.getMeasuredWidth(), maxSize.x);
        int newContentWidth = Math.max(this.mContentWidth, clampedMeasuredWidth);
        if (newContentWidth == this.mContentWidth) goto L6;
        this.mContentWidth = newContentWidth;
        return true;
    L6:
        return false;
    }

    private boolean heightLesserThanDisplayScreen(int height) {
        if (height >= (((double) this.mWindowManager.getCurrentWindowMetrics().getBounds().height()) * 0.8d)) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean updateHeight(View view, Point maxSize) {
        int clampedMeasuredHeight = Math.min(view.getMeasuredHeight(), maxSize.y);
        int newContentHeight = this.mContentHeight + clampedMeasuredHeight;
        if (newContentHeight != this.mContentHeight) goto L5;
        return false;
    L5:
        if (heightLesserThanDisplayScreen(newContentHeight) == false) goto L9;
        this.mContentHeight = newContentHeight;
        return true;
    L9:
        return false;
    }

    private void throwIfDestroyed() {
        if (this.mDestroyed == true) goto L6;
        return;
    L6:
        throw new IllegalStateException("cannot interact with a destroyed instance");
    }

    private static void resolveMaxWindowSize(Context context, Point outPoint) {
        context.getDisplayNoVerify().getSize(outPoint);
        TypedValue typedValue = sTempTypedValue;
        context.getTheme().resolveAttribute(R.^attr-private.autofillDatasetPickerMaxWidth, typedValue, true);
        outPoint.x = (int) typedValue.getFraction(outPoint.x, outPoint.x);
        context.getTheme().resolveAttribute(R.^attr-private.autofillDatasetPickerMaxHeight, typedValue, true);
        outPoint.y = (int) typedValue.getFraction(outPoint.y, outPoint.y);
    }

    public void dump(PrintWriter pw, String prefix) {
        pw.print(prefix);
        pw.print("mCallback: ");
        if (this.mCallback == null) goto L5;
        boolean r0 = true;
    L6:
        pw.println(r0);
        pw.print(prefix);
        pw.print("mFullScreen: ");
        pw.println(this.mFullScreen);
        pw.print(prefix);
        pw.print("mVisibleDatasetsMaxCount: ");
        pw.println(this.mVisibleDatasetsMaxCount);
        if (this.mHeader == null) goto L10;
        pw.print(prefix);
        pw.print("mHeader: ");
        pw.println(this.mHeader);
    L10:
        if (this.mListView == null) goto L13;
        pw.print(prefix);
        pw.print("mListView: ");
        pw.println(this.mListView);
    L13:
        if (this.mFooter == null) goto L16;
        pw.print(prefix);
        pw.print("mFooter: ");
        pw.println(this.mFooter);
    L16:
        if (this.mAdapter == null) goto L19;
        pw.print(prefix);
        pw.print("mAdapter: ");
        pw.println(this.mAdapter);
    L19:
        if (this.mFilterText == null) goto L21;
        pw.print(prefix);
        pw.print("mFilterText: ");
        Helper.printlnRedactedText(pw, this.mFilterText);
    L21:
        pw.print(prefix);
        pw.print("mContentWidth: ");
        pw.println(this.mContentWidth);
        pw.print(prefix);
        pw.print("mContentHeight: ");
        pw.println(this.mContentHeight);
        pw.print(prefix);
        pw.print("mDestroyed: ");
        pw.println(this.mDestroyed);
        pw.print(prefix);
        pw.print("mContext: ");
        pw.println(this.mContext);
        pw.print(prefix);
        pw.print("mUserContext: ");
        pw.println(this.mUserContext);
        pw.print(prefix);
        pw.print("theme id: ");
        pw.print(this.mThemeId);
        switch(this.mThemeId) {
            case 16975023: goto L25;
            case 16975036: goto L24;
            default: goto L23;
        };
    L23:
        pw.println("(UNKNOWN_MODE)");
    L27:
        if (this.mWindow == null) goto L36;
        pw.print(prefix);
        pw.print("mWindow: ");
        String prefix2 = prefix + "  ";
        pw.println();
        pw.print(prefix2);
        pw.print("showing: ");
        pw.println(AnchoredWindow.m2439$$Nest$fgetmShowing(this.mWindow));
        pw.print(prefix2);
        pw.print("view: ");
        pw.println(AnchoredWindow.m2437$$Nest$fgetmContentView(this.mWindow));
        if (AnchoredWindow.m2438$$Nest$fgetmShowParams(this.mWindow) == null) goto L31;
        pw.print(prefix2);
        pw.print("params: ");
        pw.println(AnchoredWindow.m2438$$Nest$fgetmShowParams(this.mWindow));
    L31:
        pw.print(prefix2);
        pw.print("screen coordinates: ");
        if (AnchoredWindow.m2437$$Nest$fgetmContentView(this.mWindow) != null) goto L34;
        pw.println("N/A");
        return;
    L34:
        int[] coordinates = AnchoredWindow.m2437$$Nest$fgetmContentView(this.mWindow).getLocationOnScreen();
        pw.print(coordinates[0]);
        pw.print("x");
        pw.println(coordinates[1]);
        return;
    L36:
        return;
    L24:
        pw.println(" (light)");
        goto L27
    L25:
        pw.println(" (dark)");
        goto L27
    L5:
        r0 = false;
        goto L6
    }

    private void announceSearchResultIfNeeded() {
        if (AccessibilityManager.getInstance(this.mContext).isEnabled() == true) goto L5;
        return;
    L5:
        if (this.mAnnounceFilterResult != null) goto L7;
        this.mAnnounceFilterResult = new AnnounceFilterResult(this, null);
    L7:
        this.mAnnounceFilterResult.post();
    }

    public IExtFillUi getExt() {
        return this.mExt;
    }
}
