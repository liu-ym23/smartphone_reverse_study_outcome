package com.bytedance.android.livesdkapi.paramtransfer.utils;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import androidx.core.app.BundleCompat;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.model.live.MetricTrackerData;
import com.bytedance.android.livesdkapi.enterparam.CommonEnterParamsData;
import com.bytedance.android.livesdkapi.paramtransfer.model.RoomBundleParams;
import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import jc1.g;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
import yt2.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010H\u0002J2\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0014\u001a\u00020\u00042\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010J6\u0010\u0015\u001a\u0004\u0018\u00010\r2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u00042\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010H\u0007J(\u0010\u0018\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00042\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010H\u0002J\u0014\u0010\u0019\u001a\u0004\u0018\u00010\r2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0007J:\u0010\u001c\u001a\u00020\u00112&\u0010\u001d\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001ej\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0013H\u0002J\u001a\u0010!\u001a\u00020\u00112\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\"\u001a\u00020\rH\u0007J\u008a\u0001\u0010#\u001a\u00020\u00112\b\u0010 \u001a\u0004\u0018\u00010\u00132&\u0010$\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001ej\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u001f2&\u0010%\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001ej\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u001f2&\u0010&\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001ej\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u001fH\u0002J0\u0010'\u001a\u00020\u00112\b\u0010 \u001a\u0004\u0018\u00010\u00132\u001c\u0010(\u001a\u0018\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010)\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010H\u0002J\u0016\u0010*\u001a\u00020\u00112\u000e\u0010+\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010,J \u0010-\u001a\u00020\u00112\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020/J.\u00101\u001a\u00020\u0011*\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004022\u0014\u00103\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u000102H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\"\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u00064"}, d2 = {"Lcom/bytedance/android/livesdkapi/paramtransfer/utils/RoomParamTransferUtils;", "", "()V", "TAG", "", "trackerDataList", "Ljava/util/LinkedList;", "Lcom/bytedance/android/livesdkapi/depend/model/live/MetricTrackerData;", "getTrackerDataList", "()Ljava/util/LinkedList;", "setTrackerDataList", "(Ljava/util/LinkedList;)V", "businessParams2Parcelable", "Lcom/bytedance/android/livesdkapi/paramtransfer/model/RoomBundleParams;", "stringData", LynxVideoManagerLite.EVENT_ON_ERROR, "Lkotlin/Function1;", "", "createJSONObject", "Lorg/json/JSONObject;", "name", "createRoomBundleParams", "eventParamsData", "businessParamsData", "eventParams2Parcelable", "getRoomBundleParamsData", "bundle", "Landroid/os/Bundle;", "putMapValueFromJSONObject", "map", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "jsonObject", "putRoomBundleParamsData", "commonEnterParam", "setBusinessParamsMap", "click", "common", "firstShow", "setBusinessParamsString", "setCallback", "", "updateInnerTracker", "newTrackerData", "", "updateOuterTracker", "isFirstRoom", "", "isUseOnce", "putIfNotEmpty", "", "newMap", "room_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RoomParamTransferUtils {
    public static final RoomParamTransferUtils INSTANCE = null;
    public static final String TAG = "RoomParamTransfer";
    private static LinkedList<MetricTrackerData> trackerDataList;

    private RoomParamTransferUtils() {
    }

    static {
        INSTANCE = new RoomParamTransferUtils();
    }

    public final LinkedList<MetricTrackerData> getTrackerDataList() {
        return trackerDataList;
    }

    @JvmStatic
    public static final RoomBundleParams getRoomBundleParamsData(Bundle r100) {
        Boolean r101 = a.f569043a;
        Intrinsics.checkNotNullParameter(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_COMMON_ENTER_PARAM_ALL, "key");
        Object r102 = null;
        if (r100 == null) goto L28;
        Object r103 = r100.get(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_COMMON_ENTER_PARAM_ALL);
        if (r103 == null) goto L11;
        if ((r103 instanceof Parcelable) == false) goto L11;
        r102 = (Parcelable) r103;
    L11:
        if (a.a() == false) goto L28;
        IBinder r104 = BundleCompat.getBinder(r100, ILiveRoomPlayFragmentConstant.EXTRA_LIVE_COMMON_ENTER_PARAM_ALL);
        if ((r104 instanceof g) == true) goto L15;
        r104 = null;
    L15:
        g r105 = (g) r104;
        if (r105 == null) goto L28;
        if ((r105.f498078a instanceof Parcelable) == true) goto L21;
        r105 = null;
    L21:
        if (r105 == null) goto L28;
        Object r106 = r105.f498078a;
        if ((r106 instanceof Parcelable) == false) goto L26;
        r102 = r106;
    L26:
        r102 = (Parcelable) r102;
    L28:
        return (RoomBundleParams) r102;
    }

    public final void setTrackerDataList(LinkedList<MetricTrackerData> r100) {
        trackerDataList = r100;
    }

    public final void updateInnerTracker(List<MetricTrackerData> r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (trackerDataList != null) goto L7;
        trackerDataList = new LinkedList();
    L7:
        Iterator<T> r101 = r100.iterator();
    L9:
        if (r101.hasNext() == false) goto L29;
        MetricTrackerData r102 = (MetricTrackerData) r101.next();
        LinkedList<MetricTrackerData> r103 = trackerDataList;
        MetricTrackerData r104 = null;
        Object r105 = null;
        if (r103 == null) goto L19;
        Iterator<T> r106 = r103.iterator();
    L14:
        if (r106.hasNext() == false) goto L18;
        Object r107 = r106.next();
        if (Intrinsics.areEqual(((MetricTrackerData) r107).getEventName(), r102.getEventName()) == false) goto L14;
        r105 = r107;
    L18:
        r104 = (MetricTrackerData) r105;
    L19:
        if (r104 == null) goto L20;
        if (r104.getFinalUseTracker() != null) goto L26;
        r104.setFinalUseTracker(new LinkedHashMap());
    L26:
        Map<String, String> r108 = r104.getFinalUseTracker();
        if (r108 == null) goto L9;
        INSTANCE.putIfNotEmpty(r108, r102.getCurrentRoomTracker());
        goto L9
    L20:
        r102.setFinalUseTracker(r102.getCurrentRoomTracker());
        LinkedList<MetricTrackerData> r109 = trackerDataList;
        if (r109 == null) goto L9;
        r109.add(r102);
        goto L9
    }

    private final RoomBundleParams businessParams2Parcelable(String r110, Function1<? super String, Unit> r111) {
        final RoomBundleParams r100 = new RoomBundleParams();
        r100.setCommonEnterParams(new CommonEnterParamsData(null, null, null, null, null, null, 63, null));
        if (r110 != null) goto L5;
        return r100;
    L5:
        JSONObject r112 = createJSONObject(r110, "business_live_params", r111);
        if (r112 != null) goto L8;
        return r100;
    L8:
        Iterator<String> r113 = r112.keys();
    L10:
        if (r113.hasNext() == false) goto L49;
        String r101 = r113.next();
        JSONObject r102 = r112.optJSONObject(r101);
        if (Intrinsics.areEqual(r101, BusinessParamsTypeKt.realName(BusinessParamsType.ECOM_LIVE_PARAMS)) == true) goto L13;
        if (Intrinsics.areEqual(r101, BusinessParamsTypeKt.realName(BusinessParamsType.ROOM_ENTER_AD_PARAMS)) == true) goto L16;
        JSONObject r103 = null;
        HashMap<String, String> r104 = null;
        HashMap<String, String> r105 = null;
        if (Intrinsics.areEqual(r101, BusinessParamsTypeKt.realName(BusinessParamsType.LIVE_COMMUNITY_PARAMS)) == true) goto L19;
        if (Intrinsics.areEqual(r101, BusinessParamsTypeKt.realName(BusinessParamsType.LOCAL_LIFE_LIVE_PARAMS)) == true) goto L25;
        if (Intrinsics.areEqual(r101, BusinessParamsTypeKt.realName(BusinessParamsType.ROOM_ENTER_PARAMS)) == true) goto L28;
        if (Intrinsics.areEqual(r101, BusinessParamsTypeKt.realName(BusinessParamsType.LIVE_EXTRA_PARAMS)) == true) goto L34;
        if (Intrinsics.areEqual(r101, BusinessParamsTypeKt.realName(BusinessParamsType.LIVE_GAMECP_PARAMS)) == false) goto L10;
        setBusinessParamsString(r102, new AnonymousClass5(r100));
        goto L10
    L34:
        CommonEnterParamsData r106 = r100.getCommonEnterParams();
        if (r106 == null) goto L37;
        HashMap<String, String> r107 = r106.getFirstRoomParams();
    L38:
        CommonEnterParamsData r108 = r100.getCommonEnterParams();
        if (r108 == null) goto L41;
        HashMap<String, String> r109 = r108.getParams();
    L42:
        CommonEnterParamsData r114 = r100.getCommonEnterParams();
        if (r114 == null) goto L45;
        r104 = r114.getFirstShowRoomParams();
    L45:
        setBusinessParamsMap(r102, r107, r109, r104);
        goto L10
    L41:
        r109 = null;
        goto L42
    L37:
        r107 = null;
        goto L38
    L28:
        HashMap<String, String> r115 = r100.getEnterClick();
        HashMap<String, String> r116 = r100.getEnterCommon();
        CommonEnterParamsData r117 = r100.getCommonEnterParams();
        if (r117 == null) goto L31;
        r105 = r117.getEnterRoom();
    L31:
        setBusinessParamsMap(r102, r115, r116, r105);
        goto L10
    L25:
        setBusinessParamsString(r102, new AnonymousClass4(r100));
        goto L10
    L19:
        setBusinessParamsString(r102, new AnonymousClass3(r100));
        HashMap<String, String> r118 = r100.getCommunityClickMap();
        if (r102 == null) goto L22;
        r103 = r102.optJSONObject("click");
    L22:
        putMapValueFromJSONObject(r118, r103);
        goto L10
    L16:
        setBusinessParamsString(r102, new AnonymousClass2(r100));
        goto L10
    L13:
        setBusinessParamsString(r102, new AnonymousClass1(r100));
        goto L10
    L49:
        return r100;
    }

    private final RoomBundleParams eventParams2Parcelable(String r110, Function1<? super String, Unit> r111) {
        JSONObject r112 = createJSONObject(r110, "event_params", r111);
        RoomBundleParams r113 = new RoomBundleParams();
        r113.setCommonEnterParams(new CommonEnterParamsData(null, null, null, null, null, null, 63, null));
        if (r112 != null) goto L5;
        return r113;
    L5:
        Iterator<String> r100 = r112.keys();
    L7:
        if (r100.hasNext() == false) goto L33;
        String r101 = r100.next();
        JSONObject r102 = r112.optJSONObject(r101);
        if (r101 == null) goto L7;
        int r103 = r101.hashCode();
        HashMap<String, String> r104 = null;
        if (r103 != (-1354814997)) goto L14;
        if (r101.equals("common") == false) goto L7;
        CommonEnterParamsData r105 = r113.getCommonEnterParams();
        if (r105 == null) goto L32;
        r104 = r105.getMobParams();
    L32:
        putMapValueFromJSONObject(r104, r102);
        goto L7
    L14:
        if (r103 != (-160829652)) goto L16;
        if (r101.equals("first_show") == false) goto L7;
        putMapValueFromJSONObject(r113.getEventFirstShow(), r102);
        goto L7
    L16:
        if (r103 != 94750088) goto L7;
        if (r101.equals("click") == false) goto L7;
        CommonEnterParamsData r106 = r113.getCommonEnterParams();
        if (r106 == null) goto L23;
        r104 = r106.getFirstRoomMobParams();
    L23:
        putMapValueFromJSONObject(r104, r102);
        goto L7
    L33:
        return r113;
    }

    private final void putIfNotEmpty(Map<String, String> r100, Map<String, String> r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        r100.putAll(r101);
    }

    private final void putMapValueFromJSONObject(HashMap<String, String> r100, JSONObject r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        if (r100 != null) goto L6;
        return;
    L6:
        Iterator<String> r102 = r101.keys();
    L8:
        if (r102.hasNext() == false) goto L10;
        String r103 = r102.next();
        r100.put(r103, JSONObjectProtectorUtils.getString(r101, r103));
        goto L8
    }

    @JvmStatic
    public static final void putRoomBundleParamsData(Bundle r100, RoomBundleParams r101) {
        Intrinsics.checkNotNullParameter(r101, "commonEnterParam");
        Boolean r102 = a.f569043a;
        Intrinsics.checkNotNullParameter(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_COMMON_ENTER_PARAM_ALL, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        if (r100 != null) goto L6;
        return;
    L6:
        if (a.a() == false) goto L8;
        BundleCompat.putBinder(r100, ILiveRoomPlayFragmentConstant.EXTRA_LIVE_COMMON_ENTER_PARAM_ALL, new g(r101));
        return;
    L8:
        r100.putParcelable(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_COMMON_ENTER_PARAM_ALL, r101);
    }

    private final void setBusinessParamsString(JSONObject r100, Function1<? super List<String>, Unit> r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        ArrayList r102 = new ArrayList();
        JSONObject r103 = r100.optJSONObject("click");
        String r104 = "";
        if (r103 == null) goto L8;
        String r105 = r103.toString();
        if (r105 == null) goto L8;
    L9:
        r102.add(r105);
        JSONObject r106 = r100.optJSONObject("common");
        if (r106 == null) goto L13;
        String r107 = r106.toString();
        if (r107 == null) goto L13;
    L14:
        r102.add(r107);
        JSONObject r108 = r100.optJSONObject("first_show");
        if (r108 == null) goto L20;
        String r109 = r108.toString();
        if (r109 == null) goto L20;
        r104 = r109;
    L20:
        r102.add(r104);
        if (r101 == null) goto L24;
        Unit r110 = r101.invoke(r102);
        return;
    L24:
        return;
    L13:
        r107 = "";
    L8:
        r105 = "";
        goto L9
    }

    @JvmStatic
    public static final RoomBundleParams createRoomBundleParams(String r100, String r101, Function1<? super String, Unit> r102) {
        if (r100 == null) goto L4;
        RoomBundleParams r103 = INSTANCE.eventParams2Parcelable(r100, r102);
    L5:
        RoomBundleParams r104 = INSTANCE.businessParams2Parcelable(r101, r102);
        if (r103 == null) goto L16;
        CommonEnterParamsData r105 = r103.getCommonEnterParams();
        if (r105 == null) goto L16;
        HashMap<String, String> r106 = r105.getFirstRoomMobParams();
        if (r106 == null) goto L16;
        CommonEnterParamsData r107 = r104.getCommonEnterParams();
        if (r107 == null) goto L16;
        HashMap<String, String> r108 = r107.getFirstRoomMobParams();
        if (r108 == null) goto L16;
        r108.putAll(r106);
    L16:
        if (r103 == null) goto L26;
        CommonEnterParamsData r109 = r103.getCommonEnterParams();
        if (r109 == null) goto L26;
        HashMap<String, String> r110 = r109.getMobParams();
        if (r110 == null) goto L26;
        CommonEnterParamsData r111 = r104.getCommonEnterParams();
        if (r111 == null) goto L26;
        HashMap<String, String> r112 = r111.getMobParams();
        if (r112 == null) goto L26;
        r112.putAll(r110);
    L26:
        if (r103 == null) goto L32;
        HashMap<String, String> r113 = r103.getEventFirstShow();
        if (r113 == null) goto L32;
        HashMap<String, String> r114 = r104.getEventFirstShow();
        if (r114 == null) goto L32;
        r114.putAll(r113);
    L32:
        return r104;
    L4:
        r103 = null;
        goto L5
    }

    public final JSONObject createJSONObject(String r100, String r101, Function1<? super String, Unit> r102) {
        Intrinsics.checkNotNullParameter(r101, "name");
        JSONObject r103 = null;
        if (r100 != null) goto L12;
        return null;
    L12:
        r103 = new JSONObject(r100);     // Catch: JSONException -> L7
    L8:
        if (r103 != null) goto L11;
        if (r102 == null) goto L11;
        Unit r104 = r102.invoke(r101);
    L11:
        return r103;
    }

    public final void updateOuterTracker(Bundle r100, boolean r101, boolean r102) {
        RoomBundleParams r103 = getRoomBundleParamsData(r100);
        if (r103 == null) goto L5;
        List<MetricTrackerData> r104 = r103.getTrackerDataList();
    L6:
        if (r104 == null) goto L16;
        Iterator<T> r105 = r104.iterator();
    L9:
        if (r105.hasNext() == false) goto L16;
        MetricTrackerData r106 = (MetricTrackerData) r105.next();
        LinkedHashMap r107 = new LinkedHashMap();
        if (r101 == false) goto L13;
        INSTANCE.putIfNotEmpty(r107, r106.getCurrentRoomTracker());
    L13:
        if (r102 == false) goto L15;
        INSTANCE.putIfNotEmpty(r107, r106.getUseOnceTracker());
    L15:
        INSTANCE.putIfNotEmpty(r107, r106.getAllRoomTracker());
        Unit r108 = Unit.INSTANCE;
        r106.setFinalUseTracker(r107);
    L16:
        LinkedList<MetricTrackerData> r109 = new LinkedList();
        if (r104 != null) goto L20;
        r104 = CollectionsKt.emptyList();
    L20:
        r109.addAll(r104);
        trackerDataList = r109;
        return;
    L5:
        r104 = null;
        goto L6
    }

    private final void setBusinessParamsMap(JSONObject r100, HashMap<String, String> r101, HashMap<String, String> r102, HashMap<String, String> r103) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r101 == null) goto L6;
        INSTANCE.putMapValueFromJSONObject(r101, r100.optJSONObject("click"));
    L6:
        if (r102 == null) goto L8;
        INSTANCE.putMapValueFromJSONObject(r102, r100.optJSONObject("common"));
    L8:
        if (r103 == null) goto L11;
        INSTANCE.putMapValueFromJSONObject(r103, r100.optJSONObject("first_show"));
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RoomBundleParams businessParams2Parcelable$default(RoomParamTransferUtils r100, String r101, Function1 r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = null;
    L6:
        return r100.businessParams2Parcelable(r101, r102);
    }

    public static /* synthetic */ RoomBundleParams createRoomBundleParams$default(String r100, String r101, Function1 r102, int r103, Object r104) {
        if ((r103 & 4) == 0) goto L6;
        r102 = null;
    L6:
        return createRoomBundleParams(r100, r101, r102);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RoomBundleParams eventParams2Parcelable$default(RoomParamTransferUtils r100, String r101, Function1 r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = null;
    L6:
        return r100.eventParams2Parcelable(r101, r102);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ JSONObject createJSONObject$default(RoomParamTransferUtils r100, String r101, String r102, Function1 r103, int r104, Object r105) {
        if ((r104 & 4) == 0) goto L6;
        r103 = null;
    L6:
        return r100.createJSONObject(r101, r102, r103);
    }
}
