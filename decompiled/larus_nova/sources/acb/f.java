package acb;

import com.bytedance.lark.pb.media.v1.GetNutStoreFilePreviewUrlRequest;
import com.bytedance.lark.pb.media.v1.SaveToNutStoreRequest;
import com.bytedance.lark.pb.media.v1.SaveToSpaceStoreRequest;
import com.ss.android.lark.utils.ApiUtils;

/* JADX INFO: loaded from: classes35.dex */
public final class f implements zbb.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ybb.a f2911a;

    @Override // zbb.a
    public final void a() {
        new SaveToSpaceStoreRequest.Builder();
        throw null;
    }

    @Override // zbb.a
    public final void b() {
        new GetNutStoreFilePreviewUrlRequest.Builder();
        throw null;
    }

    @Override // zbb.a
    public final void c() {
        new SaveToNutStoreRequest.Builder();
        throw null;
    }

    public f() {
        this.f2911a = (ybb.a) ApiUtils.getApi(ybb.a.class);
    }
}
