package v6;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import com.stepos.base.data.ContourHierarchy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class d {

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a extends d {

        /* renamed from: a, reason: collision with root package name */
        public final String f13423a;

        /* renamed from: b, reason: collision with root package name */
        public final long f13424b;

        /* renamed from: c, reason: collision with root package name */
        public final long f13425c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f13426d;

        /* renamed from: e, reason: collision with root package name */
        public final int f13427e;

        /* renamed from: f, reason: collision with root package name */
        public final String f13428f;

        /* renamed from: g, reason: collision with root package name */
        public final String f13429g;

        public a(String text, long j10, long j11, boolean z, int i10, String cumulativeText, String str) {
            kotlin.jvm.internal.g.f(text, "text");
            kotlin.jvm.internal.g.f(cumulativeText, "cumulativeText");
            this.f13423a = text;
            this.f13424b = j10;
            this.f13425c = j11;
            this.f13426d = z;
            this.f13427e = i10;
            this.f13428f = cumulativeText;
            this.f13429g = str;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return kotlin.jvm.internal.g.b(this.f13423a, aVar.f13423a) && this.f13424b == aVar.f13424b && this.f13425c == aVar.f13425c && this.f13426d == aVar.f13426d && this.f13427e == aVar.f13427e && kotlin.jvm.internal.g.b(this.f13428f, aVar.f13428f) && kotlin.jvm.internal.g.b(this.f13429g, aVar.f13429g);
        }

        public final int hashCode() {
            return this.f13429g.hashCode() + v1.d.a(ai.onnxruntime.a.d(this.f13427e, ai.onnxruntime.a.f(a0.a.c(a0.a.c(this.f13423a.hashCode() * 31, this.f13424b, 31), this.f13425c, 31), 31, this.f13426d), 31), 31, this.f13428f);
        }

        public final String toString() {
            StringBuilder sbL = com.stepos.core.ota.d.l("AsrChunk(text=", this.f13424b, this.f13423a, ", startMs=");
            a0.a.s(this.f13425c, ", endMs=", ", isFinal=", sbL);
            sbL.append(this.f13426d);
            sbL.append(", sentenceIndex=");
            sbL.append(this.f13427e);
            sbL.append(", cumulativeText=");
            return com.stepos.core.ota.d.j(sbL, this.f13428f, ", id=", this.f13429g, ")");
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class c extends d {
        public final boolean equals(Object obj) {
            return this == obj || (obj instanceof c);
        }

        public final int hashCode() {
            throw null;
        }

        public final String toString() {
            return "Classification(results=null, id=null)";
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    /* renamed from: v6.d$d, reason: collision with other inner class name */
    public static final class C0156d extends d {
        public final boolean equals(Object obj) {
            return this == obj || (obj instanceof C0156d);
        }

        public final int hashCode() {
            throw null;
        }

        public final String toString() {
            return "Detection(boxes=null, id=null)";
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class e extends d {

        /* renamed from: a, reason: collision with root package name */
        public final float[] f13435a;

        /* renamed from: b, reason: collision with root package name */
        public final String f13436b;

        public e(String id2, float[] vector) {
            kotlin.jvm.internal.g.f(vector, "vector");
            kotlin.jvm.internal.g.f(id2, "id");
            this.f13435a = vector;
            this.f13436b = id2;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof e)) {
                return false;
            }
            e eVar = (e) obj;
            return kotlin.jvm.internal.g.b(this.f13435a, eVar.f13435a) && kotlin.jvm.internal.g.b(this.f13436b, eVar.f13436b);
        }

        public final int hashCode() {
            return this.f13436b.hashCode() + (Arrays.hashCode(this.f13435a) * 31);
        }

        public final String toString() {
            return h0.e.c("Embedding(vector=", Arrays.toString(this.f13435a), ", id=", this.f13436b, ")");
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class g {

        /* renamed from: a, reason: collision with root package name */
        public final String f13440a;

        /* renamed from: b, reason: collision with root package name */
        public final int f13441b;

        /* renamed from: c, reason: collision with root package name */
        public final int f13442c;

        /* renamed from: d, reason: collision with root package name */
        public final int f13443d;

        /* renamed from: e, reason: collision with root package name */
        public final int f13444e;

        /* renamed from: f, reason: collision with root package name */
        public final float f13445f;

        /* renamed from: g, reason: collision with root package name */
        public final Float f13446g;
        public final Float h;

        /* renamed from: i, reason: collision with root package name */
        public final Float f13447i;

        /* renamed from: j, reason: collision with root package name */
        public final float[] f13448j;

        public g(String faceToken, int i10, int i11, int i12, int i13, float f8, Float f9, Float f10, Float f11, float[] fArr) {
            kotlin.jvm.internal.g.f(faceToken, "faceToken");
            this.f13440a = faceToken;
            this.f13441b = i10;
            this.f13442c = i11;
            this.f13443d = i12;
            this.f13444e = i13;
            this.f13445f = f8;
            this.f13446g = f9;
            this.h = f10;
            this.f13447i = f11;
            this.f13448j = fArr;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!g.class.equals(obj != null ? obj.getClass() : null)) {
                return false;
            }
            kotlin.jvm.internal.g.d(obj, "null cannot be cast to non-null type com.stepos.base.data.Output.FaceBox");
            g gVar = (g) obj;
            float[] fArr = gVar.f13448j;
            if (!kotlin.jvm.internal.g.b(this.f13440a, gVar.f13440a) || this.f13441b != gVar.f13441b || this.f13442c != gVar.f13442c || this.f13443d != gVar.f13443d || this.f13444e != gVar.f13444e || this.f13445f != gVar.f13445f || !kotlin.jvm.internal.g.a(this.f13446g, gVar.f13446g) || !kotlin.jvm.internal.g.a(this.h, gVar.h) || !kotlin.jvm.internal.g.a(this.f13447i, gVar.f13447i)) {
                return false;
            }
            float[] fArr2 = this.f13448j;
            if (fArr2 == null) {
                if (fArr != null) {
                    return false;
                }
            } else if (fArr == null || !Arrays.equals(fArr2, fArr)) {
                return false;
            }
            return true;
        }

        public final int hashCode() {
            int iA = a0.a.a(this.f13445f, ((((((((this.f13440a.hashCode() * 31) + this.f13441b) * 31) + this.f13442c) * 31) + this.f13443d) * 31) + this.f13444e) * 31, 31);
            Float f8 = this.f13446g;
            int iHashCode = (iA + (f8 != null ? f8.hashCode() : 0)) * 31;
            Float f9 = this.h;
            int iHashCode2 = (iHashCode + (f9 != null ? f9.hashCode() : 0)) * 31;
            Float f10 = this.f13447i;
            int iHashCode3 = (iHashCode2 + (f10 != null ? f10.hashCode() : 0)) * 31;
            float[] fArr = this.f13448j;
            return iHashCode3 + (fArr != null ? Arrays.hashCode(fArr) : 0);
        }

        public final String toString() {
            String string = Arrays.toString(this.f13448j);
            StringBuilder sbF = h0.e.f("FaceBox(faceToken=", this.f13440a, ", x=", this.f13441b, ", y=");
            h0.e.l(sbF, this.f13442c, ", width=", this.f13443d, ", height=");
            sbF.append(this.f13444e);
            sbF.append(", score=");
            sbF.append(this.f13445f);
            sbF.append(", yaw=");
            sbF.append(this.f13446g);
            sbF.append(", pitch=");
            sbF.append(this.h);
            sbF.append(", roll=");
            sbF.append(this.f13447i);
            sbF.append(", landmarks=");
            sbF.append(string);
            sbF.append(")");
            return sbF.toString();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class h extends d {

        /* renamed from: a, reason: collision with root package name */
        public final ArrayList f13449a;

        /* renamed from: b, reason: collision with root package name */
        public final String f13450b;

        public h() {
            throw null;
        }

        public h(ArrayList arrayList) {
            this.f13449a = arrayList;
            this.f13450b = "";
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof h)) {
                return false;
            }
            h hVar = (h) obj;
            return kotlin.jvm.internal.g.b(this.f13449a, hVar.f13449a) && kotlin.jvm.internal.g.b(this.f13450b, hVar.f13450b);
        }

        public final int hashCode() {
            return this.f13450b.hashCode() + (this.f13449a.hashCode() * 31);
        }

        public final String toString() {
            return "FaceDetectOutput(faces=" + this.f13449a + ", id=" + this.f13450b + ")";
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class i extends d {

        /* renamed from: a, reason: collision with root package name */
        public final List<j> f13451a;

        /* renamed from: b, reason: collision with root package name */
        public final String f13452b;

        public i() {
            throw null;
        }

        public i(List list) {
            this.f13451a = list;
            this.f13452b = "";
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof i)) {
                return false;
            }
            i iVar = (i) obj;
            return kotlin.jvm.internal.g.b(this.f13451a, iVar.f13451a) && kotlin.jvm.internal.g.b(this.f13452b, iVar.f13452b);
        }

        public final int hashCode() {
            return this.f13452b.hashCode() + (this.f13451a.hashCode() * 31);
        }

        public final String toString() {
            return "FaceEmbedOutput(features=" + this.f13451a + ", id=" + this.f13452b + ")";
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class j {

        /* renamed from: a, reason: collision with root package name */
        public final String f13453a;

        /* renamed from: b, reason: collision with root package name */
        public final List<Float> f13454b;

        /* renamed from: c, reason: collision with root package name */
        public final int f13455c;

        public j(int i10, List feature, String str) {
            kotlin.jvm.internal.g.f(feature, "feature");
            this.f13453a = str;
            this.f13454b = feature;
            this.f13455c = i10;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof j)) {
                return false;
            }
            j jVar = (j) obj;
            return this.f13453a.equals(jVar.f13453a) && kotlin.jvm.internal.g.b(this.f13454b, jVar.f13454b) && this.f13455c == jVar.f13455c;
        }

        public final int hashCode() {
            return ai.onnxruntime.a.d(this.f13455c, h0.e.b(this.f13454b, this.f13453a.hashCode() * 31, 31), 31);
        }

        public final String toString() {
            StringBuilder sb2 = new StringBuilder("FaceFeature(faceToken=");
            sb2.append(this.f13453a);
            sb2.append(", feature=");
            sb2.append(this.f13454b);
            sb2.append(", featureDim=");
            return ai.onnxruntime.a.j(", qualityScore=null)", this.f13455c, sb2);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class k extends d {

        /* renamed from: a, reason: collision with root package name */
        public final float f13456a;

        /* renamed from: b, reason: collision with root package name */
        public final String f13457b;

        public k(float f8, String id2) {
            kotlin.jvm.internal.g.f(id2, "id");
            this.f13456a = f8;
            this.f13457b = id2;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof k)) {
                return false;
            }
            k kVar = (k) obj;
            return Float.compare(this.f13456a, kVar.f13456a) == 0 && kotlin.jvm.internal.g.b(this.f13457b, kVar.f13457b);
        }

        public final int hashCode() {
            return this.f13457b.hashCode() + (Float.hashCode(this.f13456a) * 31);
        }

        public final String toString() {
            return "FaceQualityOutput(qualityScore=" + this.f13456a + ", id=" + this.f13457b + ")";
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class l extends d {

        /* renamed from: a, reason: collision with root package name */
        public final byte[] f13458a;

        /* renamed from: b, reason: collision with root package name */
        public final int f13459b;

        /* renamed from: c, reason: collision with root package name */
        public final int f13460c;

        /* renamed from: d, reason: collision with root package name */
        public final int f13461d;

        /* renamed from: e, reason: collision with root package name */
        public final String f13462e;

        public l(byte[] data, int i10, int i11, int i12, int i13) {
            i12 = (i13 & 8) != 0 ? 1 : i12;
            kotlin.jvm.internal.g.f(data, "data");
            this.f13458a = data;
            this.f13459b = i10;
            this.f13460c = i11;
            this.f13461d = i12;
            this.f13462e = "";
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!l.class.equals(obj != null ? obj.getClass() : null)) {
                return false;
            }
            kotlin.jvm.internal.g.d(obj, "null cannot be cast to non-null type com.stepos.base.data.Output.ImageData");
            l lVar = (l) obj;
            return Arrays.equals(this.f13458a, lVar.f13458a) && this.f13459b == lVar.f13459b && this.f13460c == lVar.f13460c && this.f13461d == lVar.f13461d && kotlin.jvm.internal.g.b(this.f13462e, lVar.f13462e);
        }

        public final int hashCode() {
            return this.f13462e.hashCode() + (((((((Arrays.hashCode(this.f13458a) * 31) + this.f13459b) * 31) + this.f13460c) * 31) + this.f13461d) * 31);
        }

        public final String toString() {
            StringBuilder sbF = h0.e.f("ImageData(data=", Arrays.toString(this.f13458a), ", width=", this.f13459b, ", height=");
            h0.e.l(sbF, this.f13460c, ", format=", this.f13461d, ", id=");
            return ai.onnxruntime.a.o(sbF, this.f13462e, ")");
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class m extends d {

        /* renamed from: a, reason: collision with root package name */
        public final Bitmap f13463a;

        /* renamed from: b, reason: collision with root package name */
        public final List<List<Point>> f13464b;

        /* renamed from: c, reason: collision with root package name */
        public final List<ContourHierarchy> f13465c;

        /* renamed from: d, reason: collision with root package name */
        public final float f13466d;

        /* renamed from: e, reason: collision with root package name */
        public final Rect f13467e;

        /* renamed from: f, reason: collision with root package name */
        public final int f13468f;

        /* renamed from: g, reason: collision with root package name */
        public final String f13469g;

        public m() {
            throw null;
        }

        public m(Bitmap bitmap, List contours, List hierarchies, float f8, Rect region, int i10) {
            kotlin.jvm.internal.g.f(contours, "contours");
            kotlin.jvm.internal.g.f(hierarchies, "hierarchies");
            kotlin.jvm.internal.g.f(region, "region");
            this.f13463a = bitmap;
            this.f13464b = contours;
            this.f13465c = hierarchies;
            this.f13466d = f8;
            this.f13467e = region;
            this.f13468f = i10;
            this.f13469g = "";
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof m)) {
                return false;
            }
            m mVar = (m) obj;
            return kotlin.jvm.internal.g.b(this.f13463a, mVar.f13463a) && kotlin.jvm.internal.g.b(this.f13464b, mVar.f13464b) && kotlin.jvm.internal.g.b(this.f13465c, mVar.f13465c) && Float.compare(this.f13466d, mVar.f13466d) == 0 && kotlin.jvm.internal.g.b(this.f13467e, mVar.f13467e) && this.f13468f == mVar.f13468f && kotlin.jvm.internal.g.b(this.f13469g, mVar.f13469g);
        }

        public final int hashCode() {
            Bitmap bitmap = this.f13463a;
            return this.f13469g.hashCode() + ai.onnxruntime.a.d(this.f13468f, (this.f13467e.hashCode() + a0.a.a(this.f13466d, h0.e.b(this.f13465c, h0.e.b(this.f13464b, (bitmap == null ? 0 : bitmap.hashCode()) * 31, 31), 31), 31)) * 31, 31);
        }

        public final String toString() {
            StringBuilder sb2 = new StringBuilder("ImageMattingOutput(resultBitmap=");
            sb2.append(this.f13463a);
            sb2.append(", contours=");
            sb2.append(this.f13464b);
            sb2.append(", hierarchies=");
            sb2.append(this.f13465c);
            sb2.append(", proportion=");
            sb2.append(this.f13466d);
            sb2.append(", region=");
            sb2.append(this.f13467e);
            sb2.append(", sampleSize=");
            sb2.append(this.f13468f);
            sb2.append(", id=");
            return ai.onnxruntime.a.o(sb2, this.f13469g, ")");
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class n extends d {

        /* renamed from: a, reason: collision with root package name */
        public final float f13470a;

        /* renamed from: b, reason: collision with root package name */
        public final float f13471b;

        /* renamed from: c, reason: collision with root package name */
        public final float f13472c;

        /* renamed from: d, reason: collision with root package name */
        public final float f13473d;

        /* renamed from: e, reason: collision with root package name */
        public final float f13474e;

        /* renamed from: f, reason: collision with root package name */
        public final byte[] f13475f;

        /* renamed from: g, reason: collision with root package name */
        public final int f13476g;
        public final String h;

        public n(float f8, float f9, float f10, float f11, float f12, byte[] data) {
            kotlin.jvm.internal.g.f(data, "data");
            this.f13470a = f8;
            this.f13471b = f9;
            this.f13472c = f10;
            this.f13473d = f11;
            this.f13474e = f12;
            this.f13475f = data;
            this.f13476g = 2;
            this.h = "";
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!n.class.equals(obj != null ? obj.getClass() : null)) {
                return false;
            }
            kotlin.jvm.internal.g.d(obj, "null cannot be cast to non-null type com.stepos.base.data.Output.InpaintPatch");
            n nVar = (n) obj;
            return this.f13470a == nVar.f13470a && this.f13471b == nVar.f13471b && this.f13472c == nVar.f13472c && this.f13473d == nVar.f13473d && this.f13474e == nVar.f13474e && Arrays.equals(this.f13475f, nVar.f13475f) && this.f13476g == nVar.f13476g && kotlin.jvm.internal.g.b(this.h, nVar.h);
        }

        public final int hashCode() {
            return this.h.hashCode() + ((((Arrays.hashCode(this.f13475f) + a0.a.a(this.f13474e, a0.a.a(this.f13473d, a0.a.a(this.f13472c, a0.a.a(this.f13471b, Float.hashCode(this.f13470a) * 31, 31), 31), 31), 31)) * 31) + this.f13476g) * 31);
        }

        public final String toString() {
            return "InpaintPatch(scale=" + this.f13470a + ", x=" + this.f13471b + ", y=" + this.f13472c + ", width=" + this.f13473d + ", height=" + this.f13474e + ", data=" + Arrays.toString(this.f13475f) + ", format=" + this.f13476g + ", id=" + this.h + ")";
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class o extends d {

        /* renamed from: a, reason: collision with root package name */
        public final Bitmap f13477a;

        /* renamed from: b, reason: collision with root package name */
        public final ArrayList f13478b;

        /* renamed from: c, reason: collision with root package name */
        public final List<ContourHierarchy> f13479c;

        /* renamed from: d, reason: collision with root package name */
        public final String f13480d;

        public o() {
            throw null;
        }

        public o(Bitmap resultBitmap, ArrayList arrayList, List hierarchies) {
            kotlin.jvm.internal.g.f(resultBitmap, "resultBitmap");
            kotlin.jvm.internal.g.f(hierarchies, "hierarchies");
            this.f13477a = resultBitmap;
            this.f13478b = arrayList;
            this.f13479c = hierarchies;
            this.f13480d = "";
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof o)) {
                return false;
            }
            o oVar = (o) obj;
            return kotlin.jvm.internal.g.b(this.f13477a, oVar.f13477a) && kotlin.jvm.internal.g.b(this.f13478b, oVar.f13478b) && kotlin.jvm.internal.g.b(this.f13479c, oVar.f13479c) && kotlin.jvm.internal.g.b(this.f13480d, oVar.f13480d);
        }

        public final int hashCode() {
            return this.f13480d.hashCode() + h0.e.b(this.f13479c, (this.f13478b.hashCode() + (this.f13477a.hashCode() * 31)) * 31, 31);
        }

        public final String toString() {
            return "InteractiveSegmentOutput(resultBitmap=" + this.f13477a + ", contours=" + this.f13478b + ", hierarchies=" + this.f13479c + ", id=" + this.f13480d + ")";
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class p extends d {

        /* renamed from: a, reason: collision with root package name */
        public final int f13481a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f13482b;

        /* renamed from: c, reason: collision with root package name */
        public final float[] f13483c;

        /* renamed from: d, reason: collision with root package name */
        public final float[] f13484d;

        /* renamed from: e, reason: collision with root package name */
        public final int f13485e;

        /* renamed from: f, reason: collision with root package name */
        public final String f13486f;

        public p(int i10, boolean z, float[] fArr, float[] fArr2, int i11, String id2) {
            kotlin.jvm.internal.g.f(id2, "id");
            this.f13481a = i10;
            this.f13482b = z;
            this.f13483c = fArr;
            this.f13484d = fArr2;
            this.f13485e = i11;
            this.f13486f = id2;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!p.class.equals(obj != null ? obj.getClass() : null)) {
                return false;
            }
            kotlin.jvm.internal.g.d(obj, "null cannot be cast to non-null type com.stepos.base.data.Output.PrivacyClassify");
            p pVar = (p) obj;
            return this.f13481a == pVar.f13481a && this.f13482b == pVar.f13482b && Arrays.equals(this.f13483c, pVar.f13483c) && Arrays.equals(this.f13484d, pVar.f13484d) && this.f13485e == pVar.f13485e && kotlin.jvm.internal.g.b(this.f13486f, pVar.f13486f);
        }

        public final int hashCode() {
            return this.f13486f.hashCode() + ((((Arrays.hashCode(this.f13484d) + ((Arrays.hashCode(this.f13483c) + ai.onnxruntime.a.f(this.f13481a * 31, 31, this.f13482b)) * 31)) * 31) + this.f13485e) * 31);
        }

        public final String toString() {
            String string = Arrays.toString(this.f13483c);
            String string2 = Arrays.toString(this.f13484d);
            StringBuilder sb2 = new StringBuilder("PrivacyClassify(predictedClass=");
            sb2.append(this.f13481a);
            sb2.append(", label=");
            sb2.append(this.f13482b);
            sb2.append(", logits=");
            ai.onnxruntime.a.z(sb2, string, ", probs=", string2, ", classCount=");
            sb2.append(this.f13485e);
            sb2.append(", id=");
            sb2.append(this.f13486f);
            sb2.append(")");
            return sb2.toString();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class r extends d {
        public final boolean equals(Object obj) {
            return this == obj || (obj instanceof r);
        }

        public final int hashCode() {
            throw null;
        }

        public final String toString() {
            return "VisionOutput(results=null, id=null)";
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class f extends d {

        /* renamed from: a, reason: collision with root package name */
        public final String f13437a;

        /* renamed from: b, reason: collision with root package name */
        public final int f13438b;

        /* renamed from: c, reason: collision with root package name */
        public final String f13439c;

        public f(String message, int i10, String id2) {
            kotlin.jvm.internal.g.f(message, "message");
            kotlin.jvm.internal.g.f(id2, "id");
            this.f13437a = message;
            this.f13438b = i10;
            this.f13439c = id2;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof f)) {
                return false;
            }
            f fVar = (f) obj;
            return kotlin.jvm.internal.g.b(this.f13437a, fVar.f13437a) && this.f13438b == fVar.f13438b && kotlin.jvm.internal.g.b(this.f13439c, fVar.f13439c);
        }

        public final int hashCode() {
            return this.f13439c.hashCode() + ai.onnxruntime.a.d(this.f13438b, this.f13437a.hashCode() * 31, 31);
        }

        public final String toString() {
            return ai.onnxruntime.a.o(h0.e.f("Error(message=", this.f13437a, ", code=", this.f13438b, ", id="), this.f13439c, ")");
        }

        public /* synthetic */ f(String str, int i10, int i11, String str2) {
            this(str, (i11 & 2) != 0 ? 0 : i10, (i11 & 4) != 0 ? "" : str2);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class q extends d {

        /* renamed from: a, reason: collision with root package name */
        public final String f13487a;

        /* renamed from: b, reason: collision with root package name */
        public final String f13488b;

        /* renamed from: c, reason: collision with root package name */
        public final Bundle f13489c;

        public q(String content, String id2, Bundle bundle) {
            kotlin.jvm.internal.g.f(content, "content");
            kotlin.jvm.internal.g.f(id2, "id");
            this.f13487a = content;
            this.f13488b = id2;
            this.f13489c = bundle;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof q)) {
                return false;
            }
            q qVar = (q) obj;
            return kotlin.jvm.internal.g.b(this.f13487a, qVar.f13487a) && kotlin.jvm.internal.g.b(this.f13488b, qVar.f13488b) && kotlin.jvm.internal.g.b(this.f13489c, qVar.f13489c);
        }

        public final int hashCode() {
            int iA = v1.d.a(this.f13487a.hashCode() * 31, 31, this.f13488b);
            Bundle bundle = this.f13489c;
            return iA + (bundle == null ? 0 : bundle.hashCode());
        }

        public final String toString() {
            StringBuilder sbS = ai.onnxruntime.a.s("Text(content=", this.f13487a, ", id=", this.f13488b, ", extras=");
            sbS.append(this.f13489c);
            sbS.append(")");
            return sbS.toString();
        }

        public /* synthetic */ q(String str, String str2, Bundle bundle, int i10) {
            this(str, (i10 & 2) != 0 ? "" : str2, (i10 & 4) != 0 ? null : bundle);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class b extends d {

        /* renamed from: a, reason: collision with root package name */
        public final float[] f13430a;

        /* renamed from: b, reason: collision with root package name */
        public final int f13431b;

        /* renamed from: c, reason: collision with root package name */
        public final int f13432c;

        /* renamed from: d, reason: collision with root package name */
        public final int f13433d;

        /* renamed from: e, reason: collision with root package name */
        public final String f13434e;

        public b(float[] data, int i10, int i11, int i12, String id2) {
            kotlin.jvm.internal.g.f(data, "data");
            kotlin.jvm.internal.g.f(id2, "id");
            this.f13430a = data;
            this.f13431b = i10;
            this.f13432c = i11;
            this.f13433d = i12;
            this.f13434e = id2;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!b.class.equals(obj != null ? obj.getClass() : null)) {
                return false;
            }
            kotlin.jvm.internal.g.d(obj, "null cannot be cast to non-null type com.stepos.base.data.Output.Audio");
            b bVar = (b) obj;
            return Arrays.equals(this.f13430a, bVar.f13430a) && this.f13431b == bVar.f13431b && this.f13432c == bVar.f13432c && this.f13433d == bVar.f13433d && kotlin.jvm.internal.g.b(this.f13434e, bVar.f13434e);
        }

        public final int hashCode() {
            return this.f13434e.hashCode() + (((((((Arrays.hashCode(this.f13430a) * 31) + this.f13431b) * 31) + this.f13432c) * 31) + this.f13433d) * 31);
        }

        public final String toString() {
            StringBuilder sbF = h0.e.f("Audio(data=", Arrays.toString(this.f13430a), ", sampleRate=", this.f13431b, ", channels=");
            h0.e.l(sbF, this.f13432c, ", encoding=", this.f13433d, ", id=");
            return ai.onnxruntime.a.o(sbF, this.f13434e, ")");
        }

        public /* synthetic */ b(float[] fArr, int i10, int i11, int i12) {
            this(fArr, (i12 & 2) != 0 ? 24000 : i10, (i12 & 4) != 0 ? 1 : i11, 4, "");
        }
    }
}
