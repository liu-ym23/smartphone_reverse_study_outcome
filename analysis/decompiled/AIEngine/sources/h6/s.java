package h6;

import com.stepos.aiengine.modelmanager.ModelGroup;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    public final String f9338a;

    /* renamed from: b, reason: collision with root package name */
    public final String f9339b;

    /* renamed from: c, reason: collision with root package name */
    public final String f9340c;

    /* renamed from: d, reason: collision with root package name */
    public final String f9341d;

    /* renamed from: e, reason: collision with root package name */
    public final long f9342e;

    /* renamed from: f, reason: collision with root package name */
    public int f9343f;

    /* renamed from: g, reason: collision with root package name */
    public int f9344g;
    public final boolean h;

    /* renamed from: i, reason: collision with root package name */
    public int f9345i;

    /* renamed from: j, reason: collision with root package name */
    public int f9346j;

    /* renamed from: k, reason: collision with root package name */
    public final String f9347k;

    public s(String abilityId, String otaName, String displayName, String str, long j10, int i10, int i11, boolean z, int i12, int i13, String displayDir) {
        kotlin.jvm.internal.g.f(abilityId, "abilityId");
        kotlin.jvm.internal.g.f(otaName, "otaName");
        kotlin.jvm.internal.g.f(displayName, "displayName");
        kotlin.jvm.internal.g.f(displayDir, "displayDir");
        this.f9338a = abilityId;
        this.f9339b = otaName;
        this.f9340c = displayName;
        this.f9341d = str;
        this.f9342e = j10;
        this.f9343f = i10;
        this.f9344g = i11;
        this.h = z;
        this.f9345i = i12;
        this.f9346j = i13;
        this.f9347k = displayDir;
    }

    public static s a(s sVar, String str, String str2, int i10) {
        String abilityId = sVar.f9338a;
        String otaName = sVar.f9339b;
        String displayName = (i10 & 4) != 0 ? sVar.f9340c : str;
        String description = (i10 & 8) != 0 ? sVar.f9341d : str2;
        long j10 = sVar.f9342e;
        int i11 = sVar.f9343f;
        int i12 = sVar.f9344g;
        boolean z = sVar.h;
        int i13 = sVar.f9345i;
        int i14 = sVar.f9346j;
        String displayDir = (i10 & 1024) != 0 ? sVar.f9347k : "";
        sVar.getClass();
        kotlin.jvm.internal.g.f(abilityId, "abilityId");
        kotlin.jvm.internal.g.f(otaName, "otaName");
        kotlin.jvm.internal.g.f(displayName, "displayName");
        kotlin.jvm.internal.g.f(description, "description");
        kotlin.jvm.internal.g.f(displayDir, "displayDir");
        return new s(abilityId, otaName, displayName, description, j10, i11, i12, z, i13, i14, displayDir);
    }

    public final ModelGroup b() {
        return this.h ? ModelGroup.f5843a : ModelGroup.f5844b;
    }

    public final boolean c() {
        int i10 = this.f9345i;
        if (i10 != 4 && i10 != 3) {
            if (this.f9343f != 4) {
                if (i10 == 1 || i10 == 2 || i10 == 5) {
                }
            }
            return true;
        }
        return false;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof s)) {
            return false;
        }
        s sVar = (s) obj;
        return kotlin.jvm.internal.g.b(this.f9338a, sVar.f9338a) && kotlin.jvm.internal.g.b(this.f9339b, sVar.f9339b) && kotlin.jvm.internal.g.b(this.f9340c, sVar.f9340c) && kotlin.jvm.internal.g.b(this.f9341d, sVar.f9341d) && this.f9342e == sVar.f9342e && this.f9343f == sVar.f9343f && this.f9344g == sVar.f9344g && this.h == sVar.h && this.f9345i == sVar.f9345i && this.f9346j == sVar.f9346j && kotlin.jvm.internal.g.b(this.f9347k, sVar.f9347k);
    }

    public final int hashCode() {
        return this.f9347k.hashCode() + ai.onnxruntime.a.d(this.f9346j, ai.onnxruntime.a.d(this.f9345i, ai.onnxruntime.a.f(ai.onnxruntime.a.d(this.f9344g, ai.onnxruntime.a.d(this.f9343f, a0.a.c(v1.d.a(v1.d.a(v1.d.a(this.f9338a.hashCode() * 31, 31, this.f9339b), 31, this.f9340c), 31, this.f9341d), this.f9342e, 31), 31), 31), 31, this.h), 31), 31);
    }

    public final String toString() {
        int i10 = this.f9343f;
        int i11 = this.f9344g;
        int i12 = this.f9345i;
        int i13 = this.f9346j;
        StringBuilder sbS = ai.onnxruntime.a.s("ModelRow(abilityId=", this.f9338a, ", otaName=", this.f9339b, ", displayName=");
        ai.onnxruntime.a.z(sbS, this.f9340c, ", description=", this.f9341d, ", fileSize=");
        sbS.append(this.f9342e);
        sbS.append(", installStatus=");
        sbS.append(i10);
        sbS.append(", downloadProgress=");
        sbS.append(i11);
        sbS.append(", isPreset=");
        sbS.append(this.h);
        sbS.append(", rawState=");
        sbS.append(i12);
        sbS.append(", remoteVersionCode=");
        sbS.append(i13);
        return ai.onnxruntime.a.p(sbS, ", displayDir=", this.f9347k, ")");
    }
}
