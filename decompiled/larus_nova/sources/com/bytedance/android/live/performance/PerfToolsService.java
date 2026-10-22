package com.bytedance.android.live.performance;

import android.app.Activity;
import android.app.Dialog;
import android.text.TextUtils;
import android.view.WindowManager;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.performance.adapter.DebugNormalInfoAdapter;
import com.bytedance.android.live.performance.adapter.DebugPerformanceTextAdapter;
import com.bytedance.android.live.performance.api.IPerfToolsService;
import com.bytedance.android.live.performance.views.charts.LineChartView;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import jc1.k;
import org.json.JSONObject;
import sr0.i;
import vr0.a;
import wr0.b;
import wr0.c;

/* JADX INFO: loaded from: classes46.dex */
public class PerfToolsService implements IPerfToolsService {
    private i mPresenter;

    @Override // com.bytedance.android.live.performance.api.IPerfToolsService
    public void clearSceneInfo() {
        Iterator<String> r100 = b.f560790b.keySet().iterator();
    L4:
        if (r100.hasNext() == false) goto L13;
        String r101 = r100.next();
        HashMap<String, b.a> r102 = b.f560790b;
        b.a r103 = r102.get(r101);
        if (r103 == null) goto L4;
        if (r103.f560800d != 1) goto L4;
        HashMap<String, String> r104 = r103.f560798b;
        if (r104 == null) goto L12;
        r104.clear();
    L12:
        r102.remove(r101);
        b.j(r101, false);
        goto L4
    }

    @Override // com.bytedance.android.live.performance.api.IPerfToolsService
    public void dismiss() {
        i r100 = this.mPresenter;
        if (r100 != null) goto L5;
        return;
    L5:
        r100.a();
        r100.b();
        r100.f543199x = null;
        r100.f543196u = null;
        r100.f543176a = null;
        b.b();
    }

    @Override // com.bytedance.android.live.performance.api.IPerfToolsService
    public int getCurrentEntrance() {
        i r100 = this.mPresenter;
        if (r100 != null) goto L7;
        return -1;
    L7:
        return r100.f543200y;
    }

    @Override // com.bytedance.android.live.performance.api.IPerfToolsService
    public int getCurrentPerformanceType() {
        i r100 = this.mPresenter;
        if (r100 != null) goto L7;
        return -1;
    L7:
        return r100.f543201z;
    }

