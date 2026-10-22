package com.bytedance.android.monitorV2.hybridSetting.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lz2.a;
import nz2.b;

/* JADX INFO: loaded from: classes12.dex */
public final class BidInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<String, BidConfig> f163078a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<a> f163079b;

    public static class BidConfig {
        public static final int NUM = 46;
        public boolean ajax_web;
        public String bid;
        public boolean blank_lynx;
        public boolean blank_reactnative;
        public boolean blank_web;
        public boolean container_error;
        public boolean custom_p0;
        public boolean custom_p1;
        public boolean custom_p2;
        public boolean custom_p3;
        public boolean custom_p4;
        public boolean custom_p5;
        public boolean custom_p6;
        public boolean custom_p7;
        public boolean custom_p8;
        public Map<String, Integer> eventNameSample;
        public boolean falcon_perf_web;
        public boolean fetch_error_lynx;
        public boolean fetch_error_reactnative;
        public boolean fetch_error_web;
        public long hitSample;
        public boolean js_exception_lynx;
        public boolean js_exception_web;
        public boolean jsb_error_lynx;
        public boolean jsb_error_reactnative;
        public boolean jsb_error_web;
        public boolean jsb_perf_lynx;
        public boolean jsb_perf_web;
        public boolean native_error_lynx;
        public boolean native_error_reactnative;
        public boolean native_error_web;
        public boolean navigation_start_lynx;
        public boolean navigation_start_web;
        public boolean perf_web;
        public boolean performance_lynx;
        public boolean performance_reactnative;
        public boolean res_loader_error_lynx;
        public boolean res_loader_error_template_lynx;
        public boolean res_loader_error_template_web;
        public boolean res_loader_error_web;
        public boolean res_loader_perf_lynx;
        public boolean res_loader_perf_template_lynx;
        public boolean res_loader_perf_template_web;
        public boolean res_loader_perf_web;
        public long settingId;
        public boolean static_error_lynx;
        public boolean static_error_web;
        public boolean static_perf_web;
        public boolean static_sri_web;
        public boolean tea_switch;

        public String toString() {
            return "BidConfig{, hitSample=" + this.hitSample + ", settingId=" + this.settingId + ", custom_p0=" + this.custom_p0 + ", custom_p1=" + this.custom_p1 + ", custom_p2=" + this.custom_p2 + ", custom_p3=" + this.custom_p3 + ", custom_p4=" + this.custom_p4 + ", custom_p5=" + this.custom_p5 + ", custom_p6=" + this.custom_p6 + ", custom_p7=" + this.custom_p7 + ", custom_p8=" + this.custom_p8 + ", perf_web=" + this.perf_web + ", ajax_web=" + this.ajax_web + ", static_perf_web=" + this.static_perf_web + ", static_error_web=" + this.static_error_web + ", js_exception_web=" + this.js_exception_web + ", blank_web=" + this.blank_web + ", fetch_error_web=" + this.fetch_error_web + ", jsb_error_web=" + this.jsb_error_web + ", jsb_perf_web=" + this.jsb_perf_web + ", falcon_perf_web=" + this.falcon_perf_web + ", native_error_web=" + this.native_error_web + ", navigation_start_web=" + this.navigation_start_web + ", performance_lynx=" + this.performance_lynx + ", blank_lynx=" + this.blank_lynx + ", fetch_error_lynx=" + this.fetch_error_lynx + ", jsb_error_lynx=" + this.jsb_error_lynx + ", jsb_perf_lynx=" + this.jsb_perf_lynx + ", native_error_lynx=" + this.native_error_lynx + ", navigation_start_lynx=" + this.navigation_start_lynx + ", performance_reactnative=" + this.performance_reactnative + ", blank_reactnative=" + this.blank_reactnative + ", fetch_error_reactnative=" + this.fetch_error_reactnative + ", jsb_error_reactnative=" + this.jsb_error_reactnative + ", native_error_reactnative=" + this.native_error_reactnative + ", container_error=" + this.container_error + ", js_exception_lynx=" + this.js_exception_lynx + ", static_error_lynx=" + this.static_error_lynx + ", tea_switch=" + this.tea_switch + ", res_loader_perf_web=" + this.res_loader_perf_web + ", res_loader_error_web=" + this.res_loader_error_web + ", res_loader_perf_template_web=" + this.res_loader_perf_template_web + ", res_loader_error_template_web=" + this.res_loader_error_template_web + ", res_loader_perf_lynx=" + this.res_loader_perf_lynx + ", res_loader_error_lynx=" + this.res_loader_error_lynx + ", res_loader_perf_template_lynx=" + this.res_loader_perf_template_lynx + ", res_loader_error_template_lynx=" + this.res_loader_error_template_lynx + '}';
        }

        public BidConfig() {
            this.bid = "__hybrid_default";
            this.hitSample = 0;
            this.settingId = 0;
            this.eventNameSample = new HashMap();
            this.custom_p0 = false;
            this.custom_p1 = false;
            this.custom_p2 = false;
            this.custom_p3 = false;
            this.custom_p4 = false;
            this.custom_p5 = false;
            this.custom_p6 = false;
            this.custom_p7 = false;
            this.custom_p8 = false;
            this.perf_web = false;
            this.ajax_web = false;
            this.static_perf_web = false;
            this.static_error_web = false;
            this.js_exception_web = false;
            this.blank_web = false;
            this.fetch_error_web = false;
            this.jsb_error_web = false;
            this.jsb_perf_web = false;
            this.falcon_perf_web = false;
            this.native_error_web = false;
            this.navigation_start_web = false;
            this.static_sri_web = false;
            this.performance_lynx = false;
            this.blank_lynx = false;
            this.fetch_error_lynx = false;
            this.jsb_error_lynx = false;
            this.jsb_perf_lynx = false;
            this.native_error_lynx = false;
            this.navigation_start_lynx = false;
            this.performance_reactnative = false;
            this.blank_reactnative = false;
            this.fetch_error_reactnative = false;
            this.jsb_error_reactnative = false;
            this.native_error_reactnative = false;
            this.container_error = false;
            this.js_exception_lynx = false;
            this.static_error_lynx = false;
            this.tea_switch = false;
            this.res_loader_perf_web = false;
            this.res_loader_error_web = false;
            this.res_loader_perf_template_web = false;
            this.res_loader_error_template_web = false;
            this.res_loader_perf_lynx = false;
            this.res_loader_error_lynx = false;
            this.res_loader_perf_template_lynx = false;
            this.res_loader_error_template_lynx = false;
        }

        public BidConfig(String r100) {
            this.bid = "__hybrid_default";
            this.hitSample = 0;
            this.settingId = 0;
            this.eventNameSample = new HashMap();
            this.custom_p0 = false;
            this.custom_p1 = false;
            this.custom_p2 = false;
            this.custom_p3 = false;
            this.custom_p4 = false;
            this.custom_p5 = false;
            this.custom_p6 = false;
            this.custom_p7 = false;
            this.custom_p8 = false;
            this.perf_web = false;
            this.ajax_web = false;
            this.static_perf_web = false;
            this.static_error_web = false;
            this.js_exception_web = false;
            this.blank_web = false;
            this.fetch_error_web = false;
            this.jsb_error_web = false;
            this.jsb_perf_web = false;
            this.falcon_perf_web = false;
            this.native_error_web = false;
            this.navigation_start_web = false;
            this.static_sri_web = false;
            this.performance_lynx = false;
            this.blank_lynx = false;
            this.fetch_error_lynx = false;
            this.jsb_error_lynx = false;
            this.jsb_perf_lynx = false;
            this.native_error_lynx = false;
            this.navigation_start_lynx = false;
            this.performance_reactnative = false;
            this.blank_reactnative = false;
            this.fetch_error_reactnative = false;
            this.jsb_error_reactnative = false;
            this.native_error_reactnative = false;
            this.container_error = false;
            this.js_exception_lynx = false;
            this.static_error_lynx = false;
            this.tea_switch = false;
            this.res_loader_perf_web = false;
            this.res_loader_error_web = false;
            this.res_loader_perf_template_web = false;
            this.res_loader_error_template_web = false;
            this.res_loader_perf_lynx = false;
            this.res_loader_error_lynx = false;
            this.res_loader_perf_template_lynx = false;
            this.res_loader_error_template_lynx = false;
            if (r100.isEmpty() == true) goto L6;
            this.bid = r100;
            return;
        }
    }

    public final String toString() {
        return "BidInfo{bidInfoMap=" + this.f163078a + ", regexList=" + this.f163079b + '}';
    }

    public BidInfo() {
        this.f163078a = new HashMap();
        this.f163079b = new ArrayList();
    }

    public final BidConfig a(String r100) {
        if (this.f163078a.containsKey(r100) == false) goto L7;
        return this.f163078a.get(r100);
    L7:
        if (this.f163078a.containsKey("__hybrid_default") == false) goto L10;
        b.f("BidInfo", "Not found bidConfig for " + r100 + ", use __hybrid_default");
        return this.f163078a.get("__hybrid_default");
    L10:
        b.f("BidInfo", "Not found bidConfig for " + r100 + ", use __hybrid_default");
        return new BidConfig("__hybrid_default");
    }
}
