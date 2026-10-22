package bh7;

import android.app.Activity;
import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.timon.permission.storage.constant.MediaPickType;
import com.bytedance.timon.permission.storage.constant.ResultCode;
import com.bytedance.timon.result.d;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import yg7.c;

/* JADX INFO: loaded from: classes22.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Activity f19041a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MediaPickType f19042b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f19043c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Intent f19044d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final xg7.a<Intent> f19045e;

    /* JADX INFO: renamed from: bh7.a$a, reason: collision with other inner class name */
    public static final class C0304a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Activity f19046a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public MediaPickType f19047b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f19048c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Intent f19049d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public xg7.a<Intent> f19050e;

        public C0304a() {
            this.f19047b = MediaPickType.TYPE_IMAGE_AND_VIDEO;
        }

        public final Activity getContext() {
            return this.f19046a;
        }
    }

    public final void a() {
        if (this.f19041a != null) goto L5;
    L7:
        boolean r100 = false;
    L9:
        if (r100 == true) goto L14;
        xg7.a<Intent> r101 = this.f19045e;
        if (r101 == null) goto L14;
        r101.a(ResultCode.ArgumentError.getValue(), null, null);
    L14:
        if (this.f19044d == null) goto L19;
        int r102 = yg7.a.f567506a;
        Activity r103 = this.f19041a;
        Intrinsics.checkNotNull(r103);
        Intent r104 = this.f19044d;
        xg7.a<Intent> r105 = this.f19045e;
        Intrinsics.checkNotNull(r105);
        Intrinsics.checkNotNullParameter(r103, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r104, "customIntent");
        Intrinsics.checkNotNullParameter(r105, "callback");
        if ((r103 instanceof FragmentActivity) == false) goto L18;
        d.startActivityForResult((FragmentActivity) r103, r104, null, new c(r105, null));
        return;
    L18:
        r105.a(ResultCode.ArgumentError.getValue(), null, "context 不是一个 FragmentActivity");
        return;
    L19:
        int r106 = yg7.a.f567506a;
        Activity r107 = this.f19041a;
        Intrinsics.checkNotNull(r107);
        MediaPickType r108 = this.f19042b;
        boolean r109 = this.f19043c;
        xg7.a<Intent> r110 = this.f19045e;
        Intrinsics.checkNotNull(r110);
        Intrinsics.checkNotNullParameter(r107, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r108, "type");
        Intrinsics.checkNotNullParameter(r110, "callback");
        Intent r111 = new Intent("android.intent.action.OPEN_DOCUMENT");
        r111.addCategory("android.intent.category.OPENABLE");
        r111.setType(r108.getValue());
        if (Intrinsics.areEqual(r108.getValue(), "image/* video/*") == false) goto L22;
        r111.putExtra("android.intent.extra.MIME_TYPES", new String[]{"image/*", "video/*"});
    L22:
        if (r109 == false) goto L25;
        r111.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
    L25:
        if ((r107 instanceof FragmentActivity) == false) goto L27;
        d.startActivityForResult((FragmentActivity) r107, r111, null, new yg7.b(r110));
        return;
    L27:
        r110.a(ResultCode.ArgumentError.getValue(), null, "context 不是一个 FragmentActivity");
        return;
    L5:
        if (this.f19045e == null) goto L7;
        r100 = true;
        goto L9
    }

    public a(C0304a r100) {
        this.f19041a = r100.getContext();
        this.f19042b = r100.f19047b;
        this.f19043c = r100.f19048c;
        this.f19044d = r100.f19049d;
        this.f19045e = r100.f19050e;
    }
}
