package bs;

import com.bytedance.retrofit2.client.Client;

/* JADX INFO: loaded from: classes44.dex */
public final class a implements Client.Provider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Client f20208a;

    public a(b r100) {
        this.f20208a = r100;
    }

    @Override // com.bytedance.retrofit2.client.Client.Provider
    public final Client get() {
        return this.f20208a;
    }
}
