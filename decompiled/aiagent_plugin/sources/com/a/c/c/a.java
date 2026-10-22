package com.a.c.c;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/* JADX INFO: compiled from: CompositeExecutionTime.java */
/* JADX INFO: loaded from: classes.dex */
public class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<b> f3143a;

    /* JADX INFO: renamed from: lambda$EJzk9k26Q-P02GkSt_TLHocRx8Y, reason: not valid java name */
    public static /* synthetic */ Optional m18lambda$EJzk9k26QP02GkSt_TLHocRx8Y() {
        return Optional.empty();
    }

    public static /* synthetic */ int lambda$TtQn5dtziIti1PX_aWcc53RXd0A(Optional r0, Optional r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ Optional lambda$hgF_bHZYgpAdUEZkt9EtIA7biNc(ZonedDateTime r0, b r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ boolean lambda$yvS8ba_uzbQnyp0w3r_NE0ebUrc(Optional r0) {
        return r0.isPresent();
    }

    public a(List<b> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        com.a.e.a.a(r4, "ExecutionTime list cannot be null or empty");
        this.f3143a = Collections.unmodifiableList(r4);
    }

    private static /* synthetic */ Optional a(ZonedDateTime r2, b r3) {
        return ((b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin")).a(r2);
    }

    @Override // com.a.c.c.b
    public Optional<ZonedDateTime> a(final ZonedDateTime r2) {
        return (Optional) ZeusTransformUtils.preCheckCast(this.f3143a.parallelStream().map(new $$Lambda$a$hgF_bHZYgpAdUEZkt9EtIA7biNc(r2)).filter($$Lambda$a$yvS8ba_uzbQnyp0w3r_NE0ebUrc.INSTANCE).sorted($$Lambda$a$TtQn5dtziIti1PX_aWcc53RXd0A.INSTANCE).findFirst().orElseGet($$Lambda$a$EJzk9k26QP02GkSt_TLHocRx8Y.INSTANCE), Optional.class, "com.obric.aiagent.plugin");
    }

    private static /* synthetic */ int a(Optional r2, Optional r3) {
        if (r2.isPresent() == true) goto L5;
        return 0;
    L5:
        if (r3.isPresent() == true) goto L7;
        return 0;
    L7:
        return ((ZonedDateTime) ZeusTransformUtils.preCheckCast(r2.get(), ZonedDateTime.class, "com.obric.aiagent.plugin")).compareTo((ZonedDateTime) ZeusTransformUtils.preCheckCast(r3.get(), ZonedDateTime.class, "com.obric.aiagent.plugin"));
    }
}
