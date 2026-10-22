package com.bytedance.android.livesdk.interactivity.comment.newinput.provider;

import com.ss.android.socialbase.downloader.exception.BaseException;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class s0<T> implements ObservableOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ List f135959a;

    public static final class a implements e72.b.InterfaceC5750b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ObservableEmitter f135960a;

        public a(ObservableEmitter r100) {
            this.f135960a = r100;
        }

        @Override // e72.b.InterfaceC5750b
        public final void onProgress(int r100) {
            this.f135960a.onNext(Integer.valueOf((r100 * 90) / 100));
        }

        @Override // e72.b.InterfaceC5750b
        public final void onSuccess(List<Pair<String, String>> r100) {
            Intrinsics.checkNotNullParameter(r100, "downloadPairList");
            this.f135960a.onComplete();
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // e72.b.InterfaceC5750b
        public final void a(List<Pair<String, String>> r100, BaseException r101) {
            Intrinsics.checkNotNullParameter(r100, "downloadPairList");
            ObservableEmitter r102 = this.f135960a;
            Throwable r103 = r101;
            if (r101 != null) goto L6;
            r103 = new RuntimeException("download failed.");
        L6:
            r102.onError(r103);
        }
    }

    public s0(List r100) {
        this.f135959a = r100;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(ObservableEmitter<Integer> r100) {
        Intrinsics.checkNotNullParameter(r100, "emitter");
        e72.b r101 = new e72.b(this.f135959a, new a(r100));
        if (r101.f471159a == true) goto L7;
        r101.f471159a = true;
        r101.a();
        return;
    }
}
