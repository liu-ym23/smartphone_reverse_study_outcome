package M0;

import D7.N;
import V9.o;
import V9.q;
import V9.u;
import V9.v;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.os.Parcel;
import android.os.Parcelable;
import android.security.keystore.KeyGenParameterSpec;
import android.system.Os;
import android.system.OsConstants;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.stepos.ability.R;
import j9.AbstractC1610d;
import j9.m;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.Socket;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.UnrecoverableEntryException;
import java.security.cert.CertificateException;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Flow;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import reactor.core.publisher.BaseSubscriber;
import w6.AbstractC2104a;

/* loaded from: classes2.dex */
public abstract class i {

    /* renamed from: a, reason: collision with root package name */
    public static volatile boolean f955a = false;
    public static MessageQueue b = null;
    public static Field c = null;
    public static Field d = null;
    public static boolean e = false;
    public static boolean f = false;
    public static String g = null;
    public static Method h = null;
    public static final char[] i = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: j, reason: collision with root package name */
    public static long f956j = -1;

    public static F6.a A(Context context, AttributeSet attributeSet) {
        int resourceId;
        Resources resources = context.getResources();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC2104a.g, R.attr.steposPreferenceStyle, R.style.StepOSWidget_Preference);
        try {
            int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.stepos_list_item_height);
            int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.stepos_list_item_padding_start);
            int dimensionPixelSize3 = resources.getDimensionPixelSize(R.dimen.stepos_list_item_padding_vertical);
            int dimensionPixelSize4 = resources.getDimensionPixelSize(R.dimen.stepos_list_item_icon_text_gap);
            int dimensionPixelSize5 = resources.getDimensionPixelSize(R.dimen.stepos_divider_height);
            int dimensionPixelSize6 = resources.getDimensionPixelSize(R.dimen.stepos_divider_inset_start);
            int dimensionPixelSize7 = resources.getDimensionPixelSize(R.dimen.stepos_divider_inset_end);
            int dimensionPixelSize8 = typedArrayObtainStyledAttributes.getDimensionPixelSize(23, dimensionPixelSize);
            int dimensionPixelSize9 = typedArrayObtainStyledAttributes.getDimensionPixelSize(24, dimensionPixelSize2);
            int dimensionPixelSize10 = typedArrayObtainStyledAttributes.getDimensionPixelSize(25, dimensionPixelSize3);
            int dimensionPixelSize11 = typedArrayObtainStyledAttributes.getDimensionPixelSize(19, dimensionPixelSize4);
            int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(42, 0);
            int resourceId3 = typedArrayObtainStyledAttributes.getResourceId(37, 0);
            int resourceId4 = typedArrayObtainStyledAttributes.getResourceId(46, 0);
            int iE = E(attributeSet, typedArrayObtainStyledAttributes, 36, "steposListItemSubtitleMaxLines", 1);
            boolean z10 = typedArrayObtainStyledAttributes.getBoolean(3, false);
            CharSequence charSequenceF = F(context, attributeSet, typedArrayObtainStyledAttributes, 39, "steposListItemTitle");
            CharSequence charSequenceF2 = F(context, attributeSet, typedArrayObtainStyledAttributes, 40, "steposListItemTitleEndText");
            CharSequence charSequenceF3 = F(context, attributeSet, typedArrayObtainStyledAttributes, 35, "steposListItemSubtitle");
            CharSequence charSequenceF4 = F(context, attributeSet, typedArrayObtainStyledAttributes, 30, "steposListItemRightText");
            if (charSequenceF4 == null) {
                charSequenceF4 = F(context, attributeSet, typedArrayObtainStyledAttributes, 44, "steposListItemValue");
            }
            CharSequence charSequence = charSequenceF4;
            boolean zX = x("steposListItemIconBackground", attributeSet);
            Integer numValueOf = (x("steposListItemIconBackground", attributeSet) && typedArrayObtainStyledAttributes.hasValue(15)) ? Integer.valueOf(typedArrayObtainStyledAttributes.getColor(15, 0)) : null;
            int iM = m("steposListItemIcon", attributeSet);
            if (iM < 0 || attributeSet == null || (resourceId = attributeSet.getAttributeResourceValue(iM, 0)) == 0) {
                resourceId = typedArrayObtainStyledAttributes.getResourceId(14, 0);
            }
            int i6 = resourceId;
            boolean zX2 = x("steposListItemIconTint", attributeSet);
            Integer numValueOf2 = (x("steposListItemIconTint", attributeSet) && typedArrayObtainStyledAttributes.hasValue(20)) ? Integer.valueOf(typedArrayObtainStyledAttributes.getColor(20, 0)) : null;
            boolean zC = C(attributeSet, typedArrayObtainStyledAttributes, 21, "steposListItemIconVisible", true);
            int iE2 = E(attributeSet, typedArrayObtainStyledAttributes, 18, "steposListItemIconStyle", 0);
            boolean z11 = x("steposListItemIconSize", attributeSet) || typedArrayObtainStyledAttributes.hasValue(17);
            int dimensionPixelSize12 = typedArrayObtainStyledAttributes.getDimensionPixelSize(17, 0);
            boolean z12 = x("steposListItemIconCornerRadius", attributeSet) || typedArrayObtainStyledAttributes.hasValue(16);
            float dimension = typedArrayObtainStyledAttributes.getDimension(16, 0.0f);
            int iE3 = E(attributeSet, typedArrayObtainStyledAttributes, 4, "steposListItemBadgeStyle", 0);
            boolean z13 = x("steposListItemBadgeTint", attributeSet) || typedArrayObtainStyledAttributes.hasValue(5);
            int color = typedArrayObtainStyledAttributes.hasValue(5) ? typedArrayObtainStyledAttributes.getColor(5, 0) : 0;
            boolean zC2 = C(attributeSet, typedArrayObtainStyledAttributes, 32, "steposListItemShowBadge", false);
            int iE4 = E(attributeSet, typedArrayObtainStyledAttributes, 27, "steposListItemRightBadgeStyle", 1);
            boolean z14 = x("steposListItemRightBadgeTint", attributeSet) || typedArrayObtainStyledAttributes.hasValue(28);
            int color2 = typedArrayObtainStyledAttributes.hasValue(28) ? typedArrayObtainStyledAttributes.getColor(28, 0) : 0;
            boolean zC3 = C(attributeSet, typedArrayObtainStyledAttributes, 34, "steposListItemShowRightBadge", false);
            boolean zC4 = C(attributeSet, typedArrayObtainStyledAttributes, 31, "steposListItemShowAccessory", true);
            int resourceId5 = typedArrayObtainStyledAttributes.getResourceId(29, 0);
            Integer numValueOf3 = Integer.valueOf(resourceId5);
            if (resourceId5 == 0) {
                numValueOf3 = null;
            }
            F6.a aVar = new F6.a(dimensionPixelSize8, dimensionPixelSize9, dimensionPixelSize10, dimensionPixelSize11, resourceId2, resourceId3, resourceId4, iE, z10, charSequenceF, charSequenceF2, charSequenceF3, charSequence, zX, numValueOf, i6, zX2, numValueOf2, zC, iE2, z11, dimensionPixelSize12, z12, dimension, iE3, z13, color, zC2, iE4, z14, color2, zC3, zC4, numValueOf3 != null ? numValueOf3.intValue() : typedArrayObtainStyledAttributes.getResourceId(0, R.drawable.stepos_icon_arrow_right), typedArrayObtainStyledAttributes.hasValue(1) ? Integer.valueOf(typedArrayObtainStyledAttributes.getDimensionPixelSize(1, 0)) : null, E(attributeSet, typedArrayObtainStyledAttributes, 43, "steposListItemTrailingType", 1), F(context, attributeSet, typedArrayObtainStyledAttributes, 6, "steposListItemButtonText"), E(attributeSet, typedArrayObtainStyledAttributes, 22, "steposListItemLineMode", 0), C(attributeSet, typedArrayObtainStyledAttributes, 7, "steposListItemChecked", false), C(attributeSet, typedArrayObtainStyledAttributes, 38, "steposListItemSwitchChecked", false), C(attributeSet, typedArrayObtainStyledAttributes, 26, "steposListItemPressScaleEnabled", false), C(attributeSet, typedArrayObtainStyledAttributes, 33, "steposListItemShowDivider", false), typedArrayObtainStyledAttributes.getDimensionPixelSize(10, dimensionPixelSize5), typedArrayObtainStyledAttributes.getDimensionPixelSize(12, dimensionPixelSize6), typedArrayObtainStyledAttributes.getDimensionPixelSize(11, dimensionPixelSize7), typedArrayObtainStyledAttributes.getColor(9, context.getColor(R.color.stepos_divider)), E(attributeSet, typedArrayObtainStyledAttributes, 41, "steposListItemTitleStyle", 0));
            com.stepos.ability.task.executor.e.s(typedArrayObtainStyledAttributes, null);
            return aVar;
        } finally {
        }
    }

    public static final boolean B(String method) {
        kotlin.jvm.internal.k.f(method, "method");
        return (method.equals("GET") || method.equals("HEAD")) ? false : true;
    }

    public static boolean C(AttributeSet attributeSet, TypedArray typedArray, int i6, String str, boolean z10) {
        int iM = m(str, attributeSet);
        return (iM < 0 || attributeSet == null) ? typedArray.hasValue(i6) ? typedArray.getBoolean(i6, z10) : z10 : attributeSet.getAttributeBooleanValue(iM, z10);
    }

    public static int D(int i6, byte[] bArr) {
        if (i6 + 4 > bArr.length) {
            return 0;
        }
        return ((bArr[i6 + 3] & 255) << 24) | (bArr[i6] & 255) | ((bArr[i6 + 1] & 255) << 8) | ((bArr[i6 + 2] & 255) << 16);
    }

    public static int E(AttributeSet attributeSet, TypedArray typedArray, int i6, String str, int i10) {
        int iM = m(str, attributeSet);
        return (iM < 0 || attributeSet == null) ? typedArray.hasValue(i6) ? typedArray.getInt(i6, i10) : i10 : attributeSet.getAttributeIntValue(iM, i10);
    }

    public static CharSequence F(Context context, AttributeSet attributeSet, TypedArray typedArray, int i6, String str) {
        int iM = m(str, attributeSet);
        if (iM < 0 || attributeSet == null) {
            return typedArray.getText(i6);
        }
        int attributeResourceValue = attributeSet.getAttributeResourceValue(iM, 0);
        if (attributeResourceValue == 0) {
            return attributeSet.getAttributeValue(iM);
        }
        try {
            return context.getResources().getText(attributeResourceValue);
        } catch (Exception unused) {
            return null;
        }
    }

    public static final V9.b G(Socket socket) throws IOException {
        Logger logger = o.f1422a;
        v vVar = new v(socket);
        OutputStream outputStream = socket.getOutputStream();
        kotlin.jvm.internal.k.e(outputStream, "getOutputStream(...)");
        return new V9.b(vVar, new V9.b(outputStream, vVar));
    }

    public static final V9.c H(Socket socket) throws IOException {
        Logger logger = o.f1422a;
        v vVar = new v(socket);
        InputStream inputStream = socket.getInputStream();
        kotlin.jvm.internal.k.e(inputStream, "getInputStream(...)");
        return new V9.c(0, vVar, new V9.c(1, inputStream, vVar));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Flow.Subscriber I(BaseSubscriber baseSubscriber) {
        return baseSubscriber instanceof Flow.Subscriber ? (Flow.Subscriber) baseSubscriber : new Z9.a(baseSubscriber);
    }

    public static final String J(String str) {
        kotlin.jvm.internal.k.f(str, "<this>");
        StringBuilder sb = new StringBuilder(str.length());
        int length = str.length();
        for (int i6 = 0; i6 < length; i6++) {
            char cCharAt = str.charAt(i6);
            if ('A' <= cCharAt && cCharAt < '[') {
                cCharAt = Character.toLowerCase(cCharAt);
            }
            sb.append(cCharAt);
        }
        String string = sb.toString();
        kotlin.jvm.internal.k.e(string, "toString(...)");
        return string;
    }

    public static byte[] K(String str) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        List listD0 = m.D0(str, new String[]{":"}, 6);
        if (listD0.size() != 2) {
            throw new IllegalArgumentException("wrapped passphrase malformed");
        }
        byte[] bArrDecode = Base64.decode((String) listD0.get(0), 2);
        byte[] bArrDecode2 = Base64.decode((String) listD0.get(1), 2);
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        cipher.init(2, L(), new GCMParameterSpec(128, bArrDecode));
        byte[] bArrDoFinal = cipher.doFinal(bArrDecode2);
        kotlin.jvm.internal.k.e(bArrDoFinal, "doFinal(...)");
        return bArrDoFinal;
    }

    public static SecretKey L() throws NoSuchAlgorithmException, IOException, KeyStoreException, CertificateException, NoSuchProviderException, UnrecoverableEntryException, InvalidAlgorithmParameterException {
        KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
        keyStore.load(null);
        KeyStore.Entry entry = keyStore.getEntry("taskrobot_db_wrap", null);
        KeyStore.SecretKeyEntry secretKeyEntry = entry instanceof KeyStore.SecretKeyEntry ? (KeyStore.SecretKeyEntry) entry : null;
        if (secretKeyEntry != null) {
            SecretKey secretKey = secretKeyEntry.getSecretKey();
            kotlin.jvm.internal.k.e(secretKey, "getSecretKey(...)");
            return secretKey;
        }
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES", "AndroidKeyStore");
        keyGenerator.init(new KeyGenParameterSpec.Builder("taskrobot_db_wrap", 3).setBlockModes("GCM").setEncryptionPaddings("NoPadding").setKeySize(256).build());
        SecretKey secretKeyGenerateKey = keyGenerator.generateKey();
        kotlin.jvm.internal.k.e(secretKeyGenerateKey, "generateKey(...)");
        return secretKeyGenerateKey;
    }

    public static Object a(Parcel parcel, Parcelable.Creator creator) {
        if (parcel.readInt() != 0) {
            return creator.createFromParcel(parcel);
        }
        return null;
    }

    public static void b(Parcel parcel, Parcelable parcelable) {
        if (parcelable == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcelable.writeToParcel(parcel, 0);
        }
    }

    public static long c() {
        if (N.g == -1) {
            long jSysconf = f956j;
            if (jSysconf <= 0) {
                jSysconf = Os.sysconf(OsConstants._SC_CLK_TCK);
                if (jSysconf <= 0) {
                    jSysconf = 100;
                }
                f956j = jSysconf;
            }
            N.g = 1000 / jSysconf;
        }
        return N.g;
    }

    public static Message d(MessageQueue messageQueue) throws NoSuchFieldException, SecurityException {
        Field field = c;
        if (field != null) {
            try {
                return (Message) field.get(messageQueue);
            } catch (Exception unused) {
                return null;
            }
        }
        try {
            Field declaredField = Class.forName("android.os.MessageQueue").getDeclaredField("mMessages");
            c = declaredField;
            declaredField.setAccessible(true);
            return (Message) c.get(messageQueue);
        } catch (Exception unused2) {
            return null;
        }
    }

    public static MessageQueue e() {
        if (b == null && Looper.getMainLooper() != null) {
            Looper mainLooper = Looper.getMainLooper();
            b = mainLooper == Looper.myLooper() ? Looper.myQueue() : mainLooper.getQueue();
        }
        return b;
    }

    public static String f(String str) {
        String str2;
        Process processExec;
        BufferedReader bufferedReader;
        String line = "";
        BufferedReader bufferedReader2 = null;
        try {
            if (h == null) {
                h = Class.forName("android.os.SystemProperties").getMethod("get", String.class);
            }
            str2 = (String) h.invoke(null, str);
        } catch (Exception e6) {
            e6.printStackTrace();
            str2 = "";
        }
        if (!TextUtils.isEmpty(str2)) {
            return str2;
        }
        try {
            processExec = Runtime.getRuntime().exec("getprop ".concat(str));
            bufferedReader = new BufferedReader(new InputStreamReader(processExec.getInputStream()), 1024);
        } catch (Throwable unused) {
        }
        try {
            line = bufferedReader.readLine();
            processExec.destroy();
            S0.b.F(bufferedReader);
            return line;
        } catch (Throwable unused2) {
            bufferedReader2 = bufferedReader;
            S0.b.F(bufferedReader2);
            return line;
        }
    }

    public static JSONArray g(long j5) {
        Object obj;
        MessageQueue messageQueueE = e();
        JSONArray jSONArray = new JSONArray();
        if (messageQueueE != null) {
            try {
                synchronized (messageQueueE) {
                    try {
                        Message messageD = d(messageQueueE);
                        if (messageD == null) {
                            return jSONArray;
                        }
                        int i6 = 0;
                        int i10 = 0;
                        while (messageD != null && i6 < 100) {
                            i6++;
                            i10++;
                            JSONObject jSONObjectH = h(messageD, j5);
                            try {
                                jSONObjectH.put("id", i10);
                            } catch (JSONException unused) {
                            }
                            jSONArray.put(jSONObjectH);
                            Field field = d;
                            if (field == null) {
                                try {
                                    Field declaredField = Class.forName("android.os.Message").getDeclaredField("next");
                                    d = declaredField;
                                    declaredField.setAccessible(true);
                                    obj = d.get(messageD);
                                } catch (Exception unused2) {
                                    messageD = null;
                                }
                            } else {
                                obj = field.get(messageD);
                            }
                            messageD = (Message) obj;
                        }
                    } finally {
                    }
                }
            } catch (Throwable th) {
                int i11 = com.apm.insight.b.f2156a;
                k("NPTH_CATCH", th);
                return jSONArray;
            }
        }
        return jSONArray;
    }

    public static JSONObject h(Message message, long j5) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("when", message.getWhen() - j5);
            if (message.getCallback() != null) {
                jSONObject.put("callback", String.valueOf(message.getCallback()));
            }
            jSONObject.put("what", message.what);
            if (message.getTarget() != null) {
                jSONObject.put(TypedValues.AttributesType.S_TARGET, String.valueOf(message.getTarget()));
            } else {
                jSONObject.put("barrier", message.arg1);
            }
            jSONObject.put("arg1", message.arg1);
            jSONObject.put("arg2", message.arg2);
            Object obj = message.obj;
            if (obj != null) {
                jSONObject.put("obj", obj);
            }
            return jSONObject;
        } catch (JSONException e6) {
            e6.printStackTrace();
            return jSONObject;
        }
    }

    public static void i(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static void j(String str) {
        Object[] objArr = {str, 493, -1, -1};
        HashMap map = r2.a.f5671a;
        try {
            r2.a.a(Class.forName("android.os.FileUtils"), objArr);
        } catch (Exception e6) {
            Log.w("JavaCalls", "Meet exception when call Method 'setPermissions' in android.os.FileUtils", e6);
        }
    }

    public static void k(String str, Throwable th) {
        if (com.apm.insight.g.f2160a == null) {
            return;
        }
        if (z2.i.c == -1) {
            z2.i.c = 5;
        }
        int i6 = z2.i.d;
        if (i6 < z2.i.c) {
            z2.i.d = i6 + 1;
            if (z2.i.b) {
                z2.i.a().reportCustomErr(str, "INNER", th);
            }
        }
    }

    public static int m(String str, AttributeSet attributeSet) {
        if (attributeSet == null) {
            return -1;
        }
        int attributeCount = attributeSet.getAttributeCount();
        for (int i6 = 0; i6 < attributeCount; i6++) {
            if (kotlin.jvm.internal.k.b(attributeSet.getAttributeName(i6), str)) {
                return i6;
            }
        }
        return -1;
    }

    public static String n(byte[] bArr) {
        if (bArr == null) {
            throw new NullPointerException("bytes is null");
        }
        int length = bArr.length;
        if (length > bArr.length) {
            throw new IndexOutOfBoundsException();
        }
        int i6 = length * 2;
        char[] cArr = new char[i6];
        int i10 = 0;
        for (byte b5 : bArr) {
            int i11 = i10 + 1;
            char[] cArr2 = i;
            cArr[i10] = cArr2[(b5 & 255) >> 4];
            i10 += 2;
            cArr[i11] = cArr2[b5 & 15];
        }
        return new String(cArr, 0, i6);
    }

    public static final float o(float f7, float f9, float f10) {
        float f11 = 1.0f - f10;
        float f12 = 3.0f * f11;
        float f13 = f11 * f12 * f10 * f7;
        return (f10 * f10 * f10) + (f12 * f10 * f10 * f9) + f13;
    }

    public static final q p(u uVar) {
        kotlin.jvm.internal.k.f(uVar, "<this>");
        return new q(uVar);
    }

    public static final String q(String str) {
        char cCharAt;
        kotlin.jvm.internal.k.f(str, "<this>");
        if (str.length() == 0 || 'a' > (cCharAt = str.charAt(0)) || cCharAt >= '{') {
            return str;
        }
        StringBuilder sb = new StringBuilder(str.length());
        sb.append(Character.toUpperCase(cCharAt));
        sb.append((CharSequence) str, 1, str.length());
        String string = sb.toString();
        kotlin.jvm.internal.k.e(string, "toString(...)");
        return string;
    }

    public static final void r(int i6, String str) {
        if (str.charAt(i6) == '-') {
            return;
        }
        StringBuilder sbU = B7.a.u(i6, "Expected '-' (hyphen) at index ", ", but was '");
        sbU.append(str.charAt(i6));
        sbU.append('\'');
        throw new IllegalArgumentException(sbU.toString().toString());
    }

    public static final long s(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[8192];
        int i6 = inputStream.read(bArr);
        long j5 = 0;
        while (i6 >= 0) {
            outputStream.write(bArr, 0, i6);
            j5 += i6;
            i6 = inputStream.read(bArr);
        }
        return j5;
    }

    public static final void t(long j5, byte[] bArr, int i6, int i10, int i11) {
        int i12 = 7 - i10;
        int i13 = 8 - i11;
        if (i13 > i12) {
            return;
        }
        while (true) {
            int i14 = AbstractC1610d.f4781a[(int) ((j5 >> (i12 << 3)) & 255)];
            int i15 = i6 + 1;
            bArr[i6] = (byte) (i14 >> 8);
            i6 += 2;
            bArr[i15] = (byte) i14;
            if (i12 == i13) {
                return;
            } else {
                i12--;
            }
        }
    }

    public static boolean x(String str, AttributeSet attributeSet) {
        if (attributeSet != null) {
            int attributeCount = attributeSet.getAttributeCount();
            for (int i6 = 0; i6 < attributeCount; i6++) {
                if (kotlin.jvm.internal.k.b(attributeSet.getAttributeName(i6), str)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static final boolean y(AssertionError assertionError) {
        Logger logger = o.f1422a;
        if (assertionError.getCause() != null) {
            String message = assertionError.getMessage();
            if (message != null ? m.h0(message, "getsockname failed", false) : false) {
                return true;
            }
        }
        return false;
    }

    public static final boolean z(int i6, String str) {
        char cCharAt = str.charAt(i6);
        return 'A' <= cCharAt && cCharAt < '[';
    }

    public abstract String l();

    public abstract int u(View view, ViewGroup.MarginLayoutParams marginLayoutParams);

    public abstract int v();

    public abstract ViewPropertyAnimator w(int i6, View view);
}
