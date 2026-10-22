package com.android.ttcjpaysdk.base.ui.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Vibrator;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.InputDevice;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.android.ttcjpaysdk.base.imageloader.ImageLoader;
import com.android.ttcjpaysdk.base.settings.CJPaySettingsManager;
import com.android.ttcjpaysdk.base.settings.bean.InsuranceConfiguration;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.larus.nova.R;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b'\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0002stB%\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0014\u0010b\u001a\u0004\u0018\u00010c2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010d\u001a\u00020\tH\u0016J\u0006\u0010e\u001a\u00020fJ\b\u0010g\u001a\u00020fH\u0002J\u0010\u0010h\u001a\u00020f2\u0006\u0010i\u001a\u00020jH\u0016J\u001c\u0010k\u001a\u00020\f2\b\u0010i\u001a\u0004\u0018\u00010j2\b\u0010l\u001a\u0004\u0018\u00010mH\u0016J\u0010\u0010n\u001a\u00020f2\b\u0010'\u001a\u0004\u0018\u00010]J\u0010\u0010o\u001a\u00020f2\b\u0010'\u001a\u0004\u0018\u00010(J\b\u0010p\u001a\u00020fH\u0016J\b\u0010q\u001a\u00020fH\u0016J\u0006\u0010r\u001a\u00020fR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010%\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u000e\"\u0004\b&\u0010\u0010R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010)\u001a\u0004\u0018\u00010*X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001c\u0010/\u001a\u0004\u0018\u00010\u0001X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001c\u00104\u001a\u0004\u0018\u000105X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001c\u0010:\u001a\u0004\u0018\u00010\u0012X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u0014\"\u0004\b<\u0010\u0016R\u001c\u0010=\u001a\u0004\u0018\u00010\u0012X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\u0014\"\u0004\b?\u0010\u0016R\u001c\u0010@\u001a\u0004\u0018\u00010\u0012X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\u0014\"\u0004\bB\u0010\u0016R\u001c\u0010C\u001a\u0004\u0018\u00010\u0012X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010\u0014\"\u0004\bE\u0010\u0016R\u001c\u0010F\u001a\u0004\u0018\u00010\u0012X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010\u0014\"\u0004\bH\u0010\u0016R\u001c\u0010I\u001a\u0004\u0018\u00010\u0012X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010\u0014\"\u0004\bK\u0010\u0016R\u001c\u0010L\u001a\u0004\u0018\u00010\u0012X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010\u0014\"\u0004\bN\u0010\u0016R\u001c\u0010O\u001a\u0004\u0018\u00010\u0012X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010\u0014\"\u0004\bQ\u0010\u0016R\u001c\u0010R\u001a\u0004\u0018\u00010\u0012X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010\u0014\"\u0004\bT\u0010\u0016R\u001c\u0010U\u001a\u0004\u0018\u00010\u0012X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010\u0014\"\u0004\bW\u0010\u0016R\u001c\u0010X\u001a\u0004\u0018\u00010\u0012X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010\u0014\"\u0004\bZ\u0010\u0016R\u0010\u0010[\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\\\u001a\u0004\u0018\u00010]X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010^\u001a\u0004\u0018\u00010_X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010`\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\f0aX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006u"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/widget/CJPayTalkbackKeyboardView;", "Landroid/widget/LinearLayout;", "Landroid/view/View$OnClickListener;", "Landroid/view/View$OnTouchListener;", "mContext", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "canVibrate", "", "getCanVibrate", "()Z", "setCanVibrate", "(Z)V", "doneTextView", "Landroid/widget/TextView;", "getDoneTextView", "()Landroid/widget/TextView;", "setDoneTextView", "(Landroid/widget/TextView;)V", "insuranceConfiguration", "Lcom/android/ttcjpaysdk/base/settings/bean/InsuranceConfiguration;", "getInsuranceConfiguration", "()Lcom/android/ttcjpaysdk/base/settings/bean/InsuranceConfiguration;", "setInsuranceConfiguration", "(Lcom/android/ttcjpaysdk/base/settings/bean/InsuranceConfiguration;)V", "insuranceIcon", "Landroid/graphics/Bitmap;", "insuranceImage", "Landroid/widget/ImageView;", "getInsuranceImage", "()Landroid/widget/ImageView;", "setInsuranceImage", "(Landroid/widget/ImageView;)V", "isVirtual", "setVirtual", "listener", "Lcom/android/ttcjpaysdk/base/ui/widget/CJPayTalkbackKeyboardView$OnKeyListener;", "mDeleteBtn", "Landroid/widget/ImageButton;", "getMDeleteBtn", "()Landroid/widget/ImageButton;", "setMDeleteBtn", "(Landroid/widget/ImageButton;)V", "mFirstLayout", "getMFirstLayout", "()Landroid/widget/LinearLayout;", "setMFirstLayout", "(Landroid/widget/LinearLayout;)V", "mKeyboardTitleLayout", "Landroid/widget/RelativeLayout;", "getMKeyboardTitleLayout", "()Landroid/widget/RelativeLayout;", "setMKeyboardTitleLayout", "(Landroid/widget/RelativeLayout;)V", "mLable0", "getMLable0", "setMLable0", "mLable1", "getMLable1", "setMLable1", "mLable2", "getMLable2", "setMLable2", "mLable3", "getMLable3", "setMLable3", "mLable4", "getMLable4", "setMLable4", "mLable5", "getMLable5", "setMLable5", "mLable6", "getMLable6", "setMLable6", "mLable7", "getMLable7", "setMLable7", "mLable8", "getMLable8", "setMLable8", "mLable9", "getMLable9", "setMLable9", "mLableX", "getMLableX", "setMLableX", "mRootView", "onDoneListener", "Lcom/android/ttcjpaysdk/base/ui/widget/CJPayTalkbackKeyboardView$OnDoneListener;", "vibrator", "Landroid/os/Vibrator;", "viewTouchMap", "", "getKeyboard", "", "getLayoutId", "hideX", "", "loadInsuranceImage", SendEventContainerMethodParamModel.EventKinds.onClick, BaseSwitches.V, "Landroid/view/View;", "onTouch", "event", "Landroid/view/MotionEvent;", "setOnDoneListener", "setOnKeyListener", "showDone", "showInsurance", "showX", "OnDoneListener", "OnKeyListener", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class CJPayTalkbackKeyboardView extends LinearLayout implements View.OnClickListener, View.OnTouchListener {
    private boolean canVibrate;
    private TextView doneTextView;
    private InsuranceConfiguration insuranceConfiguration;
    private Bitmap insuranceIcon;
    private ImageView insuranceImage;
    private boolean isVirtual;
    private OnKeyListener listener;
    private final Context mContext;
    private ImageButton mDeleteBtn;
    private LinearLayout mFirstLayout;
    private RelativeLayout mKeyboardTitleLayout;
    private TextView mLable0;
    private TextView mLable1;
    private TextView mLable2;
    private TextView mLable3;
    private TextView mLable4;
    private TextView mLable5;
    private TextView mLable6;
    private TextView mLable7;
    private TextView mLable8;
    private TextView mLable9;
    private TextView mLableX;
    private LinearLayout mRootView;
    private OnDoneListener onDoneListener;
    private Vibrator vibrator;
    private final Map<Integer, Boolean> viewTouchMap;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/widget/CJPayTalkbackKeyboardView$OnDoneListener;", "", "onDone", "", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnDoneListener {
        void onDone();
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0012\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&¨\u0006\u0007"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/widget/CJPayTalkbackKeyboardView$OnKeyListener;", "", "onDelete", "", "onInput", "text", "", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnKeyListener {
        void onDelete();

        void onInput(String r100);
    }

    public CJPayTalkbackKeyboardView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "mContext");
        this(r100, null, 0, 6, null);
    }

    public CJPayTalkbackKeyboardView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, "mContext");
        this(r100, r101, 0, 4, null);
    }

    public int getLayoutId() {
        return R.layout.cj_pay_view_keyboard;
    }

    private final void loadInsuranceImage() {
        InsuranceConfiguration r100 = this.insuranceConfiguration;
        if (r100 == null) goto L6;
        ImageLoader.Companion.getInstance().loadImage(getKeyboard(r100), new CJPayTalkbackKeyboardView$loadInsuranceImage$1$1(this));
        return;
    }

    public final void hideX() {
        TextView r100 = this.mLableX;
        if (r100 == null) goto L7;
        r100.setVisibility(4);
        return;
    }

    public void showDone() {
        RelativeLayout r100 = this.mKeyboardTitleLayout;
        boolean r101 = false;
        if (r100 == null) goto L6;
        r100.setVisibility(0);
    L6:
        TextView r102 = this.doneTextView;
        if (r102 == null) goto L10;
        r102.setVisibility(0);
    L10:
        InsuranceConfiguration r103 = CJPaySettingsManager.getInstance().getInsuranceConfig();
        this.insuranceConfiguration = r103;
        if (r103 != null) goto L13;
        return;
    L13:
        if (r103.show == true) goto L15;
    L17:
        if (r101 == true) goto L20;
        r103 = null;
    L20:
        if (r103 == null) goto L24;
        loadInsuranceImage();
        return;
    L24:
        return;
    L15:
        if (TextUtils.isEmpty(getKeyboard(r103)) == true) goto L17;
        r101 = true;
        goto L17
    }

    public final void showX() {
        TextView r100 = this.mLableX;
        if (r100 == null) goto L7;
        r100.setVisibility(0);
        return;
    }

    public void showInsurance() {
        InsuranceConfiguration r100 = CJPaySettingsManager.getInstance().getInsuranceConfig();
        this.insuranceConfiguration = r100;
        if (r100 != null) goto L5;
    L23:
        RelativeLayout r101 = this.mKeyboardTitleLayout;
        if (r101 == null) goto L29;
        r101.setVisibility(8);
        return;
    L29:
        return;
    L5:
        if (r100.show == true) goto L7;
    L9:
        boolean r102 = false;
    L10:
        if (r102 == true) goto L13;
        r100 = null;
    L13:
        if (r100 == null) goto L23;
        TextView r103 = this.doneTextView;
        if (r103 == null) goto L18;
        r103.setVisibility(8);
    L18:
        RelativeLayout r104 = this.mKeyboardTitleLayout;
        if (r104 == null) goto L22;
        r104.setVisibility(0);
    L22:
        loadInsuranceImage();
        return;
    L7:
        if (TextUtils.isEmpty(getKeyboard(r100)) == true) goto L9;
        r102 = true;
        goto L10
    }

    public final boolean getCanVibrate() {
        return this.canVibrate;
    }

    public final TextView getDoneTextView() {
        return this.doneTextView;
    }

    public final InsuranceConfiguration getInsuranceConfiguration() {
        return this.insuranceConfiguration;
    }

    public final ImageView getInsuranceImage() {
        return this.insuranceImage;
    }

    public final ImageButton getMDeleteBtn() {
        return this.mDeleteBtn;
    }

    public final LinearLayout getMFirstLayout() {
        return this.mFirstLayout;
    }

    public final RelativeLayout getMKeyboardTitleLayout() {
        return this.mKeyboardTitleLayout;
    }

    public final TextView getMLable0() {
        return this.mLable0;
    }

    public final TextView getMLable1() {
        return this.mLable1;
    }

    public final TextView getMLable2() {
        return this.mLable2;
    }

    public final TextView getMLable3() {
        return this.mLable3;
    }

    public final TextView getMLable4() {
        return this.mLable4;
    }

    public final TextView getMLable5() {
        return this.mLable5;
    }

    public final TextView getMLable6() {
        return this.mLable6;
    }

    public final TextView getMLable7() {
        return this.mLable7;
    }

    public final TextView getMLable8() {
        return this.mLable8;
    }

    public final TextView getMLable9() {
        return this.mLable9;
    }

    public final TextView getMLableX() {
        return this.mLableX;
    }

    public final boolean isVirtual() {
        return this.isVirtual;
    }

    public static final /* synthetic */ Bitmap access$getInsuranceIcon$p(CJPayTalkbackKeyboardView r100) {
        return r100.insuranceIcon;
    }

    public String getKeyboard(InsuranceConfiguration r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return r100.unified_keyboard_icon;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        boolean r101 = false;
        Iterator r102 = CollectionsKt.listOf(new View[]{this.mLable1, this.mLable2, this.mLable3, this.mLable4, this.mLable5, this.mLable6, this.mLable7, this.mLable8, this.mLable9, this.mLable0, this.mLableX, this.doneTextView, this.mDeleteBtn}).iterator();
    L4:
        if (r102.hasNext() == false) goto L13;
        Object r103 = r102.next();
        View r104 = (View) r103;
        if (r104 != null) goto L8;
    L10:
        boolean r105 = false;
    L11:
        if (r105 == false) goto L4;
    L15:
        if (((View) r103) == null) goto L23;
        Boolean r106 = this.viewTouchMap.get(Integer.valueOf(r100.getId()));
        if (r106 == null) goto L19;
        r101 = r106.booleanValue();
    L19:
        if (r101 == true) goto L21;
        this.isVirtual = true;
        goto L23
    L21:
        this.viewTouchMap.put(Integer.valueOf(r100.getId()), Boolean.FALSE);
    L23:
        if (this.canVibrate == false) goto L28;
        Vibrator r107 = this.vibrator;
        if (r107 == null) goto L28;
        r107.vibrate(40);
    L28:
        if (r100.getId() != R.id.keyboard_done_btn) goto L33;
        OnDoneListener r108 = this.onDoneListener;
        if (r108 == null) goto L69;
        r108.onDone();
        return;
    L69:
        return;
    L33:
        if (r100.getId() != R.id.key_lable_1) goto L35;
    L60:
        OnKeyListener r109 = this.listener;
        if (r109 == null) goto L74;
        r109.onInput(r100.getTag().toString());
        return;
    L74:
        return;
    L35:
        if (r100.getId() == R.id.key_lable_2) goto L60;
        if (r100.getId() == R.id.key_lable_3) goto L60;
        if (r100.getId() == R.id.key_lable_4) goto L60;
        if (r100.getId() == R.id.key_lable_5) goto L60;
        if (r100.getId() == R.id.key_lable_6) goto L60;
        if (r100.getId() == R.id.key_lable_7) goto L60;
        if (r100.getId() == R.id.key_lable_8) goto L60;
        if (r100.getId() == R.id.key_lable_9) goto L60;
        if (r100.getId() == R.id.key_lable_0) goto L60;
        if (r100.getId() == R.id.key_lable_X) goto L60;
        if (r100.getId() != R.id.key_lable_delete) goto L71;
        OnKeyListener r110 = this.listener;
        if (r110 == null) goto L72;
        r110.onDelete();
        return;
    L72:
        return;
    L71:
        return;
    L8:
        if (r104.getId() != r100.getId()) goto L10;
        r105 = true;
        goto L11
    L13:
        r103 = null;
        goto L15
    }

    public final void setCanVibrate(boolean r100) {
        this.canVibrate = r100;
    }

    public final void setDoneTextView(TextView r100) {
        this.doneTextView = r100;
    }

    public final void setInsuranceConfiguration(InsuranceConfiguration r100) {
        this.insuranceConfiguration = r100;
    }

    public final void setInsuranceImage(ImageView r100) {
        this.insuranceImage = r100;
    }

    public final void setMDeleteBtn(ImageButton r100) {
        this.mDeleteBtn = r100;
    }

    public final void setMFirstLayout(LinearLayout r100) {
        this.mFirstLayout = r100;
    }

    public final void setMKeyboardTitleLayout(RelativeLayout r100) {
        this.mKeyboardTitleLayout = r100;
    }

    public final void setMLable0(TextView r100) {
        this.mLable0 = r100;
    }

    public final void setMLable1(TextView r100) {
        this.mLable1 = r100;
    }

    public final void setMLable2(TextView r100) {
        this.mLable2 = r100;
    }

    public final void setMLable3(TextView r100) {
        this.mLable3 = r100;
    }

    public final void setMLable4(TextView r100) {
        this.mLable4 = r100;
    }

    public final void setMLable5(TextView r100) {
        this.mLable5 = r100;
    }

    public final void setMLable6(TextView r100) {
        this.mLable6 = r100;
    }

    public final void setMLable7(TextView r100) {
        this.mLable7 = r100;
    }

    public final void setMLable8(TextView r100) {
        this.mLable8 = r100;
    }

    public final void setMLable9(TextView r100) {
        this.mLable9 = r100;
    }

    public final void setMLableX(TextView r100) {
        this.mLableX = r100;
    }

    public final void setOnDoneListener(OnDoneListener r100) {
        this.onDoneListener = r100;
    }

    public final void setOnKeyListener(OnKeyListener r100) {
        this.listener = r100;
    }

    public final void setVirtual(boolean r100) {
        this.isVirtual = r100;
    }

    public static final /* synthetic */ void access$setInsuranceIcon$p(CJPayTalkbackKeyboardView r100, Bitmap r101) {
        r100.insuranceIcon = r101;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View r100, MotionEvent r101) {
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L28
        Unit r103 = null;
        if (r100 == null) goto L20;
        Iterator r104 = CollectionsKt.listOf(new View[]{this.mLable1, this.mLable2, this.mLable3, this.mLable4, this.mLable5, this.mLable6, this.mLable7, this.mLable8, this.mLable9, this.mLable0, this.mLableX, this.doneTextView, this.mDeleteBtn}).iterator();     // Catch: Throwable -> L28
    L7:
        if (r104.hasNext() == false) goto L16;
        Object r105 = r104.next();     // Catch: Throwable -> L28
        View r106 = (View) r105;     // Catch: Throwable -> L28
        if (r106 != null) goto L11;
    L13:
        boolean r107 = false;
    L14:
        if (r107 == false) goto L7;
    L18:
        if (((View) r105) == null) goto L20;
        Boolean r108 = this.viewTouchMap.put(Integer.valueOf(r100.getId()), Boolean.TRUE);     // Catch: Throwable -> L28
        goto L20
    L11:
        if (r106.getId() != r100.getId()) goto L13;
        r107 = true;
        goto L14
    L16:
        r105 = null;
    L20:
        if (r101 == null) goto L26;
        InputDevice r109 = InputDevice.getDevice(r101.getDeviceId());     // Catch: Throwable -> L28
        if (r109 == null) goto L24;
        boolean r110 = r109.isVirtual();     // Catch: Throwable -> L28
    L25:
        this.isVirtual = r110;     // Catch: Throwable -> L28
        r103 = Unit.INSTANCE;     // Catch: Throwable -> L28
        goto L26
    L24:
        r110 = false;
    L26:
        Result.m9449constructorimpl(r103);     // Catch: Throwable -> L28
    L30:
        return false;
    L28:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L30
    }

    public CJPayTalkbackKeyboardView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "mContext");
        super(r100, r101, r102);
        this.mContext = r100;
        this.viewTouchMap = new LinkedHashMap();
        View r103 = LayoutInflater.from(r100).inflate(getLayoutId(), this, true);
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type android.widget.LinearLayout");
        this.mRootView = (LinearLayout) r103;
        this.mKeyboardTitleLayout = (RelativeLayout) findViewById(R.id.keyboard_title);
        this.mFirstLayout = (LinearLayout) findViewById(R.id.linear_first);
        this.insuranceImage = (ImageView) findViewById(R.id.keyboard_insurance_image);
        this.doneTextView = (TextView) findViewById(R.id.keyboard_done_btn);
        this.mLable1 = (TextView) findViewById(R.id.key_lable_1);
        this.mLable2 = (TextView) findViewById(R.id.key_lable_2);
        this.mLable3 = (TextView) findViewById(R.id.key_lable_3);
        this.mLable4 = (TextView) findViewById(R.id.key_lable_4);
        this.mLable5 = (TextView) findViewById(R.id.key_lable_5);
        this.mLable6 = (TextView) findViewById(R.id.key_lable_6);
        this.mLable7 = (TextView) findViewById(R.id.key_lable_7);
        this.mLable8 = (TextView) findViewById(R.id.key_lable_8);
        this.mLable9 = (TextView) findViewById(R.id.key_lable_9);
        this.mLableX = (TextView) findViewById(R.id.key_lable_X);
        this.mLable0 = (TextView) findViewById(R.id.key_lable_0);
        this.mDeleteBtn = (ImageButton) findViewById(R.id.key_lable_delete);
        View.AccessibilityDelegate r104 = new CJPayTalkbackKeyboardView$accessibilityDelegate$1();
        TextView r105 = this.doneTextView;
        if (r105 == null) goto L5;
        r105.setOnClickListener(this);
    L5:
        TextView r106 = this.doneTextView;
        if (r106 == null) goto L8;
        r106.setOnTouchListener(this);
    L8:
        TextView r107 = this.mLable1;
        if (r107 == null) goto L11;
        r107.setOnClickListener(this);
    L11:
        TextView r108 = this.mLable1;
        if (r108 == null) goto L14;
        r108.setOnTouchListener(this);
    L14:
        TextView r109 = this.mLable1;
        if (r109 == null) goto L18;
        r109.setAccessibilityDelegate(r104);
    L18:
        TextView r110 = this.mLable2;
        if (r110 == null) goto L21;
        r110.setOnClickListener(this);
    L21:
        TextView r111 = this.mLable2;
        if (r111 == null) goto L24;
        r111.setOnTouchListener(this);
    L24:
        TextView r112 = this.mLable2;
        if (r112 == null) goto L28;
        r112.setAccessibilityDelegate(r104);
    L28:
        TextView r113 = this.mLable3;
        if (r113 == null) goto L31;
        r113.setOnClickListener(this);
    L31:
        TextView r114 = this.mLable3;
        if (r114 == null) goto L34;
        r114.setOnTouchListener(this);
    L34:
        TextView r115 = this.mLable3;
        if (r115 == null) goto L38;
        r115.setAccessibilityDelegate(r104);
    L38:
        TextView r116 = this.mLable4;
        if (r116 == null) goto L41;
        r116.setOnClickListener(this);
    L41:
        TextView r117 = this.mLable4;
        if (r117 == null) goto L44;
        r117.setOnTouchListener(this);
    L44:
        TextView r118 = this.mLable4;
        if (r118 == null) goto L48;
        r118.setAccessibilityDelegate(r104);
    L48:
        TextView r119 = this.mLable5;
        if (r119 == null) goto L51;
        r119.setOnClickListener(this);
    L51:
        TextView r120 = this.mLable5;
        if (r120 == null) goto L54;
        r120.setOnTouchListener(this);
    L54:
        TextView r121 = this.mLable5;
        if (r121 == null) goto L58;
        r121.setAccessibilityDelegate(r104);
    L58:
        TextView r122 = this.mLable6;
        if (r122 == null) goto L61;
        r122.setOnClickListener(this);
    L61:
        TextView r123 = this.mLable6;
        if (r123 == null) goto L64;
        r123.setOnTouchListener(this);
    L64:
        TextView r124 = this.mLable6;
        if (r124 == null) goto L68;
        r124.setAccessibilityDelegate(r104);
    L68:
        TextView r125 = this.mLable7;
        if (r125 == null) goto L71;
        r125.setOnClickListener(this);
    L71:
        TextView r126 = this.mLable7;
        if (r126 == null) goto L74;
        r126.setOnTouchListener(this);
    L74:
        TextView r127 = this.mLable7;
        if (r127 == null) goto L78;
        r127.setAccessibilityDelegate(r104);
    L78:
        TextView r128 = this.mLable8;
        if (r128 == null) goto L81;
        r128.setOnClickListener(this);
    L81:
        TextView r129 = this.mLable8;
        if (r129 == null) goto L84;
        r129.setOnTouchListener(this);
    L84:
        TextView r130 = this.mLable8;
        if (r130 == null) goto L88;
        r130.setAccessibilityDelegate(r104);
    L88:
        TextView r131 = this.mLable9;
        if (r131 == null) goto L91;
        r131.setOnClickListener(this);
    L91:
        TextView r132 = this.mLable9;
        if (r132 == null) goto L94;
        r132.setOnTouchListener(this);
    L94:
        TextView r133 = this.mLable9;
        if (r133 == null) goto L98;
        r133.setAccessibilityDelegate(r104);
    L98:
        TextView r134 = this.mLableX;
        if (r134 == null) goto L101;
        r134.setOnClickListener(this);
    L101:
        TextView r135 = this.mLableX;
        if (r135 == null) goto L104;
        r135.setOnTouchListener(this);
    L104:
        TextView r136 = this.mLableX;
        if (r136 == null) goto L108;
        r136.setAccessibilityDelegate(r104);
    L108:
        TextView r137 = this.mLable0;
        if (r137 == null) goto L111;
        r137.setOnClickListener(this);
    L111:
        TextView r138 = this.mLable0;
        if (r138 == null) goto L114;
        r138.setOnTouchListener(this);
    L114:
        TextView r139 = this.mLable0;
        if (r139 == null) goto L118;
        r139.setAccessibilityDelegate(r104);
    L118:
        ImageButton r140 = this.mDeleteBtn;
        if (r140 == null) goto L121;
        r140.setOnClickListener(this);
    L121:
        ImageButton r141 = this.mDeleteBtn;
        if (r141 == null) goto L124;
        r141.setOnTouchListener(this);
    L124:
        LinearLayout r142 = this.mRootView;
        if (r142 == null) goto L127;
        r142.setOnClickListener(this);
    L127:
        Object r143 = r100.getSystemService("vibrator");
        Intrinsics.checkNotNull(r143, "null cannot be cast to non-null type android.os.Vibrator");
        this.vibrator = (Vibrator) r143;
    }

    public /* synthetic */ CJPayTalkbackKeyboardView(Context r100, AttributeSet r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = 0;
    L8:
        this(r100, r101, r102);
    }
}
