package com.bytedance.android.livesdk.feedback;

import android.os.Bundle;
import com.bytedance.android.live.base.model.feedback.FeedbackCard;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.d;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u000b\u0018\u0000 #2\u00020\u0001:\u0001$B\u0007¢\u0006\u0004\b!\u0010\"J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R$\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR$\u0010\r\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\b\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR$\u0010\u0010\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\b\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006%"}, d2 = {"Lcom/bytedance/android/livesdk/feedback/FeedbackContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Landroid/os/Bundle;", "bundle", "", "configContext", "", "reqId", "Ljava/lang/String;", "getReqId", "()Ljava/lang/String;", "setReqId", "(Ljava/lang/String;)V", "enterFromMerge", "getEnterFromMerge", "setEnterFromMerge", "enterMethod", "getEnterMethod", "setEnterMethod", "Lcom/bytedance/android/live/base/model/feedback/FeedbackCard;", "mFeedbackCard", "Lcom/bytedance/android/live/base/model/feedback/FeedbackCard;", "getMFeedbackCard", "()Lcom/bytedance/android/live/base/model/feedback/FeedbackCard;", "setMFeedbackCard", "(Lcom/bytedance/android/live/base/model/feedback/FeedbackCard;)V", "", "mPreRoomId", "Ljava/lang/Long;", "getMPreRoomId", "()Ljava/lang/Long;", "setMPreRoomId", "(Ljava/lang/Long;)V", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FeedbackContext extends DataContext {
    public static final a Companion = null;
    public static final String FEEDBACK_FRAGMENT_BG = "https://lf1-webcastcdn-tos.douyinstatic.com/obj/webcast/feedback_bg.webp";
    public static final String FEEDBACK_FRAGMENT_SLIDE_PATH = "https://lf1-webcastcdn-tos.douyinstatic.com/obj/webcast/explore_slide_motion.webp";
    public static final String TAG = "FeedbackContext";
    private String enterFromMerge;
    private String enterMethod;
    private FeedbackCard mFeedbackCard;
    private Long mPreRoomId;
    private String reqId;

    public static final class a {
        public a() {
        }

        public static FeedbackContext a(int r100) {
            DataContext r101 = d.d(FeedbackContext.TAG + r100);
            if ((r101 instanceof FeedbackContext) == true) goto L6;
            r101 = null;
        L6:
            return (FeedbackContext) r101;
        }
    }

    static {
        Companion = new a();
    }

    public FeedbackContext() {
    }

    public final String getEnterFromMerge() {
        return this.enterFromMerge;
    }

    public final String getEnterMethod() {
        return this.enterMethod;
    }

    public final FeedbackCard getMFeedbackCard() {
        return this.mFeedbackCard;
    }

    public final Long getMPreRoomId() {
        return this.mPreRoomId;
    }

    public final String getReqId() {
        return this.reqId;
    }

    public final void configContext(Bundle r100) {
        String r101 = null;
        if (r100 == null) goto L5;
        String r102 = r100.getString("enter_from_merge");
    L6:
        this.enterFromMerge = r102;
        if (r100 == null) goto L9;
        r101 = r100.getString("enter_method");
    L9:
        this.enterMethod = r101;
        return;
    L5:
        r102 = null;
        goto L6
    }

    public final void setEnterFromMerge(String r100) {
        this.enterFromMerge = r100;
    }

    public final void setEnterMethod(String r100) {
        this.enterMethod = r100;
    }

    public final void setMFeedbackCard(FeedbackCard r100) {
        this.mFeedbackCard = r100;
    }

    public final void setMPreRoomId(Long r100) {
        this.mPreRoomId = r100;
    }

    public final void setReqId(String r100) {
        this.reqId = r100;
    }
}
