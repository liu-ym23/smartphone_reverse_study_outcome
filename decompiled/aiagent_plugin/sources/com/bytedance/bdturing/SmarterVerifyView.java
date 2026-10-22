package com.bytedance.bdturing;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class SmarterVerifyView extends FrameLayout {
    public static final String TAG = "SmarterVerifyView";
    private c mCallback;
    private i mSmarterListener;

    static /* synthetic */ void access$000(SmarterVerifyView r0, JSONObject r1) {
        r0.showSmarterVerifyDialog(r1);
    }

    public SmarterVerifyView(Context r3) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"));
        this.mSmarterListener = new i();
    }

    public SmarterVerifyView(Context r3, AttributeSet r4) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin"));
        this.mSmarterListener = new i();
    }

    public SmarterVerifyView(Context r3, AttributeSet r4, int r5) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin"), r5);
        this.mSmarterListener = new i();
    }

    public SmarterVerifyView(Context r3, AttributeSet r4, int r5, int r6) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin"), r5, r6);
        this.mSmarterListener = new i();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r3) {
        if (b.a().c() == true) goto L5;
        return true;
    L5:
        int r0 = r3.getAction();
        if (r0 != 0) goto L8;
        this.mSmarterListener.a();
        return false;
    L8:
        if (r0 != 1) goto L13;
        this.mSmarterListener.a(r3, new AnonymousClass1(this));
        return false;
    L13:
        return false;
    }

    private void showSmarterVerifyDialog(JSONObject r5) {
        b r0 = b.a();
        com.bytedance.bdturing.verify.a.l r1 = new com.bytedance.bdturing.verify.a.l("smartest_verify", r5);
        r1.c(false);
        r0.a((Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.bdturing.utils.d.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")), "com.obric.aiagent.plugin"), Activity.class, "com.obric.aiagent.plugin"), r1, this.mCallback);
    }

    public void setCallBack(c r3) {
        this.mCallback = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.aiagent.plugin");
    }
}
