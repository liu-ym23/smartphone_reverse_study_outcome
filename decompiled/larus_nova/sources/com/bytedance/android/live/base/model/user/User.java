package com.bytedance.android.live.base.model.user;

import android.text.TextUtils;
import com.bytedance.android.gamecp.business.instantplay.InstantPlayContext;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.user.api.IAnchorLevel;
import com.bytedance.android.live.base.model.user.api.IUserHonor;
import com.bytedance.android.live.base.model.vip.UserVipInfo;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import com.bytedance.android.livesdkapi.depend.model.live.RoomAuthStatus;
import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoDecode;
import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.common.utility.Lists;
import com.bytedance.common.utility.Logger;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.Gson;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@ProtoMessage("webcast.data.User")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000Ê\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b(\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b=\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b?\b\u0017\u0018\u0000 ä\u00032\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u00022\u00020\u0004:\u0004å\u0003æ\u0003B\t¢\u0006\u0006\bâ\u0003\u0010ã\u0003J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010\n\u001a\u00020\tH\u0007J\u0012\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\tH\u0007J\b\u0010\u000e\u001a\u00020\u0007H\u0016J\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u000fH\u0016J\u0010\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013H\u0016J\u0018\u0010\u0018\u001a\u00020\f2\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0016H\u0016J\n\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016J\u0012\u0010\u001c\u001a\u00020\f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001d\u001a\u00020\u0007H\u0016J\b\u0010\u001e\u001a\u00020\u0007H\u0016J\b\u0010\u001f\u001a\u00020\u0007H\u0016J\b\u0010 \u001a\u00020\u0007H\u0016J\u0018\u0010#\u001a\u00020\f2\u0006\u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u0007H\u0016J\u000e\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0016J\b\u0010&\u001a\u00020%H\u0016J\u0012\u0010(\u001a\u00020\f2\b\u0010'\u001a\u0004\u0018\u00010%H\u0016J\b\u0010*\u001a\u00020)H\u0016J\u0012\u0010,\u001a\u00020\f2\b\u0010+\u001a\u0004\u0018\u00010)H\u0016J\b\u0010.\u001a\u00020-H\u0016J\u0012\u00100\u001a\u00020\f2\b\u0010/\u001a\u0004\u0018\u00010-H\u0016J\b\u00102\u001a\u000201H\u0016J\u000e\u00104\u001a\u00020\f2\u0006\u00103\u001a\u000201J\b\u00105\u001a\u00020\u0007H\u0016J\u0010\u00107\u001a\u00020\f2\b\u00106\u001a\u0004\u0018\u00010\tJ\u0010\u00109\u001a\u00020\f2\b\u00108\u001a\u0004\u0018\u00010\tJ\u0010\u0010;\u001a\u00020\f2\b\u0010:\u001a\u0004\u0018\u00010\tJ\b\u0010<\u001a\u00020\u0007H\u0016J\b\u0010=\u001a\u00020\u0007H\u0016J\u0010\u0010?\u001a\u00020\f2\u0006\u0010>\u001a\u00020\u0007H\u0016J\u0010\u0010A\u001a\u00020\f2\u0006\u0010@\u001a\u00020\u000fH\u0016J\n\u0010C\u001a\u0004\u0018\u00010BH\u0016J\u0012\u0010E\u001a\u00020\f2\b\u0010D\u001a\u0004\u0018\u00010\u0014H\u0016J\n\u0010F\u001a\u0004\u0018\u00010BH\u0016J\u0010\u0010H\u001a\u00020\f2\b\u0010G\u001a\u0004\u0018\u00010BJ\u0012\u0010I\u001a\u00020\f2\b\u0010D\u001a\u0004\u0018\u00010\u0014H\u0016J\n\u0010J\u001a\u0004\u0018\u00010BH\u0016J\u0010\u0010L\u001a\u00020\f2\b\u0010K\u001a\u0004\u0018\u00010BJ\u0012\u0010M\u001a\u00020\f2\b\u0010D\u001a\u0004\u0018\u00010\u0014H\u0016J\n\u0010N\u001a\u0004\u0018\u00010\tH\u0016J\u0006\u0010O\u001a\u00020\u0007J\u0010\u0010Q\u001a\u00020\f2\u0006\u0010P\u001a\u00020\u0007H\u0016J\u0012\u0010S\u001a\u0004\u0018\u00010\t2\u0006\u0010R\u001a\u00020\u0007H\u0016J\n\u0010T\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010U\u001a\u00020\u000fH\u0016J\b\u0010V\u001a\u00020\tH\u0016J\u0012\u0010X\u001a\u00020\f2\b\u0010W\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010Y\u001a\u000201H\u0016J\b\u0010Z\u001a\u00020\u0007H\u0016J\u0010\u0010[\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013H\u0016J\b\u0010\\\u001a\u00020\tH\u0016J\n\u0010]\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010_\u001a\u00020\f2\b\u0010^\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010`\u001a\u00020\u0007H\u0016J\u0010\u0010b\u001a\u00020\f2\u0006\u0010a\u001a\u00020\u0007H\u0016J\u0010\u0010d\u001a\u00020\f2\u0006\u0010c\u001a\u00020\u000fH\u0016J\b\u0010e\u001a\u00020\u000fH\u0016J\b\u0010f\u001a\u00020\u000fH\u0016J\u0010\u0010h\u001a\u00020\f2\u0006\u0010g\u001a\u00020\u000fH\u0016J\b\u0010i\u001a\u00020\u0007H\u0016J\n\u0010j\u001a\u0004\u0018\u00010\tH\u0016J\n\u0010l\u001a\u0004\u0018\u00010kH\u0016J\u0016\u0010n\u001a\u00020\f2\u000e\u0010m\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013J\u000e\u0010p\u001a\u00020\f2\u0006\u0010o\u001a\u00020\u0002J\n\u0010q\u001a\u0004\u0018\u00010\u0002H\u0016J\u0013\u0010r\u001a\u00020\u00072\b\u0010o\u001a\u0004\u0018\u00010\u0004H\u0096\u0002J\b\u0010s\u001a\u00020\u000fH\u0016J\n\u0010t\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010v\u001a\u00020\f2\b\u0010u\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010w\u001a\u00020\tH\u0016J\u0012\u0010y\u001a\u00020\f2\b\u0010x\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010z\u001a\u00020\u0007H\u0016J\b\u0010{\u001a\u00020\u0007H\u0016J\b\u0010|\u001a\u00020\u0007H\u0016J\b\u0010~\u001a\u0004\u0018\u00010}J\u0011\u0010\u0080\u0001\u001a\u00020\f2\b\u0010\u007f\u001a\u0004\u0018\u00010}J\u0012\u0010\u0082\u0001\u001a\u00020\f2\t\u0010\u0081\u0001\u001a\u0004\u0018\u00010\tJ\u000b\u0010\u0083\u0001\u001a\u0004\u0018\u00010\tH\u0016J\u0014\u0010\u0085\u0001\u001a\u0004\u0018\u00010B2\t\u0010\u0006\u001a\u0005\u0018\u00010\u0084\u0001J\u0014\u0010\u0086\u0001\u001a\u0004\u0018\u00010\t2\t\u0010\u0006\u001a\u0005\u0018\u00010\u0084\u0001J\u0014\u0010\u0087\u0001\u001a\u0004\u0018\u00010\t2\t\u0010\u0006\u001a\u0005\u0018\u00010\u0084\u0001J\u0014\u0010\u0088\u0001\u001a\u0004\u0018\u00010\t2\t\u0010\u0006\u001a\u0005\u0018\u00010\u0084\u0001J\u0014\u0010\u0089\u0001\u001a\u0004\u0018\u00010%2\t\u0010\u0006\u001a\u0005\u0018\u00010\u0084\u0001J\u0013\u0010\u008a\u0001\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u0014\u0010\u008b\u0001\u001a\u0004\u0018\u00010\u00142\t\u0010\u0006\u001a\u0005\u0018\u00010\u0084\u0001J\u0012\u0010\u008c\u0001\u001a\u00020\u000f2\t\u0010\u0006\u001a\u0005\u0018\u00010\u0084\u0001J\t\u0010\u008d\u0001\u001a\u00020\tH\u0016J\t\u0010\u008e\u0001\u001a\u00020\tH\u0016J\u000f\u0010\u008f\u0001\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0016J\u000b\u0010\u0090\u0001\u001a\u0004\u0018\u00010\tH\u0016J\t\u0010\u0091\u0001\u001a\u00020\u0007H\u0016J\t\u0010\u0092\u0001\u001a\u00020\tH\u0016J\u000b\u0010\u0093\u0001\u001a\u0004\u0018\u00010)H\u0016J\n\u0010\u0095\u0001\u001a\u00030\u0094\u0001H\u0016J\u0011\u0010\u0096\u0001\u001a\u00020\f2\b\u0010\u0081\u0001\u001a\u00030\u0094\u0001R\u001c\u0010\u0098\u0001\u001a\u0005\u0018\u00010\u0097\u00018\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0006\b\u0098\u0001\u0010\u0099\u0001R\u001c\u0010\u009b\u0001\u001a\u0005\u0018\u00010\u009a\u00018\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0006\b\u009b\u0001\u0010\u009c\u0001R+\u0010\u009d\u0001\u001a\u0004\u0018\u00010\t8\u0016@\u0016X\u0096\u000e¢\u0006\u0018\n\u0006\b\u009d\u0001\u0010\u009e\u0001\u001a\u0006\b\u009f\u0001\u0010 \u0001\"\u0006\b¡\u0001\u0010¢\u0001R\u001b\u0010£\u0001\u001a\u0004\u0018\u00010}8\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\b£\u0001\u0010¤\u0001R)\u0010¥\u0001\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b¥\u0001\u0010¦\u0001\u001a\u0006\b¥\u0001\u0010§\u0001\"\u0006\b¨\u0001\u0010©\u0001R\u001c\u0010«\u0001\u001a\u0005\u0018\u00010ª\u00018\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0006\b«\u0001\u0010¬\u0001R\u001c\u0010®\u0001\u001a\u0005\u0018\u00010\u00ad\u00018\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0006\b®\u0001\u0010¯\u0001R!\u0010°\u0001\u001a\n\u0012\u0004\u0012\u00020B\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0006\b°\u0001\u0010±\u0001R+\u0010²\u0001\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b²\u0001\u0010\u009e\u0001\u001a\u0006\b³\u0001\u0010 \u0001\"\u0006\b´\u0001\u0010¢\u0001R+\u0010µ\u0001\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\bµ\u0001\u0010\u009e\u0001\u001a\u0006\b¶\u0001\u0010 \u0001\"\u0006\b·\u0001\u0010¢\u0001R+\u0010¸\u0001\u001a\u0004\u0018\u00010\t8\u0016@\u0016X\u0097\u000e¢\u0006\u0018\n\u0006\b¸\u0001\u0010\u009e\u0001\u001a\u0006\b¹\u0001\u0010 \u0001\"\u0006\bº\u0001\u0010¢\u0001R,\u0010¼\u0001\u001a\u0005\u0018\u00010»\u00018\u0016@\u0016X\u0097\u000e¢\u0006\u0018\n\u0006\b¼\u0001\u0010½\u0001\u001a\u0006\b¾\u0001\u0010¿\u0001\"\u0006\bÀ\u0001\u0010Á\u0001R)\u0010Â\u0001\u001a\u00020\u000f8\u0016@\u0016X\u0097\u000e¢\u0006\u0018\n\u0006\bÂ\u0001\u0010Ã\u0001\u001a\u0006\bÄ\u0001\u0010Å\u0001\"\u0006\bÆ\u0001\u0010Ç\u0001R+\u0010È\u0001\u001a\u0004\u0018\u00010\t8\u0016@\u0016X\u0097\u000e¢\u0006\u0018\n\u0006\bÈ\u0001\u0010\u009e\u0001\u001a\u0006\bÉ\u0001\u0010 \u0001\"\u0006\bÊ\u0001\u0010¢\u0001R'\u0010c\u001a\u00020\u000f8\u0016@\u0016X\u0097\u000e¢\u0006\u0017\n\u0005\bc\u0010Ã\u0001\u001a\u0006\bË\u0001\u0010Å\u0001\"\u0006\bÌ\u0001\u0010Ç\u0001R\u0019\u0010Í\u0001\u001a\u0002018\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0006\bÍ\u0001\u0010Î\u0001R\u001b\u0010Ï\u0001\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0006\bÏ\u0001\u0010\u009e\u0001R\u0019\u0010Ð\u0001\u001a\u00020\t8\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\bÐ\u0001\u0010\u009e\u0001R)\u0010W\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0017\n\u0005\bW\u0010\u009e\u0001\u001a\u0006\bÑ\u0001\u0010 \u0001\"\u0006\bÒ\u0001\u0010¢\u0001R)\u0010Ó\u0001\u001a\u0002018\u0016@\u0016X\u0097\u000e¢\u0006\u0018\n\u0006\bÓ\u0001\u0010Î\u0001\u001a\u0006\bÔ\u0001\u0010Õ\u0001\"\u0006\bÖ\u0001\u0010×\u0001R+\u0010Ø\u0001\u001a\u0004\u0018\u00010\t8\u0016@\u0016X\u0097\u000e¢\u0006\u0018\n\u0006\bØ\u0001\u0010\u009e\u0001\u001a\u0006\bÙ\u0001\u0010 \u0001\"\u0006\bÚ\u0001\u0010¢\u0001R\u001b\u0010Û\u0001\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0006\bÛ\u0001\u0010\u009e\u0001R)\u0010Ü\u0001\u001a\u0002018\u0016@\u0016X\u0097\u000e¢\u0006\u0018\n\u0006\bÜ\u0001\u0010Î\u0001\u001a\u0006\bÝ\u0001\u0010Õ\u0001\"\u0006\bÞ\u0001\u0010×\u0001R+\u0010ß\u0001\u001a\u0004\u0018\u00010\t8\u0016@\u0016X\u0097\u000e¢\u0006\u0018\n\u0006\bß\u0001\u0010\u009e\u0001\u001a\u0006\bà\u0001\u0010 \u0001\"\u0006\bá\u0001\u0010¢\u0001R)\u0010â\u0001\u001a\u00020\u000f8\u0016@\u0016X\u0097\u000e¢\u0006\u0018\n\u0006\bâ\u0001\u0010Ã\u0001\u001a\u0006\bã\u0001\u0010Å\u0001\"\u0006\bä\u0001\u0010Ç\u0001R)\u0010å\u0001\u001a\u00020\u000f8\u0016@\u0016X\u0097\u000e¢\u0006\u0018\n\u0006\bå\u0001\u0010Ã\u0001\u001a\u0006\bæ\u0001\u0010Å\u0001\"\u0006\bç\u0001\u0010Ç\u0001R)\u0010è\u0001\u001a\u0002018\u0016@\u0016X\u0097\u000e¢\u0006\u0018\n\u0006\bè\u0001\u0010Î\u0001\u001a\u0006\bé\u0001\u0010Õ\u0001\"\u0006\bê\u0001\u0010×\u0001R)\u0010ë\u0001\u001a\u00020\u000f8\u0016@\u0016X\u0097\u000e¢\u0006\u0018\n\u0006\bë\u0001\u0010Ã\u0001\u001a\u0006\bì\u0001\u0010Å\u0001\"\u0006\bí\u0001\u0010Ç\u0001R+\u0010î\u0001\u001a\u0004\u0018\u00010\t8\u0016@\u0016X\u0097\u000e¢\u0006\u0018\n\u0006\bî\u0001\u0010\u009e\u0001\u001a\u0006\bï\u0001\u0010 \u0001\"\u0006\bð\u0001\u0010¢\u0001R)\u0010ñ\u0001\u001a\u00020\u000f8\u0016@\u0016X\u0097\u000e¢\u0006\u0018\n\u0006\bñ\u0001\u0010Ã\u0001\u001a\u0006\bò\u0001\u0010Å\u0001\"\u0006\bó\u0001\u0010Ç\u0001R1\u0010ô\u0001\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00138\u0016@\u0016X\u0097\u000e¢\u0006\u0018\n\u0006\bô\u0001\u0010±\u0001\u001a\u0006\bõ\u0001\u0010ö\u0001\"\u0006\b÷\u0001\u0010ø\u0001R*\u0010'\u001a\u0005\u0018\u00010ù\u00018\u0016@\u0016X\u0097\u000e¢\u0006\u0017\n\u0005\b'\u0010ú\u0001\u001a\u0006\bû\u0001\u0010ü\u0001\"\u0006\bý\u0001\u0010þ\u0001R\"\u0010\u0080\u0002\u001a\u0005\u0018\u00010ÿ\u00018\u0016X\u0097\u0004¢\u0006\u0010\n\u0006\b\u0080\u0002\u0010\u0081\u0002\u001a\u0006\b\u0082\u0002\u0010\u0083\u0002R)\u0010+\u001a\u0004\u0018\u00010)8\u0016@\u0016X\u0097\u000e¢\u0006\u0017\n\u0005\b+\u0010\u0084\u0002\u001a\u0006\b\u0085\u0002\u0010\u0086\u0002\"\u0006\b\u0087\u0002\u0010\u0088\u0002R)\u0010/\u001a\u0004\u0018\u00010-8\u0016@\u0016X\u0097\u000e¢\u0006\u0017\n\u0005\b/\u0010\u0089\u0002\u001a\u0006\b\u008a\u0002\u0010\u008b\u0002\"\u0006\b\u008c\u0002\u0010\u008d\u0002R\u001c\u0010\u008f\u0002\u001a\u0005\u0018\u00010\u008e\u00028\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0006\b\u008f\u0002\u0010\u0090\u0002R\u001c\u0010\u0092\u0002\u001a\u0005\u0018\u00010\u0091\u00028\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0006\b\u0092\u0002\u0010\u0093\u0002R\u001b\u0010\u0094\u0002\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0006\b\u0094\u0002\u0010\u009e\u0001R\u001c\u0010\u0096\u0002\u001a\u0005\u0018\u00010\u0095\u00028\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0006\b\u0096\u0002\u0010\u0097\u0002R+\u0010\u0098\u0002\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b\u0098\u0002\u0010\u009e\u0001\u001a\u0006\b\u0099\u0002\u0010 \u0001\"\u0006\b\u009a\u0002\u0010¢\u0001R\u001c\u0010\u009c\u0002\u001a\u0005\u0018\u00010\u009b\u00028\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0006\b\u009c\u0002\u0010\u009d\u0002R\u001c\u0010\u009f\u0002\u001a\u0005\u0018\u00010\u009e\u00028\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0006\b\u009f\u0002\u0010 \u0002R+\u0010¡\u0002\u001a\u0004\u0018\u00010\u00148\u0016@\u0016X\u0097\u000e¢\u0006\u0018\n\u0006\b¡\u0002\u0010¢\u0002\u001a\u0006\b£\u0002\u0010¤\u0002\"\u0006\b¥\u0002\u0010¦\u0002R)\u0010§\u0002\u001a\u0002018\u0016@\u0016X\u0097\u000e¢\u0006\u0018\n\u0006\b§\u0002\u0010Î\u0001\u001a\u0006\b¨\u0002\u0010Õ\u0001\"\u0006\b©\u0002\u0010×\u0001R)\u0010ª\u0002\u001a\u0002018\u0016@\u0016X\u0097\u000e¢\u0006\u0018\n\u0006\bª\u0002\u0010Î\u0001\u001a\u0006\b«\u0002\u0010Õ\u0001\"\u0006\b¬\u0002\u0010×\u0001R)\u0010\u00ad\u0002\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u00ad\u0002\u0010¦\u0001\u001a\u0006\b®\u0002\u0010§\u0001\"\u0006\b¯\u0002\u0010©\u0001R)\u0010°\u0002\u001a\u00020\u000f8\u0016@\u0016X\u0097\u000e¢\u0006\u0018\n\u0006\b°\u0002\u0010Ã\u0001\u001a\u0006\b±\u0002\u0010Å\u0001\"\u0006\b²\u0002\u0010Ç\u0001R,\u0010´\u0002\u001a\u0005\u0018\u00010³\u00028\u0016@\u0016X\u0097\u000e¢\u0006\u0018\n\u0006\b´\u0002\u0010µ\u0002\u001a\u0006\b¶\u0002\u0010·\u0002\"\u0006\b¸\u0002\u0010¹\u0002R\u0019\u0010º\u0002\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0006\bº\u0002\u0010Ã\u0001R\u0019\u0010»\u0002\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0006\b»\u0002\u0010Ã\u0001R)\u0010¼\u0002\u001a\u00020\u000f8\u0016@\u0016X\u0097\u000e¢\u0006\u0018\n\u0006\b¼\u0002\u0010Ã\u0001\u001a\u0006\b½\u0002\u0010Å\u0001\"\u0006\b¾\u0002\u0010Ç\u0001R,\u0010À\u0002\u001a\u0005\u0018\u00010¿\u00028\u0016@\u0016X\u0097\u000e¢\u0006\u0018\n\u0006\bÀ\u0002\u0010Á\u0002\u001a\u0006\bÂ\u0002\u0010Ã\u0002\"\u0006\bÄ\u0002\u0010Å\u0002R!\u0010Æ\u0002\u001a\n\u0012\u0004\u0012\u000201\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0006\bÆ\u0002\u0010±\u0001R)\u0010Ç\u0002\u001a\u00020\u000f8\u0016@\u0016X\u0097\u000e¢\u0006\u0018\n\u0006\bÇ\u0002\u0010Ã\u0001\u001a\u0006\bÈ\u0002\u0010Å\u0001\"\u0006\bÉ\u0002\u0010Ç\u0001R,\u0010Ë\u0002\u001a\u0005\u0018\u00010Ê\u00028\u0016@\u0016X\u0097\u000e¢\u0006\u0018\n\u0006\bË\u0002\u0010Ì\u0002\u001a\u0006\bÍ\u0002\u0010Î\u0002\"\u0006\bÏ\u0002\u0010Ð\u0002R\u0019\u0010Ñ\u0002\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0006\bÑ\u0002\u0010Ã\u0001R,\u0010Ó\u0002\u001a\u0005\u0018\u00010Ò\u00028\u0016@\u0016X\u0097\u000e¢\u0006\u0018\n\u0006\bÓ\u0002\u0010Ô\u0002\u001a\u0006\bÕ\u0002\u0010Ö\u0002\"\u0006\b×\u0002\u0010Ø\u0002R)\u0010Ù\u0002\u001a\u00020\u00078\u0016@\u0016X\u0097\u000e¢\u0006\u0018\n\u0006\bÙ\u0002\u0010¦\u0001\u001a\u0006\bÙ\u0002\u0010§\u0001\"\u0006\bÚ\u0002\u0010©\u0001R\u0019\u0010Û\u0002\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÛ\u0002\u0010Ã\u0001R!\u0010Ü\u0002\u001a\n\u0012\u0004\u0012\u00020B\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0006\bÜ\u0002\u0010±\u0001R)\u0010Ý\u0002\u001a\u00020\u000f8\u0016@\u0016X\u0097\u000e¢\u0006\u0018\n\u0006\bÝ\u0002\u0010Ã\u0001\u001a\u0006\bÞ\u0002\u0010Å\u0001\"\u0006\bß\u0002\u0010Ç\u0001R+\u0010à\u0002\u001a\u0004\u0018\u00010\u00148\u0016@\u0016X\u0097\u000e¢\u0006\u0018\n\u0006\bà\u0002\u0010¢\u0002\u001a\u0006\bá\u0002\u0010¤\u0002\"\u0006\bâ\u0002\u0010¦\u0002R\u001b\u0010ã\u0002\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0006\bã\u0002\u0010¢\u0002R\u001b\u0010ä\u0002\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0006\bä\u0002\u0010¢\u0002R+\u0010å\u0002\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\bå\u0002\u0010\u009e\u0001\u001a\u0006\bæ\u0002\u0010 \u0001\"\u0006\bç\u0002\u0010¢\u0001R1\u0010è\u0002\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00138\u0016@\u0016X\u0097\u000e¢\u0006\u0018\n\u0006\bè\u0002\u0010±\u0001\u001a\u0006\bé\u0002\u0010ö\u0001\"\u0006\bê\u0002\u0010ø\u0001R)\u0010ë\u0002\u001a\u0002018\u0016@\u0016X\u0097\u000e¢\u0006\u0018\n\u0006\bë\u0002\u0010Î\u0001\u001a\u0006\bì\u0002\u0010Õ\u0001\"\u0006\bí\u0002\u0010×\u0001R)\u0010î\u0002\u001a\u0002018\u0016@\u0016X\u0097\u000e¢\u0006\u0018\n\u0006\bî\u0002\u0010Î\u0001\u001a\u0006\bï\u0002\u0010Õ\u0001\"\u0006\bð\u0002\u0010×\u0001R)\u0010ñ\u0002\u001a\u00020\u00078\u0016@\u0016X\u0097\u000e¢\u0006\u0018\n\u0006\bñ\u0002\u0010¦\u0001\u001a\u0006\bñ\u0002\u0010§\u0001\"\u0006\bò\u0002\u0010©\u0001R+\u0010ó\u0002\u001a\u0004\u0018\u00010\t8\u0016@\u0016X\u0097\u000e¢\u0006\u0018\n\u0006\bó\u0002\u0010\u009e\u0001\u001a\u0006\bô\u0002\u0010 \u0001\"\u0006\bõ\u0002\u0010¢\u0001R)\u0010ö\u0002\u001a\u00020\u000f8\u0016@\u0016X\u0097\u000e¢\u0006\u0018\n\u0006\bö\u0002\u0010Ã\u0001\u001a\u0006\b÷\u0002\u0010Å\u0001\"\u0006\bø\u0002\u0010Ç\u0001R,\u0010ú\u0002\u001a\u0005\u0018\u00010ù\u00028\u0016@\u0016X\u0097\u000e¢\u0006\u0018\n\u0006\bú\u0002\u0010û\u0002\u001a\u0006\bü\u0002\u0010ý\u0002\"\u0006\bþ\u0002\u0010ÿ\u0002R,\u0010\u0081\u0003\u001a\u0005\u0018\u00010\u0080\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0018\n\u0006\b\u0081\u0003\u0010\u0082\u0003\u001a\u0006\b\u0083\u0003\u0010\u0084\u0003\"\u0006\b\u0085\u0003\u0010\u0086\u0003R1\u0010\u0087\u0003\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00138\u0016@\u0016X\u0097\u000e¢\u0006\u0018\n\u0006\b\u0087\u0003\u0010±\u0001\u001a\u0006\b\u0088\u0003\u0010ö\u0001\"\u0006\b\u0089\u0003\u0010ø\u0001R!\u0010\u008a\u0003\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0006\b\u008a\u0003\u0010±\u0001R+\u0010\u008b\u0003\u001a\u0004\u0018\u00010\t8\u0016@\u0016X\u0097\u000e¢\u0006\u0018\n\u0006\b\u008b\u0003\u0010\u009e\u0001\u001a\u0006\b\u008c\u0003\u0010 \u0001\"\u0006\b\u008d\u0003\u0010¢\u0001R,\u0010\u008f\u0003\u001a\u0005\u0018\u00010\u008e\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0018\n\u0006\b\u008f\u0003\u0010\u0090\u0003\u001a\u0006\b\u0091\u0003\u0010\u0092\u0003\"\u0006\b\u0093\u0003\u0010\u0094\u0003R+\u0010\u0095\u0003\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b\u0095\u0003\u0010\u0096\u0003\u001a\u0006\b\u0097\u0003\u0010\u0098\u0003\"\u0006\b\u0099\u0003\u0010\u009a\u0003R)\u0010\u009b\u0003\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u009b\u0003\u0010¦\u0001\u001a\u0006\b\u009b\u0003\u0010§\u0001\"\u0006\b\u009c\u0003\u0010©\u0001R\u0019\u0010\u009d\u0003\u001a\u0002018\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0006\b\u009d\u0003\u0010Î\u0001R,\u0010\u009f\u0003\u001a\u0005\u0018\u00010\u009e\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0018\n\u0006\b\u009f\u0003\u0010 \u0003\u001a\u0006\b¡\u0003\u0010¢\u0003\"\u0006\b£\u0003\u0010¤\u0003R\u001c\u0010¦\u0003\u001a\u0005\u0018\u00010¥\u00038\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0006\b¦\u0003\u0010§\u0003R,\u0010©\u0003\u001a\u0005\u0018\u00010¨\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0018\n\u0006\b©\u0003\u0010ª\u0003\u001a\u0006\b«\u0003\u0010¬\u0003\"\u0006\b\u00ad\u0003\u0010®\u0003R+\u0010¯\u0003\u001a\u0004\u0018\u00010\t8\u0016@\u0016X\u0097\u000e¢\u0006\u0018\n\u0006\b¯\u0003\u0010\u009e\u0001\u001a\u0006\b°\u0003\u0010 \u0001\"\u0006\b±\u0003\u0010¢\u0001R\u001b\u0010²\u0003\u001a\u0004\u0018\u00010B8\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0006\b²\u0003\u0010³\u0003R+\u0010´\u0003\u001a\u0004\u0018\u00010\u00148\u0016@\u0016X\u0097\u000e¢\u0006\u0018\n\u0006\b´\u0003\u0010¢\u0002\u001a\u0006\bµ\u0003\u0010¤\u0002\"\u0006\b¶\u0003\u0010¦\u0002R)\u0010·\u0003\u001a\u00020\u000f8\u0016@\u0016X\u0097\u000e¢\u0006\u0018\n\u0006\b·\u0003\u0010Ã\u0001\u001a\u0006\b¸\u0003\u0010Å\u0001\"\u0006\b¹\u0003\u0010Ç\u0001R+\u0010º\u0003\u001a\u0004\u0018\u00010\t8\u0016@\u0016X\u0097\u000e¢\u0006\u0018\n\u0006\bº\u0003\u0010\u009e\u0001\u001a\u0006\b»\u0003\u0010 \u0001\"\u0006\b¼\u0003\u0010¢\u0001R)\u0010½\u0003\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b½\u0003\u0010¦\u0001\u001a\u0006\b¾\u0003\u0010§\u0001\"\u0006\b¿\u0003\u0010©\u0001R+\u0010À\u0003\u001a\u0004\u0018\u00010k8\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\bÀ\u0003\u0010Á\u0003\u001a\u0006\bÂ\u0003\u0010Ã\u0003\"\u0006\bÄ\u0003\u0010Å\u0003R\u0019\u00106\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b6\u0010\u009e\u0001R\u0019\u00108\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b8\u0010\u009e\u0001R\u0019\u0010:\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b:\u0010\u009e\u0001R'\u0010>\u001a\u00020\u00078\u0016@\u0016X\u0097\u000e¢\u0006\u0017\n\u0005\b>\u0010¦\u0001\u001a\u0006\bÆ\u0003\u0010§\u0001\"\u0006\bÇ\u0003\u0010©\u0001R)\u0010È\u0003\u001a\u00020\u00078\u0016@\u0016X\u0097\u000e¢\u0006\u0018\n\u0006\bÈ\u0003\u0010¦\u0001\u001a\u0006\bÉ\u0003\u0010§\u0001\"\u0006\bÊ\u0003\u0010©\u0001R\u0017\u0010P\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bP\u0010¦\u0001R\u0019\u0010u\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bu\u0010\u009e\u0001R\u0019\u0010x\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bx\u0010\u009e\u0001R)\u0010Ë\u0003\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bË\u0003\u0010Ã\u0001\u001a\u0006\bÌ\u0003\u0010Å\u0001\"\u0006\bÍ\u0003\u0010Ç\u0001R)\u0010Î\u0003\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÎ\u0003\u0010Ã\u0001\u001a\u0006\bÏ\u0003\u0010Å\u0001\"\u0006\bÐ\u0003\u0010Ç\u0001R.\u0010Ô\u0003\u001a\u0004\u0018\u00010\t2\t\u0010Ñ\u0003\u001a\u0004\u0018\u00010\t8V@VX\u0096\u000e¢\u0006\u0010\u001a\u0006\bÒ\u0003\u0010 \u0001\"\u0006\bÓ\u0003\u0010¢\u0001R.\u0010×\u0003\u001a\u0004\u0018\u00010\t2\t\u0010Ñ\u0003\u001a\u0004\u0018\u00010\t8V@VX\u0096\u000e¢\u0006\u0010\u001a\u0006\bÕ\u0003\u0010 \u0001\"\u0006\bÖ\u0003\u0010¢\u0001R*\u0010Û\u0003\u001a\u00020\t2\u0007\u0010Ø\u0003\u001a\u00020\t8V@VX\u0096\u000e¢\u0006\u0010\u001a\u0006\bÙ\u0003\u0010 \u0001\"\u0006\bÚ\u0003\u0010¢\u0001R\u0014\u0010Ü\u0003\u001a\u00020\u00078F¢\u0006\b\u001a\u0006\bÜ\u0003\u0010§\u0001R\u0014\u0010Ý\u0003\u001a\u00020\u00078F¢\u0006\b\u001a\u0006\bÝ\u0003\u0010§\u0001R\u0016\u0010ß\u0003\u001a\u0004\u0018\u00010\t8F¢\u0006\b\u001a\u0006\bÞ\u0003\u0010 \u0001R\u0014\u0010á\u0003\u001a\u00020\t8F¢\u0006\b\u001a\u0006\bà\u0003\u0010 \u0001¨\u0006ç\u0003"}, d2 = {"Lcom/bytedance/android/live/base/model/user/User;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "Lcom/bytedance/android/live/base/model/user/IUser;", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomAuthStatus;", "roomAuthStatus", "", "shouldUseHostInfo", "", "getIdStr", "idStr", "", "setIdStr", "isMysteryMan", "", "type", "setSearchType", "getSearchType", "", "Lpy/k;", "getBadgeImageListV2", "", "badgeImageList", "setBadgeImageListV2", "Lcom/bytedance/android/live/base/model/user/j;", "getCommonVipInfo", "info", "setCommonVipInfo", "isVcdContentAuthorized", "isVcdRelationAuthorized", "isVcdAdversaryContentAuthorized", "isVcdAdversaryRelationAuthorized", "contentAuthorized", "relationAuthorized", "setVcdAdversaryAuthorizeState", "getBadgeImageList", "Lpy/j;", "getFollowInfoExt", "followInfo", "setFollowInfoExt", "Lpy/t;", "getUserAttrExt", "userAttr", "setUserAttrExt", "Lpy/b;", "getAnchorInfoExt", "anchorInfo", "setAnchorInfoExt", "", "getPayScores", "payScores", "setPayScores", "childrenManagerForbidCreateLiveRoom", "mAvatarThumbStr", "setAvatarThumbStr", "mAvatarMediumStr", "setAVatarMediumStr", "mAvatarLargeStr", "setAvatarLargeStr", "isEnableShowFansClubReverse", "isWithCommercePermission", "enableShowCommerceSale", "setWithCommercePermission", "followStatus", "setFollowStatus", "Lcom/bytedance/android/live/base/model/ImageModel;", "getAvatarThumb", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "setAvatarThumbImplicit", "getAvatarMedium", "avatarMedium", "setAvatarMedium", "setAvatarMediumImplicit", "getAvatarLarge", "avatarLarge", "setAvatarLarge", "setAvatarLargeImplicit", "getLocationCity", "isShouldUseRealName", "shouldUseRealName", "setShouldUseRealName", "isRoomAnchor", "getProperNickName", "getRealNickName", "getPrivilegeLevel", "getCastSecUid", "secUid", "setCastSecUid", "getLiveRoomId", "canJumpToLiveRoom", "getNewUserBadges", "getIdStrKt", "getAvatarUrl", "url", "setAvatarUrl", "getUserWatchMonthValid", "enable", "setUserWatchMonthValid", "level", "setCommerceUserLevel", "getCommerceUserLevel", "getEnterprise", "enterPrise", "setEnterprise", "getRoomAutoGiftThanks", "getEncryptedId", "Lpy/o;", "getOwnRoom", "newUserBadges", "setNewUserBadges", "o", "initWith", "cloneFrom", "equals", "hashCode", "getRequestId", "requestId", "setRequestId", "getLogPb", "logPb", "setLogPb", "childrenManagerForbidWalletFunctions", "isFollowing", "isEnterpriseVerify", "Lcom/bytedance/android/live/base/model/user/HostInfo;", "getHostInfo", "hostInfo", "setHostInfo", "userId", "setUserId", "getUserId", "Lcom/bytedance/android/livesdkapi/depend/model/live/RoomAuthStatus;", "getAvatarThumbByRoomAuth", "getNickNameByRoomAuth", "getRealNickNameByRoomAuth", "getSignatureByRoomAuth", "getFollowInfoByRoomAuth", "isFollowingByRoomAuth", "getAvatarLargeByRoomAuth", "getGenderByRoomAuth", "toString", "getRemarkNameOrRealNickName", "getBadgeImageListV2Ext", "getRemarkNameOrNickname", "isSubscriber", "getRelationship", "getUserAttrFlex", "Lcom/bytedance/android/live/base/model/user/o0;", "getUserIdCompat", "assignUserId", "Lcom/bytedance/android/live/base/model/user/m0;", "extraInfo", "Lcom/bytedance/android/live/base/model/user/m0;", "Lcom/bytedance/android/live/base/model/user/PublicAreaBadgeInfo;", "publicAreaBadgeInfo", "Lcom/bytedance/android/live/base/model/user/PublicAreaBadgeInfo;", CommonConstant.KEY_UNION_ID, "Ljava/lang/String;", "getUnionId", "()Ljava/lang/String;", "setUnionId", "(Ljava/lang/String;)V", "_hostInfo", "Lcom/bytedance/android/live/base/model/user/HostInfo;", "isHideHostInfoForProfile", "Z", "()Z", "setHideHostInfoForProfile", "(Z)V", "Lcom/bytedance/android/live/base/model/user/XiguaParams;", "xiguaInfo", "Lcom/bytedance/android/live/base/model/user/XiguaParams;", "Lcom/bytedance/android/live/base/model/vip/UserVipInfo;", "userVipInfo", "Lcom/bytedance/android/live/base/model/vip/UserVipInfo;", "_badgeImageList", "Ljava/util/List;", "_webcastUid", "get_webcastUid", "set_webcastUid", "_nickName", "get_nickName", "set_nickName", "safeNicName", "getSafeNicName", "setSafeNicName", "Lpy/q;", "poiInfo", "Lpy/q;", "getPoiInfo", "()Lpy/q;", "setPoiInfo", "(Lpy/q;)V", "gender", "I", "getGender", "()I", "setGender", "(I)V", "signature", "getSignature", "setSignature", "getLevel", "setLevel", "id", "J", "userOpenId", "_idStr", "getSecUid", "setSecUid", "createTime", "getCreateTime", "()J", "setCreateTime", "(J)V", "city", "getCity", "setCity", "_locationCity", "birthday", "getBirthday", "setBirthday", "telephone", "getTelephone", "setTelephone", "experience", "getExperience", "setExperience", "status", "getStatus", "setStatus", "modifyTime", "getModifyTime", "setModifyTime", "secret", "getSecret", "setSecret", "shareQrcodeUri", "getShareQrcodeUri", "setShareQrcodeUri", "incomeSharePercent", "getIncomeSharePercent", "setIncomeSharePercent", "mediaBadgeImageList", "getMediaBadgeImageList", "()Ljava/util/List;", "setMediaBadgeImageList", "(Ljava/util/List;)V", "Lcom/bytedance/android/live/base/model/user/FollowInfo;", "Lcom/bytedance/android/live/base/model/user/FollowInfo;", "getFollowInfo", "()Lcom/bytedance/android/live/base/model/user/FollowInfo;", "setFollowInfo", "(Lcom/bytedance/android/live/base/model/user/FollowInfo;)V", "Lcom/bytedance/android/live/base/model/user/e;", "bottomEntry", "Lcom/bytedance/android/live/base/model/user/e;", "getBottomEntry", "()Lcom/bytedance/android/live/base/model/user/e;", "Lpy/t;", "getUserAttr", "()Lpy/t;", "setUserAttr", "(Lpy/t;)V", "Lpy/b;", "getAnchorInfo", "()Lpy/b;", "setAnchorInfo", "(Lpy/b;)V", "Lcom/bytedance/android/live/base/model/user/FansGroupInfo;", "fansGroupInfo", "Lcom/bytedance/android/live/base/model/user/FansGroupInfo;", "Lcom/bytedance/android/live/base/model/user/d;", "bizRelation", "Lcom/bytedance/android/live/base/model/user/d;", "verifiedContent", "Lcom/bytedance/android/live/base/model/user/Author;", "authorInfo", "Lcom/bytedance/android/live/base/model/user/Author;", "_encryptedId", "get_encryptedId", "set_encryptedId", "Lcom/bytedance/android/live/base/model/user/a;", "rewardInfo", "Lcom/bytedance/android/live/base/model/user/a;", "Lcom/bytedance/android/live/base/model/user/NobleLevelInfo;", "nobleLevelInfo", "Lcom/bytedance/android/live/base/model/user/NobleLevelInfo;", "personalCard", "Lpy/k;", "getPersonalCard", "()Lpy/k;", "setPersonalCard", "(Lpy/k;)V", "userWatchMonth", "getUserWatchMonth", "setUserWatchMonth", "publicScreenOperateFreq", "getPublicScreenOperateFreq", "setPublicScreenOperateFreq", "_userWatchMonthValid", "get_userWatchMonthValid", "set_userWatchMonthValid", "mysteryMan", "getMysteryMan", "setMysteryMan", "Lcom/bytedance/android/live/base/model/user/x;", "industryCertification", "Lcom/bytedance/android/live/base/model/user/x;", "getIndustryCertification", "()Lcom/bytedance/android/live/base/model/user/x;", "setIndustryCertification", "(Lcom/bytedance/android/live/base/model/user/x;)V", "authorizationInfo", "adversaryAuthorizationInfo", "adversaryUserStatus", "getAdversaryUserStatus", "setAdversaryUserStatus", "Lpy/c;", "mAuthenticationInfo", "Lpy/c;", "getMAuthenticationInfo", "()Lpy/c;", "setMAuthenticationInfo", "(Lpy/c;)V", "commerceConfigIds", CommonConstant.KEY_AGE_RANGE, "getAgeRange", "setAgeRange", "Lcom/bytedance/android/live/base/model/user/g0;", "subscribe", "Lcom/bytedance/android/live/base/model/user/g0;", "getSubscribe", "()Lcom/bytedance/android/live/base/model/user/g0;", "setSubscribe", "(Lcom/bytedance/android/live/base/model/user/g0;)V", "consumeDiamondLevel", "Lcom/bytedance/android/live/base/model/user/d0;", "profileStyleParams", "Lcom/bytedance/android/live/base/model/user/d0;", "getProfileStyleParams", "()Lcom/bytedance/android/live/base/model/user/d0;", "setProfileStyleParams", "(Lcom/bytedance/android/live/base/model/user/d0;)V", "isAnonymous", "setAnonymous", "searchType", "_badgeImageListV2", "userRole", "getUserRole", "setUserRole", "avatarThumbKt", "getAvatarThumbKt", "setAvatarThumbKt", "_avatarMedium", "_avatarLarge", "_avatarUrl", "get_avatarUrl", "set_avatarUrl", "topFans", "getTopFans", "setTopFans", "shortId", "getShortId", "setShortId", "fanTicketCount", "getFanTicketCount", "setFanTicketCount", "isVerified", "setVerified", "verifiedReason", "getVerifiedReason", "setVerifiedReason", "topVipNo", "getTopVipNo", "setTopVipNo", "Lpy/d;", "userHonor", "Lpy/d;", "getUserHonor", "()Lpy/d;", "setUserHonor", "(Lpy/d;)V", "Lcom/bytedance/android/live/base/model/user/api/IAnchorLevel;", "anchorLevel", "Lcom/bytedance/android/live/base/model/user/api/IAnchorLevel;", "getAnchorLevel", "()Lcom/bytedance/android/live/base/model/user/api/IAnchorLevel;", "setAnchorLevel", "(Lcom/bytedance/android/live/base/model/user/api/IAnchorLevel;)V", "userBadges", "getUserBadges", "setUserBadges", "_newUserBadges", "displayId", "getDisplayId", "setDisplayId", "Lcom/bytedance/android/live/base/model/user/l0;", "dressInfo", "Lcom/bytedance/android/live/base/model/user/l0;", "getDressInfo", "()Lcom/bytedance/android/live/base/model/user/l0;", "setDressInfo", "(Lcom/bytedance/android/live/base/model/user/l0;)V", "_anchorCommonVip", "Lcom/bytedance/android/live/base/model/user/j;", "get_anchorCommonVip", "()Lcom/bytedance/android/live/base/model/user/j;", "set_anchorCommonVip", "(Lcom/bytedance/android/live/base/model/user/j;)V", "isNeverRecharge", "setNeverRecharge", "_payScores", "Lcom/bytedance/android/live/base/model/user/t;", "fansClub", "Lcom/bytedance/android/live/base/model/user/t;", "getFansClub", "()Lcom/bytedance/android/live/base/model/user/t;", "setFansClub", "(Lcom/bytedance/android/live/base/model/user/t;)V", "Lcom/bytedance/android/live/base/model/user/FraternityInfo;", "fraternityInfo", "Lcom/bytedance/android/live/base/model/user/FraternityInfo;", "Lcom/bytedance/android/live/base/model/user/BorderInfo;", "border", "Lcom/bytedance/android/live/base/model/user/BorderInfo;", "getBorder", "()Lcom/bytedance/android/live/base/model/user/BorderInfo;", "setBorder", "(Lcom/bytedance/android/live/base/model/user/BorderInfo;)V", "specialId", "getSpecialId", "setSpecialId", "avatarBorder", "Lcom/bytedance/android/live/base/model/ImageModel;", "medal", "getMedal", "setMedal", "linkMicStats", "getLinkMicStats", "setLinkMicStats", "backgroundImgUrl", "getBackgroundImgUrl", "setBackgroundImgUrl", "_roomAutoGiftThanks", "get_roomAutoGiftThanks", "set_roomAutoGiftThanks", "_ownRoom", "Lpy/o;", "get_ownRoom", "()Lpy/o;", "set_ownRoom", "(Lpy/o;)V", "getEnableShowCommerceSale", "setEnableShowCommerceSale", "enableCarManagementPermission", "getEnableCarManagementPermission", "setEnableCarManagementPermission", "_commerceUserLevel", "get_commerceUserLevel", "set_commerceUserLevel", "_enterprise", "get_enterprise", "set_enterprise", "value", "getWebcastUid", "setWebcastUid", "webcastUid", "getNickName", "setNickName", "nickName", "s", "getIdString", "setIdString", "idString", "isCustomVerify", "isVerifyUser", "getRemarkName", "remarkName", "getFollowRelationship", "followRelationship", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "OwnRoom", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public class User extends FlexModelBase<IBaseUser> implements IUser, IBaseUser, vh7.h {
    public static final a Companion = null;
    public static final int FOLLOW_APPLY_ING = 4;
    public static final int FOLLOW_BACK = 3;
    public static final int FOLLOW_EACH_OTHER = 2;
    private static final int HASH_CODE_31 = 31;
    private static final int HASH_CODE_32 = 32;
    public static final int HAS_FOLLOWED = 1;
    public static final int MYSTERY_MAN_MYSTERIOUS_MAN = 2;
    public static final int MYSTERY_MAN_NORMAL = 1;
    public static final int MYSTERY_MAN_UNKNOWN = 0;
    public static final int NOT_FOLLOWING = 0;
    public static final int REALNAME_UNVERIFIED = 0;
    public static final int REALNAME_VERIFIED = 1;

    @IgnoreProtoFieldCheck
    @SerializedName("member_entrance_info")
    protected j _anchorCommonVip;

    @SerializedName("avatar_large")
    public py.k _avatarLarge;

    @SerializedName("avatar_medium")
    public py.k _avatarMedium;

    @SerializedName("avatar_url")
    @IgnoreProtoDecode
    private String _avatarUrl;

    @SerializedName("badge_image_list")
    public List<ImageModel> _badgeImageList;

    @SerializedName("badge_image_list_v2")
    public List<ImageModel> _badgeImageListV2;
    private int _commerceUserLevel;

    @SerializedName("encrypted_id")
    @IgnoreProtoDecode
    private String _encryptedId;
    private int _enterprise;

    @SerializedName("host_info")
    protected HostInfo _hostInfo;

    @SerializedName("id_str")
    protected String _idStr;

    @SerializedName("location_city")
    public String _locationCity;

    @IgnoreProtoFieldCheck
    @SerializedName("new_real_time_icons")
    public List<py.k> _newUserBadges;

    @SerializedName(InstantPlayContext.NICKNAME)
    protected String _nickName;

    @IgnoreProtoFieldCheck
    @SerializedName("own_room")
    protected py.o _ownRoom;

    @IgnoreProtoFieldCheck
    @SerializedName("total_recharge_diamond_count")
    public long _payScores;

    @SerializedName("room_auto_gift_thanks")
    @IgnoreProtoDecode
    private boolean _roomAutoGiftThanks;
    private boolean _userWatchMonthValid;

    @SerializedName("webcast_uid")
    protected String _webcastUid;

    @SerializedName("adversary_authorization_info")
    public int adversaryAuthorizationInfo;

    @IgnoreProtoFieldCheck
    @SerializedName("adversary_user_status")
    protected int adversaryUserStatus;

    @IgnoreProtoFieldCheck
    @SerializedName("age_range")
    protected int ageRange;

    @IgnoreProtoFieldCheck
    @SerializedName("anchor_info")
    protected py.b anchorInfo;

    @IgnoreProtoFieldCheck
    @SerializedName("webcast_anchor_level")
    protected IAnchorLevel anchorLevel;

    @IgnoreProtoFieldCheck
    @SerializedName("author_stats")
    public Author authorInfo;

    @SerializedName("authorization_info")
    public int authorizationInfo;

    @IgnoreProtoFieldCheck
    @SerializedName("avatar_border")
    public ImageModel avatarBorder;

    @SerializedName("avatar_thumb")
    protected py.k avatarThumbKt;

    @IgnoreProtoFieldCheck
    @SerializedName("bg_img_url")
    protected String backgroundImgUrl;

    @IgnoreProtoFieldCheck
    @SerializedName("birthday")
    protected long birthday;

    @SerializedName("biz_relation")
    public d bizRelation;

    @IgnoreProtoFieldCheck
    @SerializedName("border")
    protected BorderInfo border;

    @SerializedName("bottom_entry")
    protected e bottomEntry;

    @SerializedName("city")
    protected String city;

    @IgnoreProtoFieldCheck
    @SerializedName("commerce_webcast_config_ids")
    public List<Long> commerceConfigIds;

    @SerializedName("consume_diamond_level")
    public int consumeDiamondLevel;

    @IgnoreProtoFieldCheck
    @SerializedName("create_time")
    protected long createTime;

    @IgnoreProtoFieldCheck
    @SerializedName("display_id")
    protected String displayId;

    @SerializedName("user_dress_info")
    protected l0 dressInfo;

    @IgnoreProtoFieldCheck
    @SerializedName("with_car_management_permission")
    protected boolean enableCarManagementPermission;

    @IgnoreProtoFieldCheck
    @SerializedName("with_commerce_permission")
    protected boolean enableShowCommerceSale;

    @IgnoreProtoFieldCheck
    @SerializedName("experience")
    protected int experience;

    @SerializedName("extra_info")
    public m0 extraInfo;

    @IgnoreProtoFieldCheck
    @SerializedName("ticket_count")
    protected long fanTicketCount;

    @IgnoreProtoFieldCheck
    @SerializedName(PbRequest.SwitchType.FANS_CLUB)
    protected t fansClub;

    @IgnoreProtoFieldCheck
    @SerializedName("fans_group_info")
    public FansGroupInfo fansGroupInfo;

    @SerializedName("follow_info")
    protected FollowInfo followInfo;

    @IgnoreProtoFieldCheck
    @SerializedName("brotherhood_info")
    public FraternityInfo fraternityInfo;

    @IgnoreProtoFieldCheck
    @SerializedName("gender")
    protected int gender;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    public long f58939id;

    @IgnoreProtoFieldCheck
    @SerializedName("income_share_percent")
    protected int incomeSharePercent;

    @SerializedName("industry_certification")
    protected x industryCertification;

    @IgnoreProtoFieldCheck
    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_IS_ANONYMOUS)
    protected boolean isAnonymous;
    private boolean isHideHostInfoForProfile;
    private transient boolean isNeverRecharge;

    @IgnoreProtoFieldCheck
    @SerializedName("verified")
    protected boolean isVerified;

    @IgnoreProtoFieldCheck
    @SerializedName("level")
    protected int level;

    @IgnoreProtoFieldCheck
    @SerializedName("link_mic_stats")
    protected int linkMicStats;
    private String logPb;

    @IgnoreProtoFieldCheck
    @SerializedName("authentication_info")
    protected py.c mAuthenticationInfo;
    private String mAvatarLargeStr;
    private String mAvatarMediumStr;
    private String mAvatarThumbStr;

    @IgnoreProtoFieldCheck
    @SerializedName("medal")
    protected py.k medal;

    @IgnoreProtoFieldCheck
    @SerializedName("media_badge_image_list")
    protected List<py.k> mediaBadgeImageList;

    @IgnoreProtoFieldCheck
    @SerializedName("modify_time")
    protected long modifyTime;

    @SerializedName("mystery_man")
    protected int mysteryMan;

    @IgnoreProtoFieldCheck
    @SerializedName("noble_info")
    public NobleLevelInfo nobleLevelInfo;

    @IgnoreProtoFieldCheck
    @SerializedName("personal_card")
    protected py.k personalCard;

    @IgnoreProtoFieldCheck
    @SerializedName("poi_info")
    protected py.q poiInfo;

    @SerializedName("profile_style_params")
    protected d0 profileStyleParams;

    @SerializedName("public_area_badge_info")
    public PublicAreaBadgeInfo publicAreaBadgeInfo;

    @IgnoreProtoFieldCheck
    @SerializedName("public_area_oper_freq")
    protected long publicScreenOperateFreq;
    private String requestId;

    @IgnoreProtoFieldCheck
    @SerializedName("activity_reward")
    public com.bytedance.android.live.base.model.user.a rewardInfo;

    @SerializedName("desensitized_nickname")
    protected String safeNicName;
    private int searchType;

    @SerializedName("sec_uid")
    protected String secUid;

    @IgnoreProtoFieldCheck
    @SerializedName("secret")
    protected int secret;

    @IgnoreProtoFieldCheck
    @SerializedName("share_qrcode_uri")
    protected String shareQrcodeUri;

    @IgnoreProtoFieldCheck
    @SerializedName("short_id")
    protected long shortId;
    private boolean shouldUseRealName;

    @SerializedName("signature")
    protected String signature;

    @IgnoreProtoFieldCheck
    @SerializedName("special_id")
    protected String specialId;

    @IgnoreProtoFieldCheck
    @SerializedName("status")
    protected int status;

    @SerializedName("subscribe")
    protected g0 subscribe;

    @IgnoreProtoFieldCheck
    @SerializedName("telephone")
    protected String telephone;

    @IgnoreProtoFieldCheck
    @SerializedName("top_fans")
    protected List<IBaseUser> topFans;

    @IgnoreProtoFieldCheck
    @SerializedName("top_vip_no")
    protected int topVipNo;
    private String unionId;

    @IgnoreProtoFieldCheck
    @SerializedName("user_attr")
    protected py.t userAttr;

    @IgnoreProtoFieldCheck
    @SerializedName("real_time_icons")
    protected List<py.k> userBadges;

    @IgnoreProtoFieldCheck
    @SerializedName("pay_grade")
    protected py.d userHonor;

    @SerializedName("user_open_id")
    public String userOpenId;

    @IgnoreProtoFieldCheck
    @SerializedName("user_role")
    protected int userRole;
    public UserVipInfo userVipInfo;

    @IgnoreProtoFieldCheck
    @SerializedName("watch_duration_month")
    protected long userWatchMonth;

    @IgnoreProtoFieldCheck
    @SerializedName("verified_content")
    public String verifiedContent;

    @IgnoreProtoFieldCheck
    @SerializedName("verified_reason")
    protected String verifiedReason;

    @SerializedName("xigua_info")
    public XiguaParams xiguaInfo;

    @ProtoMessage("webcast.data.User.OwnRoom")
    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\u0006\u0010\u0004\u001a\u00020\u0003J\b\u0010\u0006\u001a\u00020\u0005H\u0016R*\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00078\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR*\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00078\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\t\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR*\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00078\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\t\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/live/base/model/user/User$OwnRoom;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lpy/o;", "", "canJumpToLiveRoom", "", "getId", "", "roomIdList", "Ljava/util/List;", "getRoomIdList", "()Ljava/util/List;", "setRoomIdList", "(Ljava/util/List;)V", "", "roomIdStrList", "getRoomIdStrList", "setRoomIdStrList", "", "roomIdDisplay", "getRoomIdDisplay", "setRoomIdDisplay", "<init>", "()V", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class OwnRoom extends FlexModelBase<py.o> implements py.o, vh7.h {

        @SerializedName("room_ids_display")
        protected List<Integer> roomIdDisplay;

        @SerializedName("room_ids")
        protected List<Long> roomIdList;

        @SerializedName("room_ids_str")
        protected List<String> roomIdStrList;

        public OwnRoom() {
            super(py.o.class);
        }

        public final boolean canJumpToLiveRoom() {
            if (Lists.isEmpty(getRoomIdDisplay()) == true) goto L7;
            List<Integer> r100 = getRoomIdDisplay();
            Intrinsics.checkNotNull(r100);
            if (((Number) ListProtector.get(r100, 0)).intValue() != 0) goto L7;
            return false;
        L7:
            return true;
        }

        @Override // py.o, py.p
        public long getId() {
            if (Lists.isEmpty(getRoomIdList()) == false) goto L5;
            return 0;
        L5:
            List<Long> r100 = getRoomIdList();
            Intrinsics.checkNotNull(r100);
            return ((Number) ListProtector.get(r100, 0)).longValue();
        }

        @Override // py.o
        public List<Integer> getRoomIdDisplay() {
            return this.roomIdDisplay;
        }

        @Override // py.o
        public List<Long> getRoomIdList() {
            return this.roomIdList;
        }

        @Override // py.o, py.p
        public List<String> getRoomIdStrList() {
            return this.roomIdStrList;
        }

        public OwnRoom(am3.g r100) {
            super(py.o.class);
            this.roomIdList = new ArrayList();
            this.roomIdStrList = new ArrayList();
            this.roomIdDisplay = new ArrayList();
            setThreadSafe(false);
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L16;
            am3.g.a r103 = decodeExtensionFields(r102, r100);
            if (r102 == 1) goto L14;
            if (r102 == 2) goto L13;
            if (r102 != 3) goto L11;
            List r104 = this.roomIdDisplay;
            Comparable r105 = Integer.valueOf(r100.i());
        L15:
            r104.add(r105);
            goto L3
        L11:
            am3.h.d(r103, r100);
            goto L3
        L13:
            r104 = this.roomIdStrList;
            r105 = am3.h.c(r100);
            goto L15
        L14:
            r104 = this.roomIdList;
            r105 = Long.valueOf(r100.j());
            goto L15
        L16:
            r100.d(r101);
            setThreadSafe(true);
        }

        public void setRoomIdDisplay(List<Integer> r100) {
            this.roomIdDisplay = r100;
        }

        public void setRoomIdList(List<Long> r100) {
            this.roomIdList = r100;
        }

        public void setRoomIdStrList(List<String> r100) {
            this.roomIdStrList = r100;
        }
    }

    public static final class a {
        public a() {
        }

        public static User a(IBaseUser r100) {
            if (r100 != null) goto L6;
            return null;
        L6:
            if ((r100 instanceof User) == false) goto L9;
            Gson r101 = GsonHelper.get();
            return (User) GsonProtectorUtils.fromJson(r101, GsonProtectorUtils.toJson(r101, r100), User.class);
        L9:
            User r102 = new User();
            r102.initWith(r100);
            return r102;
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public boolean childrenManagerForbidCreateLiveRoom() {
        return false;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public boolean childrenManagerForbidWalletFunctions() {
        return false;
    }

    public User() {
        super(IBaseUser.class);
        this._encryptedId = "";
        this._nickName = "";
        this.userOpenId = "";
        this._idStr = "";
        this.secUid = "";
        this._payScores = -1;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public boolean canJumpToLiveRoom() {
        py.o r100 = this._ownRoom;
        if ((r100 instanceof OwnRoom) == true) goto L5;
        r100 = null;
    L5:
        OwnRoom r101 = (OwnRoom) r100;
        if (r101 != null) goto L10;
        return true;
    L10:
        return r101.canJumpToLiveRoom();
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public IBaseUser cloneFrom() {
        Companion.getClass();
        return a.a(this);
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public ImageModel getAvatarLarge() {
    L8:
        e = move-exception;
        e.printStackTrace();
    L11:
        return (ImageModel) this._avatarLarge;
    L3:
        if (this._avatarLarge != null) goto L11;
        if (TextUtils.isEmpty(this.mAvatarLargeStr) == true) goto L11;
        this._avatarLarge = (py.k) GsonHelper.get().fromJson(this.mAvatarLargeStr, ImageModel.class);     // Catch: Exception -> L8
        goto L11
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public ImageModel getAvatarMedium() {
    L8:
        e = move-exception;
        e.printStackTrace();
    L11:
        return (ImageModel) this._avatarMedium;
    L3:
        if (this._avatarMedium != null) goto L11;
        if (TextUtils.isEmpty(this.mAvatarMediumStr) == true) goto L11;
        this._avatarMedium = (py.k) GsonHelper.get().fromJson(this.mAvatarMediumStr, ImageModel.class);     // Catch: Exception -> L8
        goto L11
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public List<py.k> getBadgeImageList() {
        return new ArrayList();
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public List<py.k> getBadgeImageListV2Ext() {
        ArrayList r100 = new ArrayList();
        r100.addAll(this._badgeImageListV2);
        return r100;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public String getCastSecUid() {
        o0.a r100 = o0.f58946a;
        String r101 = this.userOpenId;
        r100.getClass();
        if (r101 != null) goto L6;
        return "0";
    L6:
        return r101;
    }

    public final HostInfo getHostInfo() {
        HostInfo r100 = this._hostInfo;
        if (r100 == null) goto L6;
        r100.set_userId(this.userOpenId);
    L6:
        return this._hostInfo;
    }

    @RawUserIdAccess
    public final String getIdStr() {
        o0.a r100 = o0.f58946a;
        String r101 = this._idStr;
        r100.getClass();
        if (o0.a.b(r101) == true) goto L5;
        String.valueOf(this.f58939id);
    L5:
        String r102 = this.userOpenId;
        if (r102 != null) goto L9;
        return "0";
    L9:
        return r102;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser, com.bytedance.android.live.base.model.user.l
    public String getIdString() {
        o0.a r100 = o0.f58946a;
        String r101 = this._idStr;
        r100.getClass();
        if (o0.a.b(r101) == true) goto L5;
        String.valueOf(this.f58939id);
    L5:
        String r102 = this.userOpenId;
        if (r102 != null) goto L9;
        return "0";
    L9:
        return r102;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public long getLiveRoomId() {
        py.o r100 = this._ownRoom;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.getId();
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public String getLocationCity() {
        String r100 = this._locationCity;
        if (r100 == null) goto L12;
        Intrinsics.checkNotNull(r100);
        if (r100.length() != 0) goto L7;
        boolean r101 = true;
    L8:
        if (r101 == true) goto L12;
        return this._locationCity;
    L7:
        r101 = false;
    L12:
        return getCity();
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public List<py.k> getNewUserBadges() {
        List<py.k> r100 = this._newUserBadges;
        if (r100 == null) goto L8;
        if ((!r100.isEmpty()) != true) goto L8;
        return this._newUserBadges;
    L8:
        return getUserBadges();
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public String getNickName() {
        if (this.shouldUseRealName == true) goto L5;
        kz.a r100 = kz.b.f506725a;
        if (r100 == null) goto L13;
        if (r100.a() == false) goto L13;
        return r100.b(this);
    L13:
        return this._nickName;
    L5:
        return this._nickName;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public o0 getUserIdCompat() {
        o0.a r100 = o0.f58946a;
        String r101 = getIdStr();
        String r102 = getIdStr();
        r100.getClass();
        return new p0(r101, r102);
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public String getWebcastUid() {
        if (TextUtils.isEmpty(this._webcastUid) == false) goto L7;
        return getIdStr();
    L7:
        return this._webcastUid;
    }

    public int hashCode() {
        String r100 = this._nickName;
        int r101 = 0;
        if (r100 == null) goto L6;
        if (r100 == null) goto L6;
        int r102 = r100.hashCode();
    L7:
        int r103 = ((r102 * 31) + getGender()) * 31;
        if (getSignature() == null) goto L12;
        String r104 = getSignature();
        if (r104 == null) goto L12;
        int r105 = r104.hashCode();
    L13:
        int r106 = (((((r103 + r105) * 31) + getLevel()) * 31) + ((int) (getCreateTime() ^ (getCreateTime() >>> 32)))) * 31;
        if (getCity() == null) goto L18;
        String r107 = getCity();
        if (r107 == null) goto L18;
        int r108 = r107.hashCode();
    L19:
        int r109 = (((r106 + r108) * 31) + ((int) (getBirthday() ^ (getBirthday() >>> 32)))) * 31;
        if (getAvatarThumb() == null) goto L24;
        ImageModel r110 = getAvatarThumb();
        if (r110 == null) goto L24;
        int r111 = r110.hashCode();
    L25:
        int r112 = (r109 + r111) * 31;
        py.k r113 = this._avatarMedium;
        if (r113 == null) goto L29;
        if (r113 == null) goto L29;
        int r114 = r113.hashCode();
    L30:
        int r115 = (r112 + r114) * 31;
        py.k r116 = this._avatarLarge;
        if (r116 == null) goto L34;
        if (r116 == null) goto L34;
        int r117 = r116.hashCode();
    L35:
        int r118 = (r115 + r117) * 31;
        String r119 = this._avatarUrl;
        if (r119 == null) goto L39;
        if (r119 == null) goto L39;
        int r120 = r119.hashCode();
    L40:
        int r121 = (r118 + r120) * 31;
        if (getTopFans() == null) goto L45;
        List<IBaseUser> r122 = getTopFans();
        if (r122 == null) goto L45;
        int r123 = r122.hashCode();
    L46:
        int r124 = (((((((((r121 + r123) * 31) + getIdStr().hashCode()) * 31) + ((int) (getShortId() ^ (getShortId() >>> 32)))) * 31) + ((int) (getFanTicketCount() ^ (getFanTicketCount() >>> 32)))) * 31) + (isVerified() ? 1 : 0)) * 31;
        if (getVerifiedReason() == null) goto L51;
        String r125 = getVerifiedReason();
        if (r125 == null) goto L51;
        int r126 = r125.hashCode();
    L52:
        int r127 = (((r124 + r126) * 31) + getTopVipNo()) * 31;
        if (getUserHonor() == null) goto L57;
        py.d r128 = getUserHonor();
        if (r128 == null) goto L57;
        int r129 = r128.hashCode();
    L58:
        int r130 = (r127 + r129) * 31;
        if (getAnchorLevel() == null) goto L63;
        IAnchorLevel r131 = getAnchorLevel();
        if (r131 == null) goto L63;
        int r132 = r131.hashCode();
    L64:
        int r133 = (r130 + r132) * 31;
        if (getUserBadges() == null) goto L69;
        List<py.k> r134 = getUserBadges();
        if (r134 == null) goto L69;
        int r135 = r134.hashCode();
    L70:
        int r136 = (r133 + r135) * 31;
        List<py.k> r137 = this._newUserBadges;
        if (r137 == null) goto L74;
        if (r137 == null) goto L74;
        int r138 = r137.hashCode();
    L75:
        int r139 = (((r136 + r138) * 31) + getLinkMicStats()) * 31;
        String r140 = this.mAvatarThumbStr;
        if (r140 == null) goto L79;
        if (r140 == null) goto L79;
        int r141 = r140.hashCode();
    L80:
        int r142 = (r139 + r141) * 31;
        String r143 = this.mAvatarMediumStr;
        if (r143 == null) goto L84;
        if (r143 == null) goto L84;
        int r144 = r143.hashCode();
    L85:
        int r145 = (r142 + r144) * 31;
        String r146 = this.mAvatarLargeStr;
        if (r146 == null) goto L89;
        if (r146 == null) goto L89;
        int r147 = r146.hashCode();
    L90:
        int r148 = (((r145 + r147) * 31) + (getEnableShowCommerceSale() ? 1 : 0)) * 31;
        if (getBackgroundImgUrl() == null) goto L95;
        String r149 = getBackgroundImgUrl();
        if (r149 == null) goto L95;
        int r150 = r149.hashCode();
    L96:
        int r151 = (r148 + r150) * 31;
        if (getTelephone() == null) goto L101;
        String r152 = getTelephone();
        if (r152 == null) goto L101;
        int r153 = r152.hashCode();
    L102:
        int r154 = (((((((((r151 + r153) * 31) + getExperience()) * 31) + getStatus()) * 31) + ((int) (getModifyTime() ^ (getModifyTime() >>> 32)))) * 31) + getSecret()) * 31;
        if (getShareQrcodeUri() == null) goto L107;
        String r155 = getShareQrcodeUri();
        if (r155 == null) goto L107;
        int r156 = r155.hashCode();
    L108:
        int r157 = (((r154 + r156) * 31) + getIncomeSharePercent()) * 31;
        if (getFollowInfo() == null) goto L113;
        FollowInfo r158 = getFollowInfo();
        if (r158 == null) goto L113;
        int r159 = r158.hashCode();
    L114:
        int r160 = (r157 + r159) * 31;
        if (getUserAttr() == null) goto L119;
        py.t r161 = getUserAttr();
        if (r161 == null) goto L119;
        int r162 = r161.hashCode();
    L120:
        int r163 = (r160 + r162) * 31;
        if (getAnchorInfo() == null) goto L126;
        py.b r164 = getAnchorInfo();
        if (r164 == null) goto L126;
        r101 = r164.hashCode();
    L126:
        return r163 + r101;
    L119:
        r162 = 0;
    L113:
        r159 = 0;
    L107:
        r156 = 0;
    L101:
        r153 = 0;
    L95:
        r150 = 0;
    L89:
        r147 = 0;
    L84:
        r144 = 0;
    L79:
        r141 = 0;
    L74:
        r138 = 0;
    L69:
        r135 = 0;
    L63:
        r132 = 0;
    L57:
        r129 = 0;
    L51:
        r126 = 0;
    L45:
        r123 = 0;
    L39:
        r120 = 0;
    L34:
        r117 = 0;
    L29:
        r114 = 0;
    L24:
        r111 = 0;
    L18:
        r108 = 0;
    L12:
        r105 = 0;
    L6:
        r102 = 0;
        goto L7
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public boolean isEnableShowFansClubReverse() {
        d r100 = this.bizRelation;
        if (r100 != null) goto L5;
        return false;
    L5:
        Intrinsics.checkNotNull(r100);
        return r100.shopFansClubReverse;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public boolean isSubscriber() {
        List r100 = this._badgeImageListV2;
        if (r100 != null) goto L5;
        r100 = new ArrayList();
    L5:
        Iterator r101 = r100.iterator();
    L7:
        if (r101.hasNext() == false) goto L15;
        Integer r102 = ((ImageModel) r101.next()).getImageType();
        if (r102 == null) goto L7;
        if (r102.intValue() != 50) goto L7;
        return true;
    L15:
        return false;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public boolean isVcdAdversaryContentAuthorized() {
        if ((this.adversaryAuthorizationInfo & 1) > 0) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public boolean isVcdAdversaryRelationAuthorized() {
        if ((this.adversaryAuthorizationInfo & 2) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public boolean isVcdContentAuthorized() {
        if ((this.authorizationInfo & 1) > 0) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public boolean isVcdRelationAuthorized() {
        if ((this.authorizationInfo & 2) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public String toString() {
        return "User@" + Integer.toHexString(hashCode()) + "{\"nickName\":\"" + this._nickName + "\", \"id\":\"" + getIdStr() + "\"}safe name :" + getSafeNicName();
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public py.b getAnchorInfoExt() {
        return getAnchorInfo();
    }

    @Override // com.bytedance.android.live.base.model.user.IUser
    public ImageModel getAvatarThumb() {
        return (ImageModel) getAvatarThumbKt();
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public /* bridge */ /* synthetic */ py.f getBorder() {
        return getBorder();
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public /* bridge */ /* synthetic */ py.j getFollowInfo() {
        return getFollowInfo();
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public py.j getFollowInfoExt() {
        return getFollowInfo();
    }

    public final String getFollowRelationship() {
        if (getFollowInfo() == null) goto L18;
        long r100 = getFollowInfo().getFollowStatus();
        if (r100 != 2) goto L9;
        return "friends";
    L9:
        if (r100 != 1) goto L13;
        return "my_follow";
    L13:
        if (r100 != 3) goto L16;
        return "fans";
    L16:
        return "no_releation";
    L18:
        return "follow_info_null";
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public String getIdStrKt() {
        return getIdStr();
    }

    @Override // com.bytedance.android.live.base.model.user.IUser
    public int getPrivilegeLevel() {
        py.d r100 = getUserHonor();
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.getLevel();
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public String getRelationship() {
        if (getFollowInfo() == null) goto L5;
        long r100 = getFollowInfo().getFollowStatus();
    L7:
        if (r100 != 2) goto L11;
        return "friends";
    L11:
        if (this.fansGroupInfo == null) goto L15;
        return "fans_group";
    L15:
        if (r100 != 1) goto L19;
        return "my_follow";
    L19:
        if (r100 != 3) goto L22;
        return "fans";
    L22:
        return "null";
    L5:
        r100 = 0;
        goto L7
    }

    public final String getRemarkName() {
        FollowInfo r100 = getFollowInfo();
        if (r100 == null) goto L13;
        String r101 = r100.getRemarkName();
        if (r101 != null) goto L7;
        return null;
    L7:
        if (r101.length() <= 0) goto L9;
        boolean r102 = true;
    L10:
        if (r102 == true) goto L12;
        return null;
    L12:
        return r101;
    L9:
        r102 = false;
        goto L10
    L13:
        return null;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public String getRemarkNameOrNickname() {
        FollowInfo r100 = getFollowInfo();
        if (r100 == null) goto L15;
        String r101 = r100.getRemarkName();
        if (r101 == null) goto L15;
        if (r101.length() <= 0) goto L9;
        boolean r102 = true;
    L10:
        if (r102 == true) goto L13;
        r101 = null;
    L13:
        if (r101 == null) goto L15;
        return r101;
    L9:
        r102 = false;
    L15:
        return getNickName();
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public String getRemarkNameOrRealNickName() {
        FollowInfo r100 = getFollowInfo();
        if (r100 == null) goto L15;
        String r101 = r100.getRemarkName();
        if (r101 == null) goto L15;
        if (r101.length() <= 0) goto L9;
        boolean r102 = true;
    L10:
        if (r102 == true) goto L13;
        r101 = null;
    L13:
        if (r101 == null) goto L15;
        return r101;
    L9:
        r102 = false;
    L15:
        return getRealNickName();
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public py.t getUserAttrExt() {
        return getUserAttr();
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public py.t getUserAttrFlex() {
        return getUserAttr();
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public String getUserId() {
        return getIdString();
    }

    public final boolean isCustomVerify() {
        py.c r100 = getMAuthenticationInfo();
        if (r100 == null) goto L13;
        String r101 = r100.getCustomVerify();
        if (r101 != null) goto L7;
        return false;
    L7:
        if (r101.length() <= 0) goto L9;
        boolean r102 = true;
    L10:
        if (r102 != true) goto L15;
        return true;
    L15:
        return false;
    L9:
        r102 = false;
        goto L10
    L13:
        return false;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public boolean isEnterpriseVerify() {
        py.c r100 = getMAuthenticationInfo();
        if (r100 == null) goto L13;
        String r101 = r100.getEnterpriseVerifyReason();
        if (r101 != null) goto L7;
        return false;
    L7:
        if (r101.length() <= 0) goto L9;
        boolean r102 = true;
    L10:
        if (r102 != true) goto L15;
        return true;
    L15:
        return false;
    L9:
        r102 = false;
        goto L10
    L13:
        return false;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public boolean isFollowing() {
        if (getFollowInfo() != null) goto L6;
        return false;
    L6:
        if (getFollowInfo().getFollowStatus() != 2) goto L8;
    L9:
        return true;
    L8:
        if (getFollowInfo().getFollowStatus() == 1) goto L9;
        return false;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public boolean isMysteryMan() {
        if (getMysteryMan() != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isVerifyUser() {
        py.c r100 = getMAuthenticationInfo();
        if (r100 == null) goto L13;
        String r101 = ((AuthenticationInfo) r100).getVerifyContent();
        if (r101 != null) goto L7;
        return false;
    L7:
        if (r101.length() <= 0) goto L9;
        boolean r102 = true;
    L10:
        if (r102 != true) goto L15;
        return true;
    L15:
        return false;
    L9:
        r102 = false;
        goto L10
    L13:
        return false;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public boolean isWithCommercePermission() {
        return getEnableShowCommerceSale();
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public int getAdversaryUserStatus() {
        return this.adversaryUserStatus;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public int getAgeRange() {
        return this.ageRange;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser
    public py.b getAnchorInfo() {
        return this.anchorInfo;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public IAnchorLevel getAnchorLevel() {
        return this.anchorLevel;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public py.k getAvatarThumbKt() {
        return this.avatarThumbKt;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public String getAvatarUrl() {
        return this._avatarUrl;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public String getBackgroundImgUrl() {
        return this.backgroundImgUrl;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public List<py.k> getBadgeImageListV2() {
        return this._badgeImageListV2;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser
    public long getBirthday() {
        return this.birthday;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public e getBottomEntry() {
        return this.bottomEntry;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public String getCity() {
        return this.city;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public int getCommerceUserLevel() {
        return this._commerceUserLevel;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public j getCommonVipInfo() {
        return this._anchorCommonVip;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser
    public long getCreateTime() {
        return this.createTime;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public String getDisplayId() {
        return this.displayId;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser, com.bytedance.android.live.base.model.user.l
    public l0 getDressInfo() {
        return this.dressInfo;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public boolean getEnableCarManagementPermission() {
        return this.enableCarManagementPermission;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public boolean getEnableShowCommerceSale() {
        return this.enableShowCommerceSale;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public String getEncryptedId() {
        return this._encryptedId;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public int getEnterprise() {
        return this._enterprise;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser
    public int getExperience() {
        return this.experience;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public long getFanTicketCount() {
        return this.fanTicketCount;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public t getFansClub() {
        return this.fansClub;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public int getGender() {
        return this.gender;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser
    public int getIncomeSharePercent() {
        return this.incomeSharePercent;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public x getIndustryCertification() {
        return this.industryCertification;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public int getLevel() {
        return this.level;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public int getLinkMicStats() {
        return this.linkMicStats;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public String getLogPb() {
        return this.logPb;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public py.c getMAuthenticationInfo() {
        return this.mAuthenticationInfo;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public py.k getMedal() {
        return this.medal;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public List<py.k> getMediaBadgeImageList() {
        return this.mediaBadgeImageList;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser
    public long getModifyTime() {
        return this.modifyTime;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public int getMysteryMan() {
        return this.mysteryMan;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public py.o getOwnRoom() {
        return this._ownRoom;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public long getPayScores() {
        return this._payScores;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public py.k getPersonalCard() {
        return this.personalCard;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public py.q getPoiInfo() {
        return this.poiInfo;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public d0 getProfileStyleParams() {
        return this.profileStyleParams;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public long getPublicScreenOperateFreq() {
        return this.publicScreenOperateFreq;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public String getRealNickName() {
        return this._nickName;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public String getRequestId() {
        return this.requestId;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public boolean getRoomAutoGiftThanks() {
        return this._roomAutoGiftThanks;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public String getSafeNicName() {
        return this.safeNicName;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public int getSearchType() {
        return this.searchType;
    }

    public final String getSecUid() {
        return this.secUid;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public int getSecret() {
        return this.secret;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser
    public String getShareQrcodeUri() {
        return this.shareQrcodeUri;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public long getShortId() {
        return this.shortId;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public String getSignature() {
        return this.signature;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public String getSpecialId() {
        return this.specialId;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser
    public int getStatus() {
        return this.status;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public g0 getSubscribe() {
        return this.subscribe;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public String getTelephone() {
        return this.telephone;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public List<IBaseUser> getTopFans() {
        return this.topFans;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser
    public int getTopVipNo() {
        return this.topVipNo;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser
    public String getUnionId() {
        return this.unionId;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public py.t getUserAttr() {
        return this.userAttr;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public List<py.k> getUserBadges() {
        return this.userBadges;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public py.d getUserHonor() {
        return this.userHonor;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser
    public int getUserRole() {
        return this.userRole;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public long getUserWatchMonth() {
        return this.userWatchMonth;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public boolean getUserWatchMonthValid() {
        return this._userWatchMonthValid;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public String getVerifiedReason() {
        return this.verifiedReason;
    }

    public final j get_anchorCommonVip() {
        return this._anchorCommonVip;
    }

    public final String get_avatarUrl() {
        return this._avatarUrl;
    }

    public final int get_commerceUserLevel() {
        return this._commerceUserLevel;
    }

    public final String get_encryptedId() {
        return this._encryptedId;
    }

    public final int get_enterprise() {
        return this._enterprise;
    }

    public final String get_nickName() {
        return this._nickName;
    }

    public final py.o get_ownRoom() {
        return this._ownRoom;
    }

    public final boolean get_roomAutoGiftThanks() {
        return this._roomAutoGiftThanks;
    }

    public final boolean get_userWatchMonthValid() {
        return this._userWatchMonthValid;
    }

    public final String get_webcastUid() {
        return this._webcastUid;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public boolean isAnonymous() {
        return this.isAnonymous;
    }

    public final boolean isHideHostInfoForProfile() {
        return this.isHideHostInfoForProfile;
    }

    public final boolean isNeverRecharge() {
        return this.isNeverRecharge;
    }

    public final boolean isShouldUseRealName() {
        return this.shouldUseRealName;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public boolean isVerified() {
        return this.isVerified;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public /* bridge */ /* synthetic */ py.k getAvatarLarge() {
        return getAvatarLarge();
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public /* bridge */ /* synthetic */ py.k getAvatarMedium() {
        return getAvatarMedium();
    }

    @Override // com.bytedance.android.live.base.model.user.IUser
    public /* bridge */ /* synthetic */ py.k getAvatarThumb() {
        return getAvatarThumb();
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public BorderInfo getBorder() {
        return this.border;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public FollowInfo getFollowInfo() {
        return this.followInfo;
    }

    /* JADX WARN: Type inference failed for: r4v101, types: [com.bytedance.android.live.base.model.user.e, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v11, types: [com.bytedance.android.live.base.model.user.d0, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v13, types: [com.bytedance.android.live.base.model.user.l0, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v16, types: [com.bytedance.android.live.base.model.user.j, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v22, types: [com.bytedance.android.live.base.model.user.x, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v27, types: [com.bytedance.android.live.base.model.user.api.IAnchorLevel, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v38, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r4v40, types: [java.lang.Object, py.c] */
    /* JADX WARN: Type inference failed for: r4v44, types: [java.lang.Object, py.q] */
    /* JADX WARN: Type inference failed for: r4v49, types: [java.lang.Object, py.b] */
    /* JADX WARN: Type inference failed for: r4v6, types: [com.bytedance.android.live.base.model.user.g0, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v62, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r4v64, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r4v66, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r4v80, types: [java.lang.Object, py.d] */
    /* JADX WARN: Type inference failed for: r4v82, types: [com.bytedance.android.live.base.model.user.t, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v87, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r4v95, types: [java.lang.Object, py.t] */
    /* JADX WARN: Type inference failed for: r4v97, types: [java.lang.Object, py.o] */
    public User(am3.g r100) {
        super(IBaseUser.class);
        this._badgeImageList = new ArrayList();
        this.mediaBadgeImageList = new ArrayList();
        this.commerceConfigIds = new ArrayList();
        this._badgeImageListV2 = new ArrayList();
        this.topFans = new ArrayList();
        this.userBadges = new ArrayList();
        this._newUserBadges = new ArrayList();
        this._encryptedId = "";
        boolean r101 = false;
        setThreadSafe(false);
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L115;
        am3.g.a r104 = decodeExtensionFields(r103, r100);
        if (r103 != 66) goto L8;
        this.mysteryMan = r100.i();
        goto L3
    L8:
        if (r103 != 68) goto L10;
        this.safeNicName = am3.h.c(r100);
        goto L3
    L10:
        if (r103 != 81) goto L12;
        this.publicScreenOperateFreq = r100.j();
        goto L3
    L12:
        if (r103 != 1013) goto L14;
        this.backgroundImgUrl = am3.h.c(r100);
        goto L3
    L14:
        if (r103 != 1028) goto L16;
        this._idStr = am3.h.c(r100);
        goto L3
    L16:
        if (r103 != 1048) goto L18;
        this.bottomEntry = vh7.f.a(r100, e.class);
        goto L3
    L18:
        if (r103 != 5000) goto L20;
        this.userOpenId = am3.h.c(r100);
        goto L3
    L20:
        if (r103 != 5001) goto L21;
        this._hostInfo = new HostInfo(r100);
        goto L3
    L21:
        switch(r103) {
            case 1: goto L106;
            case 2: goto L105;
            case 3: goto L104;
            case 4: goto L103;
            case 5: goto L102;
            case 6: goto L101;
            case 7: goto L100;
            case 8: goto L99;
            case 9: goto L98;
            case 10: goto L97;
            case 11: goto L96;
            case 12: goto L95;
            case 13: goto L94;
            case 14: goto L93;
            case 15: goto L92;
            case 16: goto L91;
            case 17: goto L90;
            case 18: goto L89;
            case 19: goto L88;
            case 20: goto L87;
            case 21: goto L84;
            case 22: goto L83;
            case 23: goto L82;
            case 24: goto L81;
            case 25: goto L80;
            case 26: goto L79;
            case 27: goto L78;
            case 28: goto L77;
            case 29: goto L74;
            case 30: goto L73;
            case 31: goto L72;
            case 32: goto L71;
            case 33: goto L70;
            default: goto L22;
        };
    L70:
        this._ownRoom = vh7.f.a(r100, py.o.class);
        goto L3
    L71:
        this.userAttr = vh7.f.a(r100, py.t.class);
        goto L3
    L72:
        this.topVipNo = (int) r100.j();
        goto L3
    L73:
        List r105 = this._newUserBadges;
    L75:
        Class r106 = py.k.class;
    L76:
        Object r107 = vh7.f.a(r100, r106);
    L86:
        r105.add(r107);
        goto L3
    L74:
        r105 = this.userBadges;
        goto L75
    L77:
        this.medal = vh7.f.a(r100, py.k.class);
        goto L3
    L78:
        this.avatarBorder = com.bytedance.android.live.base.model.x.a(r100);
        goto L3
    L79:
        this.specialId = am3.h.c(r100);
        goto L3
    L80:
        this.border = new BorderInfo(r100);
        goto L3
    L81:
        this.fansClub = vh7.f.a(r100, t.class);
        goto L3
    L82:
        this.userHonor = vh7.f.a(r100, py.d.class);
        goto L3
    L83:
        this.followInfo = new FollowInfo(r100);
        goto L3
    L84:
        r105 = this._badgeImageList;
    L85:
        r107 = com.bytedance.android.live.base.model.x.a(r100);
        goto L86
    L87:
        this.incomeSharePercent = r100.i();
        goto L3
    L88:
        this.shareQrcodeUri = am3.h.c(r100);
        goto L3
    L89:
        this.secret = r100.i();
        goto L3
    L90:
        this.modifyTime = r100.j();
        goto L3
    L91:
        this.createTime = r100.j();
        goto L3
    L92:
        this.status = r100.i();
        goto L3
    L93:
        this.city = am3.h.c(r100);
        goto L3
    L94:
        this.experience = r100.i();
        goto L3
    L95:
        this.isVerified = am3.h.a(r100);
        goto L3
    L96:
        this._avatarLarge = vh7.f.a(r100, py.k.class);
        goto L3
    L97:
        this._avatarMedium = vh7.f.a(r100, py.k.class);
        goto L3
    L98:
        this.avatarThumbKt = vh7.f.a(r100, py.k.class);
        goto L3
    L99:
        this.telephone = am3.h.c(r100);
        goto L3
    L100:
        this.birthday = r100.j();
        goto L3
    L101:
        this.level = r100.i();
        goto L3
    L102:
        this.signature = am3.h.c(r100);
        goto L3
    L103:
        this.gender = r100.i();
        goto L3
    L104:
        this._nickName = am3.h.c(r100);
        goto L3
    L105:
        this.shortId = r100.j();
        goto L3
    L106:
        this.f58939id = r100.j();
        goto L3
    L22:
        switch(r103) {
            case 35: goto L69;
            case 36: goto L68;
            case 37: goto L67;
            case 38: goto L66;
            case 39: goto L65;
            default: goto L23;
        };
    L65:
        this.enableShowCommerceSale = am3.h.a(r100);
        goto L3
    L66:
        this.displayId = am3.h.c(r100);
        goto L3
    L67:
        this.linkMicStats = r100.i();
        goto L3
    L68:
        this.anchorInfo = vh7.f.a(r100, py.b.class);
        goto L3
    L69:
        this.fanTicketCount = r100.j();
        goto L3
    L23:
        switch(r103) {
            case 41: goto L64;
            case 42: goto L63;
            case 43: goto L62;
            case 44: goto L61;
            case 45: goto L60;
            case 46: goto L59;
            case 47: goto L58;
            case 48: goto L57;
            case 49: goto L56;
            case 50: goto L55;
            case 51: goto L54;
            case 52: goto L53;
            case 53: goto L52;
            case 54: goto L51;
            case 55: goto L50;
            case 56: goto L49;
            case 57: goto L48;
            case 58: goto L47;
            default: goto L24;
        };
    L47:
        this.adversaryUserStatus = r100.i();
        goto L3
    L48:
        r105 = this.mediaBadgeImageList;
        goto L75
    L49:
        this.poiInfo = vh7.f.a(r100, py.q.class);
        goto L3
    L50:
        this.adversaryAuthorizationInfo = r100.i();
        goto L3
    L51:
        this.authorizationInfo = r100.i();
        goto L3
    L52:
        this.mAuthenticationInfo = vh7.f.a(r100, py.c.class);
        goto L3
    L53:
        this.personalCard = vh7.f.a(r100, py.k.class);
        goto L3
    L54:
        this.fraternityInfo = new FraternityInfo(r100);
        goto L3
    L55:
        this.nobleLevelInfo = new NobleLevelInfo(r100);
        goto L3
    L56:
        this.rewardInfo = new com.bytedance.android.live.base.model.user.a(r100);
        goto L3
    L57:
        this.xiguaInfo = new XiguaParams(r100);
        goto L3
    L58:
        this.userRole = r100.i();
        goto L3
    L59:
        this.secUid = am3.h.c(r100);
        goto L3
    L60:
        r105 = this.topFans;
        r106 = IBaseUser.class;
        goto L76
    L61:
        this.authorInfo = new Author(r100);
        goto L3
    L62:
        this.verifiedContent = am3.h.c(r100);
        goto L3
    L63:
        this.anchorLevel = vh7.f.a(r100, IAnchorLevel.class);
        goto L3
    L64:
        this._payScores = r100.j();
        r101 = r101 | true;
        goto L3
    L24:
        switch(r103) {
            case 60: goto L46;
            case 61: goto L45;
            case 62: goto L44;
            case 63: goto L43;
            case 64: goto L42;
            default: goto L25;
        };
    L42:
        this.fansGroupInfo = new FansGroupInfo(r100);
        goto L3
    L43:
        this._locationCity = am3.h.c(r100);
        goto L3
    L44:
        this.industryCertification = vh7.f.a(r100, x.class);
        goto L3
    L45:
        r105 = this._badgeImageListV2;
        goto L85
    L46:
        r105 = this.commerceConfigIds;
        r107 = Long.valueOf(r100.j());
        goto L86
    L25:
        switch(r103) {
            case 70: goto L41;
            case 71: goto L40;
            case 72: goto L39;
            case 73: goto L38;
            case 74: goto L37;
            case 75: goto L36;
            case 76: goto L35;
            case 77: goto L34;
            case 78: goto L33;
            case 79: goto L32;
            default: goto L26;
        };
    L32:
        this.extraInfo = new m0(r100);
        goto L3
    L33:
        this.publicAreaBadgeInfo = u0.a(r100);
        goto L3
    L34:
        this._anchorCommonVip = vh7.f.a(r100, j.class);
        goto L3
    L35:
        this.bizRelation = new d(r100);
        goto L3
    L36:
        this.dressInfo = vh7.f.a(r100, l0.class);
        goto L3
    L37:
        this.profileStyleParams = vh7.f.a(r100, d0.class);
        goto L3
    L38:
        this._webcastUid = am3.h.c(r100);
        goto L3
    L39:
        this.consumeDiamondLevel = r100.i();
        goto L3
    L40:
        this.isAnonymous = am3.h.a(r100);
        goto L3
    L41:
        this.subscribe = vh7.f.a(r100, g0.class);
        goto L3
    L26:
        switch(r103) {
            case 1043: goto L31;
            case 1044: goto L30;
            case 1045: goto L29;
            case 1046: goto L28;
            default: goto L27;
        };
    L28:
        this.userWatchMonth = r100.j();
        goto L3
    L29:
        this.ageRange = r100.i();
        goto L3
    L30:
        this.enableCarManagementPermission = am3.h.a(r100);
        goto L3
    L31:
        this.verifiedReason = am3.h.c(r100);
        goto L3
    L27:
        am3.h.d(r104, r100);
        goto L3
    L115:
        r100.d(r102);
        setThreadSafe(true);
        if (this._nickName != null) goto L119;
        this._nickName = "";
    L119:
        if (this.userOpenId != null) goto L122;
        this.userOpenId = "";
    L122:
        if (this._idStr != null) goto L125;
        this._idStr = "";
    L125:
        if (this.secUid != null) goto L128;
        this.secUid = "";
    L128:
        if ((true & r101) == true) goto L308;
        this._payScores = -1;
        return;
    }

    private final boolean shouldUseHostInfo(IRoomAuthStatus r100) {
        if (this.isHideHostInfoForProfile == false) goto L5;
    L14:
        return false;
    L5:
        if (getHostInfo() == null) goto L14;
        if ((r100 instanceof RoomAuthStatus) == true) goto L9;
        r100 = null;
    L9:
        RoomAuthStatus r101 = (RoomAuthStatus) r100;
        if (r101 == null) goto L14;
        if (r101.useHostInfo != 1) goto L14;
        return true;
    }

    public final void assignUserId(o0 r100) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        setUserId(r100.getUserId());
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L269:
        return false;
    L8:
        if ((!Intrinsics.areEqual(getClass(), r100.getClass())) == true) goto L269;
        User r101 = (User) r100;
        if (getGender() == r101.getGender()) goto L14;
        return false;
    L14:
        if (getLevel() == r101.getLevel()) goto L16;
        return false;
    L16:
        o0.a r102 = o0.f58946a;
        String r103 = getIdStr();
        String r104 = r101.getIdStr();
        r102.getClass();
        if (o0.a.a(r103, r104) == false) goto L20;
        return false;
    L20:
        if (getCreateTime() == r101.getCreateTime()) goto L23;
        return false;
    L23:
        if (getBirthday() == r101.getBirthday()) goto L26;
        return false;
    L26:
        if (getShortId() == r101.getShortId()) goto L29;
        return false;
    L29:
        if (getFanTicketCount() == r101.getFanTicketCount()) goto L32;
        return false;
    L32:
        if (isVerified() == r101.isVerified()) goto L35;
        return false;
    L35:
        if (getTopVipNo() == r101.getTopVipNo()) goto L38;
        return false;
    L38:
        if (getLiveRoomId() == r101.getLiveRoomId()) goto L41;
        return false;
    L41:
        if (getLinkMicStats() == r101.getLinkMicStats()) goto L44;
        return false;
    L44:
        if (getEnableShowCommerceSale() == r101.getEnableShowCommerceSale()) goto L46;
        return false;
    L46:
        String r105 = this._nickName;
        if (r105 == null) goto L50;
        boolean r106 = !Intrinsics.areEqual(r105, r101._nickName);
    L53:
        if (r106 == false) goto L56;
        return false;
    L56:
        if (getSignature() == null) goto L59;
        boolean r107 = !Intrinsics.areEqual(getSignature(), r101.getSignature());
    L62:
        if (r107 == false) goto L65;
        return false;
    L65:
        if (getCity() == null) goto L68;
        boolean r108 = !Intrinsics.areEqual(getCity(), r101.getCity());
    L71:
        if (r108 == false) goto L74;
        return false;
    L74:
        if (getAvatarThumb() == null) goto L77;
        boolean r109 = !Intrinsics.areEqual(getAvatarThumb(), r101.getAvatarThumb());
    L80:
        if (r109 == false) goto L82;
        return false;
    L82:
        py.k r110 = this._avatarMedium;
        if (r110 == null) goto L86;
        boolean r111 = !Intrinsics.areEqual(r110, r101._avatarMedium);
    L89:
        if (r111 == false) goto L91;
        return false;
    L91:
        py.k r112 = this._avatarLarge;
        if (r112 == null) goto L95;
        boolean r113 = !Intrinsics.areEqual(r112, r101._avatarLarge);
    L98:
        if (r113 == false) goto L100;
        return false;
    L100:
        String r114 = this._avatarUrl;
        if (r114 == null) goto L104;
        boolean r115 = !Intrinsics.areEqual(r114, r101.getAvatarUrl());
    L107:
        if (r115 == false) goto L110;
        return false;
    L110:
        if (getTopFans() == null) goto L113;
        boolean r116 = !Intrinsics.areEqual(getTopFans(), r101.getTopFans());
    L116:
        if (r116 == false) goto L118;
        return false;
    L118:
        String r117 = this._idStr;
        if (r117 == null) goto L122;
        boolean r118 = !Intrinsics.areEqual(r117, r101._idStr);
    L125:
        if (r118 == false) goto L128;
        return false;
    L128:
        if (getVerifiedReason() == null) goto L131;
        boolean r119 = !Intrinsics.areEqual(getVerifiedReason(), r101.getVerifiedReason());
    L134:
        if (r119 == false) goto L137;
        return false;
    L137:
        if (getUserHonor() == null) goto L140;
        boolean r120 = !Intrinsics.areEqual(getUserHonor(), r101.getUserHonor());
    L143:
        if (r120 == false) goto L146;
        return false;
    L146:
        if (getAnchorLevel() == null) goto L151;
        IAnchorLevel r121 = getAnchorLevel();
        Intrinsics.checkNotNull(r121);
        if (r121.equals(r101.getAnchorLevel()) == false) goto L152;
    L153:
        boolean r122 = false;
    L154:
        if (r122 == false) goto L157;
        return false;
    L157:
        if (getUserBadges() == null) goto L160;
        boolean r123 = !Intrinsics.areEqual(getUserBadges(), r101.getUserBadges());
    L163:
        if (r123 == false) goto L165;
        return false;
    L165:
        List<py.k> r124 = this._newUserBadges;
        if (r124 == null) goto L169;
        boolean r125 = !Intrinsics.areEqual(r124, r101._newUserBadges);
    L172:
        if (r125 == false) goto L174;
        return false;
    L174:
        String r126 = this.mAvatarThumbStr;
        if (r126 == null) goto L178;
        boolean r127 = !Intrinsics.areEqual(r126, r101.mAvatarThumbStr);
    L181:
        if (r127 == false) goto L183;
        return false;
    L183:
        String r128 = this.mAvatarMediumStr;
        if (r128 == null) goto L187;
        boolean r129 = !Intrinsics.areEqual(r128, r101.mAvatarMediumStr);
    L190:
        if (r129 == false) goto L192;
        return false;
    L192:
        String r130 = this.mAvatarLargeStr;
        if (r130 == null) goto L196;
        boolean r131 = !Intrinsics.areEqual(r130, r101.mAvatarLargeStr);
    L199:
        if (r131 == false) goto L202;
        return false;
    L202:
        if (getBackgroundImgUrl() == null) goto L205;
        boolean r132 = !Intrinsics.areEqual(getBackgroundImgUrl(), r101.getBackgroundImgUrl());
    L208:
        if (r132 == false) goto L211;
        return false;
    L211:
        if (getTelephone() == null) goto L214;
        boolean r133 = !Intrinsics.areEqual(getTelephone(), r101.getTelephone());
    L217:
        if (r133 == false) goto L220;
        return false;
    L220:
        if (getExperience() == r101.getExperience()) goto L223;
        return false;
    L223:
        if (getStatus() == r101.getStatus()) goto L226;
        return false;
    L226:
        if (getModifyTime() == r101.getModifyTime()) goto L229;
        return false;
    L229:
        if (getSecret() == r101.getSecret()) goto L232;
        return false;
    L232:
        if (getShareQrcodeUri() == null) goto L235;
        boolean r134 = !Intrinsics.areEqual(getShareQrcodeUri(), r101.getShareQrcodeUri());
    L238:
        if (r134 == false) goto L241;
        return false;
    L241:
        if (getIncomeSharePercent() == r101.getIncomeSharePercent()) goto L244;
        return false;
    L244:
        if (getFollowInfo() == null) goto L247;
        boolean r135 = !Intrinsics.areEqual(getFollowInfo(), r101.getFollowInfo());
    L250:
        if (r135 == false) goto L253;
        return false;
    L253:
        if (getUserAttr() == null) goto L256;
        boolean r136 = !Intrinsics.areEqual(getUserAttr(), r101.getUserAttr());
    L259:
        if (r136 == false) goto L262;
        return false;
    L262:
        if (getAnchorInfo() == null) goto L265;
        py.b r137 = getAnchorInfo();
        Intrinsics.checkNotNull(r137);
        return r137.equals(r101.getAnchorInfo());
    L265:
        if (r101.getAnchorInfo() == null) goto L271;
        return false;
    L271:
        return true;
    L256:
        if (r101.getUserAttr() == null) goto L258;
        r136 = true;
        goto L259
    L258:
        r136 = false;
        goto L259
    L247:
        if (r101.getFollowInfo() == null) goto L249;
        r135 = true;
        goto L250
    L249:
        r135 = false;
        goto L250
    L235:
        if (r101.getShareQrcodeUri() == null) goto L237;
        r134 = true;
        goto L238
    L237:
        r134 = false;
        goto L238
    L214:
        if (r101.getTelephone() == null) goto L216;
        r133 = true;
        goto L217
    L216:
        r133 = false;
        goto L217
    L205:
        if (r101.getBackgroundImgUrl() == null) goto L207;
        r132 = true;
        goto L208
    L207:
        r132 = false;
        goto L208
    L196:
        if (r101.mAvatarLargeStr == null) goto L198;
        r131 = true;
        goto L199
    L198:
        r131 = false;
        goto L199
    L187:
        if (r101.mAvatarMediumStr == null) goto L189;
        r129 = true;
        goto L190
    L189:
        r129 = false;
        goto L190
    L178:
        if (r101.mAvatarThumbStr == null) goto L180;
        r127 = true;
        goto L181
    L180:
        r127 = false;
        goto L181
    L169:
        if (r101._newUserBadges == null) goto L171;
        r125 = true;
        goto L172
    L171:
        r125 = false;
        goto L172
    L160:
        if (r101.getUserBadges() == null) goto L162;
        r123 = true;
        goto L163
    L162:
        r123 = false;
    L152:
        r122 = true;
        goto L154
    L151:
        if (r101.getAnchorLevel() == null) goto L153;
    L140:
        if (r101.getUserHonor() == null) goto L142;
        r120 = true;
        goto L143
    L142:
        r120 = false;
        goto L143
    L131:
        if (r101.getVerifiedReason() == null) goto L133;
        r119 = true;
        goto L134
    L133:
        r119 = false;
        goto L134
    L122:
        if (r101._idStr == null) goto L124;
        r118 = true;
        goto L125
    L124:
        r118 = false;
        goto L125
    L113:
        if (r101.getTopFans() == null) goto L115;
        r116 = true;
        goto L116
    L115:
        r116 = false;
        goto L116
    L104:
        if (r101.getAvatarUrl() == null) goto L106;
        r115 = true;
        goto L107
    L106:
        r115 = false;
        goto L107
    L95:
        if (r101._avatarLarge == null) goto L97;
        r113 = true;
        goto L98
    L97:
        r113 = false;
        goto L98
    L86:
        if (r101._avatarMedium == null) goto L88;
        r111 = true;
        goto L89
    L88:
        r111 = false;
        goto L89
    L77:
        if (r101.getAvatarThumb() == null) goto L79;
        r109 = true;
        goto L80
    L79:
        r109 = false;
        goto L80
    L68:
        if (r101.getCity() == null) goto L70;
        r108 = true;
        goto L71
    L70:
        r108 = false;
        goto L71
    L59:
        if (r101.getSignature() == null) goto L61;
        r107 = true;
        goto L62
    L61:
        r107 = false;
        goto L62
    L50:
        if (r101._nickName == null) goto L52;
        r106 = true;
        goto L53
    L52:
        r106 = false;
        goto L53
    }

    public final py.k getAvatarLargeByRoomAuth(RoomAuthStatus r100) {
        if (shouldUseHostInfo(r100) == false) goto L9;
        HostInfo r101 = getHostInfo();
        if (r101 != null) goto L10;
        return null;
    L10:
        return r101.get_avatarLarge();
    L9:
        return this._avatarLarge;
    }

    public final ImageModel getAvatarThumbByRoomAuth(RoomAuthStatus r100) {
        if (shouldUseHostInfo(r100) == false) goto L7;
        HostInfo r101 = getHostInfo();
        if (r101 != null) goto L13;
        return null;
    L13:
        return r101.get_avatarThumb();
    L7:
        ImageModel r102 = getAvatarThumb();
        if ((r102 instanceof ImageModel) == true) goto L11;
        return null;
    L11:
        return r102;
    }

    public final py.j getFollowInfoByRoomAuth(RoomAuthStatus r100) {
        if (shouldUseHostInfo(r100) == false) goto L9;
        HostInfo r101 = getHostInfo();
        if (r101 != null) goto L10;
        return null;
    L10:
        return r101.get_followInfo();
    L9:
        return getFollowInfo();
    }

    public final int getGenderByRoomAuth(RoomAuthStatus r100) {
        if (shouldUseHostInfo(r100) == false) goto L9;
        HostInfo r101 = getHostInfo();
        if (r101 == null) goto L11;
        return r101.get_gender();
    L11:
        return getGender();
    L9:
        return getGender();
    }

    public final String getNickNameByRoomAuth(RoomAuthStatus r100) {
        if (shouldUseHostInfo(r100) == false) goto L9;
        HostInfo r101 = getHostInfo();
        if (r101 != null) goto L10;
        return null;
    L10:
        return r101.getNickName(this.shouldUseRealName, this);
    L9:
        return getRemarkNameOrRealNickName();
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public String getProperNickName(boolean r100) {
        if (r100 == false) goto L7;
        if (TextUtils.isEmpty(getSafeNicName()) == true) goto L7;
        Logger.d("zcc user", "safe : " + getSafeNicName());
        return getSafeNicName();
    L7:
        return getNickName();
    }

    public final String getRealNickNameByRoomAuth(RoomAuthStatus r100) {
        if (shouldUseHostInfo(r100) == false) goto L9;
        HostInfo r101 = getHostInfo();
        if (r101 != null) goto L10;
        return null;
    L10:
        return r101.get_realNickName();
    L9:
        return getRealNickName();
    }

    public final String getSignatureByRoomAuth(RoomAuthStatus r100) {
        if (shouldUseHostInfo(r100) == false) goto L9;
        HostInfo r101 = getHostInfo();
        if (r101 != null) goto L10;
        return null;
    L10:
        return r101.get_signature();
    L9:
        return getSignature();
    }

    public final void initWith(IBaseUser r100) {
        Intrinsics.checkNotNullParameter(r100, "o");
        IUser r101 = (IUser) r100;
        setEnableShowCommerceSale(r101.getEnableShowCommerceSale());
        setFanTicketCount(r101.getFanTicketCount());
        setShortId(r101.getShortId());
        setDisplayId(r101.getDisplayId());
        this._avatarUrl = r101.getAvatarUrl();
        setAvatarThumbKt(r101.getAvatarThumb());
        this._avatarMedium = r101.getAvatarMedium();
        this._avatarLarge = r101.getAvatarLarge();
        setCity(r101.getCity());
        setBirthday(r101.getBirthday());
        setNickName(r101.getNickName());
        py.q r102 = r101.getPoiInfo();
        py.b r103 = null;
        if ((r102 instanceof PoiInfo) == true) goto L5;
        r102 = null;
    L5:
        setPoiInfo((PoiInfo) r102);
        setGender(r101.getGender());
        setSignature(r101.getSignature());
        setLevel(r101.getLevel());
        setIdStr(r101.getIdString());
        List<IBaseUser> r104 = r101.getTopFans();
        if (r104 == null) goto L8;
        List<IBaseUser> r105 = new ArrayList(r104);
    L9:
        setTopFans(r105);
        setVerified(r101.isVerified());
        setVerifiedReason(r101.getVerifiedReason());
        setTopVipNo(r101.getTopVipNo());
        UserHonor.a r106 = UserHonor.Companion;
        py.d r107 = r101.getUserHonor();
        if ((r107 instanceof IUserHonor) == true) goto L12;
        r107 = null;
    L12:
        IUserHonor r108 = (IUserHonor) r107;
        r106.getClass();
        if (r108 != null) goto L16;
        UserHonor r109 = null;
    L19:
        setUserHonor(r109);
        AnchorLevel.a r110 = AnchorLevel.Companion;
        IAnchorLevel r111 = r101.getAnchorLevel();
        r110.getClass();
        if (r111 != null) goto L23;
        IAnchorLevel r112 = null;
    L26:
        setAnchorLevel(r112);
        setCreateTime(r101.getCreateTime());
        this._ownRoom = r101.getOwnRoom();
        setLinkMicStats(r101.getLinkMicStats());
        List<py.k> r113 = r101.getUserBadges();
        if (r113 == null) goto L29;
        List<py.k> r114 = new ArrayList(r113);
    L30:
        setUserBadges(r114);
        List<py.k> r115 = r101.getNewUserBadges();
        if (r115 == null) goto L33;
        ArrayList r116 = new ArrayList(r115);
    L34:
        this._newUserBadges = r116;
        setBackgroundImgUrl(r101.getBackgroundImgUrl());
        setTelephone(r101.getTelephone());
        setExperience(r101.getEnterprise());
        setStatus(r101.getStatus());
        setModifyTime(r101.getModifyTime());
        setSecret(r101.getSecret());
        setShareQrcodeUri(r101.getShareQrcodeUri());
        setIncomeSharePercent(r101.getIncomeSharePercent());
        setFollowInfo((FollowInfo) com.bytedance.android.live.base.model.m.b(r101.getFollowInfo(), FollowInfo.class));
        setUserAttr((py.t) com.bytedance.android.live.base.model.m.b(r101.getUserAttr(), UserAttr.class));
        AnchorInfo.a r117 = AnchorInfo.Companion;
        py.b r118 = r101.getAnchorInfo();
        r117.getClass();
        if ((r118 instanceof AnchorInfo) == false) goto L37;
        r103 = (AnchorInfo) r118;
    L38:
        setAnchorInfo(r103);
        Intrinsics.checkNotNullParameter(r101, "$this$secUidExt");
        String r119 = r101.getCastSecUid();
        if (r119 == null) goto L41;
        setCastSecUid(r119);
    L41:
        this._enterprise = r101.getEnterprise();
        return;
    L37:
        LocalTestManager.a(new Class[]{wy.a.class});
        goto L38
    L33:
        r116 = null;
        goto L34
    L29:
        r114 = null;
        goto L30
    L23:
        if ((r111 instanceof AnchorLevel) == false) goto L25;
        r112 = (AnchorLevel) r111;
        goto L26
    L25:
        AnchorLevel r120 = new AnchorLevel();
        AnchorLevel.access$initWith(r120, r111);
        r112 = r120;
        goto L26
    L16:
        if ((r108 instanceof UserHonor) == false) goto L18;
        Gson r121 = GsonHelper.get();
        r109 = (UserHonor) GsonProtectorUtils.fromJson(r121, GsonProtectorUtils.toJson(r121, r108), UserHonor.class);
        goto L19
    L18:
        r109 = new UserHonor();
        UserHonor.access$initWith(r109, r108);
        goto L19
    L8:
        r105 = null;
        goto L9
    }

    @Override // com.bytedance.android.live.base.model.user.IUser
    public boolean isFollowingByRoomAuth(IRoomAuthStatus r100) {
        FollowInfo r101 = getFollowInfo();
        if ((r101 instanceof FollowInfo) == true) goto L6;
        r101 = null;
    L6:
        if (r101 == null) goto L8;
        boolean r102 = r101.isFollowing();
    L10:
        if (shouldUseHostInfo(r100) == false) goto L18;
        HostInfo r103 = getHostInfo();
        if (r103 != null) goto L14;
        return false;
    L14:
        if (r103.isFollowing() != true) goto L20;
        if (r102 == false) goto L21;
        return true;
    L21:
        return false;
    L20:
        return false;
    L18:
        return r102;
    L8:
        r102 = false;
        goto L10
    }

    public final void setAVatarMediumStr(String r100) {
        this.mAvatarMediumStr = r100;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public void setAdversaryUserStatus(int r100) {
        this.adversaryUserStatus = r100;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public void setAgeRange(int r100) {
        this.ageRange = r100;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser
    public void setAnchorInfo(py.b r100) {
        this.anchorInfo = r100;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public void setAnchorInfoExt(py.b r100) {
        if ((r100 instanceof AnchorInfo) == true) goto L5;
        r100 = null;
    L5:
        setAnchorInfo((AnchorInfo) r100);
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public void setAnchorLevel(IAnchorLevel r100) {
        this.anchorLevel = r100;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public void setAnonymous(boolean r100) {
        this.isAnonymous = r100;
    }

    public final void setAvatarLarge(ImageModel r100) {
        this._avatarLarge = r100;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public void setAvatarLargeImplicit(py.k r100) {
        this._avatarLarge = (py.k) com.bytedance.android.live.base.model.m.b(r100, ImageModel.class);
    }

    public final void setAvatarLargeStr(String r100) {
        this.mAvatarLargeStr = r100;
    }

    public final void setAvatarMedium(ImageModel r100) {
        this._avatarMedium = r100;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public void setAvatarMediumImplicit(py.k r100) {
        this._avatarMedium = (py.k) com.bytedance.android.live.base.model.m.b(r100, ImageModel.class);
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public void setAvatarThumbImplicit(py.k r100) {
        setAvatarThumbKt((py.k) com.bytedance.android.live.base.model.m.b(r100, ImageModel.class));
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public void setAvatarThumbKt(py.k r100) {
        this.avatarThumbKt = r100;
    }

    public final void setAvatarThumbStr(String r100) {
        this.mAvatarThumbStr = r100;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public void setAvatarUrl(String r100) {
        this._avatarUrl = r100;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public void setBackgroundImgUrl(String r100) {
        this.backgroundImgUrl = r100;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public void setBadgeImageListV2(List<? extends py.k> r100) {
        if (r100 == null) goto L9;
        this._badgeImageListV2 = new ArrayList();
        Iterator<? extends py.k> r101 = r100.iterator();
    L5:
        if (r101.hasNext() == false) goto L15;
        py.k r102 = r101.next();
        if ((r102 instanceof ImageModel) == false) goto L5;
        this._badgeImageListV2.add((ImageModel) r102);
        goto L5
    L15:
        return;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser
    public void setBirthday(long r100) {
        this.birthday = r100;
    }

    public void setBorder(BorderInfo r100) {
        this.border = r100;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public void setCastSecUid(String r100) {
        if (r100 != null) goto L4;
        String r101 = "";
    L5:
        this.secUid = r101;
        if (r100 != null) goto L8;
        return;
    L8:
        if (r100.length() <= 0) goto L10;
        boolean r102 = true;
    L11:
        if (r102 == false) goto L15;
        this.userOpenId = r100;
        return;
    L15:
        return;
    L10:
        r102 = false;
        goto L11
    L4:
        r101 = r100;
        goto L5
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public void setCity(String r100) {
        this.city = r100;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public void setCommerceUserLevel(int r100) {
        this._commerceUserLevel = r100;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public void setCommonVipInfo(j r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if ((r100 instanceof AnchorCommonVip) == false) goto L8;
        this._anchorCommonVip = r100;
        return;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser
    public void setCreateTime(long r100) {
        this.createTime = r100;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public void setDisplayId(String r100) {
        this.displayId = r100;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public void setDressInfo(l0 r100) {
        this.dressInfo = r100;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public void setEnableCarManagementPermission(boolean r100) {
        this.enableCarManagementPermission = r100;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public void setEnableShowCommerceSale(boolean r100) {
        this.enableShowCommerceSale = r100;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public void setEnterprise(int r100) {
        this._enterprise = r100;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser
    public void setExperience(int r100) {
        this.experience = r100;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public void setFanTicketCount(long r100) {
        this.fanTicketCount = r100;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public void setFansClub(t r100) {
        this.fansClub = r100;
    }

    public void setFollowInfo(FollowInfo r100) {
        this.followInfo = r100;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public void setFollowInfoExt(py.j r100) {
        if ((r100 instanceof FollowInfo) == true) goto L5;
        r100 = null;
    L5:
        setFollowInfo((FollowInfo) r100);
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public void setFollowStatus(int r100) {
        if (getFollowInfo() == null) goto L6;
        FollowInfo r101 = getFollowInfo();
        Intrinsics.checkNotNull(r101);
        r101.setFollowStatus(r100);
        return;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public void setGender(int r100) {
        this.gender = r100;
    }

    public final void setHideHostInfoForProfile(boolean r100) {
        this.isHideHostInfoForProfile = r100;
    }

    public final void setHostInfo(HostInfo r100) {
        this._hostInfo = r100;
    }

    @RawUserIdAccess
    public final void setIdStr(String r100) {
        this.userOpenId = r100;
        this._idStr = r100;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public void setIdString(String r100) {
        Intrinsics.checkNotNullParameter(r100, "s");
        setIdStr(r100);
    }

    @Override // com.bytedance.android.live.base.model.user.IUser
    public void setIncomeSharePercent(int r100) {
        this.incomeSharePercent = r100;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public void setIndustryCertification(x r100) {
        this.industryCertification = r100;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public void setLevel(int r100) {
        this.level = r100;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public void setLinkMicStats(int r100) {
        this.linkMicStats = r100;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public void setLogPb(String r100) {
        this.logPb = r100;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public void setMAuthenticationInfo(py.c r100) {
        this.mAuthenticationInfo = r100;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public void setMedal(py.k r100) {
        this.medal = r100;
    }

    public void setMediaBadgeImageList(List<py.k> r100) {
        this.mediaBadgeImageList = r100;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser
    public void setModifyTime(long r100) {
        this.modifyTime = r100;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public void setMysteryMan(int r100) {
        this.mysteryMan = r100;
    }

    public final void setNeverRecharge(boolean r100) {
        this.isNeverRecharge = r100;
    }

    public final void setNewUserBadges(List<py.k> r100) {
        this._newUserBadges = r100;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public void setNickName(String r100) {
        this._nickName = r100;
    }

    public final void setPayScores(long r100) {
        this._payScores = r100;
        if (r100 <= 0) goto L6;
        this.isNeverRecharge = false;
        return;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public void setPersonalCard(py.k r100) {
        this.personalCard = r100;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public void setPoiInfo(py.q r100) {
        this.poiInfo = r100;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public void setProfileStyleParams(d0 r100) {
        this.profileStyleParams = r100;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public void setPublicScreenOperateFreq(long r100) {
        this.publicScreenOperateFreq = r100;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public void setRequestId(String r100) {
        this.requestId = r100;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public void setSafeNicName(String r100) {
        this.safeNicName = r100;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public void setSearchType(int r100) {
        this.searchType = r100;
    }

    public final void setSecUid(String r100) {
        this.secUid = r100;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public void setSecret(int r100) {
        this.secret = r100;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser
    public void setShareQrcodeUri(String r100) {
        this.shareQrcodeUri = r100;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public void setShortId(long r100) {
        this.shortId = r100;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public void setShouldUseRealName(boolean r100) {
        this.shouldUseRealName = r100;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public void setSignature(String r100) {
        this.signature = r100;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public void setSpecialId(String r100) {
        this.specialId = r100;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser
    public void setStatus(int r100) {
        this.status = r100;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public void setSubscribe(g0 r100) {
        this.subscribe = r100;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public void setTelephone(String r100) {
        this.telephone = r100;
    }

    public void setTopFans(List<IBaseUser> r100) {
        this.topFans = r100;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser
    public void setTopVipNo(int r100) {
        this.topVipNo = r100;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser
    public void setUnionId(String r100) {
        this.unionId = r100;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public void setUserAttr(py.t r100) {
        this.userAttr = r100;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public void setUserAttrExt(py.t r100) {
        if ((r100 instanceof UserAttr) == true) goto L5;
        r100 = null;
    L5:
        setUserAttr((UserAttr) r100);
    }

    public void setUserBadges(List<py.k> r100) {
        this.userBadges = r100;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public void setUserHonor(py.d r100) {
        this.userHonor = r100;
    }

    public final void setUserId(String r100) {
        setIdStr(r100);
    }

    @Override // com.bytedance.android.live.base.model.user.IUser
    public void setUserRole(int r100) {
        this.userRole = r100;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public void setUserWatchMonth(long r100) {
        this.userWatchMonth = r100;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public void setUserWatchMonthValid(boolean r100) {
        this._userWatchMonthValid = r100;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public void setVerified(boolean r100) {
        this.isVerified = r100;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public void setVerifiedReason(String r100) {
        this.verifiedReason = r100;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public void setWebcastUid(String r100) {
        this._webcastUid = r100;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public void setWithCommercePermission(boolean r100) {
        setEnableShowCommerceSale(r100);
    }

    public final void set_anchorCommonVip(j r100) {
        this._anchorCommonVip = r100;
    }

    public final void set_avatarUrl(String r100) {
        this._avatarUrl = r100;
    }

    public final void set_commerceUserLevel(int r100) {
        this._commerceUserLevel = r100;
    }

    public final void set_encryptedId(String r100) {
        this._encryptedId = r100;
    }

    public final void set_enterprise(int r100) {
        this._enterprise = r100;
    }

    public final void set_nickName(String r100) {
        this._nickName = r100;
    }

    public final void set_ownRoom(py.o r100) {
        this._ownRoom = r100;
    }

    public final void set_roomAutoGiftThanks(boolean r100) {
        this._roomAutoGiftThanks = r100;
    }

    public final void set_userWatchMonthValid(boolean r100) {
        this._userWatchMonthValid = r100;
    }

    public final void set_webcastUid(String r100) {
        this._webcastUid = r100;
    }

    @Override // com.bytedance.android.live.base.model.user.IUser, com.bytedance.android.live.base.model.user.IBaseUser
    public void setVcdAdversaryAuthorizeState(boolean r100, boolean r101) {
        this.adversaryAuthorizationInfo = 0;
        if (r100 == false) goto L5;
        this.adversaryAuthorizationInfo = 0 | 1;
    L5:
        if (r101 == false) goto L8;
        this.adversaryAuthorizationInfo |= 2;
        return;
    }
}
