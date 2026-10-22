package obric.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewStub;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes5.dex */
public class SettingItemSwitch extends ListContentItemSwitch {
    private static final int MSG_RESET_SWITCH_ANIM_STATE = 1;
    private final Handler mHandler;
    private ImageView mInfoBtn;
    private ViewStub mInfoBtnVS;
    private CompoundButton.OnCheckedChangeListener mOnCheckedChangeListenerReal;
    private boolean mSwitchAniming;
    private View.OnClickListener mSwitchClickListener;

    private static class H extends Handler {
        private H() {
        }

        /* synthetic */ H(AnonymousClass1 r1) {
            this();
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            if (msg.what != 1) goto L16;
            WeakReference r1 = (WeakReference) msg.obj;
            if (r1 != null) goto L8;
            SettingItemSwitch r2 = null;
        L9:
            if (r2 != null) goto L11;
            return;
        L11:
            if (r2.isAttachedToWindow() == false) goto L17;
            SettingItemSwitch.access$102(r2, false);
            return;
        L17:
            return;
        L8:
            r2 = (SettingItemSwitch) r1.get();
            goto L9
        }
    }

    static /* synthetic */ boolean access$100(SettingItemSwitch r0) {
        return r0.mSwitchAniming;
    }

    static /* synthetic */ boolean access$102(SettingItemSwitch r0, boolean r1) {
        r0.mSwitchAniming = r1;
        return r1;
    }

    static /* synthetic */ CompoundButton.OnCheckedChangeListener access$200(SettingItemSwitch r0) {
        return r0.mOnCheckedChangeListenerReal;
    }

    static /* synthetic */ Handler access$300(SettingItemSwitch r0) {
        return r0.mHandler;
    }

    static /* synthetic */ View.OnClickListener access$400(SettingItemSwitch r0) {
        return r0.mSwitchClickListener;
    }

    public SettingItemSwitch(Context context) {
        this(context, null);
    }

    public SettingItemSwitch(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SettingItemSwitch(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mHandler = new H(null);
        setImportantForAccessibility(1);
    }

    @Override // obric.widget.ListContentItemSwitch, obric.widget.ListContentItem
    protected void initRightWidget() {
        super.initRightWidget();
        SwitchEx r0 = getSwitch();
        super.setOnCheckedChangeListener(new AnonymousClass1(this));
        r0.setOnClickListener(new AnonymousClass2(this));
        r0.setOnTouchListener(new AnonymousClass3(this));
    }

    public void setIconMarginRight(int marginRight) {
        RelativeLayout.LayoutParams r0 = (RelativeLayout.LayoutParams) this.mLeftContainer.getLayoutParams();
        r0.rightMargin = marginRight;
        this.mLeftContainer.setLayoutParams(r0);
    }

    public void setIconMarginRightDimen(int rightDimen) {
        if (rightDimen <= 0) goto L4;
        setIconMarginRight(getResources().getDimensionPixelOffset(rightDimen));
        return;
    L4:
        setIconMarginRight(0);
    }

    @Deprecated
    public void setIconResource(int iconRes) {
        setIcon(iconRes);
    }

    @Override // obric.widget.ListContentItemSwitch
    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener listener) {
        this.mOnCheckedChangeListenerReal = listener;
    }

    @Override // obric.widget.ListContentItem
    protected int getDefaultMidLayout() {
        return R.layout.setting_item_mid_layout;
    }

    @Override // obric.widget.ListContentItem
    protected void initMidWidget() {
        super.initMidWidget();
        this.mInfoBtnVS = (ViewStub) findViewById(R.id.info_btn_viewstub);
    }

    public void setupInfoButton(boolean visible, View.OnClickListener listener) {
        if (visible == true) goto L4;
        ImageView r1 = this.mInfoBtn;
        if (r1 == null) goto L12;
        r1.setVisibility(8);
        return;
    L12:
        return;
    L4:
        if (this.mInfoBtn != null) goto L6;
        this.mInfoBtn = (ImageView) this.mInfoBtnVS.inflate();
    L6:
        this.mInfoBtn.setVisibility(0);
        this.mInfoBtn.setOnClickListener(listener);
    }

    @Deprecated
    public void setSwitchEnable(boolean enabled) {
        setEnabled(enabled);
    }

    public void setSwitchDisabledTips(int stringId) {
        setDisabledTips(stringId);
    }

    public void setSwitchClickListener(View.OnClickListener listener) {
        this.mSwitchClickListener = listener;
    }
}
