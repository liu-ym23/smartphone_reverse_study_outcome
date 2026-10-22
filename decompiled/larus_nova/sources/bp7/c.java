package bp7;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.bdlocation.utils.DimLocationCheckUtil;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.sysoptimizer.SmEditTextLeakOpt;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.socialbase.appdownloader.util.RomUtils;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f19986a;

    public final void a() {
        long r100 = SystemClock.elapsedRealtime();
        vo7.a r101 = vo7.a.C8028a.f556510a;
        Context r102 = this.f19986a.f19988a;
        long r103 = SystemClock.elapsedRealtime();
        ArrayList r104 = new ArrayList();
        String r105 = zo7.a.a();
        zo7.b.d("PreInstallChannelManage", "phone name is " + r105);
        switch(r105.hashCode()) {
            case -1619859642: goto L60;
            case -1443430368: goto L57;
            case -1320380160: goto L54;
            case -1206476313: goto L51;
            case -1106355917: goto L48;
            case -934971466: goto L45;
            case -759499589: goto L42;
            case -284840886: goto L39;
            case -151542385: goto L36;
            case 3318203: goto L33;
            case 3418016: goto L30;
            case 3620012: goto L27;
            case 53314910: goto L24;
            case 99462250: goto L21;
            case 103777484: goto L18;
            case 108389869: goto L15;
            case 926486349: goto L12;
            case 1864941562: goto L9;
            case 1914625883: goto L6;
            default: goto L62;
        };
    L62:
        byte r106 = -1;
    L63:
        String r110 = "";
        switch(r106) {
            case 0: goto L116;
            case 1: goto L116;
            case 2: goto L116;
            case 3: goto L115;
            case 4: goto L115;
            case 5: goto L110;
            case 6: goto L110;
            case 7: goto L105;
            case 8: goto L100;
            case 9: goto L100;
            case 10: goto L95;
            case 11: goto L90;
            case 12: goto L90;
            case 13: goto L81;
            case 14: goto L76;
            case 15: goto L71;
            case 16: goto L71;
            case 17: goto L66;
            default: goto L120;
        };
    L66:
        xo7.d r107 = a.C0335a.f19983a.f19980c;
        if (r107 == null) goto L69;
        List<String> r108 = r107.n();
    L70:
        r104.addAll(r108);
    L168:
        SystemClock.elapsedRealtime();
        zo7.b.a("PreInstallChannelManage", "get target paths done, middleTime cost is " + (SystemClock.elapsedRealtime() - r103));
        a r109 = a.C0335a.f19983a;
        xo7.b r111 = r109.f19978a;
        if (r111 == null) goto L172;
        r111.a();
    L172:
        if (r102.getPackageName().equals(AppConstants.TOUTIAO_PKG_NAME) == true) goto L284;
        xo7.b r112 = r109.f19978a;
        if (r112 == null) goto L177;
        r112.a();
    L177:
        if (r104.isEmpty() == false) goto L179;
        zo7.b.b("PreInstallChannelManage", "getFileContentByPaths meet error, filePaths is null");
        String r113 = null;
    L283:
        r101.f556508b = r113;
    L308:
        if (TextUtils.isEmpty(r101.f556508b) == true) goto L310;
    L312:
        r101.f556509c = SystemClock.elapsedRealtime() - r103;
        zo7.b.d("PreInstallChannelManage", "get PreInstallChannel done, cost time is " + r101.f556509c + ", channel is " + r101.f556508b);
        if (TextUtils.isEmpty(r101.f556508b) == true) goto L322;
        long r114 = r101.f556509c;
        String r115 = r101.f556508b;
        zo7.b.d("PreInstallChannelManage", "reportEvent() called with: phoneName = [" + r105 + "], costTime = [" + r114 + "], preInstallChannel = [" + r115 + "]");
        JSONObject r116 = new JSONObject();
        JSONObject r117 = new JSONObject();
        r117.put(HiAnalyticsConstant.BI_KEY_COST_TIME, r114);     // Catch: JSONException -> L317
        r116.put("pre_install_channel", r115);     // Catch: JSONException -> L317
        r116.put("phone_brand", r105);     // Catch: JSONException -> L317
        r116.put("phone_model", Build.MODEL);     // Catch: JSONException -> L317
        zo7.c.a("yz_channel_data", r116, r117);     // Catch: JSONException -> L317
    L319:
        AtomicBoolean r118 = d.f19987g;
        d r119 = d.a.f19994a;
        String r120 = r119.f19993f;
        if (TextUtils.isEmpty(r120) == true) goto L322;
        a.C0335a.f19983a.b(new vo7.b(r119.b(), r120, r101.f556509c));
    L317:
        e = move-exception;
        e.printStackTrace();
    L322:
        AtomicBoolean r121 = d.f19987g;
        d r122 = d.a.f19994a;
        String r123 = r101.f556508b;
        r122.a();
        e r124 = r122.f19989b;
        if (r124 != null) goto L325;
    L328:
        zo7.b.a("PreInstallChannelManage", "save PreInstallChannel into sp, endTime is " + SystemClock.elapsedRealtime());
        long r125 = SystemClock.elapsedRealtime();
        this.f19986a.f19991d = true;
        zo7.b.d("YZSdkManager", "costTime is " + (r125 - r100));
        return;
    L325:
        if (r124.f19995a != null) goto L327;
        r124.a();
    L327:
        SharedPreferences.Editor r126 = r124.f19995a.edit();
        r126.putString("pre_install_channel", r123);
        r126.commit();
        goto L328
    L310:
        if (TextUtils.isEmpty(r101.f556507a) == true) goto L312;
        r101.f556508b = r101.f556507a;
        goto L312
    L179:
        zo7.b.d("PreInstallChannelManage", "all file path : " + r104.toString());
        r104.toString();
        StringBuilder r127 = new StringBuilder();
        Iterator r128 = r104.iterator();
    L181:
        if (r128.hasNext() == false) goto L272;
        String r129 = (String) r128.next();
        if (TextUtils.isEmpty(r129) == true) goto L181;
        StringBuilder r130 = new StringBuilder();
        PolarisFileWrapper r131 = new PolarisFileWrapper(r129);
        if (r131.isFile() == false) goto L270;
        Iterator r132 = r128;
        zo7.b.d("PreInstallChannelManage", "available filePath: " + r129);
        PolarisFileInputStreamWrapper r133 = new PolarisFileInputStreamWrapper(r131);     // Catch: Throwable -> L223 IOException -> L225 FileNotFoundException -> L240
    L355:
        InputStreamReader r134 = new InputStreamReader(r133);     // Catch: Throwable -> L218 IOException -> L220 FileNotFoundException -> L222
        BufferedReader r135 = new BufferedReader(r134);     // Catch: Throwable -> L213 IOException -> L215 FileNotFoundException -> L217
    L335:
        String r136 = r135.readLine();     // Catch: IOException -> L210 FileNotFoundException -> L212 Throwable -> L255
        if (r136 == null) goto L194;
        r130.append(r136);     // Catch: IOException -> L210 FileNotFoundException -> L212 Throwable -> L255
        r130.append("\n");     // Catch: IOException -> L210 FileNotFoundException -> L212 Throwable -> L255
        goto L335
    L194:
        if (TextUtils.isEmpty(r130) == true) goto L205;
        StringBuilder r137 = new StringBuilder();     // Catch: IOException -> L210 FileNotFoundException -> L212 Throwable -> L255
        r110 = r110;
        r137.append("fileContent is ");     // Catch: IOException -> L203 FileNotFoundException -> L330 Throwable -> L255
        r137.append(r130);     // Catch: IOException -> L203 FileNotFoundException -> L330 Throwable -> L255
        zo7.b.d("PreInstallChannelManage", r137.toString());     // Catch: IOException -> L203 FileNotFoundException -> L330 Throwable -> L255
        goto L243
    L343:
        r133.close();     // Catch: IOException -> L200
        r134.close();     // Catch: IOException -> L200
        r135.close();     // Catch: IOException -> L200
    L202:
        r127 = r130;
    L274:
        if (TextUtils.isEmpty(r127) == false) goto L331;
    L282:
        r113 = r110;
        goto L283
    L331:
        JSONObject r138 = new JSONObject(r127.toString());     // Catch: Throwable -> L280
        xo7.d r139 = a.C0335a.f19983a.f19980c;     // Catch: Throwable -> L280
        if (r139 == null) goto L278;
        r139.a();     // Catch: Throwable -> L280
    L278:
        r113 = r138.optString("channel");     // Catch: Throwable -> L280
    L280:
        th = move-exception;
        zo7.b.c("PreInstallChannelManage", "readChannelFile: ", th);
    L200:
        e = move-exception;
        zo7.b.b("PreInstallChannelManage", "getFileContentByPaths() meet IOException, exception is " + e);
    L203:
        e = e;
    L229:
        zo7.b.b("PreInstallChannelManage", e.getMessage());     // Catch: Throwable -> L255
        if (r133 != null) goto L339;
    L234:
        if (r134 == null) goto L236;
        r134.close();     // Catch: IOException -> L232
    L236:
        if (r135 == null) goto L271;
        r135.close();     // Catch: IOException -> L232
    L271:
        r127 = r130;
        r128 = r132;
        r110 = r110;
        goto L181
    L339:
        r133.close();     // Catch: IOException -> L232
    L232:
        e = e;
        StringBuilder r140 = new StringBuilder("getFileContentByPaths() meet IOException, exception is ");
    L254:
        r140.append(e);
        zo7.b.b("PreInstallChannelManage", r140.toString());
    L243:
        zo7.b.b("PreInstallChannelManage", "The File doesn't not exist.");     // Catch: Throwable -> L255
        if (r133 != null) goto L337;
    L248:
        if (r134 == null) goto L250;
        r134.close();     // Catch: IOException -> L246
    L250:
        if (r135 == null) goto L271;
        r135.close();     // Catch: IOException -> L246
        goto L271
    L337:
        r133.close();     // Catch: IOException -> L246
    L246:
        e = e;
        r140 = new StringBuilder("getFileContentByPaths() meet IOException, exception is ");
        goto L254
    L205:
        r110 = r110;
        r133.close();     // Catch: IOException -> L208
        r134.close();     // Catch: IOException -> L208
        r135.close();     // Catch: IOException -> L208
    L208:
        e = e;
        r140 = new StringBuilder("getFileContentByPaths() meet IOException, exception is ");
        goto L254
    L255:
        th = th;
        BufferedReader r141 = r135;
    L257:
        BufferedReader r142 = r141;
        InputStreamReader r143 = r134;
    L258:
        Throwable r144 = th;
        BufferedReader r145 = r142;
        InputStreamReader r146 = r143;
        PolarisFileInputStreamWrapper r147 = r133;
    L259:
        if (r147 != null) goto L347;
    L263:
        if (r146 == null) goto L265;
        r146.close();     // Catch: IOException -> L261
    L265:
        if (r145 == null) goto L377;
        r145.close();     // Catch: IOException -> L261
        throw r144;
    L261:
        e = move-exception;
        zo7.b.b("PreInstallChannelManage", "getFileContentByPaths() meet IOException, exception is " + e);
        throw r144;
    L377:
        throw r144;
    L347:
        r147.close();     // Catch: IOException -> L261
    L212:
        r110 = r110;
    L210:
        e = e;
        r110 = r110;
        goto L229
    L217:
        r110 = r110;
    L242:
        r135 = null;
    L215:
        e = e;
        r110 = r110;
    L228:
        r135 = null;
    L213:
        th = th;
        r141 = null;
        goto L257
    L220:
        e = e;
    L227:
        r134 = null;
    L218:
        th = th;
        r143 = null;
        r142 = null;
    L241:
        r134 = null;
    L240:
        r133 = null;
    L225:
        e = e;
        r133 = null;
    L223:
        th = move-exception;
        r144 = th;
        r145 = null;
        r147 = null;
        r146 = null;
        goto L259
    L270:
        r132 = r128;
        r110 = r110;
        goto L271
    L272:
        r110 = r110;
        goto L274
    L284:
        Iterator r148 = r104.iterator();
    L286:
        if (r148.hasNext() == false) goto L305;
        String r149 = (String) r148.next();
        if (TextUtils.isEmpty(r149) == true) goto L286;
        PolarisFileWrapper r150 = new PolarisFileWrapper(r149);     // Catch: Throwable -> L300
        if (r150.exists() == false) goto L286;
        if (r150.canRead() == false) goto L286;
        if (r150.isFile() == false) goto L286;
        Properties r151 = new Properties();     // Catch: Throwable -> L300
        PolarisFileInputStreamWrapper r152 = new PolarisFileInputStreamWrapper(r150);     // Catch: Throwable -> L300
        r151.load(r152);     // Catch: Throwable -> L300
        xo7.d r153 = a.C0335a.f19983a.f19980c;     // Catch: Throwable -> L300
        if (r153 == null) goto L301;
        r153.a();     // Catch: Throwable -> L300
    L301:
        String r154 = r151.getProperty("channel");     // Catch: Throwable -> L300
        r152.close();     // Catch: Throwable -> L300
        if (TextUtils.isEmpty(r154) == true) goto L286;
        String r155 = r154;
    L306:
        r101.f556508b = r155;
        goto L308
    L305:
        r155 = "";
        goto L306
    L69:
        r108 = null;
        goto L70
    L71:
        xo7.d r156 = a.C0335a.f19983a.f19980c;
        if (r156 == null) goto L74;
        List<String> r157 = r156.l();
    L75:
        r104.addAll(r157);
        goto L168
    L74:
        r157 = null;
        goto L75
    L76:
        xo7.d r158 = a.C0335a.f19983a.f19980c;
        if (r158 == null) goto L79;
        List<String> r159 = r158.b();
    L80:
        r104.addAll(r159);
        goto L168
    L79:
        r159 = null;
        goto L80
    L81:
        a r160 = a.C0335a.f19983a;
        xo7.d r161 = r160.f19980c;
        if (r161 == null) goto L84;
        List<String> r162 = r161.m();
    L85:
        r104.addAll(r162);
        r104.add(a.e());
        xo7.d r163 = r160.f19980c;
        if (r163 == null) goto L88;
        List<String> r164 = r163.g();
    L89:
        r104.addAll(r164);
        goto L168
    L88:
        r164 = null;
        goto L89
    L84:
        r162 = null;
        goto L85
    L90:
        xo7.d r165 = a.C0335a.f19983a.f19980c;
        if (r165 == null) goto L93;
        List<String> r166 = r165.c();
    L94:
        r104.addAll(r166);
        goto L168
    L93:
        r166 = null;
        goto L94
    L95:
        xo7.d r167 = a.C0335a.f19983a.f19980c;
        if (r167 == null) goto L98;
        List<String> r168 = r167.f();
    L99:
        r104.addAll(r168);
        goto L168
    L98:
        r168 = null;
        goto L99
    L100:
        xo7.d r169 = a.C0335a.f19983a.f19980c;
        if (r169 == null) goto L103;
        List<String> r170 = r169.d();
    L104:
        r104.addAll(r170);
        goto L168
    L103:
        r170 = null;
        goto L104
    L105:
        xo7.d r171 = a.C0335a.f19983a.f19980c;
        if (r171 == null) goto L108;
        List<String> r172 = r171.i();
    L109:
        r104.addAll(r172);
        r104.add(a.f());
        goto L168
    L108:
        r172 = null;
        goto L109
    L110:
        r104.add(a.e());
        xo7.d r173 = a.C0335a.f19983a.f19980c;
        if (r173 == null) goto L113;
        List<String> r174 = r173.g();
    L114:
        r104.addAll(r174);
        goto L168
    L113:
        r174 = null;
        goto L114
    L115:
        r101.a(r104);
        goto L168
    L116:
        xo7.b r175 = a.C0335a.f19983a.f19978a;
        if (r175 == null) goto L119;
        r175.a();
    L119:
        r104.add(a.d(r102.getPackageName()));
        goto L168
    L120:
        a r176 = a.C0335a.f19983a;
        ArrayList r177 = new ArrayList();
        r177.add(a.e());
        xo7.d r178 = r176.f19980c;
        if (r178 == null) goto L123;
        List<String> r179 = r178.g();
    L124:
        r177.addAll(r179);
        xo7.d r180 = r176.f19980c;
        if (r180 == null) goto L127;
        List<String> r181 = r180.i();
    L128:
        r177.addAll(r181);
        r177.add(a.f());
        xo7.d r182 = r176.f19980c;
        if (r182 == null) goto L131;
        List<String> r183 = r182.d();
    L132:
        r177.addAll(r183);
        xo7.d r184 = r176.f19980c;
        if (r184 == null) goto L135;
        List<String> r185 = r184.c();
    L136:
        r177.addAll(r185);
        xo7.d r186 = r176.f19980c;
        if (r186 == null) goto L139;
        List<String> r187 = r186.f();
    L140:
        r177.addAll(r187);
        xo7.d r188 = r176.f19980c;
        if (r188 == null) goto L143;
        List<String> r189 = r188.b();
    L144:
        r177.addAll(r189);
        xo7.d r190 = r176.f19980c;
        if (r190 == null) goto L147;
        List<String> r191 = r190.m();
    L148:
        r177.addAll(r191);
        xo7.d r192 = r176.f19980c;
        if (r192 == null) goto L151;
        List<String> r193 = r192.h();
    L152:
        r177.addAll(r193);
        xo7.d r194 = r176.f19980c;
        if (r194 == null) goto L155;
        List<String> r195 = r194.l();
    L156:
        r177.addAll(r195);
        xo7.d r196 = r176.f19980c;
        if (r196 == null) goto L159;
        List<String> r197 = r196.n();
    L160:
        r177.addAll(r197);
        xo7.d r198 = r176.f19980c;
        if (r198 == null) goto L163;
        r198.j();
        String r199 = "ro.channel.com.larus.nova";
    L164:
        r177.add(a.c(r199));
        AtomicBoolean r1100 = d.f19987g;
        Context r1101 = d.a.f19994a.f19988a;
        xo7.b r200 = r176.f19978a;
        if (r200 == null) goto L167;
        r200.a();
    L167:
        r177.add(a.d(r1101.getPackageName()));
        r104.addAll(r177);
        r101.a(r104);
        goto L168
    L163:
        r199 = "";
        goto L164
    L159:
        r197 = null;
        goto L160
    L155:
        r195 = null;
        goto L156
    L151:
        r193 = null;
        goto L152
    L147:
        r191 = null;
        goto L148
    L143:
        r189 = null;
        goto L144
    L139:
        r187 = null;
        goto L140
    L135:
        r185 = null;
        goto L136
    L131:
        r183 = null;
        goto L132
    L127:
        r181 = null;
        goto L128
    L123:
        r179 = null;
        goto L124
    L6:
        if (r105.equals("lemobile") == false) goto L62;
        r106 = 16;
        goto L63
    L9:
        if (r105.equals(SmEditTextLeakOpt.SAMSUNG) == false) goto L62;
        r106 = 14;
        goto L63
    L12:
        if (r105.equals("hisense") == false) goto L62;
        r106 = 17;
        goto L63
    L15:
        if (r105.equals("redmi") == false) goto L62;
        r106 = 1;
        goto L63
    L18:
        if (r105.equals("meizu") == false) goto L62;
        r106 = 10;
        goto L63
    L21:
        if (r105.equals(RomUtils.BRAND_HONOR) == false) goto L62;
        r106 = 4;
        goto L63
    L24:
        if (r105.equals("deltainno") == false) goto L62;
        r106 = 12;
        goto L63
    L27:
        if (r105.equals(DimLocationCheckUtil.VIVO) == false) goto L62;
        r106 = 7;
        goto L63
    L30:
        if (r105.equals(AppConstants.CHANNEL_OPPO) == false) goto L62;
        r106 = 5;
        goto L63
    L33:
        if (r105.equals("letv") == false) goto L62;
        r106 = 15;
        goto L63
    L36:
        if (r105.equals("motorola") == false) goto L62;
        r106 = 9;
        goto L63
    L39:
        if (r105.equals("unknown") == false) goto L62;
        r106 = 18;
        goto L63
    L42:
        if (r105.equals(DimLocationCheckUtil.XIAOMI) == false) goto L62;
        r106 = 0;
        goto L63
    L45:
        if (r105.equals("realme") == false) goto L62;
        r106 = 6;
        goto L63
    L48:
        if (r105.equals("lenovo") == false) goto L62;
        r106 = 8;
        goto L63
    L51:
        if (r105.equals(RomUtils.BRAND_HUAWEI) == false) goto L62;
        r106 = 3;
        goto L63
    L54:
        if (r105.equals("oneplus") == false) goto L62;
        r106 = HTTP.CR;
        goto L63
    L57:
        if (r105.equals("smartisan") == false) goto L62;
        r106 = 11;
        goto L63
    L60:
        if (r105.equals("blackshark") == false) goto L62;
        r106 = 2;
        goto L63
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public c(d r100) {
        this.f19986a = r100;
    }
}
