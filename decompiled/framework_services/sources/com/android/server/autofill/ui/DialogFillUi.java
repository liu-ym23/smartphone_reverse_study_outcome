package com.android.server.autofill.ui;

import android.R;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.IntentSender;
import android.graphics.drawable.Drawable;
import android.service.autofill.Dataset;
import android.service.autofill.FillResponse;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.PluralsMessageFormatter;
import android.util.Slog;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.view.autofill.AutofillId;
import android.view.autofill.AutofillValue;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RemoteViews;
import android.widget.TextView;
import com.android.server.am.AssistDataRequester;
import com.android.server.autofill.AutofillManagerService;
import com.android.server.autofill.Helper;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/* JADX INFO: loaded from: classes.dex */
final class DialogFillUi {
    private static final String TAG = "DialogFillUi";
    private static final int THEME_ID_DARK = 16975025;
    private static final int THEME_ID_LIGHT = 16975037;
    private final ItemsAdapter mAdapter;
    private AnnounceFilterResult mAnnounceFilterResult;
    private final UiCallback mCallback;
    private final ComponentName mComponentName;
    private final Context mContext;
    private boolean mDestroyed;
    private final Dialog mDialog;
    private String mFilterText;
    private final ListView mListView;
    private final OverlayControl mOverlayControl;
    private final String mServicePackageName;
    private final int mThemeId;
    private final Context mUserContext;
    private final int mVisibleDatasetsMaxCount;

    private final class AnnounceFilterResult implements Runnable {
        private static final int SEARCH_RESULT_ANNOUNCEMENT_DELAY = 1000;
        final /* synthetic */ DialogFillUi this$0;

        /* synthetic */ AnnounceFilterResult(DialogFillUi r1, DialogFillUiIA r2) {
            this(r1);
        }

        private AnnounceFilterResult(DialogFillUi r1) {
            this.this$0 = r1;
        }

        public void post() {
            remove();
            DialogFillUi.m2425$$Nest$fgetmListView(this.this$0).postDelayed(this, 1000);
        }

        public void remove() {
            DialogFillUi.m2425$$Nest$fgetmListView(this.this$0).removeCallbacks(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            int count = DialogFillUi.m2425$$Nest$fgetmListView(this.this$0).getAdapter().getCount();
            if (count > 0) goto L5;
            String text = DialogFillUi.m2424$$Nest$fgetmContext(this.this$0).getString(R.string.badPin);
        L6:
            DialogFillUi.m2425$$Nest$fgetmListView(this.this$0).announceForAccessibility(text);
            return;
        L5:
            Map<String, Object> arguments = new HashMap();
            arguments.put(AssistDataRequester.KEY_RECEIVER_EXTRA_COUNT, Integer.valueOf(count));
            text = PluralsMessageFormatter.format(DialogFillUi.m2424$$Nest$fgetmContext(this.this$0).getResources(), arguments, R.string.badPuk);
            goto L6
        }
    }

    private final class ItemsAdapter extends BaseAdapter implements Filterable {
        private final List<ViewItem> mAllItems;
        private final List<ViewItem> mFilteredItems;
        final /* synthetic */ DialogFillUi this$0;

        /* JADX INFO: renamed from: com.android.server.autofill.ui.DialogFillUi$ItemsAdapter$1, reason: invalid class name */
        class AnonymousClass1 extends Filter {
            final /* synthetic */ ItemsAdapter this$1;

            public static /* synthetic */ boolean $r8$lambda$iS6cfD9iidF_39_LrNQEngyE8K0(CharSequence r0, ViewItem r1) {
                return lambda$performFiltering$0(r0, r1);
            }

            AnonymousClass1(ItemsAdapter this$1) {
                this.this$1 = this$1;
            }

