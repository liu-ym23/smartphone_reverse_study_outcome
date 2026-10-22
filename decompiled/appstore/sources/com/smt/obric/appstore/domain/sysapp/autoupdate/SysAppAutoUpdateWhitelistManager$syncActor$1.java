package com.smt.obric.appstore.domain.sysapp.autoupdate;

import com.bytedanceos.common.toolbox.j;
import com.obric.matrix.platform.sdk.ones.settings.MatrixSettingsManager;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.c;
import kotlin.collections.b0;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.channels.ActorScope;
import kotlinx.coroutines.channels.ChannelIterator;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ActorScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.smt.obric.appstore.domain.sysapp.autoupdate.SysAppAutoUpdateWhitelistManager$syncActor$1", f = "SysAppAutoUpdateWhitelistManager.kt", i = {1}, l = {32, 37}, m = "invokeSuspend", n = {"whitelist"}, s = {"L$1"})
@SourceDebugExtension({"SMAP\nSysAppAutoUpdateWhitelistManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SysAppAutoUpdateWhitelistManager.kt\ncom/smt/obric/appstore/domain/sysapp/autoupdate/SysAppAutoUpdateWhitelistManager$syncActor$1\n+ 2 MatrixSettingsManager.kt\ncom/obric/matrix/platform/sdk/ones/settings/MatrixSettingsManager\n*L\n1#1,85:1\n117#2,7:86\n*S KotlinDebug\n*F\n+ 1 SysAppAutoUpdateWhitelistManager.kt\ncom/smt/obric/appstore/domain/sysapp/autoupdate/SysAppAutoUpdateWhitelistManager$syncActor$1\n*L\n34#1:86,7\n*E\n"})
public final class SysAppAutoUpdateWhitelistManager$syncActor$1 extends SuspendLambda implements Function2<ActorScope<Unit>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    public SysAppAutoUpdateWhitelistManager$syncActor$1(Continuation<? super SysAppAutoUpdateWhitelistManager$syncActor$1> r10) {
        super(2, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        SysAppAutoUpdateWhitelistManager$syncActor$1 r12 = new SysAppAutoUpdateWhitelistManager$syncActor$1(r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo0invoke(ActorScope<Unit> r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x00d0 -> B:55:0x00d3). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r12) {
        Object r10 = kotlin.coroutines.intrinsics.a.d();
        int r11 = this.label;
        if (r11 == 0) goto L14;
        if (r11 == 1) goto L13;
        if (r11 != 2) goto L12;
        List r13 = (List) this.L$1;
        ChannelIterator r14 = (ChannelIterator) this.L$0;
        c.b(r12);     // Catch: Exception -> L9
        ChannelIterator r15 = r14;
    L55:
        j.n("[SysAppAutoUpdateWhitelistManager] syncToPrefs success, size: " + r13.size());     // Catch: Exception -> L46
    L15:
        this.L$0 = r15;
        this.L$1 = null;
        this.label = 1;
        Object r16 = r15.hasNext(this);
        if (r16 != r10) goto L18;
        return r10;
    L18:
        ChannelIterator r17 = r15;
        r12 = r16;
    L20:
        if (((Boolean) r12).booleanValue() == false) goto L52;
        r17.next();
        MatrixSettingsManager r18 = MatrixSettingsManager.f11938g.a();     // Catch: Exception -> L38
        Object r19 = new a(null, 1, null);     // Catch: Exception -> L38
        String r20 = r18.h();     // Catch: Exception -> L38
        if (r20 != null) goto L59;
    L31:
        List r110 = ((a) r19).a();     // Catch: Exception -> L38
        if (r110 != null) goto L34;
    L48:
        j.n("[SysAppAutoUpdateWhitelistManager] syncToPrefs: whitelist is empty");     // Catch: Exception -> L38
        r15 = r17;
        goto L15
    L34:
        if (r110.isEmpty() == true) goto L48;
        SysAppAutoUpdateWhitelistRepository r21 = SysAppAutoUpdateWhitelistManager.a();     // Catch: Exception -> L38
        if (r21 != null) goto L40;
        q.y("repository");     // Catch: Exception -> L38
        r21 = null;
    L40:
        Set r22 = b0.B0(r110);     // Catch: Exception -> L38
        this.L$0 = r17;     // Catch: Exception -> L38
        this.L$1 = r110;     // Catch: Exception -> L38
        this.label = 2;     // Catch: Exception -> L38
        if (r21.g(r22, this) != r10) goto L43;
        return r10;
    L43:
        ChannelIterator r111 = r17;
        r13 = r110;
        r15 = r111;
        goto L55
    L59:
        Object r112 = r18.i().fromJson(r20, new SysAppAutoUpdateWhitelistManager$syncActor$1$invokeSuspend$$inlined$getSetting$1().getType());     // Catch: Exception -> L29
        if (r112 == null) goto L31;
        r19 = r112;
        goto L31
    L29:
        e = move-exception;
        bc.a.f5978a.e("MatrixSettingsManager", "Failed to parse setting to type " + a.class.getSimpleName(), e);     // Catch: Exception -> L38
    L38:
        Exception e10 = e;
    L50:
        j.n("[SysAppAutoUpdateWhitelistManager] syncToPrefs error: " + e10.getMessage());
        r15 = r17;
        goto L15
    L52:
        return Unit.f21064a;
    L46:
        e = move-exception;
        r17 = r15;
        e10 = e;
    L9:
        e10 = e;
        r17 = r14;
        goto L50
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L13:
        r17 = (ChannelIterator) this.L$0;
        c.b(r12);
        goto L20
    L14:
        c.b(r12);
        r15 = ((ActorScope) this.L$0).getChannel().iterator();
        goto L15
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull ActorScope<Unit> r10, @Nullable Continuation<? super Unit> r11) {
        return ((SysAppAutoUpdateWhitelistManager$syncActor$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
