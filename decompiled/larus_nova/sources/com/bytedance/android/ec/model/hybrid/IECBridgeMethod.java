package com.bytedance.android.ec.model.hybrid;

import android.content.Context;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public interface IECBridgeMethod {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/ec/model/hybrid/IECBridgeMethod$Access;", "", "PUBLIC", "PRIVATE", "PROTECT", "ec-model_release"}, k = 1, mv = {1, 4, 3})
    public static final enum Access extends Enum<Access> {
        public static final Access PRIVATE = null;
        public static final Access PROTECT = null;
        public static final Access PUBLIC = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Access[] f47869a = null;

        static {
            Access r100 = new Access("PUBLIC", 0);
            PUBLIC = r100;
            Access r101 = new Access("PRIVATE", 1);
            PRIVATE = r101;
            Access r102 = new Access("PROTECT", 2);
            PROTECT = r102;
            f47869a = new Access[]{r100, r101, r102};
        }

        public static Access valueOf(String r100) {
            return (Access) r27.a.a(Access.class, r100);
        }

        public static Access[] values() {
            return (Access[]) f47869a.clone();
        }

        public Access(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
        public static /* synthetic */ void a(IECBridgeMethod r100, Context r101, JSONObject r102, b r103, c r110) {
            r100.a(r101, r102, r103, r110, null);
        }
    }

    public interface b {
        void onComplete(JSONObject r100);

        void onError(int r100, String r101);
    }

    public interface c {
        void a(JSONObject r100);
    }

    void a(Context r100, JSONObject r101, b r102, c r103, Object r104);

    Access getAccess();

    String getName();

    void release();
}
