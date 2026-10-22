package com.android.server.inputmethod;

import android.R;
import android.app.AlertDialog;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.Printer;
import android.util.Slog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodSubtype;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import com.android.server.LocalServices;
import com.android.server.wm.WindowManagerInternal;
import com.obric.oui.framework.material.MaterialConfigCore;
import com.obric.oui.framework.material.MaterialTokenCore;
import com.obric.oui.framework.material.OMaterialHelperCore;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
final class InputMethodMenuController {
    private static final float MODAL_CORNER_RADIUS_DP = 36.0f;
    private static final String TAG = null;
    private AlertDialog.Builder mDialogBuilder;
    private InputMethodDialogWindowContext mDialogWindowContext;
    private List<InputMethodSubtypeSwitchingController.ImeSubtypeListItem> mImList;
    private InputMethodInfo[] mIms;
    private final InputMethodManagerService mService;
    private boolean mShowImeWithHardKeyboard;
    private int[] mSubtypeIndices;
    private AlertDialog mSwitchingDialog;
    private View mSwitchingDialogTitleView;
    private final WindowManagerInternal mWindowManagerInternal;

    private static class ImeSubtypeListAdapter extends ArrayAdapter<InputMethodSubtypeSwitchingController.ImeSubtypeListItem> {
        public int mCheckedItem;
        private InputMethodInfo[] mIms;
        private final LayoutInflater mInflater;
        private final List<InputMethodSubtypeSwitchingController.ImeSubtypeListItem> mItemsList;
        public InputMethodManagerService mService;
        private int[] mSubtypeIds;
        private final int mTextViewResourceId;

        /* JADX INFO: renamed from: -$$Nest$fputmIms, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m4776$$Nest$fputmIms(ImeSubtypeListAdapter r0, InputMethodInfo[] r1) {
            r0.mIms = r1;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmSubtypeIds, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m4777$$Nest$fputmSubtypeIds(ImeSubtypeListAdapter r0, int[] r1) {
            r0.mSubtypeIds = r1;
        }

        /* synthetic */ ImeSubtypeListAdapter(Context r1, int r2, List r3, int r4, InputMethodMenuControllerIA r5) {
            this(r1, r2, r3, r4);
        }

