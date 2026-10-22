package com.bytedance.android.livesdkapi.depend.model;

import android.text.TextUtils;
import androidx.camera.core.RetryPolicy;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.android.live.base.model.UrlModel;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.ee.bear.bitable.fieldedit.BitableFieldEditAnalytic;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\r\u0018\u0000 ü\u00012\u00020\u0001:\u0012ú\u0001û\u0001ü\u0001ý\u0001þ\u0001ÿ\u0001\u0080\u0002\u0081\u0002\u0082\u0002B\u0007\b\u0016¢\u0006\u0002\u0010\u0002J\u0007\u0010ê\u0001\u001a\u00020\u0010J\u0015\u0010ë\u0001\u001a\u00020\u00102\t\u0010ì\u0001\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\t\u0010í\u0001\u001a\u0004\u0018\u00010EJ\b\u0010î\u0001\u001a\u00030ï\u0001J\t\u0010ð\u0001\u001a\u00020\u0017H\u0016J\u0007\u0010ñ\u0001\u001a\u00020\u0010J\u0007\u0010ò\u0001\u001a\u00020\u0010J\u0007\u0010ó\u0001\u001a\u00020\u0010J\u0007\u0010ô\u0001\u001a\u00020\u0010J\u0013\u0010õ\u0001\u001a\u00030ö\u00012\t\u0010÷\u0001\u001a\u0004\u0018\u00010EJ\u0013\u0010ø\u0001\u001a\u00030ö\u00012\t\u0010÷\u0001\u001a\u0004\u0018\u00010EJ\t\u0010ù\u0001\u001a\u00020\u0004H\u0016R\u001c\u0010\u0003\u001a\u00020\u00048FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u00020\u00108FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R*\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00170\u0016j\b\u0012\u0004\u0012\u00020\u0017`\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR \u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001c\u0010)\u001a\u00020\u00108FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0012\"\u0004\b+\u0010\u0014R\u001a\u0010,\u001a\u00020-X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001c\u00102\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0006\"\u0004\b4\u0010\bR\u001c\u00105\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u0006\"\u0004\b7\u0010\bR\u001a\u00108\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u0012\"\u0004\b:\u0010\u0014R\u001a\u0010;\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010&\"\u0004\b=\u0010(R\u001c\u0010>\u001a\u0004\u0018\u00010?X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u0010\u0010D\u001a\u0004\u0018\u00010EX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010F\u001a\u00020\u00048FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010\u0006\"\u0004\bH\u0010\bR\u0010\u0010I\u001a\u0004\u0018\u00010EX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010J\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010\u0012\"\u0004\bL\u0010\u0014R\u001a\u0010M\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010\u0012\"\u0004\bO\u0010\u0014R\u001c\u0010P\u001a\u00020\u00108FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010\u0012\"\u0004\bR\u0010\u0014R \u0010S\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010\u0006\"\u0004\bU\u0010\bR\u001a\u0010V\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010\u0012\"\u0004\bX\u0010\u0014R\u001a\u0010Y\u001a\u00020ZX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^R\u001a\u0010_\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010\u0012\"\u0004\ba\u0010\u0014R\u001c\u0010b\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bc\u0010\u0006\"\u0004\bd\u0010\bR \u0010e\u001a\u0004\u0018\u00010f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bg\u0010h\"\u0004\bi\u0010jR\u001e\u0010k\u001a\u00020-8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bl\u0010/\"\u0004\bm\u00101R\u001a\u0010n\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bo\u0010\u0006\"\u0004\bp\u0010\bR\u001a\u0010q\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bq\u0010\u0012\"\u0004\br\u0010\u0014R\u001a\u0010s\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bs\u0010\u0012\"\u0004\bt\u0010\u0014R\u001a\u0010u\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bu\u0010\u0012\"\u0004\bv\u0010\u0014R\u001a\u0010w\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bw\u0010\u0012\"\u0004\bx\u0010\u0014R\u001a\u0010y\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\by\u0010\u0012\"\u0004\bz\u0010\u0014R\u001a\u0010{\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b{\u0010\u0012\"\u0004\b|\u0010\u0014R\u001a\u0010}\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b}\u0010\u0012\"\u0004\b~\u0010\u0014R\"\u0010\u007f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u0014\n\u0003\u0010\u0083\u0001\u001a\u0005\b\u007f\u0010\u0080\u0001\"\u0006\b\u0081\u0001\u0010\u0082\u0001R\u001f\u0010\u0084\u0001\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0085\u0001\u0010\u0006\"\u0005\b\u0086\u0001\u0010\bR\"\u0010\u0087\u0001\u001a\u0005\u0018\u00010\u0088\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0089\u0001\u0010\u008a\u0001\"\u0006\b\u008b\u0001\u0010\u008c\u0001R#\u0010\u008d\u0001\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008e\u0001\u0010\u0006\"\u0005\b\u008f\u0001\u0010\bR\u001f\u0010\u0090\u0001\u001a\u00020\u00108FX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0091\u0001\u0010\u0012\"\u0005\b\u0092\u0001\u0010\u0014RA\u0010\u0093\u0001\u001a$\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0094\u0001j\u0011\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0095\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0096\u0001\u0010\u0097\u0001\"\u0006\b\u0098\u0001\u0010\u0099\u0001R\u001f\u0010\u009a\u0001\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u009b\u0001\u0010\u0006\"\u0005\b\u009c\u0001\u0010\bR\u001d\u0010\u009d\u0001\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u009e\u0001\u0010\u0006\"\u0005\b\u009f\u0001\u0010\bR\u001f\u0010 \u0001\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¡\u0001\u0010\u0006\"\u0005\b¢\u0001\u0010\bR\u001d\u0010£\u0001\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¤\u0001\u0010\u0006\"\u0005\b¥\u0001\u0010\bR\u001d\u0010¦\u0001\u001a\u00020\u0010X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b§\u0001\u0010\u0012\"\u0005\b¨\u0001\u0010\u0014R$\u0010©\u0001\u001a\u0005\u0018\u00010ª\u00018FX\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b«\u0001\u0010¬\u0001\"\u0006\b\u00ad\u0001\u0010®\u0001R\u001f\u0010¯\u0001\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b°\u0001\u0010\u0006\"\u0005\b±\u0001\u0010\bR\"\u0010²\u0001\u001a\u0005\u0018\u00010³\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b´\u0001\u0010µ\u0001\"\u0006\b¶\u0001\u0010·\u0001R\u001f\u0010¸\u0001\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¹\u0001\u0010\u0006\"\u0005\bº\u0001\u0010\bR\u001d\u0010»\u0001\u001a\u00020\u0017X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¼\u0001\u0010&\"\u0005\b½\u0001\u0010(R \u0010¾\u0001\u001a\u0004\u0018\u00010\u001f8FX\u0087\u0004¢\u0006\u000f\u0012\u0005\b¿\u0001\u0010\u0002\u001a\u0006\bÀ\u0001\u0010Á\u0001R\u001d\u0010Â\u0001\u001a\u00020\u0017X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÃ\u0001\u0010&\"\u0005\bÄ\u0001\u0010(R\u001f\u0010Å\u0001\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÆ\u0001\u0010\u0006\"\u0005\bÇ\u0001\u0010\bR\u001d\u0010È\u0001\u001a\u00020\u0017X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÉ\u0001\u0010&\"\u0005\bÊ\u0001\u0010(R$\u0010Ë\u0001\u001a\t\u0012\u0005\u0012\u00030Ì\u00010\u001eX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÍ\u0001\u0010!\"\u0005\bÎ\u0001\u0010#R%\u0010Ï\u0001\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u001eX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÐ\u0001\u0010!\"\u0005\bÑ\u0001\u0010#R)\u0010Ò\u0001\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÓ\u0001\u0010!\"\u0005\bÔ\u0001\u0010#R\u001f\u0010Õ\u0001\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÖ\u0001\u0010\u0006\"\u0005\b×\u0001\u0010\bR\u001d\u0010Ø\u0001\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÙ\u0001\u0010\u0006\"\u0005\bÚ\u0001\u0010\bR\u001d\u0010Û\u0001\u001a\u00020\u0017X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÜ\u0001\u0010&\"\u0005\bÝ\u0001\u0010(R)\u0010Þ\u0001\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bß\u0001\u0010!\"\u0005\bà\u0001\u0010#R\u001d\u0010á\u0001\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bâ\u0001\u0010\u0006\"\u0005\bã\u0001\u0010\bR-\u0010ä\u0001\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0016j\b\u0012\u0004\u0012\u00020\u0004`\u0018X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bå\u0001\u0010\u001a\"\u0005\bæ\u0001\u0010\u001cR\u001f\u0010ç\u0001\u001a\u00020\u00048FX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bè\u0001\u0010\u0006\"\u0005\bé\u0001\u0010\b¨\u0006\u0083\u0002"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/Sticker;", "", "()V", "abGroup", "", "getAbGroup", "()Ljava/lang/String;", "setAbGroup", "(Ljava/lang/String;)V", "aigcEffectInfo", "Lcom/bytedance/android/livesdkapi/depend/model/Sticker$AigcEffectInfo;", "getAigcEffectInfo", "()Lcom/bytedance/android/livesdkapi/depend/model/Sticker$AigcEffectInfo;", "setAigcEffectInfo", "(Lcom/bytedance/android/livesdkapi/depend/model/Sticker$AigcEffectInfo;)V", "allowOtherEffectPreview", "", "getAllowOtherEffectPreview", "()Z", "setAllowOtherEffectPreview", "(Z)V", "coexistGroup", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getCoexistGroup", "()Ljava/util/ArrayList;", "setCoexistGroup", "(Ljava/util/ArrayList;)V", "composerConfigList", "", "Lcom/bytedance/android/livesdkapi/depend/model/Sticker$ComposerConfig;", "getComposerConfigList", "()Ljava/util/List;", "setComposerConfigList", "(Ljava/util/List;)V", "currentValue", "getCurrentValue", "()I", "setCurrentValue", "(I)V", "default", "getDefault", "setDefault", "defaultDuration", "", "getDefaultDuration", "()J", "setDefaultDuration", "(J)V", "designerEncryptedId", "getDesignerEncryptedId", "setDesignerEncryptedId", "designerId", "getDesignerId", "setDesignerId", "disableEffectLink", "getDisableEffectLink", "setDisableEffectLink", "disableEffectPreview", "getDisableEffectPreview", "setDisableEffectPreview", "effect", "Lcom/ss/android/ugc/effectmanager/effect/model/Effect;", "getEffect", "()Lcom/ss/android/ugc/effectmanager/effect/model/Effect;", "setEffect", "(Lcom/ss/android/ugc/effectmanager/effect/model/Effect;)V", "effectExtraTipsInfo", "Lcom/bytedance/android/livesdkapi/depend/model/Sticker$EffectTipsInfo;", "effectId", "getEffectId", "setEffectId", "effectTipsInfo", "enableCustomizeDurationFromExtra", "getEnableCustomizeDurationFromExtra", "setEnableCustomizeDurationFromExtra", "enableCustomizeDurationFromLoki", "getEnableCustomizeDurationFromLoki", "setEnableCustomizeDurationFromLoki", "enableRhythm", "getEnableRhythm", "setEnableRhythm", "extra", "getExtra", "setExtra", "game", "getGame", "setGame", "gameInfo", "Lcom/bytedance/android/livesdkapi/depend/model/Sticker$EffectGameInfo;", "getGameInfo", "()Lcom/bytedance/android/livesdkapi/depend/model/Sticker$EffectGameInfo;", "setGameInfo", "(Lcom/bytedance/android/livesdkapi/depend/model/Sticker$EffectGameInfo;)V", "hasCustomizeDurationConfigFromLoki", "getHasCustomizeDurationConfigFromLoki", "setHasCustomizeDurationConfigFromLoki", "hint", "getHint", "setHint", "icon", "Lcom/bytedance/android/live/base/model/UrlModel;", "getIcon", "()Lcom/bytedance/android/live/base/model/UrlModel;", "setIcon", "(Lcom/bytedance/android/live/base/model/UrlModel;)V", "id", "getId", "setId", "interactRules", "getInteractRules", "setInteractRules", "isBlessing", "setBlessing", "isDoubleHandGesture", "setDoubleHandGesture", "isDownloaded", "setDownloaded", "isDownloading", "setDownloading", "isHighCost", "setHighCost", "isNew", "setNew", "isVideoUsedSticker", "setVideoUsedSticker", "isWithoutFace", "()Ljava/lang/Boolean;", "setWithoutFace", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "layerMap", "getLayerMap", "setLayerMap", "mvBindStickerInfo", "Lcom/bytedance/android/livesdkapi/depend/model/MVBindStickerInfo;", "getMvBindStickerInfo", "()Lcom/bytedance/android/livesdkapi/depend/model/MVBindStickerInfo;", "setMvBindStickerInfo", "(Lcom/bytedance/android/livesdkapi/depend/model/MVBindStickerInfo;)V", "name", "getName", "setName", "noCameraRender", "getNoCameraRender", "setNoCameraRender", "panelExtra", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getPanelExtra", "()Ljava/util/HashMap;", "setPanelExtra", "(Ljava/util/HashMap;)V", "parentResId", "getParentResId", "setParentResId", "realId", "getRealId", "setRealId", "replaceBeauty", "getReplaceBeauty", "setReplaceBeauty", "resourceId", "getResourceId", "setResourceId", "reviewOriginalFrame", "getReviewOriginalFrame", "setReviewOriginalFrame", "rhythmParam", "Lorg/json/JSONObject;", "getRhythmParam", "()Lorg/json/JSONObject;", "setRhythmParam", "(Lorg/json/JSONObject;)V", "sdkExtra", "getSdkExtra", "setSdkExtra", "sdkExtraModel", "Lcom/bytedance/android/livesdkapi/depend/model/Sticker$StickerSDKExtra;", "getSdkExtraModel", "()Lcom/bytedance/android/livesdkapi/depend/model/Sticker$StickerSDKExtra;", "setSdkExtraModel", "(Lcom/bytedance/android/livesdkapi/depend/model/Sticker$StickerSDKExtra;)V", "searchId", "getSearchId", "setSearchId", "searchResultType", "getSearchResultType", "setSearchResultType", "smallItemConfig", "getSmallItemConfig$annotations", "getSmallItemConfig", "()Lcom/bytedance/android/livesdkapi/depend/model/Sticker$ComposerConfig;", "stickerFeature", "getStickerFeature", "setStickerFeature", "stickerPanel", "getStickerPanel", "setStickerPanel", "styleType", "getStyleType", "setStyleType", "subItemStickerList", "Lcom/bytedance/android/livesdkapi/depend/model/LocalSubStickerItem;", "getSubItemStickerList", "setSubItemStickerList", "subStickers", "getSubStickers", "setSubStickers", PromotionProductPrivilegesStruct.TAGS, "getTags", "setTags", "tagsUpdatedAt", "getTagsUpdatedAt", "setTagsUpdatedAt", "topTips", "getTopTips", "setTopTips", "transferType", "getTransferType", "setTransferType", "types", "getTypes", "setTypes", "unzipPath", "getUnzipPath", "setUnzipPath", "updateKeys", "getUpdateKeys", "setUpdateKeys", "videoTag", "getVideoTag", "setVideoTag", "enableCustomizeDuration", "equals", "other", "getEffectTipsInfo", "getStickerType", "Lcom/bytedance/android/livesdkapi/depend/model/StickerType;", "hashCode", "isAigcSticker", "isInteractSticker", "isMVSticker", "isSubItem", "setEffectExtraTipsInfo", "", "tipInfo", "setEffectTipsInfo", "toString", "AigcEffectInfo", "AigcKeywordInfo", "Companion", "ComposerConfig", "EffectGameInfo", "EffectSubTipInfo", "EffectTipsInfo", "FilterConfig", "StickerSDKExtra", "liveeffect-middleware-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class Sticker {
    public static final String CARNIVAL_INTERACT_EFFECT_TAG = "carnival_interact_effect";
    public static final Companion Companion = null;
    public static final String ID_NO_STICKER = "";
    public static final String PIXEL_LOOP_STICKER = "background_photo_for_live";
    public static final int STICKER_FEATURE_BEAUTY = 4;
    public static final int STICKER_FEATURE_BODY_BEAUTY = 16;
    public static final int STICKER_FEATURE_CAMERA_MOVEMENT = 128;
    public static final int STICKER_FEATURE_FILTER = 1;
    public static final int STICKER_FEATURE_GESTURE = 8;
    public static final int STICKER_FEATURE_MAKEUPS = 2;
    public static final String STICKER_FILTER_TAG_PREVIEW = "filtered_by_preview_live";
    public static final String STICKER_FILTER_TAG_ROOM = "filtered_by_room_live";
    public static final int STICKER_TRANSFER_TYPE = 2;
    public static final String STICKER_TYPE_KEY = "effect_type";
    public static final String TEA_LOG_KEY = "tea_log";
    private String abGroup;
    private AigcEffectInfo aigcEffectInfo;
    private boolean allowOtherEffectPreview;
    private ArrayList<Integer> coexistGroup;
    private List<ComposerConfig> composerConfigList;
    private int currentValue;

    /* JADX INFO: renamed from: default, reason: not valid java name */
    private boolean f90default;
    private long defaultDuration;
    private String designerEncryptedId;
    private String designerId;
    private boolean disableEffectLink;
    private int disableEffectPreview;
    private Effect effect;
    private EffectTipsInfo effectExtraTipsInfo;
    private String effectId;
    private EffectTipsInfo effectTipsInfo;
    private boolean enableCustomizeDurationFromExtra;
    private boolean enableCustomizeDurationFromLoki;
    private boolean enableRhythm;

    @SerializedName("extra")
    private String extra;
    private boolean game;
    private EffectGameInfo gameInfo;
    private boolean hasCustomizeDurationConfigFromLoki;
    private String hint;

    @SerializedName("icon_url")
    private UrlModel icon;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private long f162575id;
    private String interactRules;
    private boolean isBlessing;
    private boolean isDoubleHandGesture;
    private boolean isDownloaded;
    private boolean isDownloading;
    private boolean isHighCost;
    private boolean isNew;
    private boolean isVideoUsedSticker;
    private Boolean isWithoutFace;
    private String layerMap;
    private MVBindStickerInfo mvBindStickerInfo;

    @SerializedName("name")
    private String name;
    private boolean noCameraRender;
    private HashMap<String, String> panelExtra;
    private String parentResId;
    private String realId;
    private String replaceBeauty;
    private String resourceId;
    private boolean reviewOriginalFrame;
    private JSONObject rhythmParam;
    private String sdkExtra;
    private StickerSDKExtra sdkExtraModel;
    private String searchId;
    private int searchResultType;
    private int stickerFeature;
    private String stickerPanel;
    private int styleType;
    private List<LocalSubStickerItem> subItemStickerList;
    private List<Sticker> subStickers;

    @SerializedName(PromotionProductPrivilegesStruct.TAGS)
    private List<String> tags;
    private String tagsUpdatedAt;
    private String topTips;
    private int transferType;

    @SerializedName("types")
    private List<String> types;
    private String unzipPath;
    private ArrayList<String> updateKeys;
    private String videoTag;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\nR\u001c\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R'\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00050\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\n0\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0007¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/Sticker$AigcEffectInfo;", "", "()V", "keywordInfoList", "", "Lcom/bytedance/android/livesdkapi/depend/model/Sticker$AigcKeywordInfo;", "getKeywordInfoList", "()Ljava/util/List;", "keywordInfoMap", "", "", "getKeywordInfoMap", "()Ljava/util/Map;", "keywordInfoMap$delegate", "Lkotlin/Lazy;", "keywordPosition", "", "getKeywordPosition", "()I", "setKeywordPosition", "(I)V", "modelReqKey", "getModelReqKey", "()Ljava/lang/String;", "setModelReqKey", "(Ljava/lang/String;)V", "promptList", "getPromptList", "getModelPrompt", "showKeyword", "liveeffect-middleware-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class AigcEffectInfo {

        @SerializedName("aigc_keyword_info_list")
        private final List<AigcKeywordInfo> keywordInfoList;
        private final Lazy keywordInfoMap$delegate;

        @SerializedName("aigc_keyword_position")
        private int keywordPosition;

        @SerializedName("aigc_model_req_key")
        private String modelReqKey;

        @SerializedName("aigc_prompt_list")
        private final List<String> promptList;

        public final Map<String, AigcKeywordInfo> getKeywordInfoMap() {
            return (Map) this.keywordInfoMap$delegate.getValue();
        }

        public AigcEffectInfo() {
            this.modelReqKey = "";
            this.promptList = CollectionsKt.emptyList();
            this.keywordInfoList = CollectionsKt.emptyList();
            this.keywordInfoMap$delegate = LazyKt.lazy(new Sticker$AigcEffectInfo$keywordInfoMap$2(this));
        }

        public final List<AigcKeywordInfo> getKeywordInfoList() {
            return this.keywordInfoList;
        }

        public final int getKeywordPosition() {
            return this.keywordPosition;
        }

        public final String getModelReqKey() {
            return this.modelReqKey;
        }

        public final List<String> getPromptList() {
            return this.promptList;
        }

        public final String getModelPrompt(String r100) {
            Intrinsics.checkNotNullParameter(r100, "showKeyword");
            ArrayList r101 = new ArrayList();
            r101.addAll(this.promptList);
            int r102 = 0;
            if (this.keywordPosition >= r101.size()) goto L6;
            int r103 = this.keywordPosition;
            if (r103 < 0) goto L6;
        L7:
            this.keywordPosition = r103;
            AigcKeywordInfo r104 = getKeywordInfoMap().get(r100);
            if (r104 == null) goto L13;
            String r105 = r104.getRealKeyword();
            if (r105 == null) goto L13;
            r100 = r105;
        L13:
            ListProtector.add(r101, r103, r100);
            StringBuilder r106 = new StringBuilder();
            Iterator r107 = r101.iterator();
        L15:
            if (r107.hasNext() == false) goto L22;
            String r108 = (String) r107.next();
            if (r102 <= 0) goto L19;
            r106.append("," + r108);
        L20:
            r102 = r102 + 1;
            goto L15
        L19:
            r106.append(r108);
            goto L20
        L22:
            return r106.toString();
        L6:
            r103 = 0;
            goto L7
        }

        public final void setKeywordPosition(int r100) {
            this.keywordPosition = r100;
        }

        public final void setModelReqKey(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.modelReqKey = r100;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\r\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R$\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/Sticker$AigcKeywordInfo;", "", "()V", "defaultUrlList", "", "", "getDefaultUrlList", "()Ljava/util/List;", "setDefaultUrlList", "(Ljava/util/List;)V", "realKeyword", "getRealKeyword", "()Ljava/lang/String;", "setRealKeyword", "(Ljava/lang/String;)V", "showKeyword", "getShowKeyword", "setShowKeyword", "liveeffect-middleware-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class AigcKeywordInfo {

        @SerializedName("default_image_url_list")
        private List<String> defaultUrlList;

        @SerializedName("real_keyword")
        private String realKeyword;

        @SerializedName("show_keyword")
        private String showKeyword;

        public AigcKeywordInfo() {
            this.showKeyword = "";
            this.realKeyword = "";
            this.defaultUrlList = CollectionsKt.emptyList();
        }

        public final List<String> getDefaultUrlList() {
            return this.defaultUrlList;
        }

        public final String getRealKeyword() {
            return this.realKeyword;
        }

        public final String getShowKeyword() {
            return this.showKeyword;
        }

        public final void setDefaultUrlList(List<String> r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.defaultUrlList = r100;
        }

        public final void setRealKeyword(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.realKeyword = r100;
        }

        public final void setShowKeyword(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.showKeyword = r100;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/Sticker$Companion;", "", "()V", "CARNIVAL_INTERACT_EFFECT_TAG", "", "ID_NO_STICKER", "PIXEL_LOOP_STICKER", "STICKER_FEATURE_BEAUTY", "", "STICKER_FEATURE_BODY_BEAUTY", "STICKER_FEATURE_CAMERA_MOVEMENT", "STICKER_FEATURE_FILTER", "STICKER_FEATURE_GESTURE", "STICKER_FEATURE_MAKEUPS", "STICKER_FILTER_TAG_PREVIEW", "STICKER_FILTER_TAG_ROOM", "STICKER_TRANSFER_TYPE", "STICKER_TYPE_KEY", "TEA_LOG_KEY", "equals", "", "sticker", "Lcom/bytedance/android/livesdkapi/depend/model/Sticker;", "sticker1", "liveeffect-middleware-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        @JvmStatic
        public final boolean equals(Sticker r100, Sticker r101) {
            if (r100 == null) goto L10;
            if (r101 != null) goto L7;
            return false;
        L7:
            if (r101.getId() != r100.getId()) goto L11;
            return true;
        L11:
            return false;
        L10:
            return false;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0013\u0018\u00002\u00020\u0001B'\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\bR\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0007\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\n\"\u0004\b\u0014\u0010\fR\u001e\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\n\"\u0004\b\u0016\u0010\fR\u001e\u0010\u0017\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0019\"\u0004\b\u001d\u0010\u001bR\u001e\u0010\u001e\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0019\"\u0004\b \u0010\u001b¨\u0006!"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/Sticker$ComposerConfig;", "", "tag", "", "defaultValue", "", "minValue", "maxValue", "(Ljava/lang/String;III)V", "getDefaultValue", "()I", "setDefaultValue", "(I)V", "doubleDirection", "", "getDoubleDirection", "()Z", "setDoubleDirection", "(Z)V", "getMaxValue", "setMaxValue", "getMinValue", "setMinValue", "name", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getTag", "setTag", "type", "getType", "setType", "liveeffect-middleware-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ComposerConfig {

        @SerializedName("value")
        private int defaultValue;

        @SerializedName("doubleDirection")
        private boolean doubleDirection;

        @SerializedName(BitableFieldEditAnalytic.ProgressFieldEditScene.MAX)
        private int maxValue;

        @SerializedName(BitableFieldEditAnalytic.ProgressFieldEditScene.MIN)
        private int minValue;

        @SerializedName("name")
        private String name;

        @SerializedName("tag")
        private String tag;

        @SerializedName("type")
        private String type;

        public final int getDefaultValue() {
            return this.defaultValue;
        }

        public final boolean getDoubleDirection() {
            return this.doubleDirection;
        }

        public final int getMaxValue() {
            return this.maxValue;
        }

        public final int getMinValue() {
            return this.minValue;
        }

        public final String getName() {
            return this.name;
        }

        public final String getTag() {
            return this.tag;
        }

        public final String getType() {
            return this.type;
        }

        public final void setDefaultValue(int r100) {
            this.defaultValue = r100;
        }

        public final void setDoubleDirection(boolean r100) {
            this.doubleDirection = r100;
        }

        public final void setMaxValue(int r100) {
            this.maxValue = r100;
        }

        public final void setMinValue(int r100) {
            this.minValue = r100;
        }

        public final void setName(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.name = r100;
        }

        public final void setTag(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.tag = r100;
        }

        public final void setType(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.type = r100;
        }

        public ComposerConfig(String r100, int r101, int r102, int r103) {
            Intrinsics.checkNotNullParameter(r100, "tag");
            this.name = "";
            this.type = "";
            this.tag = r100;
            this.defaultValue = r101;
            this.minValue = r102;
            this.maxValue = r103;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010'\u001a\u00020\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR\u001a\u0010\u001e\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0018\"\u0004\b \u0010\u001aR\u001a\u0010!\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0018\"\u0004\b#\u0010\u001aR\u001a\u0010$\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u000f\"\u0004\b&\u0010\u0011¨\u0006("}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/Sticker$EffectGameInfo;", "", "()V", "guide_name", "", "getGuide_name", "()Ljava/lang/String;", "setGuide_name", "(Ljava/lang/String;)V", "guide_res_path", "getGuide_res_path", "setGuide_res_path", "guide_show_count", "", "getGuide_show_count", "()I", "setGuide_show_count", "(I)V", "guide_url", "getGuide_url", "setGuide_url", "loadgame_when_guide", "", "getLoadgame_when_guide", "()Z", "setLoadgame_when_guide", "(Z)V", "need_beat", "getNeed_beat", "setNeed_beat", "need_bgmusic", "getNeed_bgmusic", "setNeed_bgmusic", "support_effect_mix_stream", "getSupport_effect_mix_stream", "setSupport_effect_mix_stream", "support_mode", "getSupport_mode", "setSupport_mode", "isGuideDownloaded", "liveeffect-middleware-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class EffectGameInfo {
        private String guide_name;
        private String guide_res_path;
        private int guide_show_count;
        private String guide_url;
        private boolean loadgame_when_guide;
        private boolean need_beat;
        private boolean need_bgmusic;
        private boolean support_effect_mix_stream;
        private int support_mode;

        public final boolean isGuideDownloaded() {
            String r100 = this.guide_url;
            if (r100 != null) goto L5;
        L8:
            boolean r101 = true;
        L9:
            if (r101 == true) goto L20;
            String r102 = this.guide_res_path;
            if (r102 != null) goto L13;
        L16:
            boolean r103 = true;
        L17:
            if (r103 == false) goto L19;
            return false;
        L19:
            if (new PolarisFileWrapper(this.guide_res_path).exists() == true) goto L20;
            return false;
        L13:
            if (StringsKt.isBlank(r102) == true) goto L16;
            r103 = false;
        L20:
            return true;
        L5:
            if (StringsKt.isBlank(r100) == true) goto L8;
            r101 = false;
            goto L9
        }

        public EffectGameInfo() {
            this.guide_url = "";
            this.guide_name = "";
            this.guide_res_path = "";
        }

        public final String getGuide_name() {
            return this.guide_name;
        }

        public final String getGuide_res_path() {
            return this.guide_res_path;
        }

        public final int getGuide_show_count() {
            return this.guide_show_count;
        }

        public final String getGuide_url() {
            return this.guide_url;
        }

        public final boolean getLoadgame_when_guide() {
            return this.loadgame_when_guide;
        }

        public final boolean getNeed_beat() {
            return this.need_beat;
        }

        public final boolean getNeed_bgmusic() {
            return this.need_bgmusic;
        }

        public final boolean getSupport_effect_mix_stream() {
            return this.support_effect_mix_stream;
        }

        public final int getSupport_mode() {
            return this.support_mode;
        }

        public final void setGuide_name(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.guide_name = r100;
        }

        public final void setGuide_res_path(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.guide_res_path = r100;
        }

        public final void setGuide_show_count(int r100) {
            this.guide_show_count = r100;
        }

        public final void setGuide_url(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.guide_url = r100;
        }

        public final void setLoadgame_when_guide(boolean r100) {
            this.loadgame_when_guide = r100;
        }

        public final void setNeed_beat(boolean r100) {
            this.need_beat = r100;
        }

        public final void setNeed_bgmusic(boolean r100) {
            this.need_bgmusic = r100;
        }

        public final void setSupport_effect_mix_stream(boolean r100) {
            this.support_effect_mix_stream = r100;
        }

        public final void setSupport_mode(int r100) {
            this.support_mode = r100;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/Sticker$EffectSubTipInfo;", "", AppConstants.BUNDLE_TIP, "", "tipImageUrl", "(Ljava/lang/String;Ljava/lang/String;)V", "getTip", "()Ljava/lang/String;", "setTip", "(Ljava/lang/String;)V", "getTipImageUrl", "setTipImageUrl", "liveeffect-middleware-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class EffectSubTipInfo {

        @SerializedName("sub_tip")
        private String tip;

        @SerializedName("sub_tip_image_url")
        private String tipImageUrl;

        /* JADX WARN: Multi-variable type inference failed */
        public EffectSubTipInfo() {
            Object[] r100 = 0 == true ? 1 : 0;
            this(null, r100, 3, 0 == true ? 1 : 0);
        }

        public final String getTip() {
            return this.tip;
        }

        public final String getTipImageUrl() {
            return this.tipImageUrl;
        }

        public final void setTip(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.tip = r100;
        }

        public final void setTipImageUrl(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.tipImageUrl = r100;
        }

        public EffectSubTipInfo(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, AppConstants.BUNDLE_TIP);
            Intrinsics.checkNotNullParameter(r101, "tipImageUrl");
            this.tip = r100;
            this.tipImageUrl = r101;
        }

        public /* synthetic */ EffectSubTipInfo(String r100, String r101, int r102, DefaultConstructorMarker r103) {
            if ((r102 & 1) == 0) goto L6;
            r100 = "";
        L6:
            if ((r102 & 2) == 0) goto L8;
            r101 = "";
        L8:
            this(r100, r101);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B=\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\nR\u001e\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001e\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\f\"\u0004\b\u0016\u0010\u000e¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/Sticker$EffectTipsInfo;", "", "tipText", "", "tipIcon", "tipTitle", "jumpUrl", "subTipList", "", "Lcom/bytedance/android/livesdkapi/depend/model/Sticker$EffectSubTipInfo;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getJumpUrl", "()Ljava/lang/String;", "setJumpUrl", "(Ljava/lang/String;)V", "getSubTipList", "()Ljava/util/List;", "getTipIcon", "setTipIcon", "getTipText", "setTipText", "getTipTitle", "setTipTitle", "liveeffect-middleware-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class EffectTipsInfo {

        @SerializedName("jump_url")
        private String jumpUrl;

        @SerializedName("sub_tip_list")
        private final List<EffectSubTipInfo> subTipList;

        @SerializedName("tip_icon_url")
        private String tipIcon;

        @SerializedName("tip_text")
        private String tipText;

        @SerializedName("tip_title")
        private String tipTitle;

        public EffectTipsInfo() {
            this(null, null, null, null, null, 31, null);
        }

        public final String getJumpUrl() {
            return this.jumpUrl;
        }

        public final List<EffectSubTipInfo> getSubTipList() {
            return this.subTipList;
        }

        public final String getTipIcon() {
            return this.tipIcon;
        }

        public final String getTipText() {
            return this.tipText;
        }

        public final String getTipTitle() {
            return this.tipTitle;
        }

        public final void setJumpUrl(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.jumpUrl = r100;
        }

        public final void setTipIcon(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.tipIcon = r100;
        }

        public final void setTipText(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.tipText = r100;
        }

        public final void setTipTitle(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.tipTitle = r100;
        }

        public EffectTipsInfo(String r100, String r101, String r102, String r103, List<EffectSubTipInfo> r104) {
            Intrinsics.checkNotNullParameter(r100, "tipText");
            Intrinsics.checkNotNullParameter(r101, "tipIcon");
            Intrinsics.checkNotNullParameter(r102, "tipTitle");
            Intrinsics.checkNotNullParameter(r103, "jumpUrl");
            Intrinsics.checkNotNullParameter(r104, "subTipList");
            this.tipText = r100;
            this.tipIcon = r101;
            this.tipTitle = r102;
            this.jumpUrl = r103;
            this.subTipList = r104;
        }

        public /* synthetic */ EffectTipsInfo(String r100, String r101, String r102, String r103, List r104, int r105, DefaultConstructorMarker r110) {
            String r106 = "";
            if ((r105 & 1) == 0) goto L5;
            String r111 = "";
        L7:
            if ((r105 & 2) == 0) goto L9;
            String r107 = "";
        L11:
            if ((r105 & 4) == 0) goto L13;
            String r108 = "";
        L15:
            if ((r105 & 8) != 0) goto L19;
            r106 = r103;
        L19:
            if ((r105 & 16) == 0) goto L21;
            r104 = CollectionsKt.emptyList();
        L21:
            List r109 = r104;
            this(r111, r107, r108, r106, r109);
            return;
        L13:
            r108 = r102;
            goto L15
        L9:
            r107 = r101;
            goto L11
        L5:
            r111 = r100;
            goto L7
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0016\u0010\t\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/Sticker$FilterConfig;", "", "()V", "defaultLevel", "", "getDefaultLevel", "()I", "maxLevel", "getMaxLevel", "minLevel", "getMinLevel", "liveeffect-middleware-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class FilterConfig {

        @SerializedName("value")
        private final int defaultLevel;

        @SerializedName(BitableFieldEditAnalytic.ProgressFieldEditScene.MAX)
        private final int maxLevel;

        @SerializedName(BitableFieldEditAnalytic.ProgressFieldEditScene.MIN)
        private final int minLevel;

        public FilterConfig() {
        }

        public final int getDefaultLevel() {
            return this.defaultLevel;
        }

        public final int getMaxLevel() {
            return this.maxLevel;
        }

        public final int getMinLevel() {
            return this.minLevel;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/Sticker$StickerSDKExtra;", "", "()V", "isAudioEffect", "", "()Z", "setAudioEffect", "(Z)V", "liveeffect-middleware-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class StickerSDKExtra {

        @SerializedName("audio_effect")
        private boolean isAudioEffect;

        public StickerSDKExtra() {
        }

        public final boolean isAudioEffect() {
            return this.isAudioEffect;
        }

        public final void setAudioEffect(boolean r100) {
            this.isAudioEffect = r100;
        }
    }

    static {
        Companion = new Companion(null);
    }

    @JvmStatic
    public static final boolean equals(Sticker r100, Sticker r101) {
        return Companion.equals(r100, r101);
    }

    @Deprecated(message = "", replaceWith = @ReplaceWith(expression = "composerConfigList.firstOrNull()", imports = {}))
    public static /* synthetic */ void getSmallItemConfig$annotations() {
    }

    public final boolean getAllowOtherEffectPreview() {
        String r100 = this.sdkExtra;     // Catch: Exception -> L9
        if (r100 == null) goto L12;
        JsonElement r101 = new JsonParser().parse(r100).getAsJsonObject().get("allow_other_effect_preview");     // Catch: Exception -> L9
        if (r101 == null) goto L13;
        return r101.getAsBoolean();
    L13:
        return true;
    L12:
        return true;
    L14:
        return true;
    }

    public final boolean getDefault() {
    L9:
        e = move-exception;
        e.printStackTrace();
    L11:
        return false;
    L4:
        if (this.extra == null) goto L11;
        JsonElement r100 = new JsonParser().parse(this.extra).getAsJsonObject().get("default");     // Catch: Exception -> L9
        if (r100 == null) goto L14;
        return r100.getAsBoolean();
    L14:
        return false;
    }

    public final boolean getNoCameraRender() {
        String r100 = this.sdkExtra;     // Catch: Exception -> L9
        if (r100 == null) goto L12;
        JsonElement r101 = new JsonParser().parse(r100).getAsJsonObject().get("no_camera_render");     // Catch: Exception -> L9
        if (r101 == null) goto L13;
        return r101.getAsBoolean();
    L13:
        return false;
    L12:
        return false;
    L14:
        return false;
    }

    public final boolean enableCustomizeDuration() {
        if (this.hasCustomizeDurationConfigFromLoki == false) goto L7;
        return this.enableCustomizeDurationFromLoki;
    L7:
        return this.enableCustomizeDurationFromExtra;
    }

    public final String getAbGroup() {
        String r100 = this.extra;     // Catch: Exception -> L12
        if (r100 == null) goto L15;
        JsonElement r101 = new JsonParser().parse(r100).getAsJsonObject().get("ab_group");     // Catch: Exception -> L12
        if (r101 == null) goto L16;
        String r102 = r101.getAsString();     // Catch: Exception -> L12
        if (r102 != null) goto L11;
        return "";
    L11:
        return r102;
    L16:
        return "";
    L15:
        return "";
    L18:
        return "";
    }

    public final String getEffectId() {
        if (StringUtils.isEmpty(this.effectId) == false) goto L6;
        return this.unzipPath;
    L6:
        return this.effectId;
    }

    public final EffectTipsInfo getEffectTipsInfo() {
        EffectTipsInfo r100 = this.effectExtraTipsInfo;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return this.effectTipsInfo;
    }

    public final boolean getEnableRhythm() {
        String r100 = this.sdkExtra;
        if (r100 != null) goto L11;
    L9:
        return false;
    L11:
        JSONObject r101 = new JSONObject(r100).optJSONObject("lensRequirement");     // Catch: JSONException -> L10
        if (r101 != null) goto L7;
        return false;
    L7:
        return r101.optBoolean("rhythmicMotion");
    }

    public final JSONObject getRhythmParam() {
        String r100 = this.sdkExtra;
        if (r100 != null) goto L11;
    L9:
        return null;
    L11:
        JSONObject r101 = new JSONObject(r100).optJSONObject("lensRequirement");     // Catch: JSONException -> L10
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.optJSONObject("rhythmicMotionParam");
    }

    public final ComposerConfig getSmallItemConfig() {
        return (ComposerConfig) CollectionsKt.firstOrNull(this.composerConfigList);
    }

    public final String getVideoTag() {
        String r100 = "";
        if (TextUtils.isEmpty(this.videoTag) == false) goto L24;
        String r101 = this.videoTag;
    L12:
        e = move-exception;
        e.printStackTrace();
    L15:
        if (TextUtils.isEmpty(r101) == false) goto L27;
        ComposerConfig r102 = getSmallItemConfig();
        if (r102 == null) goto L28;
        String r103 = r102.getTag();
        if (r103 == null) goto L28;
        r100 = r103;
    L28:
        return r100;
    L27:
        return r101;
    L6:
        if (this.extra == null) goto L15;
        JsonElement r104 = new JsonParser().parse(this.extra).getAsJsonObject().get("video_tag");     // Catch: Exception -> L12
        if (r104 == null) goto L11;
        r101 = r104.getAsString();     // Catch: Exception -> L12
        if (r101 != null) goto L15;
    L11:
        r101 = "";
        goto L15
    L24:
        return this.videoTag;
    }

    public int hashCode() {
        long r100 = this.f162575id;
        return (int) (r100 ^ (r100 >>> 32));
    }

    public final boolean isAigcSticker() {
        return !this.aigcEffectInfo.getKeywordInfoList().isEmpty();
    }

    public final boolean isInteractSticker() {
        if (this.interactRules.length() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isMVSticker() {
        MVBindStickerInfo r100 = this.mvBindStickerInfo;
        if (r100 == null) goto L5;
        String r101 = r100.getResourceID();
    L7:
        if (r101 != null) goto L9;
    L12:
        boolean r102 = true;
    L14:
        return !r102;
    L9:
        if (r101.length() == 0) goto L12;
        r102 = false;
        goto L14
    L5:
        r101 = null;
        goto L7
    }

    public final boolean isSubItem() {
        if (this.parentResId == null) goto L5;
        return true;
    L5:
        return false;
    }

    public String toString() {
        return "Sticker(effectId=" + getEffectId() + ", abGroup=" + getAbGroup() + ')';
    }

    public Sticker() {
        this.realId = "";
        this.resourceId = "";
        this.effectId = "";
        this.unzipPath = "";
        this.composerConfigList = new ArrayList();
        this.subItemStickerList = new ArrayList();
        this.updateKeys = new ArrayList();
        this.coexistGroup = new ArrayList();
        this.videoTag = "";
        this.abGroup = "";
        this.gameInfo = new EffectGameInfo();
        this.allowOtherEffectPreview = true;
        this.searchResultType = -1;
        this.topTips = "";
        this.aigcEffectInfo = new AigcEffectInfo();
        this.interactRules = "";
        this.enableCustomizeDurationFromExtra = true;
        this.enableCustomizeDurationFromLoki = true;
        this.defaultDuration = RetryPolicy.DEFAULT_RETRY_TIMEOUT_IN_MILLIS;
        this.layerMap = "";
    }

    public final StickerType getStickerType() {
        if (isAigcSticker() == false) goto L6;
        return StickerType.Aigc;
    L6:
        if (isInteractSticker() == false) goto L9;
        return StickerType.Interact;
    L9:
        return StickerType.Normal;
    }

    public final AigcEffectInfo getAigcEffectInfo() {
        return this.aigcEffectInfo;
    }

    public final ArrayList<Integer> getCoexistGroup() {
        return this.coexistGroup;
    }

    public final List<ComposerConfig> getComposerConfigList() {
        return this.composerConfigList;
    }

    public final int getCurrentValue() {
        return this.currentValue;
    }

    public final long getDefaultDuration() {
        return this.defaultDuration;
    }

    public final String getDesignerEncryptedId() {
        return this.designerEncryptedId;
    }

    public final String getDesignerId() {
        return this.designerId;
    }

    public final boolean getDisableEffectLink() {
        return this.disableEffectLink;
    }

    public final int getDisableEffectPreview() {
        return this.disableEffectPreview;
    }

    public final Effect getEffect() {
        return this.effect;
    }

    public final boolean getEnableCustomizeDurationFromExtra() {
        return this.enableCustomizeDurationFromExtra;
    }

    public final boolean getEnableCustomizeDurationFromLoki() {
        return this.enableCustomizeDurationFromLoki;
    }

    public final String getExtra() {
        return this.extra;
    }

    public final boolean getGame() {
        return this.game;
    }

    public final EffectGameInfo getGameInfo() {
        return this.gameInfo;
    }

    public final boolean getHasCustomizeDurationConfigFromLoki() {
        return this.hasCustomizeDurationConfigFromLoki;
    }

    public final String getHint() {
        return this.hint;
    }

    public final UrlModel getIcon() {
        return this.icon;
    }

    public final long getId() {
        return this.f162575id;
    }

    public final String getInteractRules() {
        return this.interactRules;
    }

    public final String getLayerMap() {
        return this.layerMap;
    }

    public final MVBindStickerInfo getMvBindStickerInfo() {
        return this.mvBindStickerInfo;
    }

    public final String getName() {
        return this.name;
    }

    public final HashMap<String, String> getPanelExtra() {
        return this.panelExtra;
    }

    public final String getParentResId() {
        return this.parentResId;
    }

    public final String getRealId() {
        return this.realId;
    }

    public final String getReplaceBeauty() {
        return this.replaceBeauty;
    }

    public final String getResourceId() {
        return this.resourceId;
    }

    public final boolean getReviewOriginalFrame() {
        return this.reviewOriginalFrame;
    }

    public final String getSdkExtra() {
        return this.sdkExtra;
    }

    public final StickerSDKExtra getSdkExtraModel() {
        return this.sdkExtraModel;
    }

    public final String getSearchId() {
        return this.searchId;
    }

    public final int getSearchResultType() {
        return this.searchResultType;
    }

    public final int getStickerFeature() {
        return this.stickerFeature;
    }

    public final String getStickerPanel() {
        return this.stickerPanel;
    }

    public final int getStyleType() {
        return this.styleType;
    }

    public final List<LocalSubStickerItem> getSubItemStickerList() {
        return this.subItemStickerList;
    }

    public final List<Sticker> getSubStickers() {
        return this.subStickers;
    }

    public final List<String> getTags() {
        return this.tags;
    }

    public final String getTagsUpdatedAt() {
        return this.tagsUpdatedAt;
    }

    public final String getTopTips() {
        return this.topTips;
    }

    public final int getTransferType() {
        return this.transferType;
    }

    public final List<String> getTypes() {
        return this.types;
    }

    public final String getUnzipPath() {
        return this.unzipPath;
    }

    public final ArrayList<String> getUpdateKeys() {
        return this.updateKeys;
    }

    public final boolean isBlessing() {
        return this.isBlessing;
    }

    public final boolean isDoubleHandGesture() {
        return this.isDoubleHandGesture;
    }

    public final boolean isDownloaded() {
        return this.isDownloaded;
    }

    public final boolean isDownloading() {
        return this.isDownloading;
    }

    public final boolean isHighCost() {
        return this.isHighCost;
    }

    public final boolean isNew() {
        return this.isNew;
    }

    public final boolean isVideoUsedSticker() {
        return this.isVideoUsedSticker;
    }

    public final Boolean isWithoutFace() {
        return this.isWithoutFace;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if ((!Intrinsics.areEqual(Sticker.class, r101)) == false) goto L12;
        return false;
    L12:
        if (r100 == null) goto L18;
        if (this.f162575id == ((Sticker) r100).f162575id) goto L16;
        return false;
    L16:
        return true;
    L18:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdkapi.depend.model.Sticker");
    L8:
        r101 = null;
        goto L10
    }

    public final void setAbGroup(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.abGroup = r100;
    }

    public final void setAigcEffectInfo(AigcEffectInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.aigcEffectInfo = r100;
    }

    public final void setAllowOtherEffectPreview(boolean r100) {
        this.allowOtherEffectPreview = r100;
    }

    public final void setBlessing(boolean r100) {
        this.isBlessing = r100;
    }

    public final void setCoexistGroup(ArrayList<Integer> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.coexistGroup = r100;
    }

    public final void setComposerConfigList(List<ComposerConfig> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.composerConfigList = r100;
    }

    public final void setCurrentValue(int r100) {
        this.currentValue = r100;
    }

    public final void setDefault(boolean r100) {
        this.f90default = r100;
    }

    public final void setDefaultDuration(long r100) {
        this.defaultDuration = r100;
    }

    public final void setDesignerEncryptedId(String r100) {
        this.designerEncryptedId = r100;
    }

    public final void setDesignerId(String r100) {
        this.designerId = r100;
    }

    public final void setDisableEffectLink(boolean r100) {
        this.disableEffectLink = r100;
    }

    public final void setDisableEffectPreview(int r100) {
        this.disableEffectPreview = r100;
    }

    public final void setDoubleHandGesture(boolean r100) {
        this.isDoubleHandGesture = r100;
    }

    public final void setDownloaded(boolean r100) {
        this.isDownloaded = r100;
    }

    public final void setDownloading(boolean r100) {
        this.isDownloading = r100;
    }

    public final void setEffect(Effect r100) {
        this.effect = r100;
    }

    public final void setEffectExtraTipsInfo(EffectTipsInfo r100) {
        this.effectExtraTipsInfo = r100;
    }

    public final void setEffectId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.effectId = r100;
    }

    public final void setEffectTipsInfo(EffectTipsInfo r100) {
        this.effectTipsInfo = r100;
    }

    public final void setEnableCustomizeDurationFromExtra(boolean r100) {
        this.enableCustomizeDurationFromExtra = r100;
    }

    public final void setEnableCustomizeDurationFromLoki(boolean r100) {
        this.enableCustomizeDurationFromLoki = r100;
    }

    public final void setEnableRhythm(boolean r100) {
        this.enableRhythm = r100;
    }

    public final void setExtra(String r100) {
        this.extra = r100;
    }

    public final void setGame(boolean r100) {
        this.game = r100;
    }

    public final void setGameInfo(EffectGameInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.gameInfo = r100;
    }

    public final void setHasCustomizeDurationConfigFromLoki(boolean r100) {
        this.hasCustomizeDurationConfigFromLoki = r100;
    }

    public final void setHighCost(boolean r100) {
        this.isHighCost = r100;
    }

    public final void setHint(String r100) {
        this.hint = r100;
    }

    public final void setIcon(UrlModel r100) {
        this.icon = r100;
    }

    public final void setId(long r100) {
        this.f162575id = r100;
    }

    public final void setInteractRules(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.interactRules = r100;
    }

    public final void setLayerMap(String r100) {
        this.layerMap = r100;
    }

    public final void setMvBindStickerInfo(MVBindStickerInfo r100) {
        this.mvBindStickerInfo = r100;
    }

    public final void setName(String r100) {
        this.name = r100;
    }

    public final void setNew(boolean r100) {
        this.isNew = r100;
    }

    public final void setNoCameraRender(boolean r100) {
        this.noCameraRender = r100;
    }

    public final void setPanelExtra(HashMap<String, String> r100) {
        this.panelExtra = r100;
    }

    public final void setParentResId(String r100) {
        this.parentResId = r100;
    }

    public final void setRealId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.realId = r100;
    }

    public final void setReplaceBeauty(String r100) {
        this.replaceBeauty = r100;
    }

    public final void setResourceId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.resourceId = r100;
    }

    public final void setReviewOriginalFrame(boolean r100) {
        this.reviewOriginalFrame = r100;
    }

    public final void setRhythmParam(JSONObject r100) {
        this.rhythmParam = r100;
    }

    public final void setSdkExtra(String r100) {
        this.sdkExtra = r100;
    }

    public final void setSdkExtraModel(StickerSDKExtra r100) {
        this.sdkExtraModel = r100;
    }

    public final void setSearchId(String r100) {
        this.searchId = r100;
    }

    public final void setSearchResultType(int r100) {
        this.searchResultType = r100;
    }

    public final void setStickerFeature(int r100) {
        this.stickerFeature = r100;
    }

    public final void setStickerPanel(String r100) {
        this.stickerPanel = r100;
    }

    public final void setStyleType(int r100) {
        this.styleType = r100;
    }

    public final void setSubItemStickerList(List<LocalSubStickerItem> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.subItemStickerList = r100;
    }

    public final void setSubStickers(List<Sticker> r100) {
        this.subStickers = r100;
    }

    public final void setTags(List<String> r100) {
        this.tags = r100;
    }

    public final void setTagsUpdatedAt(String r100) {
        this.tagsUpdatedAt = r100;
    }

    public final void setTopTips(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.topTips = r100;
    }

    public final void setTransferType(int r100) {
        this.transferType = r100;
    }

    public final void setTypes(List<String> r100) {
        this.types = r100;
    }

    public final void setUnzipPath(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.unzipPath = r100;
    }

    public final void setUpdateKeys(ArrayList<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.updateKeys = r100;
    }

    public final void setVideoTag(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.videoTag = r100;
    }

    public final void setVideoUsedSticker(boolean r100) {
        this.isVideoUsedSticker = r100;
    }

    public final void setWithoutFace(Boolean r100) {
        this.isWithoutFace = r100;
    }
}
