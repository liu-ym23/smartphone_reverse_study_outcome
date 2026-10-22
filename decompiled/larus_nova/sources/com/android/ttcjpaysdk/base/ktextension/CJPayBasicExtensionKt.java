package com.android.ttcjpaysdk.base.ktextension;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import androidx.exifinterface.media.ExifInterface;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.caijing.sdk.infra.base.api.env.CJHostService;
import com.bytedance.mt.protector.impl.string2number.CastByteProtector;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.mt.protector.impl.string2number.CastShortProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.reflect.KClass;
import ve4.a;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0004\n\u0002\b\u0003\u001a\u0006\u0010\u0006\u001a\u00020\u0007\u001a\u0014\u0010\b\u001a\u00020\t*\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u001a\u0014\u0010\f\u001a\u00020\n*\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u001a\n\u0010\r\u001a\u00020\t*\u00020\n\u001a\n\u0010\r\u001a\u00020\t*\u00020\t\u001a\n\u0010\u000e\u001a\u00020\n*\u00020\n\u001a\n\u0010\u000e\u001a\u00020\n*\u00020\t\u001a9\u0010\u000f\u001a\u0004\u0018\u0001H\u0010\"\u0004\b\u0000\u0010\u0011\"\u0004\b\u0001\u0010\u0010*\u001e\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u00100\u0012j\u000e\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u0010`\u0013¢\u0006\u0002\u0010\u0014\u001a\n\u0010\u0015\u001a\u00020\t*\u00020\n\u001a\n\u0010\u0015\u001a\u00020\t*\u00020\t\u001a\u0014\u0010\u0016\u001a\u00020\t*\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u001a\f\u0010\u0017\u001a\u0004\u0018\u00010\u0018*\u00020\u0007\u001a\u0014\u0010\u0019\u001a\u00020\u001a*\u00020\t2\b\b\u0002\u0010\u001b\u001a\u00020\u0001\u001a,\u0010\u001c\u001a\u0004\u0018\u0001H\u001d\"\n\b\u0000\u0010\u001d\u0018\u0001*\u00020\u001e*\u00020\u001a2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u0001H\u001dH\u0086\b¢\u0006\u0002\u0010 \"\u0018\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u00018Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\"\u0018\u0010\u0004\u001a\u00020\u0001*\u0004\u0018\u00010\u00018Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0003¨\u0006!"}, d2 = {"nullBeFalse", "", "getNullBeFalse", "(Ljava/lang/Boolean;)Z", "nullBeTrue", "getNullBeTrue", "getContext", "Landroid/content/Context;", "dip2px", "", "", PerfLog.PARAM_KEY_CONTEXT_ID, "dip2pxF", "dp", "dpF", "getLastValue", "V", "K", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "(Ljava/util/LinkedHashMap;)Ljava/lang/Object;", GXTemplateKey.GAIAX_PX, "px2dip", "toActivity", "Landroid/app/Activity;", "toHexColorString", "", "includeAlpha", "toNumber", ExifInterface.GPS_DIRECTION_TRUE, "", "defaultValue", "(Ljava/lang/String;Ljava/lang/Number;)Ljava/lang/Number;", "cj-host-service-api_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class CJPayBasicExtensionKt {
    public static final Context getContext() {
        a.f554342a.getClass();
        return ((CJHostService) a.d(CJHostService.class)).getHostApplication();
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_android_ttcjpaysdk_base_ktextension_CJPayBasicExtensionKt_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    public static final int dp(int r100) {
        Resources r101 = getContext().getResources();
        if (r101 == null) goto L7;
        DisplayMetrics r102 = INVOKEVIRTUAL_com_android_ttcjpaysdk_base_ktextension_CJPayBasicExtensionKt_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r101);
        if (r102 == null) goto L7;
        return (int) ((r100 * r102.density) + 0.5f);
    L7:
        return 0;
    }

    public static final float dpF(int r100) {
        Resources r101 = getContext().getResources();
        if (r101 == null) goto L7;
        DisplayMetrics r102 = INVOKEVIRTUAL_com_android_ttcjpaysdk_base_ktextension_CJPayBasicExtensionKt_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r101);
        if (r102 == null) goto L7;
        return (r100 * r102.density) + 0.5f;
    L7:
        return 0.0f;
    }

    public static final <K, V> V getLastValue(LinkedHashMap<K, V> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((!r100.isEmpty()) == true) goto L7;
        return null;
    L7:
        return (V) ((Map.Entry) CollectionsKt.last(r100.entrySet())).getValue();
    }

    public static final boolean getNullBeFalse(Boolean r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        return r100.booleanValue();
    }

    public static final boolean getNullBeTrue(Boolean r100) {
        if (r100 != null) goto L6;
        return true;
    L6:
        return r100.booleanValue();
    }

    public static final int px(int r100) {
        Resources r101 = getContext().getResources();
        if (r101 == null) goto L7;
        DisplayMetrics r102 = INVOKEVIRTUAL_com_android_ttcjpaysdk_base_ktextension_CJPayBasicExtensionKt_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r101);
        if (r102 == null) goto L7;
        return (int) ((r100 / r102.density) + 0.5f);
    L7:
        return 0;
    }

    public static final Activity toActivity(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((r100 instanceof Activity) == true) goto L5;
        return null;
    L5:
        return (Activity) r100;
    }

    public static final int dp(float r100) {
        Resources r101 = getContext().getResources();
        if (r101 == null) goto L7;
        DisplayMetrics r102 = INVOKEVIRTUAL_com_android_ttcjpaysdk_base_ktextension_CJPayBasicExtensionKt_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r101);
        if (r102 == null) goto L7;
        return (int) ((r100 * r102.density) + 0.5f);
    L7:
        return 0;
    }

    public static final float dpF(float r100) {
        Resources r101 = getContext().getResources();
        if (r101 == null) goto L7;
        DisplayMetrics r102 = INVOKEVIRTUAL_com_android_ttcjpaysdk_base_ktextension_CJPayBasicExtensionKt_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r101);
        if (r102 == null) goto L7;
        return (r100 * r102.density) + 0.5f;
    L7:
        return 0.0f;
    }

    public static final int px(float r100) {
        Resources r101 = getContext().getResources();
        if (r101 == null) goto L7;
        DisplayMetrics r102 = INVOKEVIRTUAL_com_android_ttcjpaysdk_base_ktextension_CJPayBasicExtensionKt_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r101);
        if (r102 == null) goto L7;
        return (int) ((r100 / r102.density) + 0.5f);
    L7:
        return 0;
    }

    public static final int dip2px(float r100, Context r101) {
        Resources r102 = getContext().getResources();
        if (r102 == null) goto L7;
        DisplayMetrics r103 = INVOKEVIRTUAL_com_android_ttcjpaysdk_base_ktextension_CJPayBasicExtensionKt_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r102);
        if (r103 == null) goto L7;
        return (int) ((r100 * r103.density) + 0.5f);
    L7:
        return 0;
    }

    public static final float dip2pxF(float r100, Context r101) {
        Resources r102 = getContext().getResources();
        if (r102 == null) goto L7;
        DisplayMetrics r103 = INVOKEVIRTUAL_com_android_ttcjpaysdk_base_ktextension_CJPayBasicExtensionKt_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r102);
        if (r103 == null) goto L7;
        return (r100 * r103.density) + 0.5f;
    L7:
        return 0.0f;
    }

    public static final int px2dip(float r100, Context r101) {
        Resources r102 = getContext().getResources();
        if (r102 == null) goto L7;
        DisplayMetrics r103 = INVOKEVIRTUAL_com_android_ttcjpaysdk_base_ktextension_CJPayBasicExtensionKt_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r102);
        if (r103 == null) goto L7;
        return (int) ((r100 / r103.density) + 0.5f);
    L7:
        return 0;
    }

    public static final String toHexColorString(int r100, boolean r101) {
        if (r101 == false) goto L5;
        StringCompanionObject r102 = StringCompanionObject.INSTANCE;
        return String.format("#%08X", Arrays.copyOf(new Object[]{Integer.valueOf(r100)}, 1));
    L5:
        StringCompanionObject r103 = StringCompanionObject.INSTANCE;
        return String.format("#%06X", Arrays.copyOf(new Object[]{Integer.valueOf(r100 & 16777215)}, 1));
    }

    public static final /* synthetic */ <T extends Number> T toNumber(String r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);     // Catch: Exception -> L24
        KClass r102 = Reflection.getOrCreateKotlinClass(Number.class);     // Catch: Exception -> L24
        if (Intrinsics.areEqual(r102, Reflection.getOrCreateKotlinClass(Byte.TYPE)) == false) goto L8;
        T r103 = Byte.valueOf(CastByteProtector.parseByte(r100));     // Catch: Exception -> L24
        Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);     // Catch: Exception -> L24
    L23:
        return r103;
    L8:
        if (Intrinsics.areEqual(r102, Reflection.getOrCreateKotlinClass(Short.TYPE)) == false) goto L11;
        r103 = Short.valueOf(CastShortProtector.parseShort(r100));     // Catch: Exception -> L24
        Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);     // Catch: Exception -> L24
        goto L23
    L11:
        if (Intrinsics.areEqual(r102, Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L14;
        r103 = Integer.valueOf(CastIntegerProtector.parseInt(r100));     // Catch: Exception -> L24
        Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);     // Catch: Exception -> L24
        goto L23
    L14:
        if (Intrinsics.areEqual(r102, Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L17;
        r103 = Long.valueOf(CastLongProtector.parseLong(r100));     // Catch: Exception -> L24
        Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);     // Catch: Exception -> L24
        goto L23
    L17:
        if (Intrinsics.areEqual(r102, Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L20;
        r103 = Float.valueOf(CastFloatProtector.parseFloat(r100));     // Catch: Exception -> L24
        Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);     // Catch: Exception -> L24
        goto L23
    L20:
        if (Intrinsics.areEqual(r102, Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L26;
        r103 = Double.valueOf(CastDoubleProtector.parseDouble(r100));     // Catch: Exception -> L24
        Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);     // Catch: Exception -> L24
        goto L23
    L26:
        return r101;
    L27:
        return r101;
    }

    public static /* synthetic */ String toHexColorString$default(int r100, boolean r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = true;
    L6:
        return toHexColorString(r100, r101);
    }

    public static /* synthetic */ Number toNumber$default(String r100, Number r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L5;
        r101 = null;
    L5:
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);     // Catch: Exception -> L27
        KClass r104 = Reflection.getOrCreateKotlinClass(Number.class);     // Catch: Exception -> L27
        if (Intrinsics.areEqual(r104, Reflection.getOrCreateKotlinClass(Byte.TYPE)) == false) goto L11;
        Number r105 = Byte.valueOf(CastByteProtector.parseByte(r100));     // Catch: Exception -> L27
        Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);     // Catch: Exception -> L27
    L26:
        return r105;
    L11:
        if (Intrinsics.areEqual(r104, Reflection.getOrCreateKotlinClass(Short.TYPE)) == false) goto L14;
        r105 = Short.valueOf(CastShortProtector.parseShort(r100));     // Catch: Exception -> L27
        Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);     // Catch: Exception -> L27
        goto L26
    L14:
        if (Intrinsics.areEqual(r104, Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L17;
        r105 = Integer.valueOf(CastIntegerProtector.parseInt(r100));     // Catch: Exception -> L27
        Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);     // Catch: Exception -> L27
        goto L26
    L17:
        if (Intrinsics.areEqual(r104, Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L20;
        r105 = Long.valueOf(CastLongProtector.parseLong(r100));     // Catch: Exception -> L27
        Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);     // Catch: Exception -> L27
        goto L26
    L20:
        if (Intrinsics.areEqual(r104, Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L23;
        r105 = Float.valueOf(CastFloatProtector.parseFloat(r100));     // Catch: Exception -> L27
        Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);     // Catch: Exception -> L27
        goto L26
    L23:
        if (Intrinsics.areEqual(r104, Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L29;
        r105 = Double.valueOf(CastDoubleProtector.parseDouble(r100));     // Catch: Exception -> L27
        Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);     // Catch: Exception -> L27
        goto L26
    L29:
        return r101;
    L30:
        return r101;
    }
}
