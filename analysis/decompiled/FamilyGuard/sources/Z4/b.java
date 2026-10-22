package Z4;

import X4.j;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PermissionGroupInfo;
import android.content.pm.PermissionInfo;
import android.util.Log;
import com.stepos.policy.sdk.util.PolicySdkPermissionManifestUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private PackageManager f6661a;

    b(PackageManager packageManager) {
        this.f6661a = packageManager;
    }

    private void b(String str, Set<String> set) {
        str.getClass();
        switch (str) {
            case "android.permission-group.CONTACTS":
                set.add(PolicySdkPermissionManifestUtils.WRITE_CONTACTS);
                set.add("android.permission.GET_ACCOUNTS");
                set.add("android.permission.READ_CONTACTS");
                break;
            case "android.permission-group.PHONE":
                set.add("android.permission.ANSWER_PHONE_CALLS");
                set.add("android.permission.READ_PHONE_NUMBERS");
                set.add(PolicySdkPermissionManifestUtils.READ_PHONE_STATE);
                set.add("android.permission.CALL_PHONE");
                set.add("android.permission.ACCEPT_HANDOVER");
                set.add("android.permission.USE_SIP");
                set.add("com.android.voicemail.permission.ADD_VOICEMAIL");
                break;
            case "android.permission-group.CALENDAR":
                set.add("android.permission.READ_CALENDAR");
                set.add(PolicySdkPermissionManifestUtils.WRITE_CALENDAR);
                break;
            case "android.permission-group.CALL_LOG":
                set.add("android.permission.READ_CALL_LOG");
                set.add(PolicySdkPermissionManifestUtils.WRITE_CALL_LOG);
                set.add("android.permission.PROCESS_OUTGOING_CALLS");
                break;
            case "android.permission-group.CAMERA":
                set.add("android.permission.CAMERA");
                break;
            case "android.permission-group.ACTIVITY_RECOGNITION":
                set.add(PolicySdkPermissionManifestUtils.ACTIVITY_RECOGNITION);
                break;
            case "android.permission-group.SENSORS":
                set.add("android.permission.BODY_SENSORS");
                break;
            case "android.permission-group.LOCATION":
                set.add(PolicySdkPermissionManifestUtils.ACCESS_FINE_LOCATION);
                set.add(PolicySdkPermissionManifestUtils.ACCESS_COARSE_LOCATION);
                set.add(PolicySdkPermissionManifestUtils.ACCESS_BACKGROUND_LOCATION);
                break;
            case "android.permission-group.STORAGE":
                set.add("android.permission.READ_EXTERNAL_STORAGE");
                set.add("android.permission.WRITE_EXTERNAL_STORAGE");
                set.add(PolicySdkPermissionManifestUtils.ACCESS_MEDIA_LOCATION);
                break;
            case "android.permission-group.MICROPHONE":
                set.add(PolicySdkPermissionManifestUtils.RECORD_AUDIO);
                break;
            case "android.permission-group.SMS":
                set.add("android.permission.READ_SMS");
                set.add("android.permission.RECEIVE_WAP_PUSH");
                set.add("android.permission.RECEIVE_MMS");
                set.add("android.permission.RECEIVE_SMS");
                set.add("android.permission.SEND_SMS");
                set.add("android.permission.READ_CELL_BROADCASTS");
                break;
        }
    }

    public List<String> a() {
        ArrayList arrayList = new ArrayList();
        for (PermissionGroupInfo permissionGroupInfo : this.f6661a.getAllPermissionGroups(128)) {
            if ("android".equals(permissionGroupInfo.packageName)) {
                arrayList.add(permissionGroupInfo.name);
            }
        }
        arrayList.add("stepos.permission-group.NETWORK");
        arrayList.add("stepos.permission-group.CHANGE_NETWORK");
        arrayList.add("stepos.permission-group.BLUETOOTH");
        arrayList.add("stepos.permission-group.OTHER");
        arrayList.add("stepos.permission-group.PACKAGES");
        arrayList.add("stepos.permission-group.PRIMARY_CLIP");
        arrayList.remove("android.permission-group.UNDEFINED");
        return arrayList;
    }

    public String c(Context context, String str) {
        if ("stepos.permission-group.NETWORK".equals(str)) {
            return context.getResources().getString(j.f6068q);
        }
        if ("stepos.permission-group.CHANGE_NETWORK".equals(str)) {
            return context.getResources().getString(j.f6067p);
        }
        if ("stepos.permission-group.BLUETOOTH".equals(str)) {
            return context.getResources().getString(j.f6066o);
        }
        if ("stepos.permission-group.OTHER".equals(str)) {
            return context.getResources().getString(j.f6069r);
        }
        try {
            return this.f6661a.getPermissionGroupInfo(str, 128).loadDescription(this.f6661a).toString();
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public String d(String str) throws PackageManager.NameNotFoundException {
        try {
            PermissionInfo permissionInfo = this.f6661a.getPermissionInfo(str, 128);
            if (permissionInfo.labelRes == 0) {
                return null;
            }
            return permissionInfo.loadLabel(this.f6661a).toString();
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public Set<String> e(String str) {
        HashSet hashSet = new HashSet();
        if ("stepos.permission-group.NETWORK".equals(str)) {
            hashSet.add("android.permission.INTERNET");
            hashSet.add("android.permission.ACCESS_NETWORK_STATE");
            hashSet.add("android.permission.CHANGE_NETWORK_STATE");
        } else if ("stepos.permission-group.CHANGE_NETWORK".equals(str)) {
            hashSet.add("android.permission.CHANGE_WIFI_STATE");
        } else if ("stepos.permission-group.BLUETOOTH".equals(str)) {
            hashSet.add("android.permission.BLUETOOTH");
            hashSet.add("android.permission.BLUETOOTH_ADMIN");
        } else if ("stepos.permission-group.PACKAGES".equals(str)) {
            hashSet.add("android.permission.QUERY_ALL_PACKAGES");
        } else if ("stepos.permission-group.PRIMARY_CLIP".equals(str)) {
            hashSet.add("android.permission.GET_PRIMARY_CLIP");
            hashSet.add("android.permission.SET_PRIMARY_CLIP");
        } else if (!"stepos.permission-group.OTHER".equals(str)) {
            try {
                for (PermissionInfo permissionInfo : this.f6661a.queryPermissionsByGroup(str, 128)) {
                    if ("android".equals(permissionInfo.packageName)) {
                        hashSet.add(permissionInfo.name);
                    } else {
                        Log.d("PackageManagerProxy", "ignore permission=" + permissionInfo.name + ", packageName=" + permissionInfo.packageName);
                    }
                }
                if ("android.permission-group.SMS".equals(str)) {
                    hashSet.add("android.permission.WRITE_SMS");
                }
            } catch (Exception unused) {
            }
        }
        b(str, hashSet);
        return hashSet;
    }
}
