package ch9;

import com.larus.kmp.voice_setting.voice.component.v4;
import com.larus.kmp.voice_setting.voice.entry.VoiceActivityFragmentKind;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v4 f23829a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final VoiceActivityFragmentKind f23830b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f23831c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f23829a, r101.f23829a) == true) goto L12;
        return false;
    L12:
        if (this.f23830b == r101.f23830b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f23831c, r101.f23831c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f23829a.hashCode() * 31) + this.f23830b.hashCode()) * 31) + this.f23831c.hashCode();
    }

    public final String toString() {
        return "VoiceActivityEntryPolicyResult(entryArgsData=" + this.f23829a + ", fragmentKind=" + this.f23830b + ", fragmentArguments=" + this.f23831c + ')';
    }

    public c(v4 r100, VoiceActivityFragmentKind r101, d r102) {
        Intrinsics.checkNotNullParameter(r100, "entryArgsData");
        Intrinsics.checkNotNullParameter(r101, "fragmentKind");
        Intrinsics.checkNotNullParameter(r102, "fragmentArguments");
        this.f23829a = r100;
        this.f23830b = r101;
        this.f23831c = r102;
    }
}
