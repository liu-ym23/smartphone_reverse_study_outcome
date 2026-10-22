package com.smt.obric.appstore.domain.oapplet;

import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import com.bytedanceos.common.toolbox.j;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.c;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlinx/coroutines/channels/ProducerScope;", "Lcom/smt/obric/appstore/domain/oapplet/b;", "", "<anonymous>", "(Lkotlinx/coroutines/channels/ProducerScope;)V"}, k = 3, mv = {1, 9, 0})
@DebugMetadata(c = "com.smt.obric.appstore.domain.oapplet.OAppletUtilKt$OAppletChangeFlow$1", f = "OAppletUtil.kt", i = {}, l = {246}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nOAppletUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OAppletUtil.kt\ncom/smt/obric/appstore/domain/oapplet/OAppletUtilKt$OAppletChangeFlow$1\n+ 2 Uri.kt\nandroidx/core/net/UriKt\n*L\n1#1,258:1\n29#2:259\n*S KotlinDebug\n*F\n+ 1 OAppletUtil.kt\ncom/smt/obric/appstore/domain/oapplet/OAppletUtilKt$OAppletChangeFlow$1\n*L\n234#1:259\n*E\n"})
public final class OAppletUtilKt$OAppletChangeFlow$1 extends SuspendLambda implements Function2<ProducerScope<? super b>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ String $tag;
    private /* synthetic */ Object L$0;
    int label;

    public static final class a extends ContentObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ProducerScope f18067a;

        public a(ProducerScope r10) {
            this.f18067a = r10;
            super(null);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean r10, Uri r11) {
            j.n("[OApplet] OAppletChangeFlow onChange selfChange: " + r10 + ", uri: " + r11);
            if (r11 != null) goto L6;
            j.p("[OApplet] OAppletChangeFlow onChange uri is null");
            return;
        L6:
            List<String> r12 = r11.getPathSegments();
            if (r12.size() >= 2) goto L11;
            j.p("[OApplet] OAppletChangeFlow onChange uri segments size is less than 2, uri: " + r11);
            return;
        L11:
            if (q.b(r12.get(0), "applet_install_changed") == true) goto L14;
            j.p("[OApplet] OAppletChangeFlow onChange uri segments[0] is not applet_install_changed, uri: " + r11);
            return;
        L14:
            String r13 = r12.get(1);
            ProducerScope r14 = this.f18067a;
            q.d(r13);
            r14.mo53trySendJP2dKIU(new b(r13));
        }
    }

    public OAppletUtilKt$OAppletChangeFlow$1(String r10, Context r11, Continuation<? super OAppletUtilKt$OAppletChangeFlow$1> r12) {
        this.$tag = r10;
        this.$context = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        OAppletUtilKt$OAppletChangeFlow$1 r12 = new OAppletUtilKt$OAppletChangeFlow$1(this.$tag, this.$context, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo0invoke(ProducerScope<? super b> r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r10) {
        Object r11 = kotlin.coroutines.intrinsics.a.d();
        int r12 = this.label;
        if (r12 == 0) goto L8;
        if (r12 != 1) goto L7;
        c.b(r10);
    L20:
        return Unit.f21064a;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        c.b(r10);
        final ProducerScope r13 = (ProducerScope) this.L$0;
        final a r14 = new a(r13);
        Uri r15 = Uri.parse("content://com.obric.appletapp.SystemAppletProvider");
        q.f(r15, "parse(this)");
        final Uri r16 = r15.buildUpon().appendPath("applet_install_changed").build();
        String r17 = this.$tag;
        Context r18 = this.$context;
        Result.a r19 = Result.Companion;     // Catch: Throwable -> L11
        j.n("[OApplet] OAppletChangeFlow registerContentObserver@" + r17 + '/' + r14.hashCode() + " observeUri: " + r16);     // Catch: Throwable -> L11
        r18.getContentResolver().registerContentObserver(r16, true, r14);     // Catch: Throwable -> L11
        Object r20 = Result.m35constructorimpl(Unit.f21064a);     // Catch: Throwable -> L11
    L13:
        Throwable r21 = Result.m38exceptionOrNullimpl(r20);
        if (r21 == null) goto L16;
        j.q("[OApplet] OAppletChangeFlow registerContentObserver failed", r21);
    L16:
        final String r22 = this.$tag;
        final Context r23 = this.$context;
        Function0<Unit> r24 = new AnonymousClass3(r13, r22, r14, r16, r23);
        this.label = 1;
        if (ProduceKt.a(r13, r24, this) != r11) goto L20;
        return r11;
    L11:
        th = move-exception;
        Result.a r25 = Result.Companion;
        r20 = Result.m35constructorimpl(c.a(th));
        goto L13
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull ProducerScope<? super b> r10, @Nullable Continuation<? super Unit> r11) {
        return ((OAppletUtilKt$OAppletChangeFlow$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
