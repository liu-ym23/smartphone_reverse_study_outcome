package B0;

import K.C0068a0;
import Z2.I;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.os.Process;
import android.util.JsonReader;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import android.widget.TextView;
import androidx.fragment.app.A;
import androidx.room.AbstractC0351g;
import com.airbnb.lottie.LottieComposition;
import com.google.android.material.datepicker.J;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import com.stepos.alphame.R;
import com.stepos.alphame.utils.Property;
import f1.AbstractC0557a;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import s.AbstractC0831a;
import s.AbstractC0840j;
import s.C0835e;
import s.C0839i;
import s0.C;
import s0.C0846d;
import s0.EnumC0843a;
import s0.G;
import u1.C0938a;
import v.AbstractC0950j;
import v.C0944d;
import v.C0948h;

/* loaded from: classes.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    public static Method f144a;

    public static J.b B(Long l4, Long l5) {
        J.b bVar;
        if (l4 == null && l5 == null) {
            return new J.b(null, null);
        }
        if (l4 == null) {
            bVar = new J.b(null, C(l5.longValue()));
        } else {
            if (l5 != null) {
                Calendar calendarF = J.f();
                Calendar calendarG = J.g(null);
                calendarG.setTimeInMillis(l4.longValue());
                Calendar calendarG2 = J.g(null);
                calendarG2.setTimeInMillis(l5.longValue());
                return calendarG.get(1) == calendarG2.get(1) ? calendarG.get(1) == calendarF.get(1) ? new J.b(F(l4.longValue(), Locale.getDefault()), F(l5.longValue(), Locale.getDefault())) : new J.b(F(l4.longValue(), Locale.getDefault()), K(l5.longValue(), Locale.getDefault())) : new J.b(K(l4.longValue(), Locale.getDefault()), K(l5.longValue(), Locale.getDefault()));
            }
            bVar = new J.b(C(l4.longValue()), null);
        }
        return bVar;
    }

    public static final int B0(G state) {
        Intrinsics.checkNotNullParameter(state, "state");
        switch (x.$EnumSwitchMapping$0[state.ordinal()]) {
            case 1:
                return 0;
            case 2:
                return 1;
            case 3:
                return 2;
            case 4:
                return 3;
            case 5:
                return 4;
            case 6:
                return 5;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static String C(long j4) {
        Calendar calendarF = J.f();
        Calendar calendarG = J.g(null);
        calendarG.setTimeInMillis(j4);
        return calendarF.get(1) == calendarG.get(1) ? F(j4, Locale.getDefault()) : K(j4, Locale.getDefault());
    }

    public static boolean C0(int i4, int i5, int i6, int i7) {
        return (i6 == 1 || i6 == 2 || (i6 == 4 && i4 != 2)) || (i7 == 1 || i7 == 2 || (i7 == 4 && i5 != 2));
    }

    public static Drawable D(Context context, TypedArray typedArray, int i4) {
        int resourceId;
        Drawable drawableO;
        return (!typedArray.hasValue(i4) || (resourceId = typedArray.getResourceId(i4, 0)) == 0 || (drawableO = I.o(context, resourceId)) == null) ? typedArray.getDrawable(i4) : drawableO;
    }

    public static int D0(Parcel parcel) {
        int i4 = parcel.readInt();
        int iQ0 = q0(parcel, i4);
        int iDataPosition = parcel.dataPosition();
        if (((char) i4) != 20293) {
            throw new A("Expected object header. Got 0x".concat(String.valueOf(Integer.toHexString(i4))), parcel);
        }
        int i5 = iQ0 + iDataPosition;
        if (i5 < iDataPosition || i5 > parcel.dataSize()) {
            throw new A(g.k("Size read is invalid start=", iDataPosition, " end=", i5), parcel);
        }
        return i5;
    }

    public static void E(List list) {
        Iterator it = list.iterator();
        if (it.hasNext()) {
            g.y(it.next());
            throw null;
        }
    }

    public static void E0(StringBuilder sb, HashMap map) {
        sb.append("{");
        boolean z4 = true;
        for (String str : map.keySet()) {
            if (!z4) {
                sb.append(",");
            }
            String str2 = (String) map.get(str);
            AbstractC0831a.h(sb, "\"", str, "\":");
            if (str2 == null) {
                sb.append("null");
            } else {
                AbstractC0831a.h(sb, "\"", str2, "\"");
            }
            z4 = false;
        }
        sb.append("}");
    }

    public static String F(long j4, Locale locale) {
        return J.b("MMMd", locale).format(new Date(j4));
    }

    public static void F0(Parcel parcel, int i4, int i5) {
        if (i4 == i5) {
            return;
        }
        throw new A(g.r(g.u("Expected size ", i5, " got ", i4, " (0x"), Integer.toHexString(i4), ")"), parcel);
    }

    public static Intent G(Activity activity) {
        Intent parentActivityIntent = activity.getParentActivityIntent();
        if (parentActivityIntent != null) {
            return parentActivityIntent;
        }
        String strI = I(activity);
        if (strI == null) {
            return null;
        }
        ComponentName componentName = new ComponentName(activity, strI);
        try {
            return J(activity, componentName) == null ? Intent.makeMainActivity(componentName) : new Intent().setComponent(componentName);
        } catch (PackageManager.NameNotFoundException unused) {
            Log.e("NavUtils", "getParentActivityIntent: bad parentActivityName '" + strI + "' in manifest");
            return null;
        }
    }

    public static String G0(int i4) {
        if (i4 == 100) {
            return "HIGH_ACCURACY";
        }
        if (i4 == 102) {
            return "BALANCED_POWER_ACCURACY";
        }
        if (i4 == 104) {
            return "LOW_POWER";
        }
        if (i4 == 105) {
            return "PASSIVE";
        }
        throw new IllegalArgumentException();
    }

    public static Intent H(Context context, ComponentName componentName) throws PackageManager.NameNotFoundException {
        String strJ = J(context, componentName);
        if (strJ == null) {
            return null;
        }
        ComponentName componentName2 = new ComponentName(componentName.getPackageName(), strJ);
        return J(context, componentName2) == null ? Intent.makeMainActivity(componentName2) : new Intent().setComponent(componentName2);
    }

    public static void H0(Parcel parcel, int i4, int i5) {
        int iQ0 = q0(parcel, i4);
        if (iQ0 == i5) {
            return;
        }
        throw new A(g.r(g.u("Expected size ", i5, " got ", iQ0, " (0x"), Integer.toHexString(iQ0), ")"), parcel);
    }

    public static String I(Activity activity) {
        try {
            return J(activity, activity.getComponentName());
        } catch (PackageManager.NameNotFoundException e4) {
            throw new IllegalArgumentException(e4);
        }
    }

    public static String J(Context context, ComponentName componentName) throws PackageManager.NameNotFoundException {
        String string;
        ActivityInfo activityInfo = context.getPackageManager().getActivityInfo(componentName, 269222528);
        String str = activityInfo.parentActivityName;
        if (str != null) {
            return str;
        }
        Bundle bundle = activityInfo.metaData;
        if (bundle == null || (string = bundle.getString("android.support.PARENT_ACTIVITY")) == null) {
            return null;
        }
        if (string.charAt(0) != '.') {
            return string;
        }
        return context.getPackageName() + string;
    }

    public static String K(long j4, Locale locale) {
        return J.b("yMMMd", locale).format(new Date(j4));
    }

    public static int L(int i4) {
        if (i4 == 1) {
            return 0;
        }
        if (i4 == 2) {
            return 1;
        }
        if (i4 == 4) {
            return 2;
        }
        if (i4 == 8) {
            return 3;
        }
        if (i4 == 16) {
            return 4;
        }
        if (i4 == 32) {
            return 5;
        }
        if (i4 == 64) {
            return 6;
        }
        if (i4 == 128) {
            return 7;
        }
        if (i4 == 256) {
            return 8;
        }
        throw new IllegalArgumentException(AbstractC0351g.m("type needs to be >= FIRST and <= LAST, type=", i4));
    }

    public static final EnumC0843a M(int i4) {
        if (i4 == 0) {
            return EnumC0843a.f14167a;
        }
        if (i4 == 1) {
            return EnumC0843a.f14168b;
        }
        throw new IllegalArgumentException(g.j("Could not convert ", i4, " to BackoffPolicy"));
    }

    public static final s0.u N(int i4) {
        if (i4 == 0) {
            return s0.u.f14214a;
        }
        if (i4 == 1) {
            return s0.u.f14215b;
        }
        if (i4 == 2) {
            return s0.u.f14216c;
        }
        if (i4 == 3) {
            return s0.u.f14217d;
        }
        if (i4 == 4) {
            return s0.u.f14218e;
        }
        if (i4 == 5) {
            return s0.u.f14219f;
        }
        throw new IllegalArgumentException(g.j("Could not convert ", i4, " to NetworkType"));
    }

    public static final C O(int i4) {
        if (i4 == 0) {
            return C.f14150a;
        }
        if (i4 == 1) {
            return C.f14151b;
        }
        throw new IllegalArgumentException(g.j("Could not convert ", i4, " to OutOfQuotaPolicy"));
    }

    public static final G P(int i4) {
        if (i4 == 0) {
            return G.f14153a;
        }
        if (i4 == 1) {
            return G.f14154b;
        }
        if (i4 == 2) {
            return G.f14155c;
        }
        if (i4 == 3) {
            return G.f14156d;
        }
        if (i4 == 4) {
            return G.f14157e;
        }
        if (i4 == 5) {
            return G.f14158f;
        }
        throw new IllegalArgumentException(g.j("Could not convert ", i4, " to State"));
    }

    public static boolean Q(Context context) {
        return context.getResources().getConfiguration().fontScale >= 1.3f;
    }

    public static MappedByteBuffer S(Context context, Uri uri) throws IOException {
        try {
            ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(uri, "r", null);
            if (parcelFileDescriptorOpenFileDescriptor == null) {
                if (parcelFileDescriptorOpenFileDescriptor != null) {
                    parcelFileDescriptorOpenFileDescriptor.close();
                }
                return null;
            }
            try {
                FileInputStream fileInputStream = new FileInputStream(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor());
                try {
                    FileChannel channel = fileInputStream.getChannel();
                    MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_ONLY, 0L, channel.size());
                    fileInputStream.close();
                    parcelFileDescriptorOpenFileDescriptor.close();
                    return map;
                } finally {
                }
            } finally {
            }
        } catch (IOException unused) {
            return null;
        }
    }

    public static final int T(s0.u networkType) {
        Intrinsics.checkNotNullParameter(networkType, "networkType");
        int iOrdinal = networkType.ordinal();
        if (iOrdinal == 0) {
            return 0;
        }
        if (iOrdinal == 1) {
            return 1;
        }
        if (iOrdinal == 2) {
            return 2;
        }
        if (iOrdinal == 3) {
            return 3;
        }
        if (iOrdinal == 4) {
            return 4;
        }
        if (networkType == s0.u.f14219f) {
            return 5;
        }
        throw new IllegalArgumentException("Could not convert " + networkType + " to int");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static K0.c W(android.util.JsonReader r17, com.airbnb.lottie.LottieComposition r18) {
        /*
            Method dump skipped, instructions count: 340
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: B0.f.W(android.util.JsonReader, com.airbnb.lottie.LottieComposition):K0.c");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:97:0x0188. Please report as an issue. */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x021d  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0248  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x03f4 A[PHI: r37
      0x03f4: PHI (r37v10 java.lang.String) = (r37v5 java.lang.String), (r37v6 java.lang.String), (r37v11 java.lang.String) binds: [B:229:0x0421, B:225:0x0416, B:214:0x03f2] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x006e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static M0.e X(android.util.JsonReader r42, com.airbnb.lottie.LottieComposition r43) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1602
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: B0.f.X(android.util.JsonReader, com.airbnb.lottie.LottieComposition):M0.e");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:102:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x037c A[PHI: r29
      0x037c: PHI (r29v11 q.i) = (r29v4 q.i), (r29v5 q.i), (r29v6 q.i), (r29v7 q.i), (r29v8 q.i), (r29v9 q.i), (r29v12 q.i) binds: [B:209:0x03c5, B:205:0x03b9, B:201:0x03ad, B:197:0x03a0, B:193:0x0393, B:189:0x0387, B:186:0x037a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x005a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.airbnb.lottie.LottieComposition Y(android.util.JsonReader r34) throws java.io.IOException, java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 1322
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: B0.f.Y(android.util.JsonReader):com.airbnb.lottie.LottieComposition");
    }

    public static K0.a Z(JsonReader jsonReader, LottieComposition lottieComposition) {
        return new K0.a(0, AbstractC0557a.S(1.0f, jsonReader, lottieComposition, O0.a.f1523a));
    }

    public static String a(String str) {
        if (str == null || str.isEmpty()) {
            return "";
        }
        if (str.length() == 1) {
            return str;
        }
        if (str.length() == 2) {
            return str.charAt(0) + "*";
        }
        return str.charAt(0) + "*" + str.substring(str.length() - 1);
    }

    public static K0.b a0(JsonReader jsonReader, LottieComposition lottieComposition, boolean z4) {
        return new K0.b(AbstractC0557a.S(z4 ? P0.c.c() : 1.0f, jsonReader, lottieComposition, O0.c.f1525a), 2);
    }

    public static byte[] b(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Parameter may not be null");
        }
        try {
            return str.getBytes("US-ASCII");
        } catch (UnsupportedEncodingException unused) {
            throw new Error("HttpClient requires ASCII support");
        }
    }

    public static K0.a b0(JsonReader jsonReader, LottieComposition lottieComposition) {
        return new K0.a(2, AbstractC0557a.S(1.0f, jsonReader, lottieComposition, O0.d.f1526a));
    }

    public static final LinkedHashSet c(byte[] bytes) {
        ObjectInputStream objectInputStream;
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (bytes.length == 0) {
            return linkedHashSet;
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        try {
            try {
                objectInputStream = new ObjectInputStream(byteArrayInputStream);
            } catch (IOException e4) {
                e4.printStackTrace();
            }
            try {
                int i4 = objectInputStream.readInt();
                for (int i5 = 0; i5 < i4; i5++) {
                    Uri uri = Uri.parse(objectInputStream.readUTF());
                    boolean z4 = objectInputStream.readBoolean();
                    Intrinsics.checkNotNullExpressionValue(uri, "uri");
                    linkedHashSet.add(new C0846d(z4, uri));
                }
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(objectInputStream, null);
                Unit unit2 = Unit.INSTANCE;
                CloseableKt.closeFinally(byteArrayInputStream, null);
                return linkedHashSet;
            } finally {
            }
        } finally {
        }
    }

    public static K0.a c0(JsonReader jsonReader, LottieComposition lottieComposition) {
        return new K0.a(3, AbstractC0557a.S(P0.c.c(), jsonReader, lottieComposition, O0.h.f1531a));
    }

    public static final void d(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        for (View view2 : SequencesKt.sequence(new C0068a0(view, null))) {
            P.a aVar = (P.a) view2.getTag(R.id.pooling_container_listener_holder_tag);
            if (aVar == null) {
                aVar = new P.a();
                view2.setTag(R.id.pooling_container_listener_holder_tag, aVar);
            }
            ArrayList arrayList = aVar.f1545a;
            int lastIndex = CollectionsKt.getLastIndex(arrayList);
            if (-1 < lastIndex) {
                g.y(arrayList.get(lastIndex));
                throw null;
            }
        }
    }

    public static F1.p d0(com.google.gson.stream.JsonReader jsonReader) {
        boolean zIsLenient = jsonReader.isLenient();
        jsonReader.setLenient(true);
        try {
            try {
                return com.airbnb.lottie.h.A(jsonReader);
            } catch (OutOfMemoryError e4) {
                throw new A("Failed parsing JSON source: " + jsonReader + " to Json", 5, e4);
            } catch (StackOverflowError e5) {
                throw new A("Failed parsing JSON source: " + jsonReader + " to Json", 5, e5);
            }
        } finally {
            jsonReader.setLenient(zIsLenient);
        }
    }

    public static F1.p e0(String str) {
        try {
            com.google.gson.stream.JsonReader jsonReader = new com.google.gson.stream.JsonReader(new StringReader(str));
            F1.p pVarD0 = d0(jsonReader);
            pVarD0.getClass();
            if (!(pVarD0 instanceof F1.r) && jsonReader.peek() != JsonToken.END_DOCUMENT) {
                throw new F1.q("Did not consume the entire document.", 5);
            }
            return pVarD0;
        } catch (MalformedJsonException e4) {
            throw new F1.q(5, e4);
        } catch (IOException e5) {
            throw new F1.q(5, e5);
        } catch (NumberFormatException e6) {
            throw new F1.q(5, e6);
        }
    }

    public static void f0(AnimatorSet animatorSet, ArrayList arrayList) {
        int size = arrayList.size();
        long jMax = 0;
        for (int i4 = 0; i4 < size; i4++) {
            Animator animator = (Animator) arrayList.get(i4);
            jMax = Math.max(jMax, animator.getDuration() + animator.getStartDelay());
        }
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, 0);
        valueAnimatorOfInt.setDuration(jMax);
        arrayList.add(0, valueAnimatorOfInt);
        animatorSet.playTogether(arrayList);
    }

    public static int i(Context context, String str) {
        if (str != null) {
            return context.checkPermission(str, Process.myPid(), Process.myUid());
        }
        throw new NullPointerException("permission must be non-null");
    }

    public static boolean i0(Parcel parcel, int i4) {
        H0(parcel, i4, 4);
        return parcel.readInt() != 0;
    }

    public static BigDecimal j(Parcel parcel, int i4) {
        int iQ0 = q0(parcel, i4);
        int iDataPosition = parcel.dataPosition();
        if (iQ0 == 0) {
            return null;
        }
        byte[] bArrCreateByteArray = parcel.createByteArray();
        int i5 = parcel.readInt();
        parcel.setDataPosition(iDataPosition + iQ0);
        return new BigDecimal(new BigInteger(bArrCreateByteArray), i5);
    }

    public static byte j0(Parcel parcel, int i4) {
        H0(parcel, i4, 4);
        return (byte) parcel.readInt();
    }

    public static Bundle k(Parcel parcel, int i4) {
        int iQ0 = q0(parcel, i4);
        int iDataPosition = parcel.dataPosition();
        if (iQ0 == 0) {
            return null;
        }
        Bundle bundle = parcel.readBundle();
        parcel.setDataPosition(iDataPosition + iQ0);
        return bundle;
    }

    public static double k0(Parcel parcel, int i4) {
        H0(parcel, i4, 8);
        return parcel.readDouble();
    }

    public static byte[] l(Parcel parcel, int i4) {
        int iQ0 = q0(parcel, i4);
        int iDataPosition = parcel.dataPosition();
        if (iQ0 == 0) {
            return null;
        }
        byte[] bArrCreateByteArray = parcel.createByteArray();
        parcel.setDataPosition(iDataPosition + iQ0);
        return bArrCreateByteArray;
    }

    public static float l0(Parcel parcel, int i4) {
        H0(parcel, i4, 4);
        return parcel.readFloat();
    }

    public static f m(int i4) {
        if (i4 != 0 && i4 == 1) {
            return new y1.e();
        }
        return new y1.l();
    }

    public static Float m0(Parcel parcel, int i4) {
        int iQ0 = q0(parcel, i4);
        if (iQ0 == 0) {
            return null;
        }
        F0(parcel, iQ0, 4);
        return Float.valueOf(parcel.readFloat());
    }

    public static y1.f n() {
        return new y1.f(0);
    }

    public static IBinder n0(Parcel parcel, int i4) {
        int iQ0 = q0(parcel, i4);
        int iDataPosition = parcel.dataPosition();
        if (iQ0 == 0) {
            return null;
        }
        IBinder strongBinder = parcel.readStrongBinder();
        parcel.setDataPosition(iDataPosition + iQ0);
        return strongBinder;
    }

    public static int[] o(Parcel parcel, int i4) {
        int iQ0 = q0(parcel, i4);
        int iDataPosition = parcel.dataPosition();
        if (iQ0 == 0) {
            return null;
        }
        int[] iArrCreateIntArray = parcel.createIntArray();
        parcel.setDataPosition(iDataPosition + iQ0);
        return iArrCreateIntArray;
    }

    public static int o0(Parcel parcel, int i4) {
        H0(parcel, i4, 4);
        return parcel.readInt();
    }

    public static Parcelable p(Parcel parcel, int i4, Parcelable.Creator creator) {
        int iQ0 = q0(parcel, i4);
        int iDataPosition = parcel.dataPosition();
        if (iQ0 == 0) {
            return null;
        }
        Parcelable parcelable = (Parcelable) creator.createFromParcel(parcel);
        parcel.setDataPosition(iDataPosition + iQ0);
        return parcelable;
    }

    public static long p0(Parcel parcel, int i4) {
        H0(parcel, i4, 8);
        return parcel.readLong();
    }

    public static String q(Parcel parcel, int i4) {
        int iQ0 = q0(parcel, i4);
        int iDataPosition = parcel.dataPosition();
        if (iQ0 == 0) {
            return null;
        }
        String string = parcel.readString();
        parcel.setDataPosition(iDataPosition + iQ0);
        return string;
    }

    public static int q0(Parcel parcel, int i4) {
        return (i4 & (-65536)) != -65536 ? (char) (i4 >> 16) : parcel.readInt();
    }

    public static Object[] r(Parcel parcel, int i4, Parcelable.Creator creator) {
        int iQ0 = q0(parcel, i4);
        int iDataPosition = parcel.dataPosition();
        if (iQ0 == 0) {
            return null;
        }
        Object[] objArrCreateTypedArray = parcel.createTypedArray(creator);
        parcel.setDataPosition(iDataPosition + iQ0);
        return objArrCreateTypedArray;
    }

    public static final void r0(View view, androidx.lifecycle.G g4) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setTag(R.id.view_tree_lifecycle_owner, g4);
    }

    public static ArrayList s(Parcel parcel, int i4, Parcelable.Creator creator) {
        int iQ0 = q0(parcel, i4);
        int iDataPosition = parcel.dataPosition();
        if (iQ0 == 0) {
            return null;
        }
        ArrayList arrayListCreateTypedArrayList = parcel.createTypedArrayList(creator);
        parcel.setDataPosition(iDataPosition + iQ0);
        return arrayListCreateTypedArrayList;
    }

    public static void t(Parcel parcel, int i4) {
        if (parcel.dataPosition() != i4) {
            throw new A(AbstractC0351g.m("Overread allowed size end=", i4), parcel);
        }
    }

    public static w.o u(C0944d c0944d, int i4, ArrayList arrayList, w.o oVar) {
        int i5;
        int i6 = i4 == 0 ? c0944d.f15576n0 : c0944d.f15578o0;
        if (i6 != -1 && (oVar == null || i6 != oVar.f15781b)) {
            int i7 = 0;
            while (true) {
                if (i7 >= arrayList.size()) {
                    break;
                }
                w.o oVar2 = (w.o) arrayList.get(i7);
                if (oVar2.f15781b == i6) {
                    if (oVar != null) {
                        oVar.c(i4, oVar2);
                        arrayList.remove(oVar);
                    }
                    oVar = oVar2;
                } else {
                    i7++;
                }
            }
        } else if (i6 != -1) {
            return oVar;
        }
        if (oVar == null) {
            if (c0944d instanceof AbstractC0950j) {
                AbstractC0950j abstractC0950j = (AbstractC0950j) c0944d;
                int i8 = 0;
                while (true) {
                    if (i8 >= abstractC0950j.f15672r0) {
                        i5 = -1;
                        break;
                    }
                    C0944d c0944d2 = abstractC0950j.f15671q0[i8];
                    if ((i4 == 0 && (i5 = c0944d2.f15576n0) != -1) || (i4 == 1 && (i5 = c0944d2.f15578o0) != -1)) {
                        break;
                    }
                    i8++;
                }
                if (i5 != -1) {
                    int i9 = 0;
                    while (true) {
                        if (i9 >= arrayList.size()) {
                            break;
                        }
                        w.o oVar3 = (w.o) arrayList.get(i9);
                        if (oVar3.f15781b == i5) {
                            oVar = oVar3;
                            break;
                        }
                        i9++;
                    }
                }
            }
            if (oVar == null) {
                oVar = new w.o();
                oVar.f15780a = new ArrayList();
                oVar.f15783d = null;
                oVar.f15784e = -1;
                int i10 = w.o.f15779f;
                w.o.f15779f = i10 + 1;
                oVar.f15781b = i10;
                oVar.f15782c = i4;
            }
            arrayList.add(oVar);
        }
        ArrayList arrayList2 = oVar.f15780a;
        if (!arrayList2.contains(c0944d)) {
            arrayList2.add(c0944d);
            if (c0944d instanceof C0948h) {
                C0948h c0948h = (C0948h) c0944d;
                c0948h.f15668t0.c(c0948h.f15669u0 == 0 ? 1 : 0, oVar, arrayList);
            }
            int i11 = oVar.f15781b;
            if (i4 == 0) {
                c0944d.f15576n0 = i11;
                c0944d.f15532I.c(i4, oVar, arrayList);
                c0944d.f15534K.c(i4, oVar, arrayList);
            } else {
                c0944d.f15578o0 = i11;
                c0944d.f15533J.c(i4, oVar, arrayList);
                c0944d.f15536M.c(i4, oVar, arrayList);
                c0944d.f15535L.c(i4, oVar, arrayList);
            }
            c0944d.f15539P.c(i4, oVar, arrayList);
        }
        return oVar;
    }

    public static final k v(r rVar) {
        Intrinsics.checkNotNullParameter(rVar, "<this>");
        return new k(rVar.f167a, rVar.f186t);
    }

    public static void v0(TextView textView, int i4) {
        com.airbnb.lottie.h.g(i4);
        if (i4 != textView.getPaint().getFontMetricsInt(null)) {
            textView.setLineSpacing(i4 - r0, 1.0f);
        }
    }

    public static final byte[] w0(Set triggers) {
        Intrinsics.checkNotNullParameter(triggers, "triggers");
        if (triggers.isEmpty()) {
            return new byte[0];
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            try {
                objectOutputStream.writeInt(triggers.size());
                Iterator it = triggers.iterator();
                while (it.hasNext()) {
                    C0846d c0846d = (C0846d) it.next();
                    objectOutputStream.writeUTF(c0846d.f14182a.toString());
                    objectOutputStream.writeBoolean(c0846d.f14183b);
                }
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(objectOutputStream, null);
                CloseableKt.closeFinally(byteArrayOutputStream, null);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                Intrinsics.checkNotNullExpressionValue(byteArray, "outputStream.toByteArray()");
                return byteArray;
            } finally {
            }
        } finally {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0047, code lost:
    
        if (r5.f266c == r9.hashCode()) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.content.res.ColorStateList x(int r8, android.content.Context r9) throws android.content.res.Resources.NotFoundException {
        /*
            android.content.res.Resources r0 = r9.getResources()
            android.content.res.Resources$Theme r9 = r9.getTheme()
            C.m r1 = new C.m
            r1.<init>(r0, r9)
            java.lang.Object r2 = C.o.f274c
            monitor-enter(r2)
            java.util.WeakHashMap r3 = C.o.f273b     // Catch: java.lang.Throwable -> L3c
            java.lang.Object r3 = r3.get(r1)     // Catch: java.lang.Throwable -> L3c
            android.util.SparseArray r3 = (android.util.SparseArray) r3     // Catch: java.lang.Throwable -> L3c
            r4 = 0
            if (r3 == 0) goto L50
            int r5 = r3.size()     // Catch: java.lang.Throwable -> L3c
            if (r5 <= 0) goto L50
            java.lang.Object r5 = r3.get(r8)     // Catch: java.lang.Throwable -> L3c
            C.l r5 = (C.l) r5     // Catch: java.lang.Throwable -> L3c
            if (r5 == 0) goto L50
            android.content.res.Configuration r6 = r5.f265b     // Catch: java.lang.Throwable -> L3c
            android.content.res.Configuration r7 = r0.getConfiguration()     // Catch: java.lang.Throwable -> L3c
            boolean r6 = r6.equals(r7)     // Catch: java.lang.Throwable -> L3c
            if (r6 == 0) goto L4d
            if (r9 != 0) goto L3f
            int r6 = r5.f266c     // Catch: java.lang.Throwable -> L3c
            if (r6 == 0) goto L49
            goto L3f
        L3c:
            r8 = move-exception
            goto Lb9
        L3f:
            if (r9 == 0) goto L4d
            int r6 = r5.f266c     // Catch: java.lang.Throwable -> L3c
            int r7 = r9.hashCode()     // Catch: java.lang.Throwable -> L3c
            if (r6 != r7) goto L4d
        L49:
            android.content.res.ColorStateList r3 = r5.f264a     // Catch: java.lang.Throwable -> L3c
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L3c
            goto L52
        L4d:
            r3.remove(r8)     // Catch: java.lang.Throwable -> L3c
        L50:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L3c
            r3 = r4
        L52:
            if (r3 == 0) goto L55
            goto Lb8
        L55:
            java.lang.ThreadLocal r2 = C.o.f272a
            java.lang.Object r3 = r2.get()
            android.util.TypedValue r3 = (android.util.TypedValue) r3
            if (r3 != 0) goto L67
            android.util.TypedValue r3 = new android.util.TypedValue
            r3.<init>()
            r2.set(r3)
        L67:
            r2 = 1
            r0.getValue(r8, r3, r2)
            int r2 = r3.type
            r3 = 28
            if (r2 < r3) goto L76
            r3 = 31
            if (r2 > r3) goto L76
            goto L87
        L76:
            android.content.res.XmlResourceParser r2 = r0.getXml(r8)
            android.content.res.ColorStateList r4 = C.c.a(r0, r2, r9)     // Catch: java.lang.Exception -> L7f
            goto L87
        L7f:
            r2 = move-exception
            java.lang.String r3 = "ResourcesCompat"
            java.lang.String r5 = "Failed to inflate ColorStateList, leaving it to the framework"
            android.util.Log.w(r3, r5, r2)
        L87:
            if (r4 == 0) goto Lb4
            java.lang.Object r2 = C.o.f274c
            monitor-enter(r2)
            java.util.WeakHashMap r0 = C.o.f273b     // Catch: java.lang.Throwable -> L9f
            java.lang.Object r3 = r0.get(r1)     // Catch: java.lang.Throwable -> L9f
            android.util.SparseArray r3 = (android.util.SparseArray) r3     // Catch: java.lang.Throwable -> L9f
            if (r3 != 0) goto La1
            android.util.SparseArray r3 = new android.util.SparseArray     // Catch: java.lang.Throwable -> L9f
            r3.<init>()     // Catch: java.lang.Throwable -> L9f
            r0.put(r1, r3)     // Catch: java.lang.Throwable -> L9f
            goto La1
        L9f:
            r8 = move-exception
            goto Lb2
        La1:
            C.l r0 = new C.l     // Catch: java.lang.Throwable -> L9f
            android.content.res.Resources r1 = r1.f267a     // Catch: java.lang.Throwable -> L9f
            android.content.res.Configuration r1 = r1.getConfiguration()     // Catch: java.lang.Throwable -> L9f
            r0.<init>(r4, r1, r9)     // Catch: java.lang.Throwable -> L9f
            r3.append(r8, r0)     // Catch: java.lang.Throwable -> L9f
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L9f
            r3 = r4
            goto Lb8
        Lb2:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L9f
            throw r8
        Lb4:
            android.content.res.ColorStateList r3 = C.k.b(r0, r8, r9)
        Lb8:
            return r3
        Lb9:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L3c
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: B0.f.x(int, android.content.Context):android.content.res.ColorStateList");
    }

    public static void x0(View view, y1.j jVar) {
        C0938a c0938a = jVar.f16234b.f16205c;
        if (c0938a == null || !c0938a.f15477a) {
            return;
        }
        float elevation = Property.DEFAULT_FLOAT_VALUE;
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
            elevation += ((View) parent).getElevation();
        }
        y1.h hVar = jVar.f16234b;
        if (hVar.f16216n != elevation) {
            hVar.f16216n = elevation;
            jVar.t();
        }
    }

    public static ColorStateList y(Context context, TypedArray typedArray, int i4) {
        int resourceId;
        ColorStateList colorStateListX;
        return (!typedArray.hasValue(i4) || (resourceId = typedArray.getResourceId(i4, 0)) == 0 || (colorStateListX = x(resourceId, context)) == null) ? typedArray.getColorStateList(i4) : colorStateListX;
    }

    public static ColorStateList z(Context context, android.support.v4.media.session.c cVar, int i4) {
        int iR;
        ColorStateList colorStateListX;
        return (!cVar.v(i4) || (iR = cVar.r(i4, 0)) == 0 || (colorStateListX = x(iR, context)) == null) ? cVar.h(i4) : colorStateListX;
    }

    public static void z0(Parcel parcel, int i4) {
        parcel.setDataPosition(parcel.dataPosition() + q0(parcel, i4));
    }

    public abstract void A(float f4, float f5, y1.x xVar);

    public abstract void A0();

    public abstract boolean R();

    public abstract void U(Throwable th);

    public abstract void V(t.d dVar);

    public abstract void e();

    public abstract boolean f(AbstractC0840j abstractC0840j, C0835e c0835e, C0835e c0835e2);

    public abstract boolean g(AbstractC0840j abstractC0840j, Object obj, Object obj2);

    public abstract void g0(C0839i c0839i, C0839i c0839i2);

    public abstract boolean h(AbstractC0840j abstractC0840j, C0839i c0839i, C0839i c0839i2);

    public abstract void h0(C0839i c0839i, Thread thread);

    public abstract void s0(int i4);

    public abstract void t0(float f4, float f5);

    public abstract void u0(Interpolator interpolator);

    public abstract float w();

    public abstract void y0(W2.e eVar);
}
