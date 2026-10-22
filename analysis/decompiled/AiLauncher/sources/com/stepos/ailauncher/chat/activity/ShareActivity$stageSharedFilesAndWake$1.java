package com.stepos.ailauncher.chat.activity;

import Ua.C1056g;
import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;
import com.stepos.ailauncher.chat.R$string;
import com.stepos.ailauncher.chat.wake.WakeService;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.C4109a;
import g9.InterfaceC4112d;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$BooleanRef;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.chat.activity.ShareActivity$stageSharedFilesAndWake$1", f = "ShareActivity.kt", l = {97}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class ShareActivity$stageSharedFilesAndWake$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ Context $appCtx;
    final /* synthetic */ String $text;
    final /* synthetic */ List<Uri> $uris;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ ShareActivity this$0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.ailauncher.chat.activity.ShareActivity$stageSharedFilesAndWake$1$1", f = "ShareActivity.kt", l = {}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.ailauncher.chat.activity.ShareActivity$stageSharedFilesAndWake$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
        final /* synthetic */ Ref$BooleanRef $oversizedFile;
        final /* synthetic */ Ref$BooleanRef $oversizedImage;
        final /* synthetic */ ArrayList<Uri> $staged;
        final /* synthetic */ List<Uri> $uris;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ ShareActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(ShareActivity shareActivity, List<? extends Uri> list, Ref$BooleanRef ref$BooleanRef, Ref$BooleanRef ref$BooleanRef2, ArrayList<Uri> arrayList, InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.this$0 = shareActivity;
            this.$uris = list;
            this.$oversizedImage = ref$BooleanRef;
            this.$oversizedFile = ref$BooleanRef2;
            this.$staged = arrayList;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, this.$uris, this.$oversizedImage, this.$oversizedFile, this.$staged, interfaceC4014c);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // p9.p
        public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return ((AnonymousClass1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objB;
            C4063a.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            File file = new File(this.this$0.getCacheDir(), "share_intake");
            if (!file.exists()) {
                file.mkdirs();
            }
            for (Uri uri : this.$uris) {
                ShareActivity shareActivity = this.this$0;
                try {
                    Result.Companion companion = Result.INSTANCE;
                    objB = Result.b(shareActivity.getContentResolver().getType(uri));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objB = Result.b(C4849c.a(th));
                }
                if (Result.g(objB)) {
                    objB = null;
                }
                String str = (String) objB;
                boolean z10 = false;
                if (str != null && La.D.X(str, "image/", false, 2, null)) {
                    z10 = true;
                }
                long j10 = z10 ? 15728640L : 5242880L;
                long jB = this.this$0.B(uri);
                if (jB <= 0 || jB <= j10) {
                    Uri uriW = this.this$0.w(uri, file);
                    if (uriW != null) {
                        this.$staged.add(uriW);
                    } else {
                        C4109a.f(Log.w("ShareActivity", "stageSharedFilesAndWake: copy failed uri=" + uri));
                    }
                } else {
                    (z10 ? this.$oversizedImage : this.$oversizedFile).f34815a = true;
                    Log.w("ShareActivity", "stageSharedFilesAndWake: reject oversize uri=" + uri + " size=" + jB + " limit=" + j10 + " mime=" + str);
                }
            }
            return Y8.t.f7040a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ShareActivity$stageSharedFilesAndWake$1(List<? extends Uri> list, Context context, ShareActivity shareActivity, String str, InterfaceC4014c<? super ShareActivity$stageSharedFilesAndWake$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$uris = list;
        this.$appCtx = context;
        this.this$0 = shareActivity;
        this.$text = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new ShareActivity$stageSharedFilesAndWake$1(this.$uris, this.$appCtx, this.this$0, this.$text, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((ShareActivity$stageSharedFilesAndWake$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Ref$BooleanRef ref$BooleanRef;
        Ref$BooleanRef ref$BooleanRef2;
        ArrayList arrayList;
        String str;
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            Ref$BooleanRef ref$BooleanRef3 = new Ref$BooleanRef();
            Ref$BooleanRef ref$BooleanRef4 = new Ref$BooleanRef();
            ArrayList arrayList2 = new ArrayList(this.$uris.size());
            Ua.I iB = Ua.Y.b();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, this.$uris, ref$BooleanRef4, ref$BooleanRef3, arrayList2, null);
            this.L$0 = ref$BooleanRef3;
            this.L$1 = ref$BooleanRef4;
            this.L$2 = arrayList2;
            this.label = 1;
            if (C1056g.j(iB, anonymousClass1, this) == objG) {
                return objG;
            }
            ref$BooleanRef = ref$BooleanRef4;
            ref$BooleanRef2 = ref$BooleanRef3;
            arrayList = arrayList2;
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            arrayList = (ArrayList) this.L$2;
            ref$BooleanRef = (Ref$BooleanRef) this.L$1;
            ref$BooleanRef2 = (Ref$BooleanRef) this.L$0;
            C4849c.b(obj);
        }
        if (ref$BooleanRef2.f34815a) {
            Toast.makeText(this.$appCtx, this.this$0.getString(R$string.file_single_size_exceeded, C4109a.g(5L)), 0).show();
        } else if (ref$BooleanRef.f34815a) {
            Toast.makeText(this.$appCtx, this.this$0.getString(R$string.image_single_size_exceeded, C4109a.g(15L)), 0).show();
        }
        if (!arrayList.isEmpty() || ((str = this.$text) != null && !La.H.x0(str))) {
            this.this$0.D(this.$text, arrayList);
            WakeService.Companion companion = WakeService.INSTANCE;
            Context context = this.$appCtx;
            kotlin.jvm.internal.p.f(context);
            companion.K1(context, this.$text, arrayList);
        }
        this.this$0.finish();
        return Y8.t.f7040a;
    }
}
