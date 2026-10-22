package ak5;

import android.text.TextUtils;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;

/* JADX INFO: loaded from: classes18.dex */
public final class a implements FlowableOnSubscribe<k> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f4001a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b f4002b;

    /* JADX INFO: renamed from: ak5.a$a, reason: collision with other inner class name */
    public class C0077a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FlowableEmitter f4003a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f4004b;

        public C0077a(a r100, FlowableEmitter r101) {
            this.f4004b = r100;
            this.f4003a = r101;
        }

        public final void a(boolean r100, String r101) {
            if (r100 == false) goto L9;
            tt5.a.b("CheckLoginFun", "onCheckOver: you have login, and supported the token, uid=" + r101);
            if (TextUtils.isEmpty(r101) == true) goto L7;
            this.f4004b.f4001a.getClass();
        L7:
            this.f4003a.onNext(this.f4004b.f4001a);
            this.f4003a.onComplete();
            return;
        L9:
            if (this.f4003a.isCancelled() == true) goto L13;
            tt5.a.d("CheckLoginFun", "onCheckOver, not Login uid=" + r101);
            this.f4003a.onError(new Exception("You are not login, so denied your http request."));
            this.f4003a.onComplete();
            return;
        }
    }

    @Override // io.reactivex.FlowableOnSubscribe
    public final void subscribe(FlowableEmitter<k> r100) throws Exception {
        this.f4002b.f4005a.a(new C0077a(this, r100));
    }

    public a(b r100, k r101) {
        this.f4002b = r100;
        this.f4001a = r101;
    }
}
