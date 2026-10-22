package com.bytedance.android.livesdk.message.model;

import android.content.Context;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.message.CommonMessageData;
import com.bytedance.android.livesdkapi.message.IPublicAreaCommon;
import com.bytedance.android.livesdkapi.message.PublicAreaCommon;
import com.bytedance.android.livesdkapi.message.Text;
import com.bytedance.android.livesdkapi.message.TextPiece;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.livesdkapi.message._TextPiece_ProtoDecoder;
import com.bytedance.android.livesdkapi.message._Text_ProtoDecoder;
import com.bytedance.android.livesdkapi.message.lazy.ITextWrapper;
import com.bytedance.android.service.manager.alliance.IAllianceService;
import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.common.utility.Lists;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import com.google.gson.annotations.SerializedName;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.ttm.player.MediaPlayer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.MemberMessage")
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0004`\u0005:\u0002mnB\u0007¢\u0006\u0004\bk\u0010lR\"\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR$\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0015\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\u001b\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\b\u001a\u0004\b\u001c\u0010\n\"\u0004\b\u001d\u0010\fR\"\u0010\u001e\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\b\u001a\u0004\b\u001f\u0010\n\"\u0004\b \u0010\fR$\u0010!\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\u000f\u001a\u0004\b\"\u0010\u0011\"\u0004\b#\u0010\u0013R\"\u0010$\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010\u0016\u001a\u0004\b%\u0010\u0018\"\u0004\b&\u0010\u001aR\"\u0010'\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b'\u0010\b\u001a\u0004\b(\u0010\n\"\u0004\b)\u0010\fR\"\u0010*\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b*\u0010\b\u001a\u0004\b+\u0010\n\"\u0004\b,\u0010\fR\u0018\u0010.\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b.\u0010/R$\u00101\u001a\u0004\u0018\u0001008\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R$\u00108\u001a\u0004\u0018\u0001078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\"\u0010?\u001a\u00020>8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b?\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR$\u0010E\u001a\u0004\u0018\u00010-8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bE\u0010/\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR$\u0010K\u001a\u0004\u0018\u00010J8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bK\u0010L\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\"\u0010Q\u001a\u00020>8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bQ\u0010@\u001a\u0004\bR\u0010B\"\u0004\bS\u0010DR\"\u0010T\u001a\u00020>8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bT\u0010@\u001a\u0004\bU\u0010B\"\u0004\bV\u0010DR\"\u0010W\u001a\u00020>8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bW\u0010@\u001a\u0004\bX\u0010B\"\u0004\bY\u0010DR0\u0010[\u001a\u0010\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020-\u0018\u00010Z8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b[\u0010\\\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`R$\u0010b\u001a\u0004\u0018\u00010a8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bb\u0010c\u001a\u0004\bd\u0010e\"\u0004\bf\u0010gR0\u0010h\u001a\u0010\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u000207\u0018\u00010Z8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bh\u0010\\\u001a\u0004\bi\u0010^\"\u0004\bj\u0010`¨\u0006o"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/MemberMessage;", "Lcom/bytedance/android/livesdk/message/model/o0;", "Lcom/bytedance/android/livesdk/message/model/va;", "Ljava/util/Comparator;", "", "Lkotlin/Comparator;", "", "_count", "I", "get_count", "()I", "set_count", "(I)V", "Lcom/bytedance/android/live/base/model/user/User;", "_user", "Lcom/bytedance/android/live/base/model/user/User;", "get_user", "()Lcom/bytedance/android/live/base/model/user/User;", "set_user", "(Lcom/bytedance/android/live/base/model/user/User;)V", "", "_isTopUser", "Z", "get_isTopUser", "()Z", "set_isTopUser", "(Z)V", "_action", "get_action", "set_action", "_topUserNo", "get_topUserNo", "set_topUserNo", "_operator", "get_operator", "set_operator", "_isSetToAdmin", "get_isSetToAdmin", "set_isSetToAdmin", "_rankScore", "get_rankScore", "set_rankScore", "_enterType", "get_enterType", "set_enterType", "", "_actionDescription", "Ljava/lang/String;", "Lcom/bytedance/android/livesdkapi/message/lazy/ITextWrapper;", "_anchorDisplayText", "Lcom/bytedance/android/livesdkapi/message/lazy/ITextWrapper;", "get_anchorDisplayText", "()Lcom/bytedance/android/livesdkapi/message/lazy/ITextWrapper;", "set_anchorDisplayText", "(Lcom/bytedance/android/livesdkapi/message/lazy/ITextWrapper;)V", "Lcom/bytedance/android/livesdk/message/model/MemberMessage$b;", "_effectConfig", "Lcom/bytedance/android/livesdk/message/model/MemberMessage$b;", "get_effectConfig", "()Lcom/bytedance/android/livesdk/message/model/MemberMessage$b;", "set_effectConfig", "(Lcom/bytedance/android/livesdk/message/model/MemberMessage$b;)V", "", "_userId", "J", "get_userId", "()J", "set_userId", "(J)V", "_popStr", "get_popStr", "()Ljava/lang/String;", "set_popStr", "(Ljava/lang/String;)V", "Lcom/bytedance/android/live/base/model/ImageModel;", "_background", "Lcom/bytedance/android/live/base/model/ImageModel;", "get_background", "()Lcom/bytedance/android/live/base/model/ImageModel;", "set_background", "(Lcom/bytedance/android/live/base/model/ImageModel;)V", "_userEnterTipType", "get_userEnterTipType", "set_userEnterTipType", "_anchorEnterTipType", "get_anchorEnterTipType", "set_anchorEnterTipType", "_enterRedirectFrom", "get_enterRedirectFrom", "set_enterRedirectFrom", "", "_buriedPoint", "Ljava/util/Map;", "get_buriedPoint", "()Ljava/util/Map;", "set_buriedPoint", "(Ljava/util/Map;)V", "Lcom/bytedance/android/livesdkapi/message/PublicAreaCommon;", "_publicAreaCommon", "Lcom/bytedance/android/livesdkapi/message/PublicAreaCommon;", "get_publicAreaCommon", "()Lcom/bytedance/android/livesdkapi/message/PublicAreaCommon;", "set_publicAreaCommon", "(Lcom/bytedance/android/livesdkapi/message/PublicAreaCommon;)V", "_alternativeEffectConfig", "get_alternativeEffectConfig", "set_alternativeEffectConfig", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MemberMessage extends o0 implements va, Comparator<Object>, vh7.h {

    @SerializedName("action")
    protected int _action;

    @SerializedName("action_description")
    protected String _actionDescription;

    @SerializedName("alternative_effect_config")
    protected Map<String, b> _alternativeEffectConfig;

    @SerializedName("anchor_display_text")
    protected ITextWrapper _anchorDisplayText;

    @SerializedName("anchor_enter_tip_type")
    protected long _anchorEnterTipType;

    @SerializedName("background_image_v2")
    protected ImageModel _background;

    @SerializedName("buried_point")
    protected Map<String, String> _buriedPoint;

    @SerializedName("member_count")
    protected int _count;

    @SerializedName("enter_effect_config")
    protected b _effectConfig;

    @SerializedName("enter_redirect_from")
    protected long _enterRedirectFrom;

    @SerializedName(ILiveRoomPlayFragmentConstant.EXTRA_HEAD_ENTER_TYPE)
    protected int _enterType;

    @SerializedName("is_set_to_admin")
    protected boolean _isSetToAdmin;

    @SerializedName("is_top_user")
    protected boolean _isTopUser;

    @SerializedName(OnekeyLoginConstants.CU_KEY_OPERATOR)
    protected User _operator;

    @SerializedName("pop_str")
    protected String _popStr;

    @SerializedName("public_area_common")
    protected PublicAreaCommon _publicAreaCommon;

    @SerializedName("rank_score")
    protected int _rankScore;

    @SerializedName("top_user_no")
    protected int _topUserNo;

    @SerializedName("user")
    protected User _user;

    @SerializedName("user_enter_tip_type")
    protected long _userEnterTipType;

    @SerializedName("user_id")
    protected long _userId;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f153575a;

    public static final class a {
    }

    @ProtoMessage("webcast.im.MemberMessage.EffectConfig")
    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001:\u0001kB\u0007¢\u0006\u0004\bi\u0010jJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\"\u0010\u0004\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u0018\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0005\u001a\u0004\b\u0019\u0010\u0007\"\u0004\b\u001a\u0010\tR$\u0010\u001b\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\f\u001a\u0004\b\u001c\u0010\u000e\"\u0004\b\u001d\u0010\u0010R\"\u0010\u001e\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0005\u001a\u0004\b\u001f\u0010\u0007\"\u0004\b \u0010\tR\"\u0010\"\u001a\u00020!8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\"\u0010(\u001a\u00020!8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b(\u0010#\u001a\u0004\b)\u0010%\"\u0004\b*\u0010'R\"\u0010+\u001a\u00020!8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b+\u0010#\u001a\u0004\b,\u0010%\"\u0004\b-\u0010'R$\u0010.\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b.\u0010\f\u001a\u0004\b/\u0010\u000e\"\u0004\b0\u0010\u0010R$\u00101\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b1\u0010\f\u001a\u0004\b2\u0010\u000e\"\u0004\b3\u0010\u0010R$\u00104\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b4\u0010\f\u001a\u0004\b5\u0010\u000e\"\u0004\b6\u0010\u0010R*\u00108\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u0001078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\"\u0010?\u001a\u00020>8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b?\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR$\u0010E\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bE\u0010\f\u001a\u0004\bF\u0010\u000e\"\u0004\bG\u0010\u0010R0\u0010J\u001a\u0010\u0012\u0004\u0012\u00020I\u0012\u0004\u0012\u00020I\u0018\u00010H8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\"\u0010P\u001a\u00020!8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bP\u0010#\u001a\u0004\bQ\u0010%\"\u0004\bR\u0010'R\"\u0010S\u001a\u00020!8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bS\u0010#\u001a\u0004\bT\u0010%\"\u0004\bU\u0010'R$\u0010V\u001a\u0004\u0018\u00010I8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bV\u0010W\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R\"\u0010\\\u001a\u00020!8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\\\u0010#\u001a\u0004\b]\u0010%\"\u0004\b^\u0010'R\"\u0010_\u001a\u00020!8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b_\u0010#\u001a\u0004\b`\u0010%\"\u0004\ba\u0010'R$\u0010b\u001a\u0004\u0018\u00010I8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bb\u0010W\u001a\u0004\bc\u0010Y\"\u0004\bd\u0010[R0\u0010f\u001a\u0010\u0012\u0004\u0012\u00020I\u0012\u0004\u0012\u00020e\u0018\u00010H8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bf\u0010K\u001a\u0004\bg\u0010M\"\u0004\bh\u0010O¨\u0006l"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/MemberMessage$b;", "Lcom/bytedance/android/livesdk/message/model/va$a;", "", "getType", "_type", "I", "get_type", "()I", "set_type", "(I)V", "Lcom/bytedance/android/live/base/model/ImageModel;", "_icon", "Lcom/bytedance/android/live/base/model/ImageModel;", "get_icon", "()Lcom/bytedance/android/live/base/model/ImageModel;", "set_icon", "(Lcom/bytedance/android/live/base/model/ImageModel;)V", "Lcom/bytedance/android/livesdkapi/message/Text;", "_textKey", "Lcom/bytedance/android/livesdkapi/message/Text;", "get_textKey", "()Lcom/bytedance/android/livesdkapi/message/Text;", "set_textKey", "(Lcom/bytedance/android/livesdkapi/message/Text;)V", "_avatarPos", "get_avatarPos", "set_avatarPos", "_textIcon", "get_textIcon", "set_textIcon", "_stayTime", "get_stayTime", "set_stayTime", "", "_animAssetId", "J", "get_animAssetId", "()J", "set_animAssetId", "(J)V", "_centerAnimAssetId", "get_centerAnimAssetId", "set_centerAnimAssetId", "_centerMP4AnimAssetId", "get_centerMP4AnimAssetId", "set_centerMP4AnimAssetId", "_badge", "get_badge", "set_badge", "_textIconOverlay", "get_textIconOverlay", "set_textIconOverlay", "_animatedBadgeOnly", "get_animatedBadgeOnly", "set_animatedBadgeOnly", "", "_badgeList", "Ljava/util/List;", "get_badgeList", "()Ljava/util/List;", "set_badgeList", "(Ljava/util/List;)V", "", "_hasSweepLight", "Z", "get_hasSweepLight", "()Z", "set_hasSweepLight", "(Z)V", "_dynamicImage", "get_dynamicImage", "set_dynamicImage", "", "", "_extra", "Ljava/util/Map;", "get_extra", "()Ljava/util/Map;", "set_extra", "(Ljava/util/Map;)V", "_remotePriority", "get_remotePriority", "set_remotePriority", "_validTime", "get_validTime", "set_validTime", "_dressId", "Ljava/lang/String;", "get_dressId", "()Ljava/lang/String;", "set_dressId", "(Ljava/lang/String;)V", "_alignment", "get_alignment", "set_alignment", "_alignmentOffset", "get_alignmentOffset", "set_alignmentOffset", "_effectSecene", "get_effectSecene", "set_effectSecene", "Lcom/bytedance/android/livesdkapi/message/TextPiece;", "_textPieceOverrides", "get_textPieceOverrides", "set_textPieceOverrides", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class b implements va.a, vh7.h {

        @SerializedName("alignment")
        protected long _alignment;

        @SerializedName("alignment_offset")
        protected long _alignmentOffset;

        @SerializedName("anim_asset_id")
        protected long _animAssetId;

        @SerializedName("animated_badge")
        protected ImageModel _animatedBadgeOnly;

        @SerializedName("avatar_pos")
        protected int _avatarPos;

        @SerializedName(IAllianceService.CONTENT_TYPE_BADGE)
        protected ImageModel _badge;

        @SerializedName("badge_list")
        protected List<? extends ImageModel> _badgeList;

        @SerializedName("center_anim_asset_id")
        protected long _centerAnimAssetId;

        @IgnoreProtoFieldCheck
        @SerializedName("mp4_anim_asset_id")
        protected long _centerMP4AnimAssetId;

        @SerializedName("dress_id")
        protected String _dressId;

        @SerializedName("dynamic_image")
        protected ImageModel _dynamicImage;

        @SerializedName("effect_scene")
        protected String _effectSecene;

        @SerializedName("extra")
        protected Map<String, String> _extra;

        @SerializedName("has_sweep_light")
        protected boolean _hasSweepLight;

        @SerializedName("icon")
        protected ImageModel _icon;

        @SerializedName("priority")
        protected long _remotePriority;

        @SerializedName("stay_time")
        protected int _stayTime;

        @SerializedName("text_icon")
        protected ImageModel _textIcon;

        @SerializedName("text_icon_overlay")
        protected ImageModel _textIconOverlay;

        @SerializedName("text")
        protected Text _textKey;

        @SerializedName("piece_values")
        protected Map<String, ? extends TextPiece> _textPieceOverrides;

        @SerializedName("type")
        protected int _type;

        @SerializedName("max_wait_time")
        protected long _validTime;

        public static final class a {
        }

        static {
        }

        public b() {
        }

        @Override // com.bytedance.android.livesdk.message.model.va.a
        public final py.k getAnimatedBadge() {
            ImageModel r100 = this._animatedBadgeOnly;
            if (r100 == null) goto L8;
            Intrinsics.checkNotNull(r100);
            if (Lists.isEmpty(r100.getUrls()) == true) goto L8;
            return this._animatedBadgeOnly;
        L8:
            return this._badge;
        }

        public final String toString() {
            return "EffectConfigBean{type=" + getType() + ", icon=" + this._icon + ", textKey=" + this._textKey + ", avatarPos=" + this._avatarPos + ", textIcon=" + this._textIcon + ", stayTime=" + this._stayTime + ", animAssetId=" + this._animAssetId + ", centerAnimAssetId=" + this._centerAnimAssetId + ", badge=" + this._badge + ", textIconOverlay=" + this._textIconOverlay + ", animatedBadge=" + this._animatedBadgeOnly + ", hasSweepLight=" + this._hasSweepLight + ", dynamicImage=" + this._dynamicImage + '}';
        }

        @Override // com.bytedance.android.livesdk.message.model.va.a
        public final long a() {
            return this._centerMP4AnimAssetId;
        }

        @Override // com.bytedance.android.livesdk.message.model.va.a
        public final boolean b() {
            return this._hasSweepLight;
        }

        @Override // com.bytedance.android.livesdk.message.model.va.a
        public final List<py.k> f() {
            return this._badgeList;
        }

        @Override // com.bytedance.android.livesdk.message.model.va.a
        public final long getAlignment() {
            return this._alignment;
        }

        @Override // com.bytedance.android.livesdk.message.model.va.a
        public final long getAlignmentOffset() {
            return this._alignmentOffset;
        }

        @Override // com.bytedance.android.livesdk.message.model.va.a
        public final long getAnimAssetId() {
            return this._animAssetId;
        }

        @Override // com.bytedance.android.livesdk.message.model.va.a
        public final int getAvatarPos() {
            return this._avatarPos;
        }

        @Override // com.bytedance.android.livesdk.message.model.va.a
        public final long getCenterAnimAssetId() {
            return this._centerAnimAssetId;
        }

        @Override // com.bytedance.android.livesdk.message.model.va.a
        public final String getDressId() {
            return this._dressId;
        }

        @Override // com.bytedance.android.livesdk.message.model.va.a
        public final py.k getDynamicImage() {
            return this._dynamicImage;
        }

        @Override // com.bytedance.android.livesdk.message.model.va.a
        public final Map<String, String> getExtra() {
            return this._extra;
        }

        @Override // com.bytedance.android.livesdk.message.model.va.a
        public final py.k getIcon() {
            return this._icon;
        }

        @Override // com.bytedance.android.livesdk.message.model.va.a
        public final int getStayTime() {
            return this._stayTime;
        }

        @Override // com.bytedance.android.livesdk.message.model.va.a
        public final com.bytedance.android.live.base.model.message.a5 getText() {
            return this._textKey;
        }

        @Override // com.bytedance.android.livesdk.message.model.va.a
        public final py.k getTextIcon() {
            return this._textIcon;
        }

        @Override // com.bytedance.android.livesdk.message.model.va.a
        public final py.k getTextIconOverlay() {
            return this._textIconOverlay;
        }

        @Override // com.bytedance.android.livesdk.message.model.va.a
        public int getType() {
            return this._type;
        }

        @Override // com.bytedance.android.livesdk.message.model.va.a
        public final Map<String, TextPiece> l() {
            return this._textPieceOverrides;
        }

        public final long n() {
            return this._remotePriority;
        }

        public final long o() {
            return this._validTime;
        }

        public b(am3.g r110) {
            this._badgeList = new ArrayList();
            this._extra = new HashMap();
            this._textPieceOverrides = new HashMap();
            long r100 = r110.c();
        L3:
            int r101 = r110.f();
            if (r101 == (-1)) goto L61;
            String r102 = null;
            switch(r101) {
                case 1: goto L60;
                case 2: goto L59;
                case 3: goto L58;
                case 4: goto L57;
                case 5: goto L56;
                case 6: goto L55;
                case 7: goto L54;
                case 8: goto L53;
                case 9: goto L7;
                case 10: goto L52;
                case 11: goto L51;
                case 12: goto L50;
                case 13: goto L7;
                case 14: goto L49;
                case 15: goto L48;
                case 16: goto L32;
                case 17: goto L31;
                case 18: goto L30;
                case 19: goto L29;
                case 20: goto L28;
                case 21: goto L27;
                case 22: goto L26;
                case 23: goto L25;
                case 24: goto L9;
                case 25: goto L8;
                default: goto L7;
            };
        L8:
            this._badgeList.add(com.bytedance.android.live.base.model.x.a(r110));
            goto L3
        L9:
            long r103 = r110.c();
            Object r104 = null;
        L10:
            int r111 = r110.f();
            if (r111 == (-1)) goto L17;
            if (r111 != 1) goto L13;
            r102 = am3.h.c(r110);
            goto L10
        L13:
            if (r111 != 2) goto L14;
            r104 = _TextPiece_ProtoDecoder.decodeStatic(r110);
            goto L10
        L14:
            am3.h.e(r110);
            goto L10
        L17:
            r110.d(r103);
            Map r105 = this._textPieceOverrides;
            if (r102 == null) goto L24;
            if (r104 == null) goto L22;
        L43:
            r105.put(r102, r104);
            goto L3
        L22:
            throw new IllegalStateException("Value must not be null");
        L24:
            throw new IllegalStateException("Key must not be null");
        L25:
            this._effectSecene = am3.h.c(r110);
            goto L3
        L26:
            this._alignmentOffset = r110.j();
            goto L3
        L27:
            this._alignment = r110.j();
            goto L3
        L28:
            this._dressId = am3.h.c(r110);
            goto L3
        L29:
            this._validTime = r110.j();
            goto L3
        L30:
            this._remotePriority = r110.j();
            goto L3
        L31:
            this._centerMP4AnimAssetId = r110.j();
            goto L3
        L32:
            long r106 = r110.c();
            r104 = null;
        L33:
            int r112 = r110.f();
            if (r112 == (-1)) goto L40;
            if (r112 != 1) goto L36;
            r102 = am3.h.c(r110);
            goto L33
        L36:
            if (r112 != 2) goto L37;
            r104 = am3.h.c(r110);
            goto L33
        L37:
            am3.h.e(r110);
            goto L33
        L40:
            r110.d(r106);
            r105 = this._extra;
            if (r102 == null) goto L47;
            if (r104 != null) goto L43;
            throw new IllegalStateException("Value must not be null");
        L47:
            throw new IllegalStateException("Key must not be null");
        L48:
            this._dynamicImage = com.bytedance.android.live.base.model.x.a(r110);
            goto L3
        L49:
            this._centerAnimAssetId = r110.j();
            goto L3
        L50:
            this._hasSweepLight = am3.h.a(r110);
            goto L3
        L51:
            this._animatedBadgeOnly = com.bytedance.android.live.base.model.x.a(r110);
            goto L3
        L52:
            this._textIconOverlay = com.bytedance.android.live.base.model.x.a(r110);
            goto L3
        L53:
            this._badge = com.bytedance.android.live.base.model.x.a(r110);
            goto L3
        L54:
            this._animAssetId = r110.j();
            goto L3
        L55:
            this._stayTime = r110.i();
            goto L3
        L56:
            this._textIcon = com.bytedance.android.live.base.model.x.a(r110);
            goto L3
        L57:
            this._textKey = _Text_ProtoDecoder.decodeStatic(r110);
            goto L3
        L58:
            this._avatarPos = (int) r110.j();
            goto L3
        L59:
            this._icon = com.bytedance.android.live.base.model.x.a(r110);
            goto L3
        L60:
            this._type = (int) r110.j();
            goto L3
        L7:
            am3.h.e(r110);
            goto L3
        L61:
            r110.d(r100);
        }

        @Override // com.bytedance.android.livesdk.message.model.va.a
        public final void c(py.k r100) {
            this._dynamicImage = (ImageModel) com.bytedance.android.live.base.model.m.b(r100, ImageModel.class);
        }

        @Override // com.bytedance.android.livesdk.message.model.va.a
        public final void d(int r100) {
            this._avatarPos = r100;
        }

        @Override // com.bytedance.android.livesdk.message.model.va.a
        public final void e(long r100) {
            this._centerAnimAssetId = r100;
        }

        @Override // com.bytedance.android.livesdk.message.model.va.a
        public final void g(long r100) {
            this._centerMP4AnimAssetId = r100;
        }

        @Override // com.bytedance.android.livesdk.message.model.va.a
        public final void h(long r100) {
            this._alignmentOffset = r100;
        }

        @Override // com.bytedance.android.livesdk.message.model.va.a
        public final void i(py.k r100) {
            this._textIconOverlay = (ImageModel) com.bytedance.android.live.base.model.m.b(r100, ImageModel.class);
        }

        @Override // com.bytedance.android.livesdk.message.model.va.a
        public final void j(long r100) {
            this._alignment = r100;
        }

        @Override // com.bytedance.android.livesdk.message.model.va.a
        public final void k(py.k r100) {
            this._textIcon = (ImageModel) com.bytedance.android.live.base.model.m.b(r100, ImageModel.class);
        }

        @Override // com.bytedance.android.livesdk.message.model.va.a
        public final void m(long r100) {
            this._animAssetId = r100;
        }

        @Override // com.bytedance.android.livesdk.message.model.va.a
        public final void setIcon(py.k r100) {
            this._icon = (ImageModel) com.bytedance.android.live.base.model.m.b(r100, ImageModel.class);
        }

        @Override // com.bytedance.android.livesdk.message.model.va.a
        public final void setType(int r100) {
            this._type = r100;
        }
    }

    static {
    }

    public final String E() {
        if (this._actionDescription != null) goto L10;
        if (this._action == 1) goto L7;
        String r100 = "";
    L8:
        this._actionDescription = r100;
        goto L10
    L7:
        r100 = G(R.string.ttlive_live_user_enter, new Object[0]);
    L10:
        return this._actionDescription;
    }

    @Override // com.bytedance.android.livesdk.message.model.va
    public final String F0() {
        int r100 = this._enterType;
        if (r100 == 15) goto L18;
        if (r100 == 1000) goto L23;
        if (r100 == 2000) goto L22;
        if (r100 == 3000) goto L21;
        if (r100 == 4000) goto L20;
        return "";
    L20:
        return G(R.string.ttlive_live_day_top10, new Object[0]);
    L21:
        return G(R.string.ttlive_live_day_top3, new Object[0]);
    L22:
        return G(R.string.ttlive_live_day_top2, new Object[0]);
    L23:
        return G(R.string.ttlive_live_day_top1, new Object[0]);
    L18:
        return G(R.string.ttlive_live_year_top10, new Object[0]);
    }

    @Override // com.bytedance.android.livesdk.message.model.va
    public final long a0() {
        return this._topUserNo;
    }

    @Override // com.bytedance.android.livesdkapi.message.BaseMessage, com.bytedance.android.live.base.model.message.t
    public final boolean canText() {
        if (this._user != null) goto L5;
    L7:
        return false;
    L5:
        if (StringUtils.isEmpty(getActionContent()) == true) goto L7;
        return true;
    }

    @Override // com.bytedance.android.livesdk.message.model.va
    public final long getAction() {
        return this._action;
    }

    @Override // com.bytedance.android.livesdk.message.model.va
    public final String getActionContent() {
        User r100 = this._operator;
        if (r100 == null) goto L6;
        gm2.q.b(r100);
    L6:
        String r101 = "";
        switch(this._action) {
            case 1: goto L61;
            case 2: goto L56;
            case 3: goto L51;
            case 4: goto L46;
            case 5: goto L44;
            case 6: goto L42;
            case 7: goto L65;
            case 8: goto L35;
            case 9: goto L24;
            case 10: goto L14;
            case 11: goto L10;
            default: goto L65;
        };
    L14:
        Object[] r102 = new Object[2];
        User r103 = this._user;
        if (r103 != null) goto L17;
        String r104 = "";
    L18:
        r102[0] = r104;
        User r105 = this._operator;
        if (r105 == null) goto L22;
        r101 = gm2.q.b(r105);
    L22:
        r102[1] = r101;
        return G(R.string.ttlive_live_user_talk_banned_cancel_by_admin, r102);
    L17:
        r104 = gm2.q.b(r103);
        goto L18
    L24:
        Object[] r106 = new Object[2];
        User r107 = this._user;
        if (r107 != null) goto L27;
        String r108 = "";
    L28:
        r106[0] = r108;
        User r109 = this._operator;
        if (r109 == null) goto L32;
        r101 = gm2.q.b(r109);
    L32:
        r106[1] = r101;
        return G(R.string.ttlive_live_user_talk_banned_by_admin, r106);
    L27:
        r108 = gm2.q.b(r107);
    L65:
        return "";
    L10:
        if (this._user != null) goto L13;
        return "";
    L13:
        return gm2.q.b(this._user) + G(R.string.ttlive_live_user_kicked_out, new Object[0]);
    L35:
        if (this._topUserNo <= 0) goto L65;
        if (this._isSetToAdmin == false) goto L40;
        return G(R.string.ttlive_live_user_being_top_user_and_admin, new Object[]{gm2.q.b(this._user), Long.valueOf(this._topUserNo)});
    L40:
        return G(R.string.ttlive_live_user_being_top_user, new Object[]{gm2.q.b(this._user), Long.valueOf(this._topUserNo)});
    L42:
        return gm2.q.b(this._user) + " " + G(R.string.ttlive_live_user_cancel_admin, new Object[0]);
    L44:
        return gm2.q.b(this._user) + " " + G(R.string.ttlive_live_user_set_admin, new Object[0]);
    L46:
        if (this._user != null) goto L49;
        return "";
    L49:
        return gm2.q.b(this._user) + G(R.string.ttlive_live_user_talk_banned_cancel, new Object[0]);
    L51:
        if (this._user != null) goto L54;
        return "";
    L54:
        return gm2.q.b(this._user) + G(R.string.ttlive_live_user_talk_banned, new Object[0]);
    L56:
        if (this._isTopUser == false) goto L59;
        return G(R.string.ttlive_live_top_user_leave, new Object[]{Long.valueOf(this._topUserNo)});
    L59:
        return G(R.string.ttlive_live_user_leave, new Object[0]);
    L61:
        if (this._isTopUser == false) goto L64;
        return G(R.string.ttlive_live_top_user_enter, new Object[]{Long.valueOf(this._topUserNo), E()});
    L64:
        return E();
    }

    @Override // com.bytedance.android.livesdk.message.model.va
    public final Map<String, String> getBuriedPoint() {
        HashMap r100 = new HashMap();
        Map<String, String> r101 = this._buriedPoint;
        if (r101 == null) goto L5;
        Intrinsics.checkNotNull(r101);
        r100.putAll(r101);
    L5:
        PublicAreaCommon r102 = this._publicAreaCommon;
        if (r102 == null) goto L10;
        Intrinsics.checkNotNull(r102);
        if (r102.getTrackingParams() == null) goto L10;
        PublicAreaCommon r103 = this._publicAreaCommon;
        Intrinsics.checkNotNull(r103);
        Map<String, String> r104 = r103.getTrackingParams();
        Intrinsics.checkNotNull(r104);
        r100.putAll(r104);
    L10:
        return r100;
    }

    @Override // com.bytedance.android.live.base.model.message.u3
    public final IPublicAreaCommon getOrInitPublicAreaCommon() {
        if (this._publicAreaCommon != null) goto L6;
        this._publicAreaCommon = new PublicAreaCommon();
    L6:
        return this._publicAreaCommon;
    }

    @Override // com.bytedance.android.livesdk.message.model.va
    public final b r() {
        b r100 = this._effectConfig;
        if (r100 == null) goto L15;
        Intrinsics.checkNotNull(r100);
        if (r100._effectSecene == null) goto L15;
        b r101 = this._effectConfig;
        Intrinsics.checkNotNull(r101);
        if (Intrinsics.areEqual(r101._effectSecene, "ecom_fansclub") == false) goto L15;
        boolean r102 = com.bytedance.android.live.revenue.core.util.h.f91037a;
        if (((com.bytedance.android.live.profit.fansclub.n) com.bytedance.android.live.revenue.core.util.h.d(com.bytedance.android.live.profit.fansclub.n.class)).enableEcomFansClubReverse() == false) goto L15;
        Map<String, b> r103 = this._alternativeEffectConfig;
        if (r103 == null) goto L13;
        Intrinsics.checkNotNull(r103);
        return r103.get("ecom_fansclub_reverse");
    L13:
        return null;
    L15:
        return this._effectConfig;
    }

    public final String toString() {
        StringBuilder r100 = new StringBuilder("MemberMessage{action=");
        r100.append(this._action);
        r100.append(", enterType=");
        r100.append(this._enterType);
        r100.append(", actionDescription='");
        r100.append(this._actionDescription);
        r100.append("', enterEffectConfig=");
        r100.append(r());
        r100.append(", userId=");
        r100.append(this._userId);
        r100.append('}');
        return r100.toString();
    }

    public MemberMessage() {
        this.type = MessageType.MEMBER;
    }

    @Override // com.bytedance.android.livesdk.message.model.va
    public final Text F1() {
        CommonMessageData r100 = getBaseMessage();
        Intrinsics.checkNotNull(r100);
        return r100.getDisplayText();
    }

    public final int hashCode() {
        CommonMessageData r100 = getBaseMessage();
        Intrinsics.checkNotNull(r100);
        Long r101 = Long.valueOf(r100.getMessageId());
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_START_TIME + r102;
    L5:
        r102 = 0;
        goto L7
    }

    @Override // com.bytedance.android.livesdk.message.model.o0, com.bytedance.android.livesdkapi.message.BaseMessage, com.bytedance.android.live.base.model.message.t
    public final boolean supportDisplayText() {
        if (getBaseMessage() == null) goto L9;
        CommonMessageData r100 = getBaseMessage();
        Intrinsics.checkNotNull(r100);
        if (r100.supportDisplayText() == false) goto L9;
        if (this._isTopUser == true) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.bytedance.android.livesdk.message.model.va
    public final long Z0() {
        return this._userEnterTipType;
    }

    @Override // com.bytedance.android.livesdk.message.model.va
    public final int e() {
        return this._enterType;
    }

    @Override // com.bytedance.android.livesdk.message.model.va
    public final py.k getBackground() {
        return this._background;
    }

    @Override // com.bytedance.android.livesdk.message.model.va
    public final IBaseUser getUser() {
        return this._user;
    }

    @Override // com.bytedance.android.live.base.model.message.u3
    public final IBaseUser getUserInMessage() {
        return this._user;
    }

    @Override // com.bytedance.android.livesdkapi.message.IRtcRoomMessage
    public final boolean isFromRtcRoom() {
        return this.f153575a;
    }

    @Override // com.bytedance.android.livesdk.message.model.va
    public final long j0() {
        return this._enterRedirectFrom;
    }

    @Override // com.bytedance.android.livesdk.message.model.va
    public final long z1() {
        return this._anchorEnterTipType;
    }

    @Override // com.bytedance.android.livesdk.message.model.va
    public final User getUser() {
        return this._user;
    }

    /* JADX WARN: Type inference failed for: r2v17, types: [com.bytedance.android.livesdkapi.message.lazy.ITextWrapper, java.lang.Object] */
    public MemberMessage(am3.g r110) {
        this._buriedPoint = new HashMap();
        this._alternativeEffectConfig = new HashMap();
        long r100 = r110.c();
    L3:
        int r101 = r110.f();
        if (r101 == (-1)) goto L60;
        String r102 = null;
        switch(r101) {
            case 1: goto L59;
            case 2: goto L58;
            case 3: goto L57;
            case 4: goto L56;
            case 5: goto L55;
            case 6: goto L54;
            case 7: goto L53;
            case 8: goto L52;
            case 9: goto L51;
            case 10: goto L50;
            case 11: goto L49;
            case 12: goto L48;
            case 13: goto L7;
            case 14: goto L47;
            case 15: goto L46;
            case 16: goto L7;
            case 17: goto L45;
            case 18: goto L44;
            case 19: goto L43;
            case 20: goto L42;
            case 21: goto L41;
            case 22: goto L25;
            case 23: goto L9;
            case 24: goto L7;
            case 25: goto L7;
            case 26: goto L8;
            default: goto L7;
        };
    L8:
        this._enterRedirectFrom = r110.j();
        goto L3
    L9:
        long r103 = r110.c();
        Object r104 = null;
    L10:
        int r111 = r110.f();
        if (r111 == (-1)) goto L17;
        if (r111 != 1) goto L13;
        r102 = am3.h.c(r110);
        goto L10
    L13:
        if (r111 != 2) goto L14;
        r104 = new b(r110);
        goto L10
    L14:
        am3.h.e(r110);
        goto L10
    L17:
        r110.d(r103);
        Map r105 = this._alternativeEffectConfig;
        if (r102 == null) goto L24;
        if (r104 == null) goto L22;
    L36:
        r105.put(r102, r104);
        goto L3
    L22:
        throw new IllegalStateException("Value must not be null");
    L24:
        throw new IllegalStateException("Key must not be null");
    L25:
        long r106 = r110.c();
        r104 = null;
    L26:
        int r112 = r110.f();
        if (r112 == (-1)) goto L33;
        if (r112 != 1) goto L29;
        r102 = am3.h.c(r110);
        goto L26
    L29:
        if (r112 != 2) goto L30;
        r104 = am3.h.c(r110);
        goto L26
    L30:
        am3.h.e(r110);
        goto L26
    L33:
        r110.d(r106);
        r105 = this._buriedPoint;
        if (r102 == null) goto L40;
        if (r104 != null) goto L36;
        throw new IllegalStateException("Value must not be null");
    L40:
        throw new IllegalStateException("Key must not be null");
    L41:
        this._anchorEnterTipType = r110.j();
        goto L3
    L42:
        this._userEnterTipType = r110.j();
        goto L3
    L43:
        this._publicAreaCommon = new PublicAreaCommon(r110);
        goto L3
    L44:
        this._anchorDisplayText = vh7.f.a(r110, ITextWrapper.class);
        goto L3
    L45:
        this._background = com.bytedance.android.live.base.model.x.a(r110);
        goto L3
    L46:
        this._effectConfig = new b(r110);
        goto L3
    L47:
        this._popStr = am3.h.c(r110);
        goto L3
    L48:
        this._userId = r110.j();
        goto L3
    L49:
        this._actionDescription = am3.h.c(r110);
        goto L3
    L50:
        this._action = (int) r110.j();
        goto L3
    L51:
        this._enterType = (int) r110.j();
        goto L3
    L52:
        this._topUserNo = (int) r110.j();
        goto L3
    L53:
        this._rankScore = (int) r110.j();
        goto L3
    L54:
        this._isTopUser = am3.h.a(r110);
        goto L3
    L55:
        this._isSetToAdmin = am3.h.a(r110);
        goto L3
    L56:
        this._operator = new User(r110);
        goto L3
    L57:
        this._count = (int) r110.j();
        goto L3
    L58:
        this._user = new User(r110);
        goto L3
    L59:
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r110);
        goto L3
    L7:
        am3.h.e(r110);
        goto L3
    L60:
        r110.d(r100);
        this.type = MessageType.MEMBER;
    }

    @Override // java.util.Comparator
    public final boolean equals(Object r100) {
        if ((r100 instanceof MemberMessage) == false) goto L8;
        CommonMessageData r101 = getBaseMessage();
        Intrinsics.checkNotNull(r101);
        long r102 = r101.messageId;
        CommonMessageData r103 = ((MemberMessage) r100).getBaseMessage();
        Intrinsics.checkNotNull(r103);
        if (r102 != r103.messageId) goto L9;
        return true;
    L9:
        return false;
    L8:
        return false;
    }

    @Override // com.bytedance.android.livesdkapi.message.IRtcRoomMessage
    public final void setFromRtcRoom(boolean r100) {
        this.f153575a = r100;
    }

    public static String G(final int r100, Object... r101) {
        final Context r102 = com.bytedance.android.live.core.utils.s1.getContext();
        if (r101.length > 0) goto L14;
        Function0<String> r103 = new MemberMessage$getString$1(r102, r100);
        SettingKey<ss1.e> r104 = com.bytedance.android.live.liveinteract.f.f72793a;
        Intrinsics.checkNotNullParameter(r103, "func");
        Integer r105 = Integer.valueOf(r100);
        Map<Integer, String> r106 = com.bytedance.android.live.liveinteract.f.f72796d;
        if (com.bytedance.android.live.liveinteract.f.f72794b == true) goto L8;
        Object r107 = r103.invoke();
    L13:
        return (String) r107;
    L8:
        HashMap r108 = (HashMap) r106;
        Object r109 = r108.get(r105);
        if (r109 != null) goto L11;
        String r110 = r103.invoke();
        r108.put(r105, r110);
        r107 = r110;
        goto L13
    L11:
        r107 = r109;
        goto L13
    L14:
        return r102.getResources().getString(r100, Arrays.copyOf(r101, r101.length));
    }

    @Override // java.util.Comparator
    public final int compare(Object r100, Object r101) {
        if (r100 == null) goto L14;
        MemberMessage r102 = (MemberMessage) r100;
        if (r101 == null) goto L12;
        int r103 = r102._rankScore;
        int r104 = ((MemberMessage) r101)._rankScore;
        if (r103 != r104) goto L10;
        return -1;
    L10:
        return r103 - r104;
    L12:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.message.model.MemberMessage");
    L14:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.message.model.MemberMessage");
    }
}
