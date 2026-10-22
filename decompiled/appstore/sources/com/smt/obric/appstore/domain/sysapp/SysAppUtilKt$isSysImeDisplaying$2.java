package com.smt.obric.appstore.domain.sysapp;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.bytedanceos.common.toolbox.j;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.smt.obric.appstore.domain.sysapp.SysAppUtilKt$isSysImeDisplaying$2", f = "SysAppUtil.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nSysAppUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SysAppUtil.kt\ncom/smt/obric/appstore/domain/sysapp/SysAppUtilKt$isSysImeDisplaying$2\n+ 2 Uri.kt\nandroidx/core/net/UriKt\n*L\n1#1,193:1\n29#2:194\n*S KotlinDebug\n*F\n+ 1 SysAppUtil.kt\ncom/smt/obric/appstore/domain/sysapp/SysAppUtilKt$isSysImeDisplaying$2\n*L\n168#1:194\n*E\n"})
public final class SysAppUtilKt$isSysImeDisplaying$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ Context $this_isSysImeDisplaying;
    int label;

    public SysAppUtilKt$isSysImeDisplaying$2(Context r10, Continuation<? super SysAppUtilKt$isSysImeDisplaying$2> r11) {
        this.$this_isSysImeDisplaying = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        return new SysAppUtilKt$isSysImeDisplaying$2(this.$this_isSysImeDisplaying, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo0invoke(CoroutineScope r10, Continuation<? super Boolean> r11) {
        return invoke2(r10, r11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [android.content.ContentProviderClient] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r10) {
        kotlin.coroutines.intrinsics.a.d();
        if (this.label != 0) goto L33;
        kotlin.c.b(r10);
        Context r11 = this.$this_isSysImeDisplaying;
        Uri r12 = Uri.parse("content://com.bytedance.android.doubaoime.provider");
        q.f(r12, "parse(this)");
        ?? r13 = 0;
        ContentProviderClient r14 = null;
        ContentProviderClient r15 = r11.getContentResolver().acquireUnstableContentProviderClient(r12);     // Catch: Throwable -> L21 Exception -> L23
        if (r15 == null) goto L9;
        Bundle r16 = r15.call("isInputViewShown", null, null);     // Catch: Throwable -> L10 Exception -> L12
        String r17 = "isSysImeDisplaying provider call ret : extra is " + r16;     // Catch: Throwable -> L10 Exception -> L12
        j.n(r17);     // Catch: Throwable -> L10 Exception -> L12
        if (r16 == null) goto L19;
        Boolean r18 = tf.a.a(r16.getBoolean("result"));     // Catch: Throwable -> L10 Exception -> L12
        r15.close();
        return r18;
    L19:
        j.n("isSysImeDisplaying err: call result err : extra is null");     // Catch: Throwable -> L10 Exception -> L12
        r15.close();
        r13 = r17;
    L27:
        return tf.a.a(false);
    L9:
        return tf.a.a(true);
    L12:
        e = e;
        r14 = r15;
    L24:
        j.n("isSysImeDisplaying provider call err: " + e.getMessage());     // Catch: Throwable -> L21
        e.printStackTrace();     // Catch: Throwable -> L21
        r13 = r14;
        if (r14 == null) goto L27;
        r14.close();
        r13 = r14;
    L10:
        th = th;
        r13 = r15;
    L29:
        if (r13 == 0) goto L31;
        r13.close();
    L31:
        throw th;
    L21:
        th = th;
    L23:
        e = e;
        goto L24
    L33:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Boolean> r11) {
        return ((SysAppUtilKt$isSysImeDisplaying$2) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
