package com.bytedance.android.gamecp.common.ui;

import android.content.Context;
import android.util.AttributeSet;
import com.bytedance.android.gamecp.common.track.GamecpTracker;
import com.bytedance.android.gamecp.common.track.TrackRegisterStrategy;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0010B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tB\u001b\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\b\u0010\fB#\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\b\u0010\u000fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/gamecp/common/ui/UserAvatarImageView;", "Lcom/bytedance/android/gamecp/common/ui/HSImageView;", "Lcom/bytedance/android/gamecp/common/ui/t;", "trackData", "", "setTrackData", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class UserAvatarImageView extends HSImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public t f56956a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f56957b;

    public static final class a {
    }

    public static final class b extends TrackRegisterStrategy {
        @Override // com.bytedance.android.gamecp.common.track.TrackRegisterStrategy
        public final int getAutoReportStrategy() {
            return 0;
        }

        public b() {
        }
    }

    static {
    }

    public final void f() {
        HashMap<String, String> r100 = GamecpTracker.f56755a;
        GamecpTracker.r(this, "comment_head", MapsKt.emptyMap(), new b(), false, 112);
    }

    public UserAvatarImageView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f56956a = new t();
        this.f56957b = "UserAvatarImageView";
        f();
    }

    public final void setTrackData(t r100) {
        Intrinsics.checkNotNullParameter(r100, "trackData");
        this.f56956a = r100;
    }

    public UserAvatarImageView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f56956a = new t();
        this.f56957b = "UserAvatarImageView";
        f();
    }

    public UserAvatarImageView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f56956a = new t();
        this.f56957b = "UserAvatarImageView";
        f();
    }
}
