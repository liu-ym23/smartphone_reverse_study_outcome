package com.bytedance.android.gamecp.business.comment.data;

import android.content.Context;
import android.text.TextUtils;
import androidx.camera.video.AudioStats;
import androidx.fragment.app.FragmentManager;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.gamecp.base.network.exception.CustomApiServerException;
import com.bytedance.android.gamecp.business.api.GamePromoteApi;
import com.bytedance.android.gamecp.business.comment.edit.x;
import com.bytedance.android.gamecp.business.datachannelmonitorlink.DataChannelMonitorLinkHandler;
import com.bytedance.android.gamecp.business.gamedetail.legacy.viewmodel.BaseGamePromoteDetailViewModel;
import com.bytedance.android.gamecp.business.i0;
import com.bytedance.android.gamecp.common.utils.ToastUtil;
import com.bytedance.android.gamecp.common.utils.y0;
import com.bytedance.android.gamecp.host_api.model.Room;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000Ø\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0019\u0018\u0000 è\u00012\u00020\u0001:\u0004é\u0001ê\u0001B\t¢\u0006\u0006\bæ\u0001\u0010ç\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J§\u0001\u0010\u001c\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\b2<\b\u0002\u0010\u001b\u001a6\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u000f\u0012\u0015\u0012\u0013\u0018\u00010\u000e¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0018¢\u0006\u0004\b\u001c\u0010\u001dJ\u0088\u0001\u0010#\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\b\u0010\u001e\u001a\u0004\u0018\u00010\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\b2%\b\u0002\u0010\"\u001a\u001f\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00040!¢\u0006\u0004\b#\u0010$J'\u0010&\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u00142\u000e\b\u0002\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00040%¢\u0006\u0004\b&\u0010'J \u0010&\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\b2\u000e\b\u0002\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00040%J\u0010\u0010*\u001a\u00020\u00042\b\u0010)\u001a\u0004\u0018\u00010(R\"\u0010+\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\"\u00102\u001a\u0002018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b2\u00104\"\u0004\b5\u00106R$\u00108\u001a\u0004\u0018\u0001078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R$\u0010\u001e\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\"\u0010\u0007\u001a\u00020C8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR!\u0010N\u001a\b\u0012\u0004\u0012\u00020\u00060I8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010MR\"\u0010O\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bO\u0010>\u001a\u0004\bP\u0010@\"\u0004\bQ\u0010BR$\u0010S\u001a\u0004\u0018\u00010R8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bS\u0010T\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR1\u0010^\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020Z0Yj\b\u0012\u0004\u0012\u00020Z`[0I8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\\\u0010K\u001a\u0004\b]\u0010MR$\u0010_\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b_\u0010>\u001a\u0004\b`\u0010@\"\u0004\ba\u0010BR$\u0010c\u001a\u0004\u0018\u00010b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bc\u0010d\u001a\u0004\be\u0010f\"\u0004\bg\u0010hR$\u0010i\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bi\u0010>\u001a\u0004\bj\u0010@\"\u0004\bk\u0010BR$\u0010l\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bl\u0010>\u001a\u0004\bm\u0010@\"\u0004\bn\u0010BR$\u0010o\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bo\u0010p\u001a\u0004\bq\u0010r\"\u0004\bs\u0010tR2\u0010u\u001a\u0012\u0012\u0004\u0012\u00020\u00020Yj\b\u0012\u0004\u0012\u00020\u0002`[8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bu\u0010v\u001a\u0004\bw\u0010x\"\u0004\by\u0010zR!\u0010}\u001a\b\u0012\u0004\u0012\u00020\u000e0I8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b{\u0010K\u001a\u0004\b|\u0010MR1\u0010\u0080\u0001\u001a\n\u0012\u0004\u0012\u00020\u007f\u0018\u00010~8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0080\u0001\u0010\u0081\u0001\u001a\u0006\b\u0082\u0001\u0010\u0083\u0001\"\u0006\b\u0084\u0001\u0010\u0085\u0001R+\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u007f8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0086\u0001\u0010\u0087\u0001\u001a\u0006\b\u0088\u0001\u0010\u0089\u0001\"\u0006\b\u008a\u0001\u0010\u008b\u0001R$\u0010\u008e\u0001\u001a\b\u0012\u0004\u0012\u00020\b0I8FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u008c\u0001\u0010K\u001a\u0005\b\u008d\u0001\u0010MR$\u0010\u0091\u0001\u001a\b\u0012\u0004\u0012\u00020\b0I8FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u008f\u0001\u0010K\u001a\u0005\b\u0090\u0001\u0010MR$\u0010\u0094\u0001\u001a\b\u0012\u0004\u0012\u00020\b0I8FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u0092\u0001\u0010K\u001a\u0005\b\u0093\u0001\u0010MR#\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000e0I8FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u0095\u0001\u0010K\u001a\u0005\b\u0096\u0001\u0010MR$\u0010\u0099\u0001\u001a\b\u0012\u0004\u0012\u00020\b0I8FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u0097\u0001\u0010K\u001a\u0005\b\u0098\u0001\u0010MR&\u0010\u009a\u0001\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u009a\u0001\u0010>\u001a\u0005\b\u009b\u0001\u0010@\"\u0005\b\u009c\u0001\u0010BR$\u0010\u009f\u0001\u001a\b\u0012\u0004\u0012\u0002010I8FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u009d\u0001\u0010K\u001a\u0005\b\u009e\u0001\u0010MR&\u0010 \u0001\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b \u0001\u0010>\u001a\u0005\b¡\u0001\u0010@\"\u0005\b¢\u0001\u0010BR,\u0010¤\u0001\u001a\u0005\u0018\u00010£\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b¤\u0001\u0010¥\u0001\u001a\u0006\b¦\u0001\u0010§\u0001\"\u0006\b¨\u0001\u0010©\u0001R,\u0010«\u0001\u001a\u0005\u0018\u00010ª\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b«\u0001\u0010¬\u0001\u001a\u0006\b\u00ad\u0001\u0010®\u0001\"\u0006\b¯\u0001\u0010°\u0001R,\u0010²\u0001\u001a\u0005\u0018\u00010±\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b²\u0001\u0010³\u0001\u001a\u0006\b´\u0001\u0010µ\u0001\"\u0006\b¶\u0001\u0010·\u0001R2\u0010¹\u0001\u001a\u000b\u0012\u0004\u0012\u00020\b\u0018\u00010¸\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b¹\u0001\u0010\u0081\u0001\u001a\u0006\bº\u0001\u0010\u0083\u0001\"\u0006\b»\u0001\u0010\u0085\u0001R,\u0010½\u0001\u001a\u0005\u0018\u00010¼\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b½\u0001\u0010¾\u0001\u001a\u0006\b¿\u0001\u0010À\u0001\"\u0006\bÁ\u0001\u0010Â\u0001R+\u0010Ã\u0001\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÃ\u0001\u0010Ä\u0001\u001a\u0006\bÅ\u0001\u0010Æ\u0001\"\u0006\bÇ\u0001\u0010È\u0001R&\u0010É\u0001\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bÉ\u0001\u0010>\u001a\u0005\bÊ\u0001\u0010@\"\u0005\bË\u0001\u0010BR+\u0010Ì\u0001\u001a\u0004\u0018\u0001018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÌ\u0001\u0010Í\u0001\u001a\u0006\bÎ\u0001\u0010Ï\u0001\"\u0006\bÐ\u0001\u0010Ñ\u0001R,\u0010Ó\u0001\u001a\u0005\u0018\u00010Ò\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÓ\u0001\u0010Ô\u0001\u001a\u0006\bÕ\u0001\u0010Ö\u0001\"\u0006\b×\u0001\u0010Ø\u0001R&\u0010Ù\u0001\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bÙ\u0001\u0010>\u001a\u0005\bÚ\u0001\u0010@\"\u0005\bÛ\u0001\u0010BR&\u0010Ü\u0001\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bÜ\u0001\u0010>\u001a\u0005\bÝ\u0001\u0010@\"\u0005\bÞ\u0001\u0010BR&\u0010ß\u0001\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bß\u0001\u0010>\u001a\u0005\bà\u0001\u0010@\"\u0005\bá\u0001\u0010BR&\u0010â\u0001\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bâ\u0001\u0010>\u001a\u0005\bã\u0001\u0010@\"\u0005\bä\u0001\u0010BR\u0018\u0010å\u0001\u001a\u0002018\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bå\u0001\u00103¨\u0006ë\u0001"}, d2 = {"Lcom/bytedance/android/gamecp/business/comment/data/GamePromoteCommentViewModel;", "Lcom/bytedance/android/gamecp/business/gamedetail/legacy/viewmodel/BaseGamePromoteDetailViewModel;", "Lcom/bytedance/android/gamecp/business/comment/data/b;", "newCommentDetail", "", "updateAfterPostComment", "", com.bytedance.android.ec.core.event.a.KEY_SCORE, "", "id", "updateAfterPostScore", "dataChannelMonitorLink", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "", "position", "commentId", "relationType", ReportConstant.COMMON_ACTION_TYPE, "content", "", GXTemplateKey.GAIAX_LAYER, "replyId", "parentId", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "onSuccess", "requestLikeAction", "(Landroid/content/Context;ILjava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function2;)V", "gameId", "replyToUserId", "replyToChildReplyId", "Lkotlin/Function1;", "callback", "sendCommentReply", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "Lkotlin/Function0;", "deleteComment", "(Ljava/lang/Long;Lkotlin/jvm/functions/Function0;)V", "Lcom/bytedance/android/gamecp/business/comment/data/d;", "commentEntrance", "updateEntranceInfo", "promoteScene", "I", "getPromoteScene", "()I", "setPromoteScene", "(I)V", "", "isPromoter", "Z", "()Z", "setPromoter", "(Z)V", "Lcom/bytedance/android/gamecp/business/v;", "gameInfo", "Lcom/bytedance/android/gamecp/business/v;", "getGameInfo", "()Lcom/bytedance/android/gamecp/business/v;", "setGameInfo", "(Lcom/bytedance/android/gamecp/business/v;)V", "Ljava/lang/String;", "getGameId", "()Ljava/lang/String;", "setGameId", "(Ljava/lang/String;)V", "", FaceService.girlLabel, "getScore", "()F", "setScore", "(F)V", "Lcom/bytedance/live/datacontext/m;", "scoreOnly$delegate", "Lcom/bytedance/live/datacontext/p;", "getScoreOnly", "()Lcom/bytedance/live/datacontext/m;", "scoreOnly", "scoreEvaluationId", "getScoreEvaluationId", "setScoreEvaluationId", "Lcom/bytedance/android/gamecp/business/comment/data/o;", "commentInfo", "Lcom/bytedance/android/gamecp/business/comment/data/o;", "getCommentInfo", "()Lcom/bytedance/android/gamecp/business/comment/data/o;", "setCommentInfo", "(Lcom/bytedance/android/gamecp/business/comment/data/o;)V", "Ljava/util/ArrayList;", "Lcom/bytedance/android/gamecp/base/core/service/depend/w;", "Lkotlin/collections/ArrayList;", "imageList$delegate", "getImageList", "imageList", "enterFrom", "getEnterFrom", "setEnterFrom", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "getFragmentManager", "()Landroidx/fragment/app/FragmentManager;", "setFragmentManager", "(Landroidx/fragment/app/FragmentManager;)V", "anchorId", "getAnchorId", "setAnchorId", "roomId", "getRoomId", "setRoomId", "myComment", "Lcom/bytedance/android/gamecp/business/comment/data/b;", "getMyComment", "()Lcom/bytedance/android/gamecp/business/comment/data/b;", "setMyComment", "(Lcom/bytedance/android/gamecp/business/comment/data/b;)V", "myCommentList", "Ljava/util/ArrayList;", "getMyCommentList", "()Ljava/util/ArrayList;", "setMyCommentList", "(Ljava/util/ArrayList;)V", "commentUpdateEvent$delegate", "getCommentUpdateEvent", "commentUpdateEvent", "", "Lcom/bytedance/android/gamecp/business/comment/data/j;", "tagList", "Ljava/util/List;", "getTagList", "()Ljava/util/List;", "setTagList", "(Ljava/util/List;)V", "selectedCommentTag", "Lcom/bytedance/android/gamecp/business/comment/data/j;", "getSelectedCommentTag", "()Lcom/bytedance/android/gamecp/business/comment/data/j;", "setSelectedCommentTag", "(Lcom/bytedance/android/gamecp/business/comment/data/j;)V", "likeCommentId$delegate", "getLikeCommentId", "likeCommentId", "deleteReplyId$delegate", "getDeleteReplyId", "deleteReplyId", "deleteReplyCommentId$delegate", "getDeleteReplyCommentId", "deleteReplyCommentId", "actionType$delegate", "getActionType", "scoreGuidePrompt$delegate", "getScoreGuidePrompt", "scoreGuidePrompt", "contentGuidePrompt", "getContentGuidePrompt", "setContentGuidePrompt", "showEntrance$delegate", "getShowEntrance", "showEntrance", "deviceSeries", "getDeviceSeries", "setDeviceSeries", "Lcom/bytedance/android/gamecp/business/comment/data/a;", "sendCharNumCheck", "Lcom/bytedance/android/gamecp/business/comment/data/a;", "getSendCharNumCheck", "()Lcom/bytedance/android/gamecp/business/comment/data/a;", "setSendCharNumCheck", "(Lcom/bytedance/android/gamecp/business/comment/data/a;)V", "Lcom/bytedance/android/gamecp/business/comment/data/p;", "firstMakeCommentGuide", "Lcom/bytedance/android/gamecp/business/comment/data/p;", "getFirstMakeCommentGuide", "()Lcom/bytedance/android/gamecp/business/comment/data/p;", "setFirstMakeCommentGuide", "(Lcom/bytedance/android/gamecp/business/comment/data/p;)V", "Lcom/bytedance/android/gamecp/business/comment/data/u;", "scoreGuide", "Lcom/bytedance/android/gamecp/business/comment/data/u;", "getScoreGuide", "()Lcom/bytedance/android/gamecp/business/comment/data/u;", "setScoreGuide", "(Lcom/bytedance/android/gamecp/business/comment/data/u;)V", "", "commentGuideTagList", "getCommentGuideTagList", "setCommentGuideTagList", "Lcom/bytedance/android/gamecp/business/comment/data/f;", "commentGameInfo", "Lcom/bytedance/android/gamecp/business/comment/data/f;", "getCommentGameInfo", "()Lcom/bytedance/android/gamecp/business/comment/data/f;", "setCommentGameInfo", "(Lcom/bytedance/android/gamecp/business/comment/data/f;)V", "commentAvgGrade", "Ljava/lang/Double;", "getCommentAvgGrade", "()Ljava/lang/Double;", "setCommentAvgGrade", "(Ljava/lang/Double;)V", "commentListEnterWay", "getCommentListEnterWay", "setCommentListEnterWay", "enableInternalEntrance", "Ljava/lang/Boolean;", "getEnableInternalEntrance", "()Ljava/lang/Boolean;", "setEnableInternalEntrance", "(Ljava/lang/Boolean;)V", "Lcom/bytedance/android/gamecp/business/gamedetail/base/model/k;", "dataChannelConfig", "Lcom/bytedance/android/gamecp/business/gamedetail/base/model/k;", "getDataChannelConfig", "()Lcom/bytedance/android/gamecp/business/gamedetail/base/model/k;", "setDataChannelConfig", "(Lcom/bytedance/android/gamecp/business/gamedetail/base/model/k;)V", "ifPromoteIcon", "getIfPromoteIcon", "setIfPromoteIcon", "promoteId", "getPromoteId", "setPromoteId", "hostId", "getHostId", "setHostId", "trackId", "getTrackId", "setTrackId", "isInNetworkRequest", "<init>", "()V", "Companion", "e", "f", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GamePromoteCommentViewModel extends BaseGamePromoteDetailViewModel {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    public static final e Companion = null;
    public static final int EVENT_COMMENT_UPDATE_DELETE = 3;
    public static final int EVENT_COMMENT_UPDATE_MODIFY = 2;
    public static final int EVENT_COMMENT_UPDATE_PUBLISH = 1;
    public static final String TAG = "GamePromoteCommentViewModel";
    private final com.bytedance.live.datacontext.p actionType$delegate;
    private String anchorId;
    private Double commentAvgGrade;
    private com.bytedance.android.gamecp.business.comment.data.f commentGameInfo;
    private List<String> commentGuideTagList;
    private com.bytedance.android.gamecp.business.comment.data.o commentInfo;
    private String commentListEnterWay;
    private final com.bytedance.live.datacontext.p commentUpdateEvent$delegate;
    private String contentGuidePrompt;
    private com.bytedance.android.gamecp.business.gamedetail.base.model.k dataChannelConfig;
    private final com.bytedance.live.datacontext.p deleteReplyCommentId$delegate;
    private final com.bytedance.live.datacontext.p deleteReplyId$delegate;
    private String deviceSeries;
    private Boolean enableInternalEntrance;
    private String enterFrom;
    private com.bytedance.android.gamecp.business.comment.data.p firstMakeCommentGuide;
    private FragmentManager fragmentManager;
    private String gameId;
    private com.bytedance.android.gamecp.business.v gameInfo;
    private String hostId;
    private String ifPromoteIcon;
    private final com.bytedance.live.datacontext.p imageList$delegate;
    private boolean isInNetworkRequest;
    private boolean isPromoter;
    private final com.bytedance.live.datacontext.p likeCommentId$delegate;
    private com.bytedance.android.gamecp.business.comment.data.b myComment;
    private ArrayList<com.bytedance.android.gamecp.business.comment.data.b> myCommentList;
    private String promoteId;
    private int promoteScene;
    private String roomId;
    private float score;
    private String scoreEvaluationId;
    private u scoreGuide;
    private final com.bytedance.live.datacontext.p scoreGuidePrompt$delegate;
    private final com.bytedance.live.datacontext.p scoreOnly$delegate;
    private com.bytedance.android.gamecp.business.comment.data.j selectedCommentTag;
    private com.bytedance.android.gamecp.business.comment.data.a sendCharNumCheck;
    private final com.bytedance.live.datacontext.p showEntrance$delegate;
    private List<com.bytedance.android.gamecp.business.comment.data.j> tagList;
    private String trackId;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GamePromoteCommentViewModel f52016a;

        public a(GamePromoteCommentViewModel r100) {
            this.f52016a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            com.bytedance.android.gamecp.business.comment.edit.w r101 = (com.bytedance.android.gamecp.business.comment.edit.w) r100;
            if ((!Intrinsics.areEqual(this.f52016a.getGameId(), r101.f52211a)) == true) goto L7;
            GamePromoteCommentViewModel.access$updateAfterPostComment(this.f52016a, r101.f52212b);
            return;
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f52017a = null;

        static {
            f52017a = new b();
        }

        public b() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            yr.c.e(GamePromoteCommentViewModel.TAG, "CommentUpdate error " + ((Throwable) r100));
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GamePromoteCommentViewModel f52018a;

        public c(GamePromoteCommentViewModel r100) {
            this.f52018a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            x r101 = (x) r100;
            if ((!Intrinsics.areEqual(this.f52018a.getGameId(), r101.f52213a)) == true) goto L7;
            GamePromoteCommentViewModel.access$updateAfterPostScore(this.f52018a, r101.f52215c, r101.f52214b);
            return;
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f52019a = null;

        static {
            f52019a = new d();
        }

        public d() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            yr.c.e(GamePromoteCommentViewModel.TAG, "CommentUpdate error " + ((Throwable) r100));
        }
    }

    public static final class e {
        public e() {
        }
    }

    public interface f {
        void a(com.bytedance.android.gamecp.business.comment.data.b r100, long r101);

        void onFail();
    }

    public static final class g<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GamePromoteCommentViewModel f52020a;

        public g(GamePromoteCommentViewModel r100) {
            this.f52020a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Disposable r101 = (Disposable) r100;
            GamePromoteCommentViewModel.access$setInNetworkRequest$p(this.f52020a, true);
        }
    }

    public static final class h implements Action {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GamePromoteCommentViewModel f52021a;

        public h(GamePromoteCommentViewModel r100) {
            this.f52021a = r100;
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
            GamePromoteCommentViewModel.access$setInNetworkRequest$p(this.f52021a, false);
        }
    }

    public static final class i<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f52022a;

        public i(Function0 r100) {
            this.f52022a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            com.bytedance.android.gamecp.base.network.response.h r101 = (com.bytedance.android.gamecp.base.network.response.h) r100;
            this.f52022a.invoke();
        }
    }

    public static final class j<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final j f52023a = null;

        static {
            f52023a = new j();
        }

        public j() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            if ((r101 instanceof CustomApiServerException) == false) goto L5;
            ToastUtil.b(((CustomApiServerException) r101).getPrompt(), 0);
            return;
        L5:
            ToastUtil.b(y0.i(R.string.ttlive_game_promote_comment_detail_error), 0);
        }
    }

    public static final class k implements Action {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GamePromoteCommentViewModel f52024a;

        public k(GamePromoteCommentViewModel r100) {
            this.f52024a = r100;
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
            GamePromoteCommentViewModel.access$setInNetworkRequest$p(this.f52024a, false);
        }
    }

    public static final class l<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GamePromoteCommentViewModel f52025a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function2 f52026b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f52027c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Integer f52028d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f52029e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ Long f52030f;

        public l(GamePromoteCommentViewModel r100, Function2 r101, int r102, Integer r103, String r104, Long r105) {
            this.f52025a = r100;
            this.f52026b = r101;
            this.f52027c = r102;
            this.f52028d = r103;
            this.f52029e = r104;
            this.f52030f = r105;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            com.bytedance.android.gamecp.base.network.response.h r101 = (com.bytedance.android.gamecp.base.network.response.h) r100;
            yr.c.a(GamePromoteCommentViewModel.TAG, "likeCommentRequest succ");
            this.f52026b.invoke(Integer.valueOf(this.f52027c), this.f52028d);
            String r102 = this.f52029e;
            if (r102 == null) goto L18;
            Long r103 = this.f52030f;
            boolean r104 = false;
            if (r103 == null) goto L7;
            int r105 = (int) r103.longValue();
        L8:
            if (r105 != 0) goto L10;
            r104 = true;
        L10:
            if (r104 == true) goto L13;
            r102 = null;
        L13:
            if (r102 == null) goto L19;
            this.f52025a.getLikeCommentId().setValue(r102);
            Integer r106 = this.f52028d;
            if (r106 == null) goto L20;
            r106.intValue();
            this.f52025a.getActionType().setValue(this.f52028d);
            return;
        L20:
            return;
        L19:
            return;
        L7:
            r105 = 0;
            goto L8
        }
    }

    public static final class m<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final m f52031a = null;

        static {
            f52031a = new m();
        }

        public m() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            if ((r101 instanceof CustomApiServerException) == false) goto L5;
            ToastUtil.b(((CustomApiServerException) r101).getPrompt(), 0);
            return;
        L5:
            ToastUtil.b(y0.i(R.string.ttlive_game_promote_comment_detail_error), 0);
        }
    }

    public static final class n implements Action {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GamePromoteCommentViewModel f52032a;

        public n(GamePromoteCommentViewModel r100) {
            this.f52032a = r100;
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
            GamePromoteCommentViewModel.access$setInNetworkRequest$p(this.f52032a, false);
        }
    }

    public static final class o<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f52033a;

        public o(Function1 r100) {
            this.f52033a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            com.bytedance.android.gamecp.base.network.response.h r101 = (com.bytedance.android.gamecp.base.network.response.h) r100;
            r r102 = (r) r101.data;
            int r103 = r102.auditStatus;
            String r104 = "";
            if (r103 != 0) goto L5;
        L10:
            Function1 r105 = this.f52033a;
            String r106 = ((r) r101.data).replyId;
            if (r106 == null) goto L14;
            r104 = r106;
        L14:
            r105.invoke(r104);
        L15:
            ToastUtil.b(((r) r101.data).auditToast, 0);
            return;
        L5:
            if (r103 == 3) goto L7;
        L9:
            this.f52033a.invoke("");
            goto L15
        L7:
            if (TextUtils.isEmpty(r102.replyId) == true) goto L9;
            goto L9
        }
    }

    public static final class p<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f52034a;

        public p(Function1 r100) {
            this.f52034a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            this.f52034a.invoke("");
            if ((r101 instanceof CustomApiServerException) == false) goto L5;
            ToastUtil.b(((CustomApiServerException) r101).getPrompt(), 0);
            return;
        L5:
            ToastUtil.b(y0.i(R.string.ttlive_game_promote_comment_detail_error), 0);
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(GamePromoteCommentViewModel.class, "scoreOnly", "getScoreOnly()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(GamePromoteCommentViewModel.class, "imageList", "getImageList()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(GamePromoteCommentViewModel.class, "commentUpdateEvent", "getCommentUpdateEvent()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(GamePromoteCommentViewModel.class, "likeCommentId", "getLikeCommentId()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(GamePromoteCommentViewModel.class, "deleteReplyId", "getDeleteReplyId()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(GamePromoteCommentViewModel.class, "deleteReplyCommentId", "getDeleteReplyCommentId()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(GamePromoteCommentViewModel.class, ReportConstant.COMMON_ACTION_TYPE, "getActionType()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(GamePromoteCommentViewModel.class, "scoreGuidePrompt", "getScoreGuidePrompt()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(GamePromoteCommentViewModel.class, "showEntrance", "getShowEntrance()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0))};
        Companion = new e();
    }

    private final com.bytedance.live.datacontext.m<ArrayList<com.bytedance.android.gamecp.base.core.service.depend.w>> getImageList() {
        return (com.bytedance.live.datacontext.m) this.imageList$delegate.a(this, $$delegatedProperties[1]);
    }

    public final com.bytedance.live.datacontext.m<Integer> getActionType() {
        return (com.bytedance.live.datacontext.m) this.actionType$delegate.a(this, $$delegatedProperties[6]);
    }

    public final com.bytedance.live.datacontext.m<Integer> getCommentUpdateEvent() {
        return (com.bytedance.live.datacontext.m) this.commentUpdateEvent$delegate.a(this, $$delegatedProperties[2]);
    }

    public final com.bytedance.live.datacontext.m<String> getDeleteReplyCommentId() {
        return (com.bytedance.live.datacontext.m) this.deleteReplyCommentId$delegate.a(this, $$delegatedProperties[5]);
    }

    public final com.bytedance.live.datacontext.m<String> getDeleteReplyId() {
        return (com.bytedance.live.datacontext.m) this.deleteReplyId$delegate.a(this, $$delegatedProperties[4]);
    }

    public final com.bytedance.live.datacontext.m<String> getLikeCommentId() {
        return (com.bytedance.live.datacontext.m) this.likeCommentId$delegate.a(this, $$delegatedProperties[3]);
    }

    public final com.bytedance.live.datacontext.m<String> getScoreGuidePrompt() {
        return (com.bytedance.live.datacontext.m) this.scoreGuidePrompt$delegate.a(this, $$delegatedProperties[7]);
    }

    public final com.bytedance.live.datacontext.m<Double> getScoreOnly() {
        return (com.bytedance.live.datacontext.m) this.scoreOnly$delegate.a(this, $$delegatedProperties[0]);
    }

    public final com.bytedance.live.datacontext.m<Boolean> getShowEntrance() {
        return (com.bytedance.live.datacontext.m) this.showEntrance$delegate.a(this, $$delegatedProperties[8]);
    }

    private final void dataChannelMonitorLink() {
        com.bytedance.android.gamecp.business.gamedetail.base.model.k r100 = this.dataChannelConfig;
        if (r100 == null) goto L20;
        String r101 = r100.a();
        if (r101 != null) goto L7;
    L10:
        boolean r102 = true;
    L11:
        if (r102 == true) goto L21;
        HashMap r103 = new HashMap();
        com.bytedance.android.gamecp.business.gamedetail.base.model.k r104 = this.dataChannelConfig;
        if (r104 == null) goto L17;
        String r105 = r104.a();
        if (r105 == null) goto L17;
    L18:
        r103.put("game_id", r105);
        r103.put("action_type", "detail_comment");
        int r106 = this.promoteScene;
        r103.put("is_ads", i0.d(r106));
        r103.put("host_id", this.promoteId);
        r103.put(com.bytedance.android.ec.core.event.a.KEY_CONTENT_ID, this.hostId);
        r103.put("scene", String.valueOf(r106));
        r103.put("req_id", i0.f(r106));
        r103.put("if_promote_icon", this.ifPromoteIcon);
        DataChannelMonitorLinkHandler.h("douyin_game_content_consume_click_monitor", r103);
        return;
    L17:
        r105 = "";
        goto L18
    L21:
        return;
    L7:
        if (r101.length() == 0) goto L10;
        r102 = false;
        goto L11
    }

    public GamePromoteCommentViewModel() {
        this.gameId = "";
        this.scoreOnly$delegate = com.bytedance.live.datacontext.q.d(this, Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE));
        this.scoreEvaluationId = "";
        this.imageList$delegate = com.bytedance.live.datacontext.q.d(this, new ArrayList());
        this.enterFrom = "";
        Room r100 = com.bytedance.android.gamecp.host_api.a.b().getLiveService().getRoomData();
        if (r100 == null) goto L7;
        String r101 = r100.getOwnerUserId();
        if (r101 == null) goto L7;
    L8:
        this.anchorId = r101;
        Room r102 = com.bytedance.android.gamecp.host_api.a.b().getLiveService().getRoomData();
        if (r102 == null) goto L12;
        String r103 = String.valueOf(r102.getId());
        if (r103 == null) goto L12;
    L13:
        this.roomId = r103;
        this.myCommentList = new ArrayList();
        this.commentUpdateEvent$delegate = com.bytedance.live.datacontext.q.d(this, 0);
        this.tagList = new ArrayList();
        this.likeCommentId$delegate = com.bytedance.live.datacontext.q.d(this, "");
        this.deleteReplyId$delegate = com.bytedance.live.datacontext.q.d(this, "");
        this.deleteReplyCommentId$delegate = com.bytedance.live.datacontext.q.d(this, "");
        this.actionType$delegate = com.bytedance.live.datacontext.q.d(this, 0);
        this.scoreGuidePrompt$delegate = com.bytedance.live.datacontext.q.d(this, "");
        this.contentGuidePrompt = "";
        this.showEntrance$delegate = com.bytedance.live.datacontext.q.d(this, Boolean.FALSE);
        this.deviceSeries = "";
        this.commentListEnterWay = "";
        this.ifPromoteIcon = "0";
        this.promoteId = "";
        this.hostId = "";
        this.trackId = "";
        bind(jv.a.a().c(com.bytedance.android.gamecp.business.comment.edit.w.class).subscribe(new a(this), b.f52017a));
        bind(jv.a.a().c(x.class).subscribe(new c(this), d.f52019a));
        return;
    L12:
        r103 = "";
    L7:
        r101 = "";
        goto L8
    }

    public final String getAnchorId() {
        return this.anchorId;
    }

    public final Double getCommentAvgGrade() {
        return this.commentAvgGrade;
    }

    public final com.bytedance.android.gamecp.business.comment.data.f getCommentGameInfo() {
        return this.commentGameInfo;
    }

    public final List<String> getCommentGuideTagList() {
        return this.commentGuideTagList;
    }

    public final com.bytedance.android.gamecp.business.comment.data.o getCommentInfo() {
        return this.commentInfo;
    }

    public final String getCommentListEnterWay() {
        return this.commentListEnterWay;
    }

    public final String getContentGuidePrompt() {
        return this.contentGuidePrompt;
    }

    public final com.bytedance.android.gamecp.business.gamedetail.base.model.k getDataChannelConfig() {
        return this.dataChannelConfig;
    }

    public final String getDeviceSeries() {
        return this.deviceSeries;
    }

    public final Boolean getEnableInternalEntrance() {
        return this.enableInternalEntrance;
    }

    public final String getEnterFrom() {
        return this.enterFrom;
    }

    public final com.bytedance.android.gamecp.business.comment.data.p getFirstMakeCommentGuide() {
        return this.firstMakeCommentGuide;
    }

    public final FragmentManager getFragmentManager() {
        return this.fragmentManager;
    }

    public final String getGameId() {
        return this.gameId;
    }

    public final com.bytedance.android.gamecp.business.v getGameInfo() {
        return this.gameInfo;
    }

    public final String getHostId() {
        return this.hostId;
    }

    public final String getIfPromoteIcon() {
        return this.ifPromoteIcon;
    }

    public final com.bytedance.android.gamecp.business.comment.data.b getMyComment() {
        return this.myComment;
    }

    public final ArrayList<com.bytedance.android.gamecp.business.comment.data.b> getMyCommentList() {
        return this.myCommentList;
    }

    public final String getPromoteId() {
        return this.promoteId;
    }

    public final int getPromoteScene() {
        return this.promoteScene;
    }

    public final String getRoomId() {
        return this.roomId;
    }

    public final float getScore() {
        return this.score;
    }

    public final String getScoreEvaluationId() {
        return this.scoreEvaluationId;
    }

    public final u getScoreGuide() {
        return this.scoreGuide;
    }

    public final com.bytedance.android.gamecp.business.comment.data.j getSelectedCommentTag() {
        return this.selectedCommentTag;
    }

    public final com.bytedance.android.gamecp.business.comment.data.a getSendCharNumCheck() {
        return this.sendCharNumCheck;
    }

    public final List<com.bytedance.android.gamecp.business.comment.data.j> getTagList() {
        return this.tagList;
    }

    public final String getTrackId() {
        return this.trackId;
    }

    public final boolean isPromoter() {
        return this.isPromoter;
    }

    public static final /* synthetic */ boolean access$isInNetworkRequest$p(GamePromoteCommentViewModel r100) {
        return r100.isInNetworkRequest;
    }

    private final void updateAfterPostComment(com.bytedance.android.gamecp.business.comment.data.b r100) {
        this.myComment = r100;
        ListProtector.add(this.myCommentList, 0, r100);
        getCommentUpdateEvent().setValue(1);
        StringBuilder r101 = new StringBuilder("CommentUpdate suc insert ");
        com.bytedance.android.gamecp.business.comment.data.o r102 = r100.evaluationInfo;
        if (r102 == null) goto L5;
        Long r103 = Long.valueOf(r102.evaluationId);
    L6:
        r101.append(r103);
        yr.c.e(TAG, r101.toString());
        getShowEntrance().setValue(Boolean.FALSE);
        getScoreOnly().setValue(Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE));
        this.scoreEvaluationId = "";
        dataChannelMonitorLink();
        return;
    L5:
        r103 = null;
        goto L6
    }

    public final void setAnchorId(String r100) {
        this.anchorId = r100;
    }

    public final void setCommentAvgGrade(Double r100) {
        this.commentAvgGrade = r100;
    }

    public final void setCommentGameInfo(com.bytedance.android.gamecp.business.comment.data.f r100) {
        this.commentGameInfo = r100;
    }

    public final void setCommentGuideTagList(List<String> r100) {
        this.commentGuideTagList = r100;
    }

    public final void setCommentInfo(com.bytedance.android.gamecp.business.comment.data.o r100) {
        this.commentInfo = r100;
    }

    public final void setCommentListEnterWay(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.commentListEnterWay = r100;
    }

    public final void setContentGuidePrompt(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.contentGuidePrompt = r100;
    }

    public final void setDataChannelConfig(com.bytedance.android.gamecp.business.gamedetail.base.model.k r100) {
        this.dataChannelConfig = r100;
    }

    public final void setDeviceSeries(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.deviceSeries = r100;
    }

    public final void setEnableInternalEntrance(Boolean r100) {
        this.enableInternalEntrance = r100;
    }

    public final void setEnterFrom(String r100) {
        this.enterFrom = r100;
    }

    public final void setFirstMakeCommentGuide(com.bytedance.android.gamecp.business.comment.data.p r100) {
        this.firstMakeCommentGuide = r100;
    }

    public final void setFragmentManager(FragmentManager r100) {
        this.fragmentManager = r100;
    }

    public final void setGameId(String r100) {
        this.gameId = r100;
    }

    public final void setGameInfo(com.bytedance.android.gamecp.business.v r100) {
        this.gameInfo = r100;
    }

    public final void setHostId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.hostId = r100;
    }

    public final void setIfPromoteIcon(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.ifPromoteIcon = r100;
    }

    public final void setMyComment(com.bytedance.android.gamecp.business.comment.data.b r100) {
        this.myComment = r100;
    }

    public final void setMyCommentList(ArrayList<com.bytedance.android.gamecp.business.comment.data.b> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.myCommentList = r100;
    }

    public final void setPromoteId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.promoteId = r100;
    }

    public final void setPromoteScene(int r100) {
        this.promoteScene = r100;
    }

    public final void setPromoter(boolean r100) {
        this.isPromoter = r100;
    }

    public final void setRoomId(String r100) {
        this.roomId = r100;
    }

    public final void setScore(float r100) {
        this.score = r100;
    }

    public final void setScoreEvaluationId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.scoreEvaluationId = r100;
    }

    public final void setScoreGuide(u r100) {
        this.scoreGuide = r100;
    }

    public final void setSelectedCommentTag(com.bytedance.android.gamecp.business.comment.data.j r100) {
        this.selectedCommentTag = r100;
    }

    public final void setSendCharNumCheck(com.bytedance.android.gamecp.business.comment.data.a r100) {
        this.sendCharNumCheck = r100;
    }

    public final void setTagList(List<com.bytedance.android.gamecp.business.comment.data.j> r100) {
        this.tagList = r100;
    }

    public final void setTrackId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.trackId = r100;
    }

    public final void updateEntranceInfo(com.bytedance.android.gamecp.business.comment.data.d r100) {
        com.bytedance.live.datacontext.m<String> r101 = getScoreGuidePrompt();
        String r102 = "";
        if (r100 == null) goto L6;
        String r103 = r100.scoreGuidePrompt;
        if (r103 == null) goto L6;
    L7:
        r101.setValue(r103);
        if (r100 == null) goto L11;
        String r104 = r100.contentGuidePrompt;
        if (r104 == null) goto L11;
    L12:
        this.contentGuidePrompt = r104;
        if (isCleared() == true) goto L21;
        com.bytedance.live.datacontext.m<Boolean> r105 = getShowEntrance();
        if (r100 == null) goto L19;
        Boolean r106 = r100.showEntrance;
        if (r106 == null) goto L19;
        boolean r107 = r106.booleanValue();
    L20:
        r105.setValue(Boolean.valueOf(r107));
    L19:
        r107 = false;
    L21:
        if (r100 == null) goto L24;
        String r108 = r100.deviceSeries;
        if (r108 == null) goto L24;
    L25:
        this.deviceSeries = r108;
        com.bytedance.android.gamecp.business.comment.data.f r109 = null;
        if (r100 == null) goto L28;
        com.bytedance.android.gamecp.business.comment.data.a r110 = r100.sendCharNumCheck;
    L29:
        this.sendCharNumCheck = r110;
        if (r100 == null) goto L32;
        com.bytedance.android.gamecp.business.comment.data.p r111 = r100.firstMakeCommentGuide;
    L33:
        this.firstMakeCommentGuide = r111;
        if (r100 == null) goto L36;
        u r112 = r100.scoreGuide;
    L37:
        this.scoreGuide = r112;
        if (r100 == null) goto L40;
        List<String> r113 = r100.commentGuideTagList;
    L41:
        this.commentGuideTagList = r113;
        if (r100 == null) goto L44;
        r109 = r100.gameInfo;
    L44:
        this.commentGameInfo = r109;
        if (r100 == null) goto L52;
        com.bytedance.android.gamecp.business.comment.data.o r114 = r100.userScoreEvaluation;
        if (r114 == null) goto L52;
        String r115 = String.valueOf(r114.evaluationId);
        if (r115 == null) goto L52;
        r102 = r115;
    L52:
        this.scoreEvaluationId = r102;
        return;
    L40:
        r113 = null;
        goto L41
    L36:
        r112 = null;
        goto L37
    L32:
        r111 = null;
        goto L33
    L28:
        r110 = null;
    L24:
        r108 = "";
    L11:
        r104 = "";
    L6:
        r103 = "";
        goto L7
    }

    public static final /* synthetic */ void access$setInNetworkRequest$p(GamePromoteCommentViewModel r100, boolean r101) {
        r100.isInNetworkRequest = r101;
    }

    public static final /* synthetic */ void access$updateAfterPostComment(GamePromoteCommentViewModel r100, com.bytedance.android.gamecp.business.comment.data.b r101) {
        r100.updateAfterPostComment(r101);
    }

    private final void updateAfterPostScore(double r100, String r101) {
        getScoreOnly().setValue(Double.valueOf(r100));
        this.scoreEvaluationId = r101;
    }

    public final void deleteComment(String r100, Function0<Unit> r101) {
        Intrinsics.checkNotNullParameter(r101, "callback");
        if (this.isInNetworkRequest == false) goto L5;
        return;
    L5:
        Observable<com.bytedance.android.gamecp.base.network.response.h<Unit>> r102 = ((GamePromoteApi) bs.e.a().b(GamePromoteApi.class)).deleteEvaluation(r100);
        if (r102 == null) goto L17;
        Observable<com.bytedance.android.gamecp.base.network.response.h<Unit>> r103 = r102.observeOn(AndroidSchedulers.mainThread());
        if (r103 == null) goto L18;
        Observable<com.bytedance.android.gamecp.base.network.response.h<Unit>> r104 = r103.doOnSubscribe(new g(this));
        if (r104 == null) goto L19;
        Observable<com.bytedance.android.gamecp.base.network.response.h<Unit>> r105 = r104.doFinally(new h(this));
        if (r105 == null) goto L20;
        Disposable r106 = r105.subscribe(new i(r101), j.f52023a);
        if (r106 == null) goto L21;
        bind(r106);
        return;
    L21:
        return;
    L20:
        return;
    L19:
        return;
    L18:
        return;
    }

    public final void deleteComment(Long r100, Function0<Unit> r101) {
        Intrinsics.checkNotNullParameter(r101, "callback");
        deleteComment(String.valueOf(r100), r101);
    }

    public static final /* synthetic */ void access$updateAfterPostScore(GamePromoteCommentViewModel r100, double r101, String r102) {
        r100.updateAfterPostScore(r101, r102);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void deleteComment$default(GamePromoteCommentViewModel r100, Long r101, Function0 r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L5;
        r102 = AnonymousClass1.INSTANCE;
    L5:
        r100.deleteComment(r101, r102);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void deleteComment$default(GamePromoteCommentViewModel r100, String r101, Function0 r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L5;
        r102 = AnonymousClass2.INSTANCE;
    L5:
        r100.deleteComment(r101, r102);
    }

    public final void sendCommentReply(Context r100, String r101, String r102, String r103, Long r104, String r105, String r106, String r107, Function1<? super String, Unit> r110) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r110, "callback");
        if (com.bytedance.android.gamecp.host_api.a.b().getUserService().user().isLogin() == true) goto L7;
        com.bytedance.android.gamecp.host_api.a.b().getUserService().user().c(r100, new com.bytedance.android.gamecp.host_api.model.user.c(new com.bytedance.android.gamecp.host_api.model.user.c.a())).observeOn(AndroidSchedulers.mainThread()).subscribe(hv.d.f487274b, hv.d.f487273a);
        ToastUtil.b(y0.i(R.string.ttlive_game_promote_login_to_reply), 0);
        return;
    L7:
        if (this.isInNetworkRequest == false) goto L9;
        return;
    L9:
        this.isInNetworkRequest = true;
        HashMap r108 = new HashMap();
        r108.put("game_id", String.valueOf(r101));
        r108.put("content", String.valueOf(r102));
        r108.put("eval_id", String.valueOf(r103));
        r108.put(GXTemplateKey.GAIAX_LAYER, String.valueOf(r104));
        if (TextUtils.isEmpty(r105) == true) goto L13;
        r108.put("reply_to_comment_id", String.valueOf(r105));
    L13:
        if (TextUtils.isEmpty(r106) == true) goto L16;
        r108.put("reply_to_user_id", String.valueOf(r106));
    L16:
        if (TextUtils.isEmpty(r107) == true) goto L18;
        r108.put("reply_to_reply_id", String.valueOf(r107));
    L18:
        Observable<com.bytedance.android.gamecp.base.network.response.h<r>> r109 = ((GamePromoteApi) bs.e.a().b(GamePromoteApi.class)).makeReply(r108);
        if (r109 == null) goto L28;
        Observable<com.bytedance.android.gamecp.base.network.response.h<r>> r111 = r109.observeOn(AndroidSchedulers.mainThread());
        if (r111 == null) goto L29;
        Observable<com.bytedance.android.gamecp.base.network.response.h<r>> r112 = r111.doFinally(new n(this));
        if (r112 == null) goto L30;
        Disposable r113 = r112.subscribe(new o(r110), new p(r110));
        if (r113 == null) goto L31;
        bind(r113);
        return;
    L31:
        return;
    L30:
        return;
    L29:
        return;
    }

    public final void requestLikeAction(Context r110, int r111, String r112, Integer r113, Integer r114, String r115, Long r116, String r117, String r118, Function2<? super Integer, ? super Integer, Unit> r210) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r210, "onSuccess");
        int r100 = 0;
        if (com.bytedance.android.gamecp.host_api.a.b().getUserService().user().isLogin() == true) goto L7;
        com.bytedance.android.gamecp.host_api.a.b().getUserService().user().c(r110, new com.bytedance.android.gamecp.host_api.model.user.c(new com.bytedance.android.gamecp.host_api.model.user.c.a())).observeOn(AndroidSchedulers.mainThread()).subscribe(hv.d.f487274b, hv.d.f487273a);
        ToastUtil.b(y0.i(R.string.ttlive_game_promote_login_to_like), 0);
        return;
    L7:
        if (this.isInNetworkRequest == false) goto L9;
        return;
    L9:
        this.isInNetworkRequest = true;
        HashMap r101 = new HashMap();
        r101.put("eval_id", String.valueOf(r112));
        r101.put("game_id", String.valueOf(this.gameId));
        r101.put("relation_type", String.valueOf(r113));
        r101.put("action_type", String.valueOf(r114));
        if (r116 == null) goto L12;
        r100 = (int) r116.longValue();
    L12:
        if (r100 == 0) goto L15;
        r101.put(GXTemplateKey.GAIAX_LAYER, String.valueOf(r116));
    L15:
        if (TextUtils.isEmpty(r117) == true) goto L18;
        r101.put("comment_id", String.valueOf(r117));
    L18:
        if (TextUtils.isEmpty(r118) == true) goto L20;
        r101.put("parent_id", String.valueOf(r118));
    L20:
        Observable<com.bytedance.android.gamecp.base.network.response.h<Unit>> r102 = ((GamePromoteApi) bs.e.a().b(GamePromoteApi.class)).likeCommentRequest(r101);
        if (r102 == null) goto L30;
        Observable<com.bytedance.android.gamecp.base.network.response.h<Unit>> r103 = r102.observeOn(AndroidSchedulers.mainThread());
        if (r103 == null) goto L31;
        Observable<com.bytedance.android.gamecp.base.network.response.h<Unit>> r104 = r103.doFinally(new k(this));
        if (r104 == null) goto L32;
        Disposable r105 = r104.subscribe(new l(this, r210, r111, r114, r112, r116), m.f52031a);
        if (r105 == null) goto L33;
        bind(r105);
        return;
    L33:
        return;
    L32:
        return;
    L31:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void sendCommentReply$default(GamePromoteCommentViewModel r110, Context r111, String r112, String r113, String r114, Long r115, String r116, String r210, String r211, Function1 r212, int r213, Object r214) {
        if ((r213 & 32) == 0) goto L5;
        String r100 = "";
    L7:
        if ((r213 & 64) == 0) goto L9;
        String r117 = "";
    L11:
        if ((r213 & 128) == 0) goto L13;
        String r118 = "";
    L15:
        if ((r213 & 256) == 0) goto L17;
        Function1 r119 = C98661.INSTANCE;
    L18:
        r110.sendCommentReply(r111, r112, r113, r114, r115, r100, r117, r118, r119);
        return;
    L17:
        r119 = r212;
        goto L18
    L13:
        r118 = r211;
        goto L15
    L9:
        r117 = r210;
        goto L11
    L5:
        r100 = r116;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void requestLikeAction$default(GamePromoteCommentViewModel r110, Context r111, int r112, String r113, Integer r114, Integer r115, String r116, Long r210, String r211, String r212, Function2 r213, int r214, Object r215) {
        if ((r214 & 64) == 0) goto L5;
        Long r100 = 0L;
    L7:
        if ((r214 & 128) == 0) goto L9;
        String r117 = "";
    L11:
        if ((r214 & 256) == 0) goto L13;
        String r118 = "";
    L15:
        if ((r214 & 512) == 0) goto L17;
        Function2 r119 = C98651.INSTANCE;
    L18:
        r110.requestLikeAction(r111, r112, r113, r114, r115, r116, r100, r117, r118, r119);
        return;
    L17:
        r119 = r213;
        goto L18
    L13:
        r118 = r212;
        goto L15
    L9:
        r117 = r211;
        goto L11
    L5:
        r100 = r210;
        goto L7
    }
}