            @Override // android.widget.Filter
            protected Filter.FilterResults performFiltering(final CharSequence filterText) {
                List<ViewItem> filtered = (List) ItemsAdapter.m2427$$Nest$fgetmAllItems(this.this$1).stream().filter(new DialogFillUi$ItemsAdapter$1$$ExternalSyntheticLambda0(filterText)).collect(Collectors.toList());
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
                int oldItemCount = ItemsAdapter.m2428$$Nest$fgetmFilteredItems(this.this$1).size();
                ItemsAdapter.m2428$$Nest$fgetmFilteredItems(this.this$1).clear();
                if (results.count <= 0) goto L6;
                List<ViewItem> items = (List) results.values;
                ItemsAdapter.m2428$$Nest$fgetmFilteredItems(this.this$1).addAll(items);
            L6:
                if (oldItemCount == ItemsAdapter.m2428$$Nest$fgetmFilteredItems(this.this$1).size()) goto L8;
                boolean resultCountChanged = true;
            L9:
                if (resultCountChanged == false) goto L11;
                DialogFillUi.m2426$$Nest$mannounceSearchResultIfNeeded(this.this$1.this$0);
            L11:
                this.this$1.notifyDataSetChanged();
                return;
            L8:
                resultCountChanged = false;
                goto L9
            }
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmAllItems, reason: not valid java name */
        static /* bridge */ /* synthetic */ List m2427$$Nest$fgetmAllItems(ItemsAdapter r0) {
            return r0.mAllItems;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmFilteredItems, reason: not valid java name */
        static /* bridge */ /* synthetic */ List m2428$$Nest$fgetmFilteredItems(ItemsAdapter r0) {
            return r0.mFilteredItems;
        }

        @Override // android.widget.Adapter
        public /* bridge */ /* synthetic */ Object getItem(int r1) {
            return getItem(r1);
        }

        ItemsAdapter(DialogFillUi r1, List<ViewItem> items) {
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

    interface UiCallback {
        void onCanceled();

        void onDatasetPicked(Dataset r1);

        void onDismissed();

        void onResponsePicked(FillResponse r1);

        void onShown(int r1);

        void startIntentSender(IntentSender r1);
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

    public static /* synthetic */ void $r8$lambda$05Zww8WEAAPbaTGCEidVUs8bUgk(DialogFillUi r0, AdapterView r1, View r2, int r3, long r4) {
        r0.lambda$initialDatasetLayout$8(r1, r2, r3, r4);
    }

    public static /* synthetic */ void $r8$lambda$BpWN_115K7uV9sYFHWJxWWBtnxQ(DialogFillUi r0, FillResponse r1, View r2) {
        r0.lambda$initialAuthenticationLayout$6(r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$CBE6k_ZSdQhcD86EpD1iOaRb-gY, reason: not valid java name */
    public static /* synthetic */ void m2421$r8$lambda$CBE6k_ZSdQhcD86EpD1iOaRbgY(DialogFillUi r0, View r1) {
        r0.lambda$setDismissButton$3(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$GDd9PoBLu3lcKlZaFR4IQf8K-vM, reason: not valid java name */
    public static /* synthetic */ void m2422$r8$lambda$GDd9PoBLu3lcKlZaFR4IQf8KvM(DialogFillUi r0, int r1, DialogInterface r2) {
        r0.lambda$new$1(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$H3xKYouFGb_IW541LpAsehLMTgQ(AdapterView.OnItemClickListener r0, View r1) {
        lambda$initialDatasetLayout$9(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$HTFZKDyu7J9_xg-iY5_JcA-Mc4E, reason: not valid java name */
    public static /* synthetic */ void m2423$r8$lambda$HTFZKDyu7J9_xgiY5_JcAMc4E(DialogFillUi r0, FillResponse r1, View r2) {
        r0.lambda$initialAuthenticationLayout$5(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$P_IL2eiNdFDMq9CAhltNLZA1wok(DialogFillUi r0, int r1, int r2) {
        r0.lambda$initialDatasetLayout$10(r1, r2);
    }

    public static /* synthetic */ boolean $r8$lambda$SzZ8qsVwd3ZlUxBrtJjWvpJA244(DialogFillUi r0, View r1, PendingIntent r2, RemoteViews.RemoteResponse r3) {
        return r0.lambda$createDatasetItems$7(r1, r2, r3);
    }

    public static /* synthetic */ boolean $r8$lambda$VPRhHTj1_G7uJFg53l9PVUDEUYo(DialogFillUi r0, View r1, PendingIntent r2, RemoteViews.RemoteResponse r3) {
        return r0.lambda$initialAuthenticationLayout$4(r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$YBHZdYuXTDr3hWHy9i_EqnYOhnM(DialogFillUi r0, DialogInterface r1) {
        r0.lambda$new$0(r1);
    }

    public static /* synthetic */ boolean $r8$lambda$cApiaMYD28Q6yw_ba3hb57MpmY4(DialogFillUi r0, View r1, PendingIntent r2, RemoteViews.RemoteResponse r3) {
        return r0.lambda$setHeader$2(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m2424$$Nest$fgetmContext(DialogFillUi r0) {
        return r0.mContext;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmListView, reason: not valid java name */
    static /* bridge */ /* synthetic */ ListView m2425$$Nest$fgetmListView(DialogFillUi r0) {
        return r0.mListView;
    }

    /* JADX INFO: renamed from: -$$Nest$mannounceSearchResultIfNeeded, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2426$$Nest$mannounceSearchResultIfNeeded(DialogFillUi r0) {
        r0.announceSearchResultIfNeeded();
    }

    DialogFillUi(Context context, FillResponse response, AutofillId focusedViewId, String filterText, Drawable serviceIcon, String servicePackageName, ComponentName componentName, OverlayControl overlayControl, boolean nightMode, UiCallback callback) {
        if (Helper.sVerbose == false) goto L5;
        Slog.v(TAG, "nightMode: " + nightMode);
    L5:
        if (nightMode == false) goto L7;
        int r0 = 16975025;
    L8:
        this.mThemeId = r0;
        this.mCallback = callback;
        this.mOverlayControl = overlayControl;
        this.mServicePackageName = servicePackageName;
        this.mComponentName = componentName;
        this.mContext = new ContextThemeWrapper(context, this.mThemeId);
        this.mUserContext = Helper.getUserContext(this.mContext);
        LayoutInflater inflater = LayoutInflater.from(this.mContext);
        View decor = inflater.inflate(R.layout.breadcrumbs_in_fragment_material, null);
        if (response.getShowFillDialogIcon() == false) goto L12;
        setServiceIcon(decor, serviceIcon);
    L12:
        setHeader(decor, response);
        this.mVisibleDatasetsMaxCount = getVisibleDatasetsMaxCount();
        if (response.getAuthentication() == null) goto L20;
        this.mListView = null;
        this.mAdapter = null;
        initialAuthenticationLayout(decor, response);     // Catch: RuntimeException -> L17
    L21:
        setDismissButton(decor);
        this.mDialog = new Dialog(this.mContext, this.mThemeId);
        this.mDialog.setContentView(decor);
        setDialogParamsAsBottomSheet();
        this.mDialog.setOnCancelListener(new DialogFillUi$$ExternalSyntheticLambda6(this));
        if (this.mAdapter == null) goto L24;
        final int datasetsShown = this.mAdapter.getCount();
    L25:
        this.mDialog.setOnShowListener(new DialogFillUi$$ExternalSyntheticLambda7(this, datasetsShown));
        show();
        return;
    L24:
        datasetsShown = 0;
    L17:
        e = move-exception;
        callback.onCanceled();
        Slog.e(TAG, "Error inflating remote views", e);
        this.mDialog = null;
        return;
    L20:
        List<ViewItem> items = createDatasetItems(response, focusedViewId);
        this.mAdapter = new ItemsAdapter(this, items);
        this.mListView = (ListView) decor.findViewById(R.id.autofill_dialog_no);
        initialDatasetLayout(decor, filterText);
        goto L21
    L7:
        r0 = 16975037;
        goto L8
    }

    private /* synthetic */ void lambda$new$0(DialogInterface d) {
        this.mCallback.onCanceled();
    }

    private /* synthetic */ void lambda$new$1(int datasetsShown, DialogInterface d) {
        this.mCallback.onShown(datasetsShown);
    }

    private int getVisibleDatasetsMaxCount() {
        if (AutofillManagerService.getVisibleDatasetsMaxCount() <= 0) goto L9;
        int maxCount = AutofillManagerService.getVisibleDatasetsMaxCount();
        if (Helper.sVerbose == false) goto L7;
        Slog.v(TAG, "overriding maximum visible datasets to " + maxCount);
    L7:
        return maxCount;
    L9:
        return this.mContext.getResources().getInteger(R.integer.autofill_max_visible_datasets);
    }

    private void setDialogParamsAsBottomSheet() {
        Window window = this.mDialog.getWindow();
        window.setType(2038);
        window.addFlags(131074);
        window.setDimAmount(0.6f);
        window.addPrivateFlags(16);
        window.setSoftInputMode(32);
        window.setGravity(81);
        window.setCloseOnTouchOutside(true);
        WindowManager.LayoutParams params = window.getAttributes();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        window.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int screenWidth = displayMetrics.widthPixels;
        int maxWidth = this.mContext.getResources().getDimensionPixelSize(R.dimen.autofill_save_scroll_view_top_margin);
        params.width = Math.min(screenWidth, maxWidth);
        params.accessibilityTitle = this.mContext.getString(R.string.back_button_label);
        params.windowAnimations = R.style.DialogWindowTitle.DeviceDefault.Light;
    }

    private void setServiceIcon(View decor, Drawable serviceIcon) {
        if (serviceIcon != null) goto L4;
        return;
    L4:
        ImageView iconView = (ImageView) decor.findViewById(R.id.autofill_sheet_scroll_view);
        int actualWidth = serviceIcon.getMinimumWidth();
        int actualHeight = serviceIcon.getMinimumHeight();
        if (Helper.sDebug == false) goto L7;
        Slog.d(TAG, "Adding service icon (" + actualWidth + "x" + actualHeight + ")");
    L7:
        iconView.setImageDrawable(serviceIcon);
        iconView.setVisibility(0);
    }

    private void setHeader(View decor, FillResponse response) {
        RemoteViews presentation = Helper.sanitizeRemoteView(response.getDialogHeader());
        if (presentation != null) goto L5;
        return;
    L5:
        ViewGroup container = (ViewGroup) decor.findViewById(R.id.autofill_dialog_list);
        RemoteViews.InteractionHandler interceptionHandler = new DialogFillUi$$ExternalSyntheticLambda8(this);
        View content = presentation.applyWithTheme(this.mUserContext, (ViewGroup) decor, interceptionHandler, this.mThemeId);
        container.addView(content);
        container.setVisibility(0);
    }

    private /* synthetic */ boolean lambda$setHeader$2(View view, PendingIntent pendingIntent, RemoteViews.RemoteResponse r) {
        if (pendingIntent == null) goto L6;
        this.mCallback.startIntentSender(pendingIntent.getIntentSender());
        return true;
    L6:
        return true;
    }

    private void setDismissButton(View decor) {
        TextView noButton = (TextView) decor.findViewById(R.id.autofill_dialog_picker);
        noButton.setText(R.string.battery_saver_description_with_learn_more);
        noButton.setOnClickListener(new DialogFillUi$$ExternalSyntheticLambda9(this));
    }

    private /* synthetic */ void lambda$setDismissButton$3(View v) {
        this.mCallback.onDismissed();
    }

    private void setContinueButton(View decor, View.OnClickListener listener) {
        TextView yesButton = (TextView) decor.findViewById(R.id.autofill_save);
        yesButton.setText(R.string.autofill_update_yes);
        yesButton.setOnClickListener(listener);
        yesButton.setVisibility(0);
    }

    private void initialAuthenticationLayout(View decor, final FillResponse response) {
        RemoteViews presentation = Helper.sanitizeRemoteView(response.getDialogPresentation());
        if (presentation != null) goto L5;
        presentation = Helper.sanitizeRemoteView(response.getPresentation());
    L5:
        if (presentation == null) goto L9;
        ViewGroup container = (ViewGroup) decor.findViewById(R.id.autofill_dialog_header);
        RemoteViews.InteractionHandler interceptionHandler = new DialogFillUi$$ExternalSyntheticLambda3(this);
        View content = presentation.applyWithTheme(this.mUserContext, (ViewGroup) decor, interceptionHandler, this.mThemeId);
        container.addView(content);
        container.setVisibility(0);
        container.setFocusable(true);
        container.setOnClickListener(new DialogFillUi$$ExternalSyntheticLambda4(this, response));
        setContinueButton(decor, new DialogFillUi$$ExternalSyntheticLambda5(this, response));
        return;
    L9:
        throw new RuntimeException("No presentation for fill dialog authentication");
    }

    private /* synthetic */ boolean lambda$initialAuthenticationLayout$4(View view, PendingIntent pendingIntent, RemoteViews.RemoteResponse r) {
        if (pendingIntent == null) goto L6;
        this.mCallback.startIntentSender(pendingIntent.getIntentSender());
        return true;
    L6:
        return true;
    }

    private /* synthetic */ void lambda$initialAuthenticationLayout$5(FillResponse response, View v) {
        this.mCallback.onResponsePicked(response);
    }

    private /* synthetic */ void lambda$initialAuthenticationLayout$6(FillResponse response, View v) {
        this.mCallback.onResponsePicked(response);
    }

    private ArrayList<ViewItem> createDatasetItems(FillResponse response, AutofillId focusedViewId) {
        int datasetCount = response.getDatasets().size();
        if (Helper.sVerbose == false) goto L5;
        Slog.v(TAG, "Number datasets: " + datasetCount + " max visible: " + this.mVisibleDatasetsMaxCount);
    L5:
        RemoteViews.InteractionHandler interceptionHandler = new DialogFillUi$$ExternalSyntheticLambda10(this);
        ArrayList<ViewItem> items = new ArrayList(datasetCount);
        int i = 0;
    L6:
        if (i >= datasetCount) goto L40;
        Dataset dataset = (Dataset) response.getDatasets().get(i);
        int index = dataset.getFieldIds().indexOf(focusedViewId);
        if (index < 0) goto L38;
        RemoteViews presentation = Helper.sanitizeRemoteView(dataset.getFieldDialogPresentation(index));
        if (presentation == null) goto L12;
        if (Helper.sVerbose == false) goto L19;
        Slog.v(TAG, "setting remote view for " + focusedViewId);     // Catch: RuntimeException -> L17
    L19:
        View view = presentation.applyWithTheme(this.mUserContext, null, interceptionHandler, this.mThemeId);     // Catch: RuntimeException -> L17
        Dataset.DatasetFieldFilter filter = dataset.getFilter(index);
        String valueText = null;
        boolean filterable = true;
        if (filter != null) goto L28;
        AutofillValue value = (AutofillValue) dataset.getFieldValues().get(index);
        if (value != null) goto L25;
    L27:
        String valueText2 = valueText;
        Pattern filterPattern = null;
    L36:
        items.add(new ViewItem(dataset, filterPattern, filterable, valueText2, view));
        goto L38
    L25:
        if (value.isText() == false) goto L27;
        valueText = value.getTextValue().toString().toLowerCase();
        goto L27
    L28:
        Pattern filterPattern2 = filter.pattern;
        if (filterPattern2 == null) goto L31;
        valueText2 = null;
        filterPattern = filterPattern2;
        goto L36
    L31:
        if (Helper.sVerbose == false) goto L34;
        Slog.v(TAG, "Explicitly disabling filter at id " + focusedViewId + " for dataset #" + index);
    L34:
        filterable = false;
        valueText2 = null;
        filterPattern = filterPattern2;
    L17:
        e = move-exception;
        Slog.e(TAG, "Error inflating remote views", e);
        goto L38
    L12:
        if (Helper.sDebug == false) goto L38;
        Slog.w(TAG, "not displaying UI on field " + focusedViewId + " because service didn't provide a presentation for it on " + dataset);
    L38:
        i = i + 1;
        goto L6
    L40:
        return items;
    }

    private /* synthetic */ boolean lambda$createDatasetItems$7(View view, PendingIntent pendingIntent, RemoteViews.RemoteResponse r) {
        if (pendingIntent == null) goto L6;
        this.mCallback.startIntentSender(pendingIntent.getIntentSender());
        return true;
    L6:
        return true;
    }

    private void initialDatasetLayout(View decor, String filterText) {
        final AdapterView.OnItemClickListener onItemClickListener = new DialogFillUi$$ExternalSyntheticLambda0(this);
        this.mListView.setAdapter(this.mAdapter);
        this.mListView.setVisibility(0);
        this.mListView.setOnItemClickListener(onItemClickListener);
        if (this.mAdapter.getCount() != 1) goto L5;
        setContinueButton(decor, new DialogFillUi$$ExternalSyntheticLambda1(onItemClickListener));
    L5:
        if (filterText != null) goto L7;
        this.mFilterText = null;
    L8:
        final int oldCount = this.mAdapter.getCount();
        this.mAdapter.getFilter().filter(this.mFilterText, new DialogFillUi$$ExternalSyntheticLambda2(this, oldCount));
        return;
    L7:
        this.mFilterText = filterText.toLowerCase();
        goto L8
    }

    private /* synthetic */ void lambda$initialDatasetLayout$8(AdapterView adapter, View view, int position, long id) {
        ViewItem vi = this.mAdapter.getItem(position);
        this.mCallback.onDatasetPicked(vi.dataset);
    }

    private static /* synthetic */ void lambda$initialDatasetLayout$9(AdapterView.OnItemClickListener onItemClickListener, View v) {
        onItemClickListener.onItemClick(null, null, 0, 0);
    }

    private /* synthetic */ void lambda$initialDatasetLayout$10(int oldCount, int count) {
        if (this.mDestroyed == false) goto L5;
        return;
    L5:
        int size = 0;
        if (count > 0) goto L16;
        if (Helper.sDebug == true) goto L10;
    L14:
        this.mCallback.onCanceled();
        return;
    L10:
        if (this.mFilterText == null) goto L13;
        size = this.mFilterText.length();
    L13:
        Slog.d(TAG, "No dataset matches filter with " + size + " chars");
        goto L14
    L16:
        if (this.mAdapter.getCount() <= this.mVisibleDatasetsMaxCount) goto L18;
        this.mListView.setVerticalScrollBarEnabled(true);
        this.mListView.onVisibilityAggregated(true);
    L20:
        if (this.mAdapter.getCount() == oldCount) goto L24;
        this.mListView.requestLayout();
        return;
    L24:
        return;
    L18:
        this.mListView.setVerticalScrollBarEnabled(false);
        goto L20
    }

    private void show() {
        Slog.i(TAG, "Showing fill dialog");
        this.mDialog.show();
        this.mOverlayControl.hideOverlays();
    }

    boolean isShowing() {
        return this.mDialog.isShowing();
    }

    void hide() {
        if (Helper.sVerbose == false) goto L11;
        Slog.v(TAG, "Hiding fill dialog.");
    L11:
        this.mDialog.hide();     // Catch: Throwable -> L8
        this.mOverlayControl.showOverlays();
        return;
    L8:
        th = move-exception;
        this.mOverlayControl.showOverlays();
        throw th;
    }

    void destroy() {
    L5:
        th = move-exception;
        this.mOverlayControl.showOverlays();
        throw th;
    L3:
        if (Helper.sDebug == false) goto L7;
        Slog.d(TAG, "destroy()");     // Catch: Throwable -> L5
    L7:
        throwIfDestroyed();     // Catch: Throwable -> L5
        this.mDialog.dismiss();     // Catch: Throwable -> L5
        this.mDestroyed = true;     // Catch: Throwable -> L5
        this.mOverlayControl.showOverlays();
    }

    private void throwIfDestroyed() {
        if (this.mDestroyed == true) goto L6;
        return;
    L6:
        throw new IllegalStateException("cannot interact with a destroyed instance");
    }

    public String toString() {
        return "NO TITLE";
    }

    void dump(PrintWriter pw, String prefix) {
        pw.print(prefix);
        pw.print("service: ");
        pw.println(this.mServicePackageName);
        pw.print(prefix);
        pw.print("app: ");
        pw.println(this.mComponentName.toShortString());
        pw.print(prefix);
        pw.print("theme id: ");
        pw.print(this.mThemeId);
        switch(this.mThemeId) {
            case 16975025: goto L6;
            case 16975037: goto L5;
            default: goto L4;
        };
    L4:
        pw.println("(UNKNOWN_MODE)");
    L7:
        View view = this.mDialog.getWindow().getDecorView();
        int[] loc = view.getLocationOnScreen();
        pw.print(prefix);
        pw.print("coordinates: ");
        pw.print('(');
        pw.print(loc[0]);
        pw.print(',');
        pw.print(loc[1]);
        pw.print(')');
        pw.print('(');
        pw.print(loc[0] + view.getWidth());
        pw.print(',');
        pw.print(loc[1] + view.getHeight());
        pw.println(')');
        pw.print(prefix);
        pw.print("destroyed: ");
        pw.println(this.mDestroyed);
        return;
    L5:
        pw.println(" (light)");
        goto L7
    L6:
        pw.println(" (dark)");
        goto L7
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
}
