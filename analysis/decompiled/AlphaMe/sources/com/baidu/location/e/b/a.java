package com.baidu.location.e.b;

import B0.g;
import androidx.room.AbstractC0351g;
import com.baidu.location.e.h;
import java.io.File;

/* loaded from: classes.dex */
public class a {

    /* renamed from: com.baidu.location.e.b.a$a, reason: collision with other inner class name */
    public static class C0015a {

        /* renamed from: a, reason: collision with root package name */
        public static final String f5812a;

        /* renamed from: b, reason: collision with root package name */
        public static final String f5813b;

        static {
            StringBuilder sb = new StringBuilder();
            sb.append(h.g());
            String str = File.separator;
            AbstractC0351g.C(sb, str, "locModel", str, "gps_checker");
            f5812a = g.r(sb, str, "GPS_Checker_Model.m");
            f5813b = h.g() + str + "locModel" + str + "gps_checker" + str;
        }
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public static final String f5814a;

        /* renamed from: b, reason: collision with root package name */
        private static final String f5815b;

        static {
            StringBuilder sb = new StringBuilder("indoor");
            String str = File.separator;
            String strR = g.r(sb, str, "poiData");
            f5815b = strR;
            f5814a = h.g() + str + "locModel" + str + strR + str;
        }
    }

    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public static final String f5816a;

        /* renamed from: b, reason: collision with root package name */
        public static final String f5817b;

        static {
            StringBuilder sb = new StringBuilder();
            sb.append(h.g());
            String str = File.separator;
            AbstractC0351g.C(sb, str, "locModel", str, "vdrModel");
            f5816a = g.r(sb, str, "mobilenet_opt.nb");
            f5817b = h.g() + str + "locModel" + str + "vdrModel" + str;
        }
    }

    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public static final String f5818a;

        /* renamed from: b, reason: collision with root package name */
        private static final String f5819b;

        static {
            StringBuilder sb = new StringBuilder("outdoor");
            String str = File.separator;
            String strR = g.r(sb, str, "poiData");
            f5819b = strR;
            f5818a = h.g() + str + "locModel" + str + strR + str;
        }
    }

    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public static final String f5820a;

        /* renamed from: b, reason: collision with root package name */
        public static final String f5821b;

        static {
            StringBuilder sb = new StringBuilder();
            sb.append(h.g());
            String str = File.separator;
            AbstractC0351g.C(sb, str, "locModel", str, "subway");
            f5820a = g.r(sb, str, "State_Recognition_Model_Static.m");
            f5821b = h.g() + str + "locModel" + str + "subway" + str;
        }
    }

    public static class f {

        /* renamed from: a, reason: collision with root package name */
        public static final String f5822a;

        /* renamed from: b, reason: collision with root package name */
        public static final String f5823b;

        static {
            StringBuilder sb = new StringBuilder();
            sb.append(h.g());
            String str = File.separator;
            AbstractC0351g.C(sb, str, "locModel", str, "traffic");
            f5822a = g.r(sb, str, "Traffic_Recognition_Model.m");
            f5823b = h.g() + str + "locModel" + str + "traffic" + str;
        }
    }
}
