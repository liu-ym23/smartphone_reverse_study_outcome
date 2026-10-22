package q9;

import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pattern f23577a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Pattern f23578b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Pattern f23579c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Pattern f23580d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Pattern f23581e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Pattern f23582f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Pattern f23583g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Pattern f23584h = null;

    static {
        f23577a = Pattern.compile("#EXT-X-TARGETDURATION:(\\d+)\\b");
        f23578b = Pattern.compile("#EXTINF:([\\d\\.]+)\\b");
        f23579c = Pattern.compile("#EXT-X-VERSION:(\\d+)\\b");
        f23580d = Pattern.compile("#EXT-X-MEDIA-SEQUENCE:(\\d+)\\b");
        f23581e = Pattern.compile("METHOD=(NONE|AES-128|SAMPLE-AES|SAMPLE-AES-CENC|SAMPLE-AES-CTR)\\s*(,|$)");
        f23582f = Pattern.compile("KEYFORMAT=\"(.+?)\"");
        f23583g = Pattern.compile("URI=\"(.+?)\"");
        f23584h = Pattern.compile("IV=([^,.*]+)");
    }
}
