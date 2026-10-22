package aq8;

import com.larus.platform.model.SlashMentionConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final dq8.h f15937a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final dq8.g f15938b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final dq8.f f15939c;

    public d() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f15937a, r101.f15937a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f15938b, r101.f15938b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f15939c, r101.f15939c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f15937a.hashCode() * 31) + this.f15938b.hashCode()) * 31) + this.f15939c.hashCode();
    }

    public final String toString() {
        return "InstructionDependency(host=" + this.f15937a + ", eventSink=" + this.f15938b + ", attachment=" + this.f15939c + ')';
    }

    public /* synthetic */ d(int r100) {
        this(dq8.e.f469696a, dq8.d.f469695a, dq8.c.f469693a);
    }

    public d(dq8.h r100, dq8.g r101, dq8.f r102) {
        Intrinsics.checkNotNullParameter(r100, "host");
        Intrinsics.checkNotNullParameter(r101, "eventSink");
        Intrinsics.checkNotNullParameter(r102, SlashMentionConfig.MENTION_CONTENT_ATTACHMENT);
        this.f15937a = r100;
        this.f15938b = r101;
        this.f15939c = r102;
    }
}
