package e3;

import d8.z;
import java.util.HashMap;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public static final HashMap f2362a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public static final d3.b f2363b;

    /* renamed from: c, reason: collision with root package name */
    public static final d3.b f2364c;

    static {
        new d3.b("chat", new z(4));
        new d3.b("chat-vision", new z(4));
        new d3.b("chat-smsparse", new z(4));
        new d3.b("chinese_clip", new z(9));
        new d3.b("embedding", new z(10));
        f2363b = new d3.b("embedding_bge", new z(10));
        new d3.b("reranking", new z(11));
        f2364c = new d3.b("memory", new z(12));
        new d3.b("image_matting", new z(13));
        new d3.b("image_inpaint", new z(6));
        new d3.b("image_extend", new z(5));
        new d3.b("image_inpaint_aigc", new z(6));
        new d3.b("interactive_segment", new z(7));
        new d3.b("speech_recognition", new z(8));
    }
}
