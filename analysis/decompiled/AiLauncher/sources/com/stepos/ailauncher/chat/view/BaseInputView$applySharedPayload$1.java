package com.stepos.ailauncher.chat.view;

import Ua.C1056g;
import android.content.ContentResolver;
import android.net.Uri;
import com.stepos.ailauncher.chat.adapter.C2517x;
import com.zyql.ai.selector.entity.LocalMedia;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.C4109a;
import g9.InterfaceC4112d;
import h8.C4148a;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import l9.C4877a;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.chat.view.BaseInputView$applySharedPayload$1", f = "BaseInputView.kt", l = {9277}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class BaseInputView$applySharedPayload$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ ArrayList<Uri> $allowedUris;
    final /* synthetic */ ContentResolver $resolver;
    Object L$0;
    int label;
    final /* synthetic */ BaseInputView this$0;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"LUa/M;", "Lkotlin/Pair;", "", "Lcom/zyql/ai/selector/entity/LocalMedia;", "<anonymous>", "(LUa/M;)Lkotlin/Pair;"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.ailauncher.chat.view.BaseInputView$applySharedPayload$1$1", f = "BaseInputView.kt", l = {}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.ailauncher.chat.view.BaseInputView$applySharedPayload$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Pair<? extends List<LocalMedia>, ? extends List<LocalMedia>>>, Object> {
        final /* synthetic */ ArrayList<Uri> $allowedUris;
        final /* synthetic */ File $cacheDir;
        final /* synthetic */ ContentResolver $resolver;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ BaseInputView this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ArrayList<Uri> arrayList, ContentResolver contentResolver, BaseInputView baseInputView, File file, InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$allowedUris = arrayList;
            this.$resolver = contentResolver;
            this.this$0 = baseInputView;
            this.$cacheDir = file;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$allowedUris, this.$resolver, this.this$0, this.$cacheDir, interfaceC4014c);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // p9.p
        public final Object invoke(Ua.M m10, InterfaceC4014c<? super Pair<? extends List<LocalMedia>, ? extends List<LocalMedia>>> interfaceC4014c) {
            return ((AnonymousClass1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objB;
            boolean z10;
            AnonymousClass1 anonymousClass1 = this;
            C4063a.g();
            if (anonymousClass1.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            int i10 = 0;
            for (Uri uri : anonymousClass1.$allowedUris) {
                int i11 = i10 + 1;
                String type = anonymousClass1.$resolver.getType(uri);
                String strI9 = anonymousClass1.this$0.i9(uri);
                if (strI9 == null) {
                    strI9 = "share_" + System.currentTimeMillis();
                }
                long jCurrentTimeMillis = System.currentTimeMillis() + i10;
                File file = new File(anonymousClass1.$cacheDir, jCurrentTimeMillis + "_" + strI9);
                ContentResolver contentResolver = anonymousClass1.$resolver;
                try {
                    Result.Companion companion = Result.INSTANCE;
                    InputStream inputStreamOpenInputStream = contentResolver.openInputStream(uri);
                    if (inputStreamOpenInputStream != null) {
                        try {
                            FileOutputStream fileOutputStream = new FileOutputStream(file);
                            try {
                                C4877a.b(inputStreamOpenInputStream, fileOutputStream, 0, 2, null);
                                l9.b.a(fileOutputStream, null);
                                l9.b.a(inputStreamOpenInputStream, null);
                                z10 = true;
                            } finally {
                            }
                        } finally {
                        }
                    } else {
                        z10 = false;
                    }
                    objB = Result.b(C4109a.a(z10));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objB = Result.b(C4849c.a(th));
                }
                Throwable thE = Result.e(objB);
                if (thE != null) {
                    C4148a.t("InputView", "applySharedPayload: copy uri failed " + uri, thE, false, 8, null);
                    objB = C4109a.a(false);
                }
                if (((Boolean) objB).booleanValue()) {
                    LocalMedia localMedia = new LocalMedia();
                    localMedia.setId(jCurrentTimeMillis);
                    localMedia.setPath(uri.toString());
                    localMedia.setFileName(strI9);
                    localMedia.setRealPath(file.getAbsolutePath());
                    localMedia.setSize(file.length());
                    if (type == null || !La.D.X(type, "image/", false, 2, null)) {
                        arrayList2.add(localMedia);
                    } else {
                        arrayList.add(localMedia);
                    }
                }
                anonymousClass1 = this;
                i10 = i11;
            }
            return Y8.j.a(arrayList, arrayList2);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseInputView$applySharedPayload$1(BaseInputView baseInputView, ArrayList<Uri> arrayList, ContentResolver contentResolver, InterfaceC4014c<? super BaseInputView$applySharedPayload$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = baseInputView;
        this.$allowedUris = arrayList;
        this.$resolver = contentResolver;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new BaseInputView$applySharedPayload$1(this.this$0, this.$allowedUris, this.$resolver, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((BaseInputView$applySharedPayload$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            File file = new File(this.this$0.getContext().getCacheDir(), "share_inbox");
            if (!file.exists()) {
                file.mkdirs();
            }
            Ua.I iB = Ua.Y.b();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$allowedUris, this.$resolver, this.this$0, file, null);
            this.L$0 = g9.h.a(file);
            this.label = 1;
            obj = C1056g.j(iB, anonymousClass1, this);
            if (obj == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        Pair pair = (Pair) obj;
        List<? extends LocalMedia> list = (List) pair.a();
        List<? extends LocalMedia> list2 = (List) pair.b();
        if (!list.isEmpty()) {
            this.this$0.dd(list);
        }
        if (!list2.isEmpty()) {
            this.this$0.cd(list2);
        }
        int size = list.size();
        int size2 = list2.size();
        C2517x c2517x = this.this$0.chatInputImageAdapter;
        if (c2517x == null) {
            kotlin.jvm.internal.p.A("chatInputImageAdapter");
            c2517x = null;
        }
        C4148a.d("InputView", "applySharedPayload: done, images=" + size + " files=" + size2 + " adapterItems=" + c2517x.k().size(), false, 4, null);
        return Y8.t.f7040a;
    }
}
