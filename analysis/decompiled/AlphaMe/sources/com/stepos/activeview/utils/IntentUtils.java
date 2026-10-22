package com.stepos.activeview.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import ch.qos.logback.core.CoreConstants;
import f0.C0556b;
import java.net.URISyntaxException;
import net.zetetic.database.sqlcipher.SQLiteDatabase;

/* loaded from: classes.dex */
public class IntentUtils {
    private static final String TAG = "IntentUtils";

    private static String bundle2String(Bundle bundle, boolean z4) {
        if (bundle == null) {
            return null;
        }
        StringBuilder sb = null;
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            char c4 = obj instanceof String ? 'S' : obj instanceof Boolean ? 'B' : obj instanceof Byte ? 'b' : obj instanceof Character ? 'c' : obj instanceof Double ? 'd' : obj instanceof Float ? 'f' : obj instanceof Integer ? 'i' : obj instanceof Long ? 'l' : obj instanceof Short ? 's' : obj instanceof Bundle ? 'D' : (char) 0;
            if (c4 != 0 && (!z4 || c4 == 'D')) {
                if (sb == null) {
                    sb = new StringBuilder();
                }
                sb.append(c4);
                sb.append(CoreConstants.DOT);
                sb.append(Uri.encode(str));
                sb.append('=');
                if (c4 == 'D') {
                    sb.append(Uri.encode(bundle2String((Bundle) obj, false)));
                } else {
                    sb.append(Uri.encode(obj.toString()));
                }
                sb.append(';');
            }
        }
        if (sb == null) {
            return null;
        }
        return sb.toString();
    }

    public static Intent getAvailableActivityIntent(Context context, String str) {
        try {
            Intent uri = parseUri(str);
            if (uri.resolveActivity(context.getPackageManager()) == null && (uri = context.getPackageManager().getLaunchIntentForPackage(str)) != null && "android.intent.action.MAIN".equals(uri.getAction())) {
                uri.setAction(null);
            }
            return uri;
        } catch (Exception e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public static boolean handleActionUri(Context context, String str, String str2) {
        str.getClass();
        switch (str) {
            case "startActivity":
                return startActivity(context, str2);
            case "sendBroadcast":
                return sendBroadcast(context, str2);
            case "sendLocalBroadcast":
                return sendLocalBroadcast(context, str2);
            case "startService":
                return startService(context, str2);
            default:
                return false;
        }
    }

    public static Intent parseUri(String str) throws URISyntaxException {
        Bundle bundleString2Bundle;
        Intent uri = Intent.parseUri(str, 0);
        int iIndexOf = str.indexOf(";b_start");
        int iIndexOf2 = str.indexOf(";b_end");
        if (iIndexOf > 0 && iIndexOf2 > 0 && iIndexOf + 8 < iIndexOf2 && (bundleString2Bundle = string2Bundle(str.substring(iIndexOf + 9, iIndexOf2 + 1))) != null) {
            uri.putExtras(bundleString2Bundle);
        }
        return uri;
    }

    public static boolean sendBroadcast(Context context, String str) {
        try {
            Intent uri = parseUri(str);
            if (context.getPackageManager().queryBroadcastReceivers(uri, 0).size() > 0) {
                context.sendBroadcast(uri);
                return true;
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        return true;
    }

    public static boolean sendLocalBroadcast(Context context, String str) {
        C0556b c0556b;
        try {
            Intent uri = parseUri(str);
            synchronized (C0556b.f12511e) {
                try {
                    if (C0556b.f12512f == null) {
                        C0556b.f12512f = new C0556b(context.getApplicationContext());
                    }
                    c0556b = C0556b.f12512f;
                } catch (Throwable th) {
                    throw th;
                }
            }
            c0556b.a(uri);
            return false;
        } catch (Exception e4) {
            e4.printStackTrace();
            return false;
        }
    }

    public static boolean startActivity(Context context, String str) {
        try {
            Intent availableActivityIntent = getAvailableActivityIntent(context, str);
            availableActivityIntent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            context.startActivity(availableActivityIntent);
            return true;
        } catch (Exception e4) {
            e4.printStackTrace();
            return false;
        }
    }

    public static boolean startService(Context context, String str) {
        try {
            context.startService(parseUri(str));
            return true;
        } catch (Exception e4) {
            e4.printStackTrace();
            return false;
        }
    }

    private static Bundle string2Bundle(String str) {
        if (str == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        int i4 = 0;
        while (i4 >= 0 && i4 < str.length()) {
            int iIndexOf = str.indexOf(61, i4);
            int iIndexOf2 = str.indexOf(59, i4);
            if (iIndexOf < 0 || iIndexOf2 < 0) {
                return null;
            }
            if (iIndexOf <= iIndexOf2 && iIndexOf >= i4 + 1) {
                String strDecode = Uri.decode(str.substring(iIndexOf + 1, iIndexOf2));
                String strDecode2 = Uri.decode(str.substring(i4 + 2, iIndexOf));
                if (str.startsWith("S.", i4)) {
                    bundle.putString(strDecode2, strDecode);
                } else if (str.startsWith("B.", i4)) {
                    bundle.putBoolean(strDecode2, Boolean.parseBoolean(strDecode));
                } else if (str.startsWith("b.", i4)) {
                    bundle.putByte(strDecode2, Byte.parseByte(strDecode));
                } else if (str.startsWith("c.", i4)) {
                    bundle.putChar(strDecode2, strDecode.charAt(0));
                } else if (str.startsWith("d.", i4)) {
                    bundle.putDouble(strDecode2, Double.parseDouble(strDecode));
                } else if (str.startsWith("f.", i4)) {
                    bundle.putFloat(strDecode2, Float.parseFloat(strDecode));
                } else if (str.startsWith("i.", i4)) {
                    bundle.putInt(strDecode2, Integer.parseInt(strDecode));
                } else if (str.startsWith("l.", i4)) {
                    bundle.putLong(strDecode2, Long.parseLong(strDecode));
                } else if (str.startsWith("s.", i4)) {
                    bundle.putShort(strDecode2, Short.parseShort(strDecode));
                } else if (str.startsWith("D.", i4)) {
                    bundle.putBundle(strDecode2, string2Bundle(strDecode));
                }
            }
            i4 = iIndexOf2 + 1;
        }
        return bundle;
    }
}