    @Override // com.bytedance.android.live.performance.api.IPerfToolsService
    public boolean isContentVisible() {
        i r100 = this.mPresenter;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.f543182g == false) goto L7;
        return true;
    }

    @Override // com.bytedance.android.live.performance.api.IPerfToolsService
    public boolean isNormalViewVisible() {
        i r100 = this.mPresenter;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.d() == false) goto L7;
        return true;
    }

    @Override // com.bytedance.android.live.performance.api.IPerfToolsService
    public boolean isPerformanceViewVisible() {
        i r100 = this.mPresenter;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.e() == false) goto L7;
        return true;
    }

    public PerfToolsService() {
        k.l(IPerfToolsService.class, this);
        this.mPresenter = new i();
    }

    @Override // com.bytedance.android.live.performance.api.IPerfToolsService
    public void verifyEntranceNormalData() {
        if (c.a() == false) goto L70;
        i r100 = this.mPresenter;
        if (r100 == null) goto L76;
        r100.getClass();
        ArrayList r101 = new ArrayList();
        if (r100.f543200y != 4) goto L15;
        if (r100.f543194s != null) goto L12;
    L19:
        int r102 = this.mPresenter.f543200y;
        IPerfToolsService r103 = b.f560789a;
        if (r101.isEmpty() == false) goto L23;
    L47:
        i r104 = this.mPresenter;
        if (r104.f543200y != 4) goto L55;
        if (r104.f543194s != null) goto L52;
        return;
    L52:
        if (r104.e() == false) goto L72;
        DebugPerformanceTextAdapter r105 = r104.f543194s;
        ((ArrayList) r105.f85383b).clear();
        ((ArrayList) r105.f85383b).addAll(r101);
        r105.notifyDataSetChanged();
        return;
    L72:
        return;
    L55:
        if (r104.f543187l != null) goto L57;
        return;
    L57:
        if (r104.d() == false) goto L75;
        DebugNormalInfoAdapter r106 = r104.f543187l;
        ((ArrayList) r106.f85380b).clear();
        ((ArrayList) r106.f85380b).addAll(r101);
        r106.notifyDataSetChanged();
        return;
    L75:
        return;
    L23:
        if (r102 != 1) goto L29;
        if (b.i() == false) goto L27;
        r102 = 9;
    L36:
        List<String> r107 = b.f560791c.get(Integer.valueOf(r102));
        if (r107 == null) goto L47;
        if (r107.isEmpty() == true) goto L47;
        Iterator r108 = r101.iterator();
    L43:
        if (r108.hasNext() == false) goto L47;
        if (r107.contains(((a) r108.next()).f556805a) == true) goto L43;
        r108.remove();
        goto L43
    L27:
        r102 = 10;
        goto L36
    L29:
        if (r102 != 2) goto L36;
        Iterator r109 = r101.iterator();
    L32:
        if (r109.hasNext() == false) goto L47;
        if (b.a(((a) r109.next()).f556805a) == true) goto L32;
        r109.remove();
        goto L32
    L12:
        if (r100.e() == false) goto L19;
        r101.addAll(r100.f543194s.f85383b);
        goto L19
    L15:
        if (r100.f543187l == null) goto L19;
        if (r100.d() == false) goto L19;
        r101.addAll(r100.f543187l.f85380b);
        goto L19
    L76:
        return;
    }

    @Override // com.bytedance.android.live.performance.api.IPerfToolsService
    public void clearDynamicData() {
        b.b();
    }

    @Override // com.bytedance.android.live.performance.api.IPerfToolsService
    public void addClientInfoKey(JSONObject r100) {
        if (r100 != null) goto L4;
        IPerfToolsService r101 = b.f560789a;
        return;
    L4:
        if (b.f560794f == false) goto L17;
        HashMap<Integer, List<String>> r102 = b.f560791c;
        List<String> r103 = r102.get(10);
        List<String> r104 = r102.get(9);
        if (r104 == null) goto L18;
        if (r103 == null) goto L20;
        ArrayList r105 = new ArrayList(r103);
        ArrayList r106 = new ArrayList(r104);
        Iterator<String> r107 = r100.keys();
    L11:
        if (r107.hasNext() == false) goto L13;
        String r108 = r107.next();
        r105.add(r108);
        r106.add(r108);
        ((ArrayList) b.f560795g).add(r108);
        goto L11
    L13:
        HashMap<Integer, List<String>> r109 = b.f560791c;
        r109.put(10, r105);
        r109.put(9, r106);
        b.f560794f = false;
        return;
    L20:
        return;
    L18:
        return;
    }

    @Override // com.bytedance.android.live.performance.api.IPerfToolsService
    public void addLiveCoreInfoKey(JSONObject r100) {
        if (r100 != null) goto L4;
        IPerfToolsService r101 = b.f560789a;
        return;
    L4:
        if (b.f560793e == false) goto L16;
        List<String> r102 = b.f560791c.get(10);
        if (r102 == null) goto L18;
        ArrayList r103 = new ArrayList(r102);
        Iterator<String> r104 = r100.keys();
    L10:
        if (r104.hasNext() == false) goto L12;
        r103.add(r104.next());
        goto L10
    L12:
        b.f560791c.put(10, r103);
        b.f560793e = false;
        return;
    L18:
        return;
    }

    @Override // com.bytedance.android.live.performance.api.IPerfToolsService
    public List<a> getDataForEntrance(int r100) {
        return b.f(r100);
    }

    @Override // com.bytedance.android.live.performance.api.IPerfToolsService
    public List<Double> getDataForPerformanceEntrance(int r100) {
        String r101 = b.h(r100).get("data_performance_type");
        ArrayList r102 = new ArrayList();
        if (TextUtils.isEmpty(r101) == true) goto L13;
        HashMap<String, b.a> r103 = b.f560790b;
        if (r103.containsKey(r101) == false) goto L13;
        b.a r104 = r103.get(r101);
        if (r104 == null) goto L13;
        if (r104.f560800d != 2) goto L13;
        r102.addAll(r104.f560799c);
    L13:
        return r102;
    }

    @Override // com.bytedance.android.live.performance.api.IPerfToolsService
    public String getNormalInfo(String r100) {
        return b.g(r100);
    }

    @Override // com.bytedance.android.live.performance.api.IPerfToolsService
    public String getPerformanceChartTitle(int r100) {
        return b.h(r100).get("data_performance_title");
    }

    @Override // com.bytedance.android.live.performance.api.IPerfToolsService
    public void initAndShowDebugTool(boolean r100) {
        if (this.mPresenter != null) goto L5;
        this.mPresenter = new i();
    L5:
        if (r100 == true) goto L8;
        dismiss();
        return;
    L8:
        i r101 = this.mPresenter;
        if (r101.f543183h == false) goto L11;
        return;
    L11:
        if (r101.f543182g == true) goto L16;
        r101.c();
        return;
    }

    @Override // com.bytedance.android.live.performance.api.IPerfToolsService
    public void removeClientInfo(JSONObject r100) {
        if (r100 == null) goto L17;
        final i r101 = this.mPresenter;
        if (r101 == null) goto L28;
        Iterator<String> r102 = r100.keys();
    L8:
        if (r102.hasNext() == false) goto L29;
        final String r103 = r102.next();
        if (r101.f543187l == null) goto L8;
        if (c.a() == false) goto L13;
        DebugNormalInfoAdapter r104 = r101.f543187l;
        a r105 = r104.A2(r103);
        if (r105 == null) goto L8;
        ((ArrayList) r104.f85380b).remove(r105);
        r104.notifyDataSetChanged();
        goto L8
    L13:
        r101.A.post(new sr0.a(r101, r103));
        goto L8
    L29:
        return;
    L28:
        return;
    }

    @Override // com.bytedance.android.live.performance.api.IPerfToolsService
    public void removeSceneInfo(String r100) {
        IPerfToolsService r101 = b.f560789a;
        if (TextUtils.isEmpty(r100) == true) goto L15;
        HashMap<String, b.a> r102 = b.f560790b;
        if (r102.containsKey(r100) == false) goto L16;
        b.a r103 = r102.get(r100);
        if (r103 != null) goto L11;
        return;
    L11:
        if (r103.f560800d != 1) goto L18;
        r102.remove(r100);
        b.j(r100, false);
        return;
    L18:
        return;
    L16:
        return;
    }

    @Override // com.bytedance.android.live.performance.api.IPerfToolsService
    public IPerfToolsService setActivity(Activity r100) {
        i r101 = this.mPresenter;
        if (r101 != null) goto L5;
        return this;
    L5:
        r101.f543199x = r100;
        if (r100 == null) goto L8;
        r101.f543176a = (WindowManager) r100.getApplicationContext().getSystemService(LiveEndPageData.TAG_WINDOW);
    L8:
        return this;
    }

    @Override // com.bytedance.android.live.performance.api.IPerfToolsService
    public void updateNormalInfo(final a r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r100.f556806b) == true) goto L55;
        i r101 = this.mPresenter;
        if (r101 == null) goto L56;
        boolean r102 = false;
        if (r101.f543187l == null) goto L10;
        boolean r103 = true;
    L11:
        if (r103 == true) goto L13;
        return;
    L13:
        if (r101.d() == false) goto L61;
        String r104 = r100.f556805a;
        IPerfToolsService r105 = b.f560789a;
        if (TextUtils.isEmpty(r104) == true) goto L40;
        IPerfToolsService r106 = b.f560789a;
        if (r106 == null) goto L40;
        int r107 = r106.getCurrentEntrance();
        if (r107 != 1) goto L27;
        if (b.i() == false) goto L25;
        r107 = 9;
    L29:
        List<String> r108 = b.f560791c.get(Integer.valueOf(r107));
        if (r108 == null) goto L40;
        if (r108.isEmpty() == true) goto L40;
        Iterator<String> r109 = r108.iterator();
    L36:
        if (r109.hasNext() == false) goto L40;
        if (r109.next().equals(r104) == false) goto L36;
        r102 = true;
        goto L40
    L25:
        r107 = 10;
        goto L29
    L27:
        if (r107 != 2) goto L29;
        r102 = b.a(r104);
    L40:
        if (r102 == true) goto L42;
        return;
    L42:
        final i r110 = this.mPresenter;
        if (r110.f543187l != null) goto L45;
        return;
    L45:
        if (r110.d() == true) goto L47;
        return;
    L47:
        if (c.a() == true) goto L49;
        r110.A.post(new sr0.c(r110, r100));
        return;
    L49:
        r110.f543187l.y2(r100);
        return;
    L61:
        return;
    L10:
        r103 = false;
        goto L11
    L56:
        return;
    }

    @Override // com.bytedance.android.live.performance.api.IPerfToolsService
    public void updatePerformanceChart(double r100) {
        i r101 = this.mPresenter;
        if (r101 != null) goto L6;
        return;
    L6:
        if (r101.f543188m == null) goto L10;
        LineChartView.Data r102 = new LineChartView.Data(r100, new Date());
        LineChartView r103 = r101.f543188m;
        ((ArrayList) r103.f85399j).add(r102);
        r103.i();
        return;
    }

    @Override // com.bytedance.android.live.performance.api.IPerfToolsService
    public void addPerformanceData(String r110, double r111) {
        IPerfToolsService r100 = b.f560789a;
        if (TextUtils.isEmpty(r110) == true) goto L89;
        IPerfToolsService r101 = b.f560789a;
        if (r101 != null) goto L7;
        return;
    L7:
        if (r101.isContentVisible() == true) goto L10;
        return;
    L10:
        if (r101.isPerformanceViewVisible() == false) goto L12;
    L66:
        HashMap<String, b.a> r102 = b.f560790b;
        if (r102.containsKey(r110) == true) goto L69;
        b.a r103 = new b.a();
        ArrayList r104 = new ArrayList();
        r103.f560799c = r104;
        r104.add(Double.valueOf(r111));
        r103.f560800d = 2;
    L79:
        r102.put(r110, r103);
        if (r101.isPerformanceViewVisible() == false) goto L92;
        String r105 = b.h(r101.getCurrentPerformanceType()).get("data_performance_type");
        if (r105 != null) goto L85;
    L87:
        r101.updatePerformanceChart(r111);
        return;
    L85:
        if (r105.equals(r110) == true) goto L87;
        return;
    L92:
        return;
    L69:
        r103 = r102.get(r110);
        if (r103 != null) goto L72;
    L78:
        r103 = new b.a();
        ArrayList r106 = new ArrayList();
        r103.f560799c = r106;
        r106.add(Double.valueOf(r111));
        r103.f560800d = 2;
        goto L79
    L72:
        if (r103.f560800d != 2) goto L78;
        if (r103.f560799c != null) goto L77;
        r103.f560799c = new ArrayList();
    L77:
        ((ArrayList) r103.f560799c).add(Double.valueOf(r111));
        goto L79
    L12:
        if (r101.isNormalViewVisible() == false) goto L66;
        if (TextUtils.isEmpty(IPerformanceManager.MODULE_GIFT_EFFECT) == false) goto L16;
        boolean r107 = false;
    L17:
        if (r107 == false) goto L56;
        String r108 = b.e(IPerformanceManager.MODULE_GIFT_EFFECT, r110);
        r110.getClass();
        byte r109 = -1;
        switch(r110.hashCode()) {
            case -1304311193: goto L34;
            case -947329893: goto L30;
            case -816061345: goto L26;
            case 1077775884: goto L22;
            default: goto L37;
        };
    L37:
        switch(r109) {
            case 0: goto L51;
            case 1: goto L47;
            case 2: goto L43;
            case 3: goto L39;
            default: goto L56;
        };
    L39:
        String r112 = s1.B(R.string.ttlive_perftools_cpu_rate_no_percent);
        StringBuilder r113 = new StringBuilder();
        double r114 = 100.0d * r111;
        r113.append(r114);
        r113.append(GXTemplateKey.GAIAX_PE);
        r101.updateNormalInfo(new a(r108, r112, r113.toString()));
        HashMap<String, b.a> r115 = b.f560790b;
        b.a r116 = r115.get(r108);
        if (r116 != null) goto L42;
        r116 = new b.a();
        r116.f560800d = 0;
    L42:
        r116.f560797a = r114 + GXTemplateKey.GAIAX_PE;
        r115.put(r108, r116);
        goto L56
    L43:
        r101.updateNormalInfo(new a(r108, s1.B(R.string.ttlive_perftools_battery_temperature_no_unit), r111 + s1.B(R.string.ttlive_perftools_centigrade)));
        HashMap<String, b.a> r117 = b.f560790b;
        b.a r118 = r117.get(r108);
        if (r118 != null) goto L46;
        r118 = new b.a();
        r118.f560800d = 0;
    L46:
        r118.f560797a = r111 + s1.B(R.string.ttlive_perftools_centigrade);
        r117.put(r108, r118);
        goto L56
    L47:
        r101.updateNormalInfo(new a(r108, s1.B(R.string.ttlive_perftools_cpu_used), r111 + "s"));
        HashMap<String, b.a> r119 = b.f560790b;
        b.a r120 = r119.get(r108);
        if (r120 != null) goto L50;
        r120 = new b.a();
        r120.f560800d = 0;
    L50:
        r120.f560797a = r111 + "s";
        r119.put(r108, r120);
        goto L56
    L51:
        r101.updateNormalInfo(new a(r108, s1.B(R.string.ttlive_perftools_fps), r111 + ""));
        HashMap<String, b.a> r121 = b.f560790b;
        b.a r122 = r121.get(r108);
        if (r122 != null) goto L54;
        r122 = new b.a();
        r122.f560800d = 0;
    L54:
        r122.f560797a = r111 + "";
        r121.put(r108, r122);
        goto L56
    L22:
        if (r110.equals("data_cpu_rate") == false) goto L37;
        r109 = 3;
        goto L37
    L26:
        if (r110.equals("data_temperature") == false) goto L37;
        r109 = 2;
        goto L37
    L30:
        if (r110.equals("data_cpu_speed") == false) goto L37;
        r109 = 1;
        goto L37
    L34:
        if (r110.equals("data_avg_fps") == false) goto L37;
        r109 = 0;
    L56:
        if (TextUtils.isEmpty("ktv") == false) goto L58;
        boolean r123 = false;
    L59:
        if (r123 == false) goto L66;
        String r124 = b.e("ktv", r110);
        if ("data_http_rtt".equals(r110) == false) goto L66;
        r101.updateNormalInfo(new a(r124, s1.B(R.string.ttlive_perftools_http_rtt), r111 + "ms"));
        HashMap<String, b.a> r125 = b.f560790b;
        b.a r126 = r125.get(r124);
        if (r126 != null) goto L65;
        r126 = new b.a();
        r126.f560800d = 0;
    L65:
        r126.f560797a = r111 + "ms";
        r125.put(r124, r126);
        goto L66
    L58:
        r123 = ((ArrayList) b.f560792d).contains(Integer.valueOf(b.d("ktv")));
        goto L59
    L16:
        r107 = ((ArrayList) b.f560792d).contains(Integer.valueOf(b.d(IPerformanceManager.MODULE_GIFT_EFFECT)));
        goto L17
    }

    @Override // com.bytedance.android.live.performance.api.IPerfToolsService
    public void setData(String r100, String r101) {
        IPerfToolsService r102 = b.f560789a;
        if (TextUtils.isEmpty(r100) == true) goto L30;
        if (r101 == null) goto L31;
        IPerfToolsService r103 = b.f560789a;
        if (r103 == null) goto L35;
        String r104 = r101.trim();
        b.a r105 = new b.a();
        r105.f560797a = r104;
        r105.f560800d = 0;
        b.f560790b.put(r100, r105);
        if (r103.isContentVisible() == false) goto L36;
        int r106 = r103.getCurrentEntrance();
        if (r106 == 1) goto L14;
    L17:
        List<String> r107 = b.f560791c.get(Integer.valueOf(r106));
        if (r107 != null) goto L20;
        return;
    L20:
        if (r107.isEmpty() == false) goto L22;
        return;
    L22:
        if (r107.contains(r100) == true) goto L24;
        return;
    L24:
        if (r106 == 2) goto L26;
    L28:
        r103.updateNormalInfo(new a(r100, b.c(r100), r104));
        return;
    L26:
        if (b.a(r100) == true) goto L28;
        return;
    L14:
        if (b.i() == false) goto L16;
        r106 = 9;
        goto L17
    L16:
        r106 = 10;
        goto L17
    L36:
        return;
    L35:
        return;
    L31:
        return;
    }

    @Override // com.bytedance.android.live.performance.api.IPerfToolsService
    public void setDialog(Dialog r100, boolean r101) {
        i r102 = this.mPresenter;
        if (r102 != null) goto L5;
        return;
    L5:
        r102.f543196u = r100;
        r102.f543197v = r101;
        if (r102.f543183h == false) goto L9;
        r102.f543179d.setDialog(r100);
        return;
    L9:
        if (r102.f543182g == false) goto L13;
        r102.f543178c.setDialog(r100);
        return;
    }

    @Override // com.bytedance.android.live.performance.api.IPerfToolsService
    public void setSceneInfo(String r100, Map<String, String> r101) {
        IPerfToolsService r102 = b.f560789a;
        if (TextUtils.isEmpty(r100) == true) goto L28;
        if (r101 == null) goto L30;
        IPerfToolsService r103 = b.f560789a;
        if (r103 == null) goto L32;
        b.a r104 = new b.a();
        HashMap<String, String> r105 = new HashMap();
        r104.f560798b = r105;
        r105.putAll(r101);
        r104.f560800d = 1;
        HashMap<String, b.a> r106 = b.f560790b;
        r106.put(r100, r104);
        b.j(r100, true);
        if ("link_mic".equals(r100) == true) goto L11;
    L19:
        int r107 = b.d(r100);
        List<String> r108 = b.f560791c.get(Integer.valueOf(r107));
        if (r108 != null) goto L22;
        return;
    L22:
        if (r108.isEmpty() == true) goto L33;
        Iterator<String> r109 = r108.iterator();
    L26:
        if (r109.hasNext() == false) goto L34;
        String r110 = r109.next();
        String r111 = b.g(r110);
        b.f560789a.updateNormalInfo(new a(r110, b.c(r110), r111));
        goto L26
    L34:
        return;
    L33:
        return;
    L11:
        if (r101.containsKey("stream_mix_on_client") == false) goto L19;
        String r112 = r101.get("stream_mix_on_client");
        if (r112 != null) goto L15;
    L17:
        String r113 = "mixOnServer";
    L18:
        r103.updateNormalInfo(new a("data_mix_type", s1.B(R.string.ttlive_perftools_mix_type), r113));
        b.a r114 = new b.a();
        r114.f560800d = 0;
        r114.f560797a = r113;
        r106.put("data_mix_type", r114);
        goto L19
    L15:
        if (r112.equals("1") == false) goto L17;
        r113 = "mixOnClient";
        goto L18
    L32:
        return;
    L30:
        return;
    }
}
