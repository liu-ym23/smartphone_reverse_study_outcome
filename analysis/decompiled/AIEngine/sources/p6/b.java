package p6;

import com.stepos.base.protocol.ProtocolType;
import com.stepos.core.ability.factory.AIEngineAbilityId;
import com.stepos.core.model.manager.ModelCacheImpl;
import gc.o;
import java.util.Iterator;
import java.util.List;
import mb.m;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: e, reason: collision with root package name */
    public static final b f11432e;

    /* renamed from: f, reason: collision with root package name */
    public static final List<b> f11433f;

    /* renamed from: a, reason: collision with root package name */
    public final String f11434a;

    /* renamed from: b, reason: collision with root package name */
    public final String f11435b;

    /* renamed from: c, reason: collision with root package name */
    public final String f11436c;

    /* renamed from: d, reason: collision with root package name */
    public final ProtocolType f11437d;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a {
        public static b a(String value) {
            Object next;
            kotlin.jvm.internal.g.f(value, "value");
            Iterator<T> it = b.f11433f.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (o.f0(((b) next).f11434a, value)) {
                    break;
                }
            }
            b bVar = (b) next;
            return bVar == null ? new b(value, value, "", ProtocolType.f6378a) : bVar;
        }
    }

    static {
        ProtocolType protocolType = ProtocolType.f6378a;
        b bVar = new b("chat", "对话", "文本对话生成，如 ChatGPT、文心一言", protocolType);
        f11432e = bVar;
        b bVar2 = new b(ModelCacheImpl.MODEL_TYPE_LLM, "文本生成", "大语言模型文本生成", protocolType);
        b bVar3 = new b(AIEngineAbilityId.EMBEDDING, "向量嵌入", "文本向量化，用于语义搜索", protocolType);
        b bVar4 = new b("text_classification", "文本分类", "情感分析、意图识别等", protocolType);
        b bVar5 = new b("ner", "命名实体识别", "提取人名、地名、机构名等", protocolType);
        ProtocolType protocolType2 = ProtocolType.f6379b;
        b bVar6 = new b("detection", "目标检测", "物体检测、人脸检测等", protocolType2);
        b bVar7 = new b("image_classification", "图像分类", "识别图片类别", protocolType2);
        b bVar8 = new b("ocr", "文字识别", "提取图片中的文字", protocolType2);
        b bVar9 = new b("captioning", "图像描述", "生成图片的文字描述", protocolType2);
        b bVar10 = new b("image_embedding", "图像嵌入", "图像向量化，用于以图搜图", protocolType2);
        ProtocolType protocolType3 = ProtocolType.f6380c;
        b bVar11 = new b("asr", "语音识别", "语音转文字", protocolType3);
        b bVar12 = new b("tts", "语音合成", "文字转语音", protocolType3);
        b bVar13 = new b("vad", "语音活动检测", "端侧判停：起说/判停端点事件 + 能量波形，不出文本", protocolType3);
        b bVar14 = new b("speaker", "声纹识别", "说话人识别、声纹嵌入", protocolType3);
        ProtocolType protocolType4 = ProtocolType.f6382e;
        b bVar15 = new b(ModelCacheImpl.MODEL_TYPE_VLM, "视觉语言模型", "图文问答，如 GPT-4V、MobileVLM", protocolType4);
        b bVar16 = new b("memory", "记忆理解", "基于多张历史图片的上下文推理，如截图对比、界面变化追踪", protocolType4);
        b bVar17 = new b("doc_understanding", "文档理解", "文档分析、表格理解等", protocolType4);
        b bVar18 = new b("video_understanding", "视频理解", "视频内容分析", protocolType4);
        b bVar19 = new b("highlight", "高光", "视频高光理解与文本生成", protocolType4);
        ProtocolType protocolType5 = ProtocolType.f6381d;
        f11433f = m.b0(bVar, bVar2, bVar3, bVar4, bVar5, bVar6, bVar7, bVar8, bVar9, bVar10, bVar11, bVar12, bVar14, bVar13, bVar15, bVar16, bVar17, bVar18, bVar19, new b("enhancement", "图像增强", "亮度、对比度优化等", protocolType5), new b("super_resolution", "超分辨率", "图像无损放大", protocolType5));
    }

    public b(String value, String displayName, String str, ProtocolType primaryProtocol) {
        kotlin.jvm.internal.g.f(value, "value");
        kotlin.jvm.internal.g.f(displayName, "displayName");
        kotlin.jvm.internal.g.f(primaryProtocol, "primaryProtocol");
        this.f11434a = value;
        this.f11435b = displayName;
        this.f11436c = str;
        this.f11437d = primaryProtocol;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return kotlin.jvm.internal.g.b(this.f11434a, bVar.f11434a) && kotlin.jvm.internal.g.b(this.f11435b, bVar.f11435b) && kotlin.jvm.internal.g.b(this.f11436c, bVar.f11436c) && this.f11437d == bVar.f11437d;
    }

    public final int hashCode() {
        return this.f11437d.hashCode() + v1.d.a(v1.d.a(this.f11434a.hashCode() * 31, 31, this.f11435b), 31, this.f11436c);
    }

    public final String toString() {
        return this.f11434a;
    }
}
