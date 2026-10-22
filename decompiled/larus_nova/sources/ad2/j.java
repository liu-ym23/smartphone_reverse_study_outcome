package ad2;

import com.ss.bduploader.BDVideoUploader;
import io.reactivex.functions.Action;

/* JADX INFO: loaded from: classes9.dex */
public final class j implements Action {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BDVideoUploader f2968a;

    public j(BDVideoUploader r100) {
        this.f2968a = r100;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        this.f2968a.stop();
    }
}
