package v6;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import com.stepos.base.strategy.ExecutionPreference;
import com.stepos.core.common.util.TraceIdKeys;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public String f13385a;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final String f13394a;

        /* renamed from: b, reason: collision with root package name */
        public final long f13395b;

        public b(String str, long j10) {
            this.f13394a = str;
            this.f13395b = j10;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return kotlin.jvm.internal.g.b(this.f13394a, bVar.f13394a) && this.f13395b == bVar.f13395b;
        }

        public final int hashCode() {
            return Long.hashCode(this.f13395b) + (this.f13394a.hashCode() * 31);
        }

        public final String toString() {
            StringBuilder sbL = com.stepos.core.ota.d.l("AudioMultiFileItem(localPath=", this.f13395b, this.f13394a, ", timeOffsetMs=");
            sbL.append(")");
            return sbL.toString();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class d extends c {

        /* renamed from: b, reason: collision with root package name */
        public final String f13407b;

        /* renamed from: c, reason: collision with root package name */
        public String f13408c;

        public d(String path) {
            kotlin.jvm.internal.g.f(path, "path");
            this.f13407b = path;
            this.f13408c = "";
        }

        @Override // v6.c
        public final void b(String str) {
            kotlin.jvm.internal.g.f(str, "<set-?>");
            this.f13408c = str;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return kotlin.jvm.internal.g.b(this.f13407b, dVar.f13407b) && kotlin.jvm.internal.g.b(this.f13408c, dVar.f13408c);
        }

        public final int hashCode() {
            return this.f13408c.hashCode() + (this.f13407b.hashCode() * 31);
        }

        public final String toString() {
            return h0.e.c("ImagePath(path=", this.f13407b, ", id=", this.f13408c, ")");
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class e extends c {

        /* renamed from: b, reason: collision with root package name */
        public final List<c> f13409b;

        /* renamed from: c, reason: collision with root package name */
        public String f13410c;

        /* renamed from: d, reason: collision with root package name */
        public final Bundle f13411d;

        /* JADX WARN: Multi-variable type inference failed */
        public e(List<? extends c> items, String id2, Bundle bundle) {
            kotlin.jvm.internal.g.f(items, "items");
            kotlin.jvm.internal.g.f(id2, "id");
            this.f13409b = items;
            this.f13410c = id2;
            this.f13411d = bundle;
        }

        @Override // v6.c
        public final void b(String str) {
            kotlin.jvm.internal.g.f(str, "<set-?>");
            this.f13410c = str;
        }

        public final Bundle c() {
            return this.f13411d;
        }

        public final List<c> d() {
            return this.f13409b;
        }

        public final g e() {
            ArrayList arrayList = new ArrayList();
            for (Object obj : this.f13409b) {
                if (obj instanceof g) {
                    arrayList.add(obj);
                }
            }
            return (g) kotlin.collections.a.v0(arrayList);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof e)) {
                return false;
            }
            e eVar = (e) obj;
            return kotlin.jvm.internal.g.b(this.f13409b, eVar.f13409b) && kotlin.jvm.internal.g.b(this.f13410c, eVar.f13410c) && kotlin.jvm.internal.g.b(this.f13411d, eVar.f13411d);
        }

        public final h f() {
            ArrayList arrayList = new ArrayList();
            for (Object obj : this.f13409b) {
                if (obj instanceof h) {
                    arrayList.add(obj);
                }
            }
            return (h) kotlin.collections.a.v0(arrayList);
        }

        public final int hashCode() {
            int iA = v1.d.a(this.f13409b.hashCode() * 31, 31, this.f13410c);
            Bundle bundle = this.f13411d;
            return iA + (bundle == null ? 0 : bundle.hashCode());
        }

        public final String toString() {
            return "Mixed(items=" + this.f13409b + ", id=" + this.f13410c + ", extras=" + this.f13411d + ")";
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class f extends c {

        /* renamed from: b, reason: collision with root package name */
        public final String f13412b;

        /* renamed from: c, reason: collision with root package name */
        public final String f13413c;

        /* renamed from: d, reason: collision with root package name */
        public final Bundle f13414d;

        /* renamed from: e, reason: collision with root package name */
        public String f13415e;

        public f(String name, String str, Bundle args) {
            kotlin.jvm.internal.g.f(name, "name");
            kotlin.jvm.internal.g.f(args, "args");
            this.f13412b = name;
            this.f13413c = str;
            this.f13414d = args;
            this.f13415e = "";
        }

        @Override // v6.c
        public final void b(String str) {
            kotlin.jvm.internal.g.f(str, "<set-?>");
            this.f13415e = str;
        }

        public final Bundle c() {
            return this.f13414d;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof f)) {
                return false;
            }
            f fVar = (f) obj;
            return kotlin.jvm.internal.g.b(this.f13412b, fVar.f13412b) && kotlin.jvm.internal.g.b(this.f13413c, fVar.f13413c) && kotlin.jvm.internal.g.b(this.f13414d, fVar.f13414d) && kotlin.jvm.internal.g.b(this.f13415e, fVar.f13415e);
        }

        public final int hashCode() {
            int iHashCode = this.f13412b.hashCode() * 31;
            String str = this.f13413c;
            return this.f13415e.hashCode() + ((this.f13414d.hashCode() + ((iHashCode + (str == null ? 0 : str.hashCode())) * 31)) * 31);
        }

        public final String toString() {
            String str = this.f13415e;
            StringBuilder sbS = ai.onnxruntime.a.s("SessionRef(name=", this.f13412b, ", prompt=", this.f13413c, ", args=");
            sbS.append(this.f13414d);
            sbS.append(", id=");
            sbS.append(str);
            sbS.append(")");
            return sbS.toString();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class g extends c {

        /* renamed from: b, reason: collision with root package name */
        public final String f13416b;

        /* renamed from: c, reason: collision with root package name */
        public String f13417c;

        /* renamed from: d, reason: collision with root package name */
        public final Bundle f13418d;

        public g(String content, Bundle bundle, int i10) {
            bundle = (i10 & 4) != 0 ? null : bundle;
            kotlin.jvm.internal.g.f(content, "content");
            this.f13416b = content;
            this.f13417c = "";
            this.f13418d = bundle;
        }

        @Override // v6.c
        public final void b(String str) {
            kotlin.jvm.internal.g.f(str, "<set-?>");
            this.f13417c = str;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof g)) {
                return false;
            }
            g gVar = (g) obj;
            return kotlin.jvm.internal.g.b(this.f13416b, gVar.f13416b) && kotlin.jvm.internal.g.b(this.f13417c, gVar.f13417c) && kotlin.jvm.internal.g.b(this.f13418d, gVar.f13418d);
        }

        public final int hashCode() {
            int iA = v1.d.a(this.f13416b.hashCode() * 31, 31, this.f13417c);
            Bundle bundle = this.f13418d;
            return iA + (bundle == null ? 0 : bundle.hashCode());
        }

        public final String toString() {
            StringBuilder sbS = ai.onnxruntime.a.s("Text(content=", this.f13416b, ", id=", this.f13417c, ", extras=");
            sbS.append(this.f13418d);
            sbS.append(")");
            return sbS.toString();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class h extends c {

        /* renamed from: b, reason: collision with root package name */
        public final String f13419b;

        /* renamed from: c, reason: collision with root package name */
        public final long f13420c;

        /* renamed from: d, reason: collision with root package name */
        public final int f13421d;

        /* renamed from: e, reason: collision with root package name */
        public String f13422e;

        public h(long j10, String path, String id2, int i10) {
            kotlin.jvm.internal.g.f(path, "path");
            kotlin.jvm.internal.g.f(id2, "id");
            this.f13419b = path;
            this.f13420c = j10;
            this.f13421d = i10;
            this.f13422e = id2;
        }

        @Override // v6.c
        public final void b(String str) {
            kotlin.jvm.internal.g.f(str, "<set-?>");
            this.f13422e = str;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof h)) {
                return false;
            }
            h hVar = (h) obj;
            return kotlin.jvm.internal.g.b(this.f13419b, hVar.f13419b) && this.f13420c == hVar.f13420c && this.f13421d == hVar.f13421d && kotlin.jvm.internal.g.b(this.f13422e, hVar.f13422e);
        }

        public final int hashCode() {
            return this.f13422e.hashCode() + ai.onnxruntime.a.d(this.f13421d, a0.a.c(this.f13419b.hashCode() * 31, this.f13420c, 31), 31);
        }

        public final String toString() {
            String str = this.f13422e;
            StringBuilder sbL = com.stepos.core.ota.d.l("Video(path=", this.f13420c, this.f13419b, ", durationMs=");
            sbL.append(", frameRate=");
            sbL.append(this.f13421d);
            sbL.append(", id=");
            sbL.append(str);
            sbL.append(")");
            return sbL.toString();
        }
    }

    public final String a() {
        return this.f13385a;
    }

    public abstract void b(String str);

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a extends c {

        /* renamed from: b, reason: collision with root package name */
        public final short[] f13386b;

        /* renamed from: c, reason: collision with root package name */
        public final int f13387c;

        /* renamed from: d, reason: collision with root package name */
        public final String f13388d;

        /* renamed from: e, reason: collision with root package name */
        public final String f13389e;

        /* renamed from: f, reason: collision with root package name */
        public final List<b> f13390f;

        /* renamed from: g, reason: collision with root package name */
        public final ExecutionPreference f13391g;
        public final v6.b h;

        /* renamed from: i, reason: collision with root package name */
        public final Bundle f13392i;

        /* renamed from: j, reason: collision with root package name */
        public String f13393j;

        public a(short[] buffer, int i10, String str, String str2, List<b> list, ExecutionPreference executionPreference, v6.b bVar, Bundle bundle, String str3) {
            kotlin.jvm.internal.g.f(buffer, "buffer");
            this.f13386b = buffer;
            this.f13387c = i10;
            this.f13388d = str;
            this.f13389e = str2;
            this.f13390f = list;
            this.f13391g = executionPreference;
            this.h = bVar;
            this.f13392i = bundle;
            this.f13393j = str3;
        }

        public static a c(a aVar, short[] sArr, String str, ExecutionPreference executionPreference, v6.b bVar, Bundle bundle, int i10) {
            if ((i10 & 1) != 0) {
                sArr = aVar.f13386b;
            }
            short[] buffer = sArr;
            int i11 = aVar.f13387c;
            if ((i10 & 4) != 0) {
                str = aVar.f13388d;
            }
            String str2 = str;
            String str3 = aVar.f13389e;
            List<b> list = aVar.f13390f;
            ExecutionPreference executionPreference2 = (i10 & 32) != 0 ? aVar.f13391g : executionPreference;
            v6.b bVar2 = (i10 & 64) != 0 ? aVar.h : bVar;
            Bundle bundle2 = (i10 & TraceIdKeys.MAX_LENGTH) != 0 ? aVar.f13392i : bundle;
            String id2 = aVar.f13393j;
            aVar.getClass();
            kotlin.jvm.internal.g.f(buffer, "buffer");
            kotlin.jvm.internal.g.f(executionPreference2, "executionPreference");
            kotlin.jvm.internal.g.f(id2, "id");
            return new a(buffer, i11, str2, str3, list, executionPreference2, bVar2, bundle2, id2);
        }

        @Override // v6.c
        public final void b(String str) {
            kotlin.jvm.internal.g.f(str, "<set-?>");
            this.f13393j = str;
        }

        public final boolean d() {
            List<b> list = this.f13390f;
            return !(list == null || list.isEmpty());
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!a.class.equals(obj != null ? obj.getClass() : null)) {
                return false;
            }
            kotlin.jvm.internal.g.d(obj, "null cannot be cast to non-null type com.stepos.base.data.Input.Audio");
            a aVar = (a) obj;
            return Arrays.equals(this.f13386b, aVar.f13386b) && this.f13387c == aVar.f13387c && kotlin.jvm.internal.g.b(this.f13388d, aVar.f13388d) && kotlin.jvm.internal.g.b(this.f13389e, aVar.f13389e) && kotlin.jvm.internal.g.b(this.f13390f, aVar.f13390f) && this.f13391g == aVar.f13391g && kotlin.jvm.internal.g.b(this.h, aVar.h) && kotlin.jvm.internal.g.b(this.f13393j, aVar.f13393j);
        }

        public final int hashCode() {
            int iHashCode = ((Arrays.hashCode(this.f13386b) * 31) + this.f13387c) * 31;
            String str = this.f13388d;
            int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.f13389e;
            int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
            List<b> list = this.f13390f;
            int iHashCode4 = (this.f13391g.hashCode() + ((iHashCode3 + (list != null ? list.hashCode() : 0)) * 31)) * 31;
            v6.b bVar = this.h;
            return this.f13393j.hashCode() + ((iHashCode4 + (bVar != null ? bVar.hashCode() : 0)) * 31);
        }

        public final String toString() {
            String string = Arrays.toString(this.f13386b);
            String str = this.f13393j;
            StringBuilder sbF = h0.e.f("Audio(buffer=", string, ", sampleRate=", this.f13387c, ", audioUrl=");
            ai.onnxruntime.a.z(sbF, this.f13388d, ", localPath=", this.f13389e, ", multiFileItems=");
            sbF.append(this.f13390f);
            sbF.append(", executionPreference=");
            sbF.append(this.f13391g);
            sbF.append(", cloudUploadScene=");
            sbF.append(this.h);
            sbF.append(", extras=");
            sbF.append(this.f13392i);
            sbF.append(", id=");
            return ai.onnxruntime.a.o(sbF, str, ")");
        }

        public /* synthetic */ a(short[] sArr, int i10, String str, String str2, List list, int i11) {
            this(sArr, i10, (i11 & 4) != 0 ? null : str, (i11 & 8) != 0 ? null : str2, (i11 & 16) != 0 ? null : list, ExecutionPreference.f6386a, null, null, "");
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    /* renamed from: v6.c$c, reason: collision with other inner class name */
    public static final class C0155c extends c {

        /* renamed from: b, reason: collision with root package name */
        public final Bitmap f13396b;

        /* renamed from: c, reason: collision with root package name */
        public final String f13397c;

        /* renamed from: d, reason: collision with root package name */
        public final byte[] f13398d;

        /* renamed from: e, reason: collision with root package name */
        public final int f13399e;

        /* renamed from: f, reason: collision with root package name */
        public final Point[] f13400f;

        /* renamed from: g, reason: collision with root package name */
        public final int f13401g;
        public final boolean h;

        /* renamed from: i, reason: collision with root package name */
        public final boolean f13402i;

        /* renamed from: j, reason: collision with root package name */
        public final Rect f13403j;

        /* renamed from: k, reason: collision with root package name */
        public final long f13404k;

        /* renamed from: l, reason: collision with root package name */
        public final Bundle f13405l;

        /* renamed from: m, reason: collision with root package name */
        public String f13406m;

        public C0155c(Bitmap bitmap, String str, byte[] bArr, int i10, Point[] pointArr, int i11, boolean z, boolean z3, Rect rect, long j10, Bundle bundle, String id2) {
            kotlin.jvm.internal.g.f(bitmap, "bitmap");
            kotlin.jvm.internal.g.f(id2, "id");
            this.f13396b = bitmap;
            this.f13397c = str;
            this.f13398d = bArr;
            this.f13399e = i10;
            this.f13400f = pointArr;
            this.f13401g = i11;
            this.h = z;
            this.f13402i = z3;
            this.f13403j = rect;
            this.f13404k = j10;
            this.f13405l = bundle;
            this.f13406m = id2;
        }

        @Override // v6.c
        public final void b(String str) {
            kotlin.jvm.internal.g.f(str, "<set-?>");
            this.f13406m = str;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0155c)) {
                return false;
            }
            C0155c c0155c = (C0155c) obj;
            return kotlin.jvm.internal.g.b(this.f13396b, c0155c.f13396b) && kotlin.jvm.internal.g.b(this.f13397c, c0155c.f13397c) && kotlin.jvm.internal.g.b(this.f13398d, c0155c.f13398d) && this.f13399e == c0155c.f13399e && kotlin.jvm.internal.g.b(this.f13400f, c0155c.f13400f) && this.f13401g == c0155c.f13401g && this.h == c0155c.h && this.f13402i == c0155c.f13402i && kotlin.jvm.internal.g.b(this.f13403j, c0155c.f13403j) && this.f13404k == c0155c.f13404k && kotlin.jvm.internal.g.b(this.f13405l, c0155c.f13405l) && kotlin.jvm.internal.g.b(this.f13406m, c0155c.f13406m);
        }

        public final int hashCode() {
            int iHashCode = this.f13396b.hashCode() * 31;
            String str = this.f13397c;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            byte[] bArr = this.f13398d;
            int iD = ai.onnxruntime.a.d(this.f13399e, (iHashCode2 + (bArr == null ? 0 : Arrays.hashCode(bArr))) * 31, 31);
            Point[] pointArr = this.f13400f;
            int iF = ai.onnxruntime.a.f(ai.onnxruntime.a.f(ai.onnxruntime.a.d(this.f13401g, (iD + (pointArr == null ? 0 : Arrays.hashCode(pointArr))) * 31, 31), 31, this.h), 31, this.f13402i);
            Rect rect = this.f13403j;
            int iC = a0.a.c((iF + (rect == null ? 0 : rect.hashCode())) * 31, this.f13404k, 31);
            Bundle bundle = this.f13405l;
            return this.f13406m.hashCode() + ((iC + (bundle != null ? bundle.hashCode() : 0)) * 31);
        }

        public final String toString() {
            String string = Arrays.toString(this.f13398d);
            String string2 = Arrays.toString(this.f13400f);
            String str = this.f13406m;
            StringBuilder sb2 = new StringBuilder("Image(bitmap=");
            sb2.append(this.f13396b);
            sb2.append(", imagePath=");
            sb2.append(this.f13397c);
            sb2.append(", rawBytes=");
            com.stepos.core.ota.d.o(this.f13399e, string, ", rotateAngle=", ", points=", sb2);
            com.stepos.core.ota.d.o(this.f13401g, string2, ", sampleSize=", ", checkProportion=", sb2);
            sb2.append(this.h);
            sb2.append(", returnImage=");
            sb2.append(this.f13402i);
            sb2.append(", extendEdgesPx=");
            sb2.append(this.f13403j);
            sb2.append(", inferenceSeed=");
            sb2.append(this.f13404k);
            sb2.append(", extras=");
            sb2.append(this.f13405l);
            sb2.append(", id=");
            sb2.append(str);
            sb2.append(")");
            return sb2.toString();
        }

        public /* synthetic */ C0155c(Bitmap bitmap, String str, byte[] bArr, int i10, int i11) {
            this(bitmap, (i11 & 2) != 0 ? null : str, (i11 & 4) != 0 ? null : bArr, 0, null, (i11 & 32) != 0 ? 1 : i10, true, true, null, 0L, null, "");
        }
    }
}
