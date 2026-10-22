package bsa;

import com.bytedance.ee.bear.sheet.filter.FilterData;
import com.ss.ttvideoengine.model.VideoThumbInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f20354a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f20355b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f20356c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f20357d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f20358e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f20359f;

    public g(JSONObject r100) {
        this.f20358e = false;
        this.f20359f = false;
        this.f20354a = r100.optBoolean("enable", false);
        this.f20355b = r100.optInt(VideoThumbInfo.KEY_INTERVAL, 10);
        this.f20356c = r100.optInt(FilterData.FilterOptionItem.Type.RANGE, 85);
        this.f20357d = r100.optInt("ratio_limit", 80);
    }
}
