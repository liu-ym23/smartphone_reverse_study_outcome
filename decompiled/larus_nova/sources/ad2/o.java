package ad2;

import com.ss.bduploader.BDImageUploader;
import io.reactivex.functions.Action;

/* JADX INFO: loaded from: classes9.dex */
public final class o implements Action {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BDImageUploader f2987a;

    public o(BDImageUploader r100) {
        this.f2987a = r100;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        this.f2987a.stop();
    }
}