        private ImeSubtypeListAdapter(Context context, int textViewResourceId, List<InputMethodSubtypeSwitchingController.ImeSubtypeListItem> itemsList, int checkedItem) {
            super(context, textViewResourceId, itemsList);
            this.mTextViewResourceId = textViewResourceId;
            this.mItemsList = itemsList;
            this.mCheckedItem = checkedItem;
            this.mInflater = LayoutInflater.from(context);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int position, View convertView, ViewGroup parent) {
            int r0 = 0;
            if (convertView == null) goto L5;
            View view = convertView;
        L7:
            if (position >= 0) goto L9;
        L24:
            return view;
        L9:
            if (position >= this.mItemsList.size()) goto L24;
            InputMethodSubtypeSwitchingController.ImeSubtypeListItem item = this.mItemsList.get(position);
            CharSequence imeName = item.mImeName;
            CharSequence subtypeName = item.mSubtypeName;
            TextView firstTextView = (TextView) view.findViewById(R.id.text1);
            TextView secondTextView = (TextView) view.findViewById(R.id.text2);
            if (TextUtils.isEmpty(subtypeName) == false) goto L14;
            firstTextView.setText(imeName);
            secondTextView.setVisibility(8);
        L15:
            View endCheck = view.findViewById(R.id.flagIncludeNotImportantViews);
            if (position != this.mCheckedItem) goto L18;
            int r9 = 0;
        L19:
            endCheck.setVisibility(r9);
            endCheck.setEnabled(false);
            endCheck.setClickable(false);
            View r10 = view.findViewById(R.id.media_route_extended_settings_button);
            if (position != (this.mItemsList.size() - 1)) goto L22;
            r0 = 8;
        L22:
            r10.setVisibility(r0);
            return view;
        L18:
            r9 = 8;
            goto L19
        L14:
            firstTextView.setText(subtypeName);
            secondTextView.setText(imeName);
            secondTextView.setVisibility(0);
            goto L15
        L5:
            view = this.mInflater.inflate(this.mTextViewResourceId, parent, false);
            goto L7
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$9RRpOtxJiywTqYa-Xg3g0Bq9Ph0, reason: not valid java name */
    public static /* synthetic */ void m4772$r8$lambda$9RRpOtxJiywTqYaXg3g0Bq9Ph0(InputMethodMenuController r0, int r1, DialogInterface r2) {
        r0.lambda$showInputMethodMenuLocked$0(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$CLlh9zsn5eLEdOVTdGA7ylv4q7c(InputMethodMenuController r0, ImeSubtypeListAdapter r1, int r2, DialogInterface r3, int r4) {
        r0.lambda$showInputMethodMenuLocked$2(r1, r2, r3, r4);
    }

    public static /* synthetic */ void $r8$lambda$MXA6j6l1_XGRSmVxCgAImAHaUGU(Context r0, ComponentCallbacks r1, DialogInterface r2) {
        lambda$registerConfigurationCallback$3(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$ydeaWQ9e2M695TY8yZyULWklPlw(InputMethodMenuController r0, int r1, CompoundButton r2, boolean r3) {
        r0.lambda$showInputMethodMenuLocked$1(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSwitchingDialog, reason: not valid java name */
    static /* bridge */ /* synthetic */ AlertDialog m4773$$Nest$fgetmSwitchingDialog(InputMethodMenuController r0) {
        return r0.mSwitchingDialog;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetTAG, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m4774$$Nest$sfgetTAG() {
        return TAG;
    }

    /* JADX INFO: renamed from: -$$Nest$smgetUiNightMode, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m4775$$Nest$smgetUiNightMode(Configuration r0) {
        return getUiNightMode(r0);
    }

    static {
        TAG = InputMethodMenuController.class.getSimpleName();
    }

    InputMethodMenuController(InputMethodManagerService service) {
        this.mService = service;
        this.mWindowManagerInternal = (WindowManagerInternal) LocalServices.getService(WindowManagerInternal.class);
    }

    void showInputMethodMenuLocked(boolean showAuxSubtypes, int displayId, String preferredInputMethodId, int preferredInputMethodSubtypeIndex, List<InputMethodSubtypeSwitchingController.ImeSubtypeListItem> imList, final int userId) {
        InputMethodBindingController bindingController = this.mService.getInputMethodBindingController(userId);
        hideInputMethodMenuLocked(userId);
        if (preferredInputMethodSubtypeIndex != (-1)) goto L7;
        InputMethodSubtype currentSubtype = bindingController.getCurrentInputMethodSubtype();
        if (currentSubtype == null) goto L7;
        String curMethodId = bindingController.getSelectedMethodId();
        InputMethodInfo currentImi = InputMethodSettingsRepository.get(userId).getMethodMap().get(curMethodId);
        int preferredInputMethodSubtypeIndex2 = SubtypeUtils.getSubtypeIndexFromHashCode(currentImi, currentSubtype.hashCode());
    L8:
        int size = imList.size();
        this.mImList = imList;
        this.mIms = new InputMethodInfo[size];
        this.mSubtypeIndices = new int[size];
        int i = 0;
        int checkedItem = -1;
    L9:
        if (i >= size) goto L20;
        InputMethodSubtypeSwitchingController.ImeSubtypeListItem item = imList.get(i);
        this.mIms[i] = item.mImi;
        this.mSubtypeIndices[i] = item.mSubtypeIndex;
        if (this.mIms[i].getId().equals(preferredInputMethodId) == false) goto L18;
        int subtypeIndex = this.mSubtypeIndices[i];
        if (subtypeIndex == (-1)) goto L17;
        if (preferredInputMethodSubtypeIndex2 != (-1)) goto L16;
        if (subtypeIndex == 0) goto L17;
    L16:
        if (subtypeIndex != preferredInputMethodSubtypeIndex2) goto L18;
    L17:
        checkedItem = i;
    L18:
        i = i + 1;
        goto L9
    L20:
        if (checkedItem != (-1)) goto L23;
        Slog.w(TAG, "Switching menu shown with no item selected, IME id: " + preferredInputMethodId + ", subtype index: " + preferredInputMethodSubtypeIndex2);
    L23:
        if (this.mDialogWindowContext != null) goto L25;
        this.mDialogWindowContext = new InputMethodDialogWindowContext();
    L25:
        Context dialogWindowContext = this.mDialogWindowContext.get(displayId);
        this.mDialogBuilder = new AlertDialog.Builder(dialogWindowContext);
        this.mDialogBuilder.setOnCancelListener(new InputMethodMenuController$$ExternalSyntheticLambda1(this, userId));
        Context dialogContext = this.mDialogBuilder.getContext();
        TypedArray a = dialogContext.obtainStyledAttributes(null, com.android.internal.R.styleable.DialogPreference, R.attr.alertDialogStyle, 0);
        Drawable dialogIcon = a.getDrawable(2);
        a.recycle();
        this.mDialogBuilder.setIcon(dialogIcon);
        LayoutInflater inflater = (LayoutInflater) dialogContext.getSystemService(LayoutInflater.class);
        View view = inflater.inflate(R.layout.select_dialog_item_material, null);
        setupInputMethodMenuMaterial(dialogContext, view.findViewById(R.id.decor_content_parent));
        TextView title = (TextView) view.findViewById(R.id.remote_views_next_child);
        title.setText(R.string.use_a_different_app);
        ListView listView = (ListView) view.findViewById(R.id.nokeys);
        Button cancelButton = (Button) view.findViewById(R.id.calendar);
        cancelButton.setText(R.string.permdesc_startForegroundServicesFromBackground);
        cancelButton.setOnClickListener(new AnonymousClass1(this, userId));
        int sideSpacing = dialogContext.getResources().getDimensionPixelSize(R.dimen.keyguard_avatar_name_size);
        this.mDialogBuilder.setView(view, sideSpacing, 0, sideSpacing, 0);
        View tv = view.findViewById(R.id.remote_views_override_id);
        this.mSwitchingDialogTitleView = tv;
        View r2 = this.mSwitchingDialogTitleView.findViewById(R.id.installer);
        if (this.mWindowManagerInternal.isHardKeyboardAvailable() == false) goto L28;
        int r4 = 0;
    L29:
        r2.setVisibility(r4);
        Switch hardKeySwitch = (Switch) this.mSwitchingDialogTitleView.findViewById(R.id.installerExemptIgnored);
        hardKeySwitch.setChecked(this.mShowImeWithHardKeyboard);
        hardKeySwitch.setOnCheckedChangeListener(new InputMethodMenuController$$ExternalSyntheticLambda2(this, userId));
        final ImeSubtypeListAdapter adapter = new ImeSubtypeListAdapter(dialogContext, R.layout.select_dialog_material, imList, checkedItem, null);
        final DialogInterface.OnClickListener choiceListener = new InputMethodMenuController$$ExternalSyntheticLambda3(this, adapter, userId);
        adapter.mService = this.mService;
        ImeSubtypeListAdapter.m4776$$Nest$fputmIms(adapter, this.mIms);
        ImeSubtypeListAdapter.m4777$$Nest$fputmSubtypeIds(adapter, this.mSubtypeIndices);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AnonymousClass2(this, choiceListener));
        this.mSwitchingDialog = this.mDialogBuilder.create();
        this.mSwitchingDialog.setCanceledOnTouchOutside(true);
        Window w = this.mSwitchingDialog.getWindow();
        WindowManager.LayoutParams attrs = w.getAttributes();
        w.setType(2012);
        w.setHideOverlayWindows(true);
        attrs.token = dialogWindowContext.getWindowContextToken();
        attrs.privateFlags |= 16;
        attrs.setTitle("Select input method");
        attrs.width = -1;
        attrs.gravity = 80;
        int offSet = dialogContext.getResources().getDimensionPixelOffset(R.dimen.keyguard_avatar_name_size);
        attrs.y = offSet;
        w.setBackgroundDrawableResource(R.color.transparent);
        w.getDecorView().setSystemUiVisibility(4866);
        w.setAttributes(attrs);
        this.mService.updateSystemUiLocked(userId);
        this.mService.sendOnNavButtonFlagsChangedLocked(this.mService.getUserData(userId));
        this.mSwitchingDialog.show();
        w.setLayout(-1, -2);
        registerConfigurationCallback(dialogWindowContext, this.mSwitchingDialog, userId);
        return;
    L28:
        r4 = 8;
    L7:
        preferredInputMethodSubtypeIndex2 = preferredInputMethodSubtypeIndex;
        goto L8
    }

    private /* synthetic */ void lambda$showInputMethodMenuLocked$0(int userId, DialogInterface dialog) {
        hideInputMethodMenu(userId);
    }

    private /* synthetic */ void lambda$showInputMethodMenuLocked$1(int userId, CompoundButton buttonView, boolean isChecked) {
        SecureSettingsWrapper.putBoolean("show_ime_with_hard_keyboard", isChecked, userId);
        hideInputMethodMenu(userId);
    }

    private /* synthetic */ void lambda$showInputMethodMenuLocked$2(ImeSubtypeListAdapter adapter, int userId, DialogInterface dialog, int which) {
        monitor-enter(ImfLock.class);
    L19:
        th = move-exception;
        throw th;
    L5:
        if (this.mIms == null) goto L26;
        if (this.mIms.length <= which) goto L26;
        if (this.mSubtypeIndices == null) goto L26;
        if (this.mSubtypeIndices.length <= which) goto L26;
        InputMethodInfo im = this.mIms[which];     // Catch: Throwable -> L19
        int subtypeIndex = this.mSubtypeIndices[which];     // Catch: Throwable -> L19
        adapter.mCheckedItem = which;     // Catch: Throwable -> L19
        adapter.notifyDataSetChanged();     // Catch: Throwable -> L19
        if (im == null) goto L23;
        if (subtypeIndex < 0) goto L21;
        if (subtypeIndex >= im.getSubtypeCount()) goto L21;
    L22:
        this.mService.setInputMethodLocked(im.getId(), subtypeIndex, userId);     // Catch: Throwable -> L19
    L21:
        subtypeIndex = -1;
    L23:
        hideInputMethodMenuLocked(userId);     // Catch: Throwable -> L19
        monitor-exit(ImfLock.class);     // Catch: Throwable -> L19
        return;
    L26:
        monitor-exit(ImfLock.class);     // Catch: Throwable -> L19
    }

    private void setupInputMethodMenuMaterial(Context context, View surfaceView) {
        Slog.i(TAG, "setupInputMethodMenuMaterial: start");
        if (context == null) goto L21;
        if (surfaceView == null) goto L21;
        if (OMaterialHelperCore.isObricMaterialEnabled(context, TAG) == true) goto L23;
        return;
    L23:
        boolean isLight = OMaterialHelperCore.isLightMode(context);     // Catch: RuntimeException -> L15
        MaterialConfigCore[] materials = copyModalMaterials(isLight);     // Catch: RuntimeException -> L15
        if (materials == null) goto L17;
        if (materials.length == 0) goto L17;
        configureInputMethodMenuMaterialSurface(context, surfaceView);     // Catch: RuntimeException -> L15
        OMaterialHelperCore.setMaterials(surfaceView, 3, materials);     // Catch: RuntimeException -> L15
        surfaceView.invalidate();     // Catch: RuntimeException -> L15
        Slog.i(TAG, "setupInputMethodMenuMaterial: applied OUI_Bg_Modal material, isLight=" + isLight);     // Catch: RuntimeException -> L15
        return;
    L17:
        Slog.w(TAG, "setupInputMethodMenuMaterial: missing OUI_Bg_Modal token");     // Catch: RuntimeException -> L15
        return;
    L15:
        e = move-exception;
        Slog.w(TAG, "setupInputMethodMenuMaterial: material setup failed", e);
        return;
    L21:
        Slog.e(TAG, "setupInputMethodMenuMaterial: missing context or dialog surface view");
    }

    private static void configureInputMethodMenuMaterialSurface(Context context, View surfaceView) {
        GradientDrawable background = new GradientDrawable();
        background.setShape(0);
        background.setColor(0);
        background.setCornerRadius(OMaterialHelperCore.dpToPx(context, MODAL_CORNER_RADIUS_DP));
        surfaceView.setBackground(background);
        surfaceView.setOutlineProvider(ViewOutlineProvider.BACKGROUND);
        surfaceView.setClipToOutline(true);
    }

    private static MaterialConfigCore[] copyModalMaterials(boolean isLight) {
        return OMaterialHelperCore.copyMaterials((MaterialConfigCore[]) MaterialTokenCore.OUI_Bg_Modal.invoke(Boolean.valueOf(isLight)));
    }

    void updateKeyboardFromSettingsLocked(int userId) {
        this.mShowImeWithHardKeyboard = SecureSettingsWrapper.getBoolean("show_ime_with_hard_keyboard", false, userId);
        if (this.mSwitchingDialog != null) goto L5;
        return;
    L5:
        if (this.mSwitchingDialogTitleView != null) goto L7;
        return;
    L7:
        if (this.mSwitchingDialog.isShowing() == false) goto L12;
        Switch hardKeySwitch = (Switch) this.mSwitchingDialogTitleView.findViewById(R.id.installerExemptIgnored);
        hardKeySwitch.setChecked(this.mShowImeWithHardKeyboard);
        return;
    }

    void hideInputMethodMenu(int userId) {
        monitor-enter(ImfLock.class);
        hideInputMethodMenuLocked(userId);     // Catch: Throwable -> L7
        monitor-exit(ImfLock.class);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void hideInputMethodMenuLocked(int userId) {
        if (this.mSwitchingDialog == null) goto L6;
        this.mSwitchingDialog.dismiss();
        this.mSwitchingDialog = null;
        this.mSwitchingDialogTitleView = null;
        this.mService.updateSystemUiLocked(userId);
        this.mService.sendOnNavButtonFlagsChangedToAllImesLocked();
        this.mDialogBuilder = null;
        this.mImList = null;
        this.mIms = null;
        this.mSubtypeIndices = null;
        return;
    }

    private void registerConfigurationCallback(final Context context, final AlertDialog dialog, final int userId) {
        final int lastUiNightMode = getUiNightMode(context.getResources().getConfiguration());
        final ComponentCallbacks callbacks = new AnonymousClass3(this, lastUiNightMode, dialog, userId);
        context.registerComponentCallbacks(callbacks);
        dialog.setOnDismissListener(new InputMethodMenuController$$ExternalSyntheticLambda0(context, callbacks));
    }

    private static /* synthetic */ void lambda$registerConfigurationCallback$3(Context context, ComponentCallbacks callbacks, DialogInterface dialogInterface) {
        context.unregisterComponentCallbacks(callbacks);
    }

    private static int getUiNightMode(Configuration configuration) {
        return configuration.uiMode & 48;
    }

    AlertDialog getSwitchingDialogLocked() {
        return this.mSwitchingDialog;
    }

    boolean getShowImeWithHardKeyboard() {
        return this.mShowImeWithHardKeyboard;
    }

    boolean isisInputMethodPickerShownForTestLocked() {
        if (this.mSwitchingDialog != null) goto L7;
        return false;
    L7:
        return this.mSwitchingDialog.isShowing();
    }

    void handleHardKeyboardStatusChange(boolean available) {
        monitor-enter(ImfLock.class);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (this.mSwitchingDialog != null) goto L7;
    L17:
        monitor-exit(ImfLock.class);     // Catch: Throwable -> L15
        return;
    L7:
        if (this.mSwitchingDialogTitleView == null) goto L17;
        if (this.mSwitchingDialog.isShowing() == false) goto L17;
        View r1 = this.mSwitchingDialogTitleView.findViewById(R.id.installer);     // Catch: Throwable -> L15
        if (available == false) goto L13;
        int r2 = 0;
    L14:
        r1.setVisibility(r2);     // Catch: Throwable -> L15
        goto L17
    L13:
        r2 = 8;
        goto L14
    }

    void dump(Printer pw, String prefix) {
        boolean showing = isisInputMethodPickerShownForTestLocked();
        pw.println(prefix + "isShowing: " + showing);
        if (showing == false) goto L6;
        pw.println(prefix + "imList: " + this.mImList);
        return;
    }
}
