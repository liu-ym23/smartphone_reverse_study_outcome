package Z4;

import android.content.Context;
import com.stepos.policy.sdk.util.PolicySdkPermissionManifestUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public class e {

    /* renamed from: d, reason: collision with root package name */
    private static volatile e f6669d;

    /* renamed from: a, reason: collision with root package name */
    private Map<String, a> f6670a;

    /* renamed from: b, reason: collision with root package name */
    private Map<String, Set<String>> f6671b;

    /* renamed from: c, reason: collision with root package name */
    private final b f6672c;

    private e(Context context) {
        this.f6672c = new b(context.getApplicationContext().getPackageManager());
        f();
        j();
    }

    public static e b(Context context) {
        if (f6669d == null) {
            synchronized (e.class) {
                try {
                    if (f6669d == null) {
                        f6669d = new e(context);
                    }
                } finally {
                }
            }
        }
        return f6669d;
    }

    private String c(String str) {
        for (Map.Entry<String, Set<String>> entry : this.f6671b.entrySet()) {
            Iterator<String> it = entry.getValue().iterator();
            while (it.hasNext()) {
                if (str.equals(it.next())) {
                    return entry.getKey();
                }
            }
        }
        return "stepos.permission-group.OTHER";
    }

    private void f() {
        HashMap map = new HashMap();
        this.f6670a = map;
        int i5 = X4.e.f5946t;
        map.put("stepos.permission-group.NETWORK", new a(0, "连接网络", i5));
        this.f6670a.put(PolicySdkPermissionManifestUtils.LOCATION_GROUP, new a(1, "获取位置信息", X4.e.f5944r));
        this.f6670a.put("android.permission-group.CAMERA", new a(2, "拍照和录像", X4.e.f5942p));
        this.f6670a.put(PolicySdkPermissionManifestUtils.MICROPHONE_GROUP, new a(3, "录制音频", X4.e.f5945s));
        this.f6670a.put("android.permission-group.PHONE", new a(4, "拨打电话或获取手机状态", X4.e.f5948v));
        this.f6670a.put("android.permission-group.SMS", new a(5, "读取或发送信息", X4.e.f5950x));
        this.f6670a.put(PolicySdkPermissionManifestUtils.CONTACTS_GROUP, new a(6, "读取或修改联系人", X4.e.f5943q));
        this.f6670a.put(PolicySdkPermissionManifestUtils.CALL_LOG_GROUP, new a(7, "读取或修改通话记录", X4.e.f5941o));
        this.f6670a.put("android.permission-group.STORAGE", new a(8, "读写手机存储", X4.e.f5951y));
        this.f6670a.put("stepos.permission-group.BLUETOOTH", new a(9, null, i5));
        this.f6670a.put("stepos.permission-group.CHANGE_NETWORK", new a(10, "开启和关闭无线网络", i5));
        this.f6670a.put(PolicySdkPermissionManifestUtils.CALENDAR_GROUP, new a(11, "读取或修改日历", X4.e.f5940n));
        Map<String, a> map2 = this.f6670a;
        int i6 = X4.e.f5949w;
        map2.put("android.permission-group.SENSORS", new a(12, null, i6));
        this.f6670a.put("android.permission-group.ACTIVITY_RECOGNITION", new a(13, null, i6));
        this.f6670a.put("stepos.permission-group.OTHER", new a(14, null, X4.e.f5947u));
        this.f6670a.put("stepos.permission-group.PACKAGES", new a(15, "读取应用列表", 0));
        this.f6670a.put("stepos.permission-group.PRIMARY_CLIP", new a(16, "读取或写入剪切板", 0));
        this.f6670a.put("android.permission.CALL_PHONE", new a(0, null, 0));
        this.f6670a.put("android.permission.ANSWER_PHONE_CALLS", new a(1, "接听电话", 0));
        this.f6670a.put("android.permission.USE_SIP", new a(2, "拨打或接听 SIP 电话", 0));
        this.f6670a.put("android.permission.READ_PHONE_NUMBERS", new a(3, null, 0));
        this.f6670a.put(PolicySdkPermissionManifestUtils.READ_PHONE_STATE, new a(4, "读取手机状态和识别码", 0));
        this.f6670a.put("com.android.voicemail.permission.ADD_VOICEMAIL", new a(5, null, 0));
        this.f6670a.put("android.permission.ACCEPT_HANDOVER", new a(6, "继续进行来自其他应用的通话", 0));
        this.f6670a.put("android.permission.ACCESS_UCE_OPTIONS_SERVICE", new a(7, null, 0));
        this.f6670a.put("android.permission.ACCESS_UCE_PRESENCE_SERVICE", new a(8, null, 0));
        this.f6670a.put("android.permission.READ_CALL_LOG", new a(0, null, 0));
        this.f6670a.put(PolicySdkPermissionManifestUtils.WRITE_CALL_LOG, new a(1, "修改通话记录", 0));
        this.f6670a.put("android.permission.PROCESS_OUTGOING_CALLS", new a(2, "修改默认电话应用", 0));
        this.f6670a.put("android.permission.READ_SMS", new a(0, "读取短信或彩信", 0));
        this.f6670a.put("android.permission.READ_CELL_BROADCASTS", new a(1, "读取小区广播", 0));
        this.f6670a.put("android.permission.SEND_SMS", new a(2, "发送短信或彩信", 0));
        this.f6670a.put("android.permission.RECEIVE_SMS", new a(3, "接收短信", 0));
        this.f6670a.put("android.permission.RECEIVE_MMS", new a(4, "接收彩信", 0));
        this.f6670a.put("android.permission.RECEIVE_WAP_PUSH", new a(5, "接收 WAP 讯息", 0));
        this.f6670a.put("android.permission.WRITE_SMS", new a(6, "修改短信或彩信", 0));
        this.f6670a.put("android.permission.READ_CONTACTS", new a(0, null, 0));
        this.f6670a.put(PolicySdkPermissionManifestUtils.WRITE_CONTACTS, new a(1, "修改联系人", 0));
        this.f6670a.put("android.permission.GET_ACCOUNTS", new a(2, "读取应用账号", 0));
        this.f6670a.put("android.permission.CAMERA", new a(0, "拍照或录像", 0));
        this.f6670a.put(PolicySdkPermissionManifestUtils.RECORD_AUDIO, new a(0, "使用麦克风或录音", 0));
        this.f6670a.put(PolicySdkPermissionManifestUtils.ACCESS_FINE_LOCATION, new a(0, "获取确切位置信息", 0));
        this.f6670a.put(PolicySdkPermissionManifestUtils.ACCESS_COARSE_LOCATION, new a(1, "获取大致位置信息", 0));
        this.f6670a.put(PolicySdkPermissionManifestUtils.ACCESS_BACKGROUND_LOCATION, new a(2, "应用在后台时获取位置信息", 0));
        this.f6670a.put("android.permission.READ_CALENDAR", new a(0, "读取日历", 0));
        this.f6670a.put(PolicySdkPermissionManifestUtils.WRITE_CALENDAR, new a(1, "修改日历", 0));
        this.f6670a.put("android.permission.READ_EXTERNAL_STORAGE", new a(0, "读取手机存储", 0));
        this.f6670a.put("android.permission.WRITE_EXTERNAL_STORAGE", new a(1, "写入手机存储", 0));
        this.f6670a.put("android.permission.CHANGE_WIFI_STATE", new a(0, "开启或关闭无线网络", 0));
        this.f6670a.put("android.permission.BLUETOOTH", new a(0, null, 0));
        this.f6670a.put("android.permission.BLUETOOTH_ADMIN", new a(1, null, 0));
        this.f6670a.put("android.permission.BODY_SENSORS", new a(0, "读取身体传感器数据", 0));
        this.f6670a.put("android.permission.USE_FINGERPRINT", new a(1, null, 0));
        this.f6670a.put("android.permission.USE_BIOMETRIC", new a(2, null, 0));
        this.f6670a.put(PolicySdkPermissionManifestUtils.ACTIVITY_RECOGNITION, new a(0, "识别健身运动类型和状态", 0));
        this.f6670a.put("android.permission.INTERNET", new a(0, "连接网络", 0));
        this.f6670a.put("android.permission.ACCESS_NETWORK_STATE", new a(1, null, 0));
        this.f6670a.put("android.permission.CHANGE_NETWORK_STATE", new a(2, "修改网络连接", 0));
        this.f6670a.put("android.permission.QUERY_ALL_PACKAGES", new a(0, "读取应用列表", 0));
        this.f6670a.put("android.permission.GET_PRIMARY_CLIP", new a(0, "读取剪切板", 0));
        this.f6670a.put("android.permission.SET_PRIMARY_CLIP", new a(1, "写入剪切板", 0));
        this.f6670a.put(PolicySdkPermissionManifestUtils.READ_MEDIA_AUDIO, new a(0, "读取音乐和音频", 0));
        this.f6670a.put(PolicySdkPermissionManifestUtils.READ_MEDIA_VISUAL_GROUP, new a(1, "读取照片和视频", 0));
        this.f6670a.put("android.permission.LOCAL_MAC_ADDRESS", new a(0, "唯一设备标识符", 0));
    }

    private d g(List<d> list, String str) {
        for (d dVar : list) {
            if (dVar.g().equals(str)) {
                return dVar;
            }
        }
        d dVar2 = new d(str, this.f6670a.get(str), this.f6672c);
        list.add(dVar2);
        return dVar2;
    }

    private c h(List<d> list, String str) {
        Iterator<d> it = list.iterator();
        while (it.hasNext()) {
            c cVarH = it.next().h(str);
            if (cVarH != null) {
                return cVarH;
            }
        }
        c cVar = new c(str, this.f6670a.get(str), this.f6672c);
        g(list, c(str)).b(cVar);
        return cVar;
    }

    private boolean i(String str) {
        return this.f6671b.containsKey(str);
    }

    private void j() {
        this.f6671b = new HashMap();
        for (String str : this.f6672c.a()) {
            this.f6671b.put(str, this.f6672c.e(str));
        }
    }

    public List<d> a() {
        return e((String[]) this.f6671b.keySet().toArray(new String[0]), true);
    }

    public String d(Context context, String str) {
        return new c(str, this.f6670a.get(str), this.f6672c).d(context);
    }

    public List<d> e(String[] strArr, boolean z5) {
        if (strArr == null || strArr.length <= 0) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList();
        int i5 = 0;
        for (String str : strArr) {
            if (i(str)) {
                g(arrayList, str);
                if (z5) {
                    Iterator<String> it = this.f6671b.get(str).iterator();
                    while (it.hasNext()) {
                        h(arrayList, it.next());
                    }
                }
            } else {
                h(arrayList, str);
            }
        }
        Collections.sort(arrayList);
        int size = arrayList.size();
        while (i5 < size) {
            Object obj = arrayList.get(i5);
            i5++;
            Collections.sort(((d) obj).i());
        }
        return arrayList;
    }
}
