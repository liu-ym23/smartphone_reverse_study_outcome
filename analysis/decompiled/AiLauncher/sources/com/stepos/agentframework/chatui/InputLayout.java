package com.stepos.agentframework.chatui;

import Z8.C1173v;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.AgentUIConfig;
import com.stepos.agentframework.R$id;
import com.stepos.agentframework.R$layout;
import com.stepos.agentframework.chatcore.SessionHandler;
import com.stepos.agentframework.chatcore.file.FileInfo;
import com.stepos.agentframework.chatcore.session.AgentError;
import com.stepos.agentframework.chatcore.utils.ExtKt;
import com.stepos.agentframework.file.FileManager;
import d.AbstractC3936b;
import h8.C4148a;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import kotlin.C4848b;
import kotlin.Metadata;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import t4.InterfaceC5507a;
import y4.InterfaceC5940b;

@Metadata(d1 = {"\u0000ü\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000f\u0010\rJ\u000f\u0010\u0010\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0010\u0010\rJ\u0017\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0015\u0010\rJ\u001b\u0010\u0018\u001a\u00020\u000b2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u001a\u0010\rJ\u000f\u0010\u001b\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u001b\u0010\rJ\u000f\u0010\u001c\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u001c\u0010\rJ\u000f\u0010\u001d\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u001d\u0010\rJ\u0011\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0002¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u000bH\u0016¢\u0006\u0004\b!\u0010\rJ\u0019\u0010#\u001a\u00020\u000b2\b\u0010\"\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b#\u0010\u0019J\u0019\u0010&\u001a\u00020\u000b2\b\u0010%\u001a\u0004\u0018\u00010$H\u0016¢\u0006\u0004\b&\u0010'J\u0019\u0010)\u001a\u00020\u000b2\b\u0010%\u001a\u0004\u0018\u00010(H\u0016¢\u0006\u0004\b)\u0010*J\u0019\u0010,\u001a\u00020\u000b2\b\u0010%\u001a\u0004\u0018\u00010+H\u0016¢\u0006\u0004\b,\u0010-J\u0019\u0010/\u001a\u00020\u000b2\b\u0010%\u001a\u0004\u0018\u00010.H\u0016¢\u0006\u0004\b/\u00100J\u0019\u00102\u001a\u00020\u000b2\b\u0010%\u001a\u0004\u0018\u000101H\u0016¢\u0006\u0004\b2\u00103J#\u00106\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010!*\u0002042\u0006\u00105\u001a\u00020\u0007H\u0016¢\u0006\u0004\b6\u00107J\u000f\u00108\u001a\u00020\u000bH\u0016¢\u0006\u0004\b8\u0010\rJ\u000f\u00109\u001a\u00020\u000bH\u0016¢\u0006\u0004\b9\u0010\rJ\u0017\u0010;\u001a\u00020\u000b2\u0006\u0010:\u001a\u00020\u0011H\u0016¢\u0006\u0004\b;\u0010\u0014J\u0017\u0010=\u001a\u00020\u000b2\u0006\u0010<\u001a\u00020\u0016H\u0016¢\u0006\u0004\b=\u0010\u0019J\u0015\u0010@\u001a\u00020\u000b2\u0006\u0010?\u001a\u00020>¢\u0006\u0004\b@\u0010AJ\u0015\u0010B\u001a\u00020\u000b2\u0006\u0010?\u001a\u00020>¢\u0006\u0004\bB\u0010AJ\u000f\u0010C\u001a\u000204H\u0016¢\u0006\u0004\bC\u0010DJ\u0019\u0010F\u001a\u00020\u000b2\b\u0010E\u001a\u0004\u0018\u00010\u001eH\u0016¢\u0006\u0004\bF\u0010GJ+\u0010J\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010I\u001a\u0004\u0018\u00010HH\u0016¢\u0006\u0004\bJ\u0010KJ\u0015\u0010N\u001a\u00020\u000b2\u0006\u0010M\u001a\u00020L¢\u0006\u0004\bN\u0010OJ\u000f\u0010P\u001a\u00020\u000bH\u0016¢\u0006\u0004\bP\u0010\rJ\r\u0010Q\u001a\u00020\u000b¢\u0006\u0004\bQ\u0010\rJ\r\u0010R\u001a\u00020\u000b¢\u0006\u0004\bR\u0010\rJ\u001b\u0010U\u001a\u00020\u000b2\f\u0010T\u001a\b\u0012\u0004\u0012\u00020>0S¢\u0006\u0004\bU\u0010VR\u0014\u0010W\u001a\u00020\u00168\u0002X\u0082D¢\u0006\u0006\n\u0004\bW\u0010XR\"\u0010Z\u001a\u00020Y8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\bZ\u0010[\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_R\u0016\u0010a\u001a\u00020`8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\ba\u0010bR\u0016\u0010c\u001a\u00020`8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bc\u0010bR\u0016\u0010e\u001a\u00020d8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\be\u0010fR\"\u0010g\u001a\u00020\u00018\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\bg\u0010h\u001a\u0004\bi\u0010j\"\u0004\bk\u0010lR\u0016\u0010m\u001a\u00020`8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bm\u0010bR\u0016\u0010n\u001a\u00020\u00018\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bn\u0010hR\u0016\u0010o\u001a\u00020`8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bo\u0010bR\u0016\u0010p\u001a\u00020\u00018\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bp\u0010hR\"\u0010q\u001a\u00020d8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\bq\u0010f\u001a\u0004\br\u0010s\"\u0004\bt\u0010uR\"\u0010v\u001a\u00020d8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\bv\u0010f\u001a\u0004\bw\u0010s\"\u0004\bx\u0010uR\"\u0010z\u001a\u00020y8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\bz\u0010{\u001a\u0004\b|\u0010}\"\u0004\b~\u0010\u007fR*\u0010\u0081\u0001\u001a\u00030\u0080\u00018\u0006@\u0006X\u0086.¢\u0006\u0018\n\u0006\b\u0081\u0001\u0010\u0082\u0001\u001a\u0006\b\u0083\u0001\u0010\u0084\u0001\"\u0006\b\u0085\u0001\u0010\u0086\u0001R&\u0010\u0087\u0001\u001a\u00020\u00018\u0006@\u0006X\u0086.¢\u0006\u0015\n\u0005\b\u0087\u0001\u0010h\u001a\u0005\b\u0088\u0001\u0010j\"\u0005\b\u0089\u0001\u0010lR&\u0010\u008a\u0001\u001a\u00020d8\u0006@\u0006X\u0086.¢\u0006\u0015\n\u0005\b\u008a\u0001\u0010f\u001a\u0005\b\u008b\u0001\u0010s\"\u0005\b\u008c\u0001\u0010uR\u001a\u0010\u008e\u0001\u001a\u00030\u008d\u00018\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\b\u008e\u0001\u0010\u008f\u0001R\u001a\u0010\u0091\u0001\u001a\u00030\u0090\u00018\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\b\u0091\u0001\u0010\u0092\u0001R\u001a\u0010\u0094\u0001\u001a\u00030\u0093\u00018\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\b\u0094\u0001\u0010\u0095\u0001R\u001a\u0010\u0096\u0001\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0096\u0001\u0010XR(\u0010\u0097\u0001\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0006\b\u0097\u0001\u0010\u0098\u0001\u001a\u0006\b\u0097\u0001\u0010\u0099\u0001\"\u0005\b\u009a\u0001\u0010\u0014R\u0019\u0010\u009b\u0001\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009b\u0001\u0010\u0098\u0001R\"\u0010\u009d\u0001\u001a\u000b\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u009c\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009d\u0001\u0010\u009e\u0001R\u0019\u0010\u009f\u0001\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009f\u0001\u0010 \u0001R\u001f\u0010¤\u0001\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\u000f\n\u0006\b¡\u0001\u0010¢\u0001\u001a\u0005\b£\u0001\u0010jR\u001f\u0010§\u0001\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\u000f\n\u0006\b¥\u0001\u0010¢\u0001\u001a\u0005\b¦\u0001\u0010jR\u001b\u0010¨\u0001\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¨\u0001\u0010©\u0001R\u001b\u0010ª\u0001\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bª\u0001\u0010«\u0001R\u001b\u0010¬\u0001\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¬\u0001\u0010\u00ad\u0001R\u001b\u0010®\u0001\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b®\u0001\u0010¯\u0001R\u001b\u0010°\u0001\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b°\u0001\u0010±\u0001R\u001c\u0010³\u0001\u001a\u0005\u0018\u00010²\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b³\u0001\u0010´\u0001R\u001a\u0010¶\u0001\u001a\u00030µ\u00018\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\b¶\u0001\u0010·\u0001R\u0018\u0010¹\u0001\u001a\u00030¸\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¹\u0001\u0010º\u0001R)\u0010»\u0001\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0005\b»\u0001\u0010X\u001a\u0006\b¼\u0001\u0010½\u0001\"\u0005\b¾\u0001\u0010\u0019R9\u0010Á\u0001\u001a\u0012\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020\u00160À\u0001\u0018\u00010¿\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÁ\u0001\u0010Â\u0001\u001a\u0006\bÃ\u0001\u0010Ä\u0001\"\u0006\bÅ\u0001\u0010Æ\u0001¨\u0006Ç\u0001"}, d2 = {"Lcom/stepos/agentframework/chatui/InputLayout;", "Landroid/widget/LinearLayout;", "Ly4/b;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "LY8/t;", "y", "()V", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "U", "H", "", "hasText", ExifInterface.LONGITUDE_WEST, "(Z)V", "G", "", "txt", ExifInterface.LONGITUDE_EAST, "(Ljava/lang/String;)V", "x", "w", "R", "C", "Lcom/stepos/agentframework/chatcore/SessionHandler;", "getSessionHandler", "()Lcom/stepos/agentframework/chatcore/SessionHandler;", ExifInterface.GPS_DIRECTION_TRUE, "message", "f", "Ly4/b$f;", "listener", "setOnSendMessageListener", "(Ly4/b$f;)V", "Ly4/b$d;", "setOnImageClickListener", "(Ly4/b$d;)V", "Ly4/b$c;", "setOnFileClickListener", "(Ly4/b$c;)V", "Ly4/b$b;", "setOnCancelListener", "(Ly4/b$b;)V", "Ly4/b$a;", "setOnBtnPlusClickListener", "(Ly4/b$a;)V", "Landroid/view/View;", "id", Const.INTENT_KEY_APIKEY, "(I)Landroid/view/View;", Const.INTENT_KEY_UMID, "e", "isReplying", "setReplyingStatus", "text", "setInputTxt", "Lcom/stepos/agentframework/chatcore/file/FileInfo;", "imageItem", "v", "(Lcom/stepos/agentframework/chatcore/file/FileInfo;)V", "X", "getView", "()Landroid/view/View;", "handler", Const.INTENT_KEY_PKGNAME, "(Lcom/stepos/agentframework/chatcore/SessionHandler;)V", "Lcom/stepos/agentframework/AgentUIConfig;", "agentUIConfig", "c", "(Landroid/content/Context;Landroid/util/AttributeSet;Lcom/stepos/agentframework/AgentUIConfig;)V", "Lcom/stepos/agentframework/file/b;", Const.JSON_KEY_PROVIDER, "setPickFileProvider", "(Lcom/stepos/agentframework/file/b;)V", "destroy", "B", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "files", "Y", "(Ljava/util/List;)V", "TAG", "Ljava/lang/String;", "Landroidx/appcompat/widget/AppCompatEditText;", "etMessage", "Landroidx/appcompat/widget/AppCompatEditText;", "getEtMessage", "()Landroidx/appcompat/widget/AppCompatEditText;", "setEtMessage", "(Landroidx/appcompat/widget/AppCompatEditText;)V", "Landroidx/appcompat/widget/AppCompatImageView;", "btnSend", "Landroidx/appcompat/widget/AppCompatImageView;", "btnCancel", "Landroid/widget/ImageView;", "btnPlus", "Landroid/widget/ImageView;", "llBottomOptions", "Landroid/widget/LinearLayout;", "getLlBottomOptions", "()Landroid/widget/LinearLayout;", "setLlBottomOptions", "(Landroid/widget/LinearLayout;)V", "btnImage", "llImage", "btnFile", "llFile", "ivVoiceInput", "getIvVoiceInput", "()Landroid/widget/ImageView;", "setIvVoiceInput", "(Landroid/widget/ImageView;)V", "ivKeyboard", "getIvKeyboard", "setIvKeyboard", "Landroid/widget/TextView;", "tvVoiceOutput", "Landroid/widget/TextView;", "getTvVoiceOutput", "()Landroid/widget/TextView;", "setTvVoiceOutput", "(Landroid/widget/TextView;)V", "Landroidx/constraintlayout/widget/ConstraintLayout;", "clVoiceInput", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getClVoiceInput", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "setClVoiceInput", "(Landroidx/constraintlayout/widget/ConstraintLayout;)V", "llEdit", "getLlEdit", "setLlEdit", "ivExitEdit", "getIvExitEdit", "setIvExitEdit", "Landroidx/recyclerview/widget/RecyclerView;", "rvInputImages", "Landroidx/recyclerview/widget/RecyclerView;", "Landroid/widget/CheckedTextView;", "tvDeepThink", "Landroid/widget/CheckedTextView;", "Lcom/stepos/agentframework/chatui/w1;", "chatInputImageAdapter", "Lcom/stepos/agentframework/chatui/w1;", "voiceText", "isBottomOptionsExpanded", "Z", "()Z", "setBottomOptionsExpanded", "isWaitingReply", "Ljava/lang/ref/WeakReference;", "mSessionHandlerRef", "Ljava/lang/ref/WeakReference;", "picAndFileReadyStatus", "I", "llThink$delegate", "LY8/h;", "getLlThink", "llThink", "rootInput$delegate", "getRootInput", "rootInput", "onSendButtonClickedListener", "Ly4/b$f;", "onImageClickListener", "Ly4/b$d;", "onFileClickListener", "Ly4/b$c;", "onCancelListener", "Ly4/b$b;", "onBtnPlusClickListener", "Ly4/b$a;", "Lcom/stepos/agentframework/file/FileManager;", "fileManager", "Lcom/stepos/agentframework/file/FileManager;", "Lt4/a;", "fileUploadListener", "Lt4/a;", "LUa/M;", "uploadAuditScope", "LUa/M;", "auditUserId", "getAuditUserId", "()Ljava/lang/String;", "setAuditUserId", "Ld/b;", "", "result", "Ld/b;", "getResult", "()Ld/b;", "setResult", "(Ld/b;)V", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class InputLayout extends LinearLayout implements InterfaceC5940b {
    private final String TAG;
    private String auditUserId;
    private AppCompatImageView btnCancel;
    private AppCompatImageView btnFile;
    private AppCompatImageView btnImage;
    private ImageView btnPlus;
    private AppCompatImageView btnSend;
    private C2116w1 chatInputImageAdapter;
    public ConstraintLayout clVoiceInput;
    public AppCompatEditText etMessage;
    private FileManager fileManager;
    private InterfaceC5507a fileUploadListener;
    private boolean isBottomOptionsExpanded;
    private boolean isWaitingReply;
    public ImageView ivExitEdit;
    public ImageView ivKeyboard;
    public ImageView ivVoiceInput;
    public LinearLayout llBottomOptions;
    public LinearLayout llEdit;
    private LinearLayout llFile;
    private LinearLayout llImage;

    /* renamed from: llThink$delegate, reason: from kotlin metadata */
    private final Y8.h llThink;
    private WeakReference<SessionHandler> mSessionHandlerRef;
    private InterfaceC5940b.a onBtnPlusClickListener;
    private InterfaceC5940b.InterfaceC0556b onCancelListener;
    private InterfaceC5940b.c onFileClickListener;
    private InterfaceC5940b.d onImageClickListener;
    private InterfaceC5940b.f onSendButtonClickedListener;
    private int picAndFileReadyStatus;
    private AbstractC3936b<String[]> result;

    /* renamed from: rootInput$delegate, reason: from kotlin metadata */
    private final Y8.h rootInput;
    private RecyclerView rvInputImages;
    private CheckedTextView tvDeepThink;
    public TextView tvVoiceOutput;
    private final Ua.M uploadAuditScope;
    private String voiceText;

    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"com/stepos/agentframework/chatui/InputLayout$a", "Lcom/stepos/agentframework/file/FileManager$a;", "", "Lcom/stepos/agentframework/chatcore/file/FileInfo;", "files", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Ljava/util/List;)V", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a implements FileManager.a {
        public a() {
        }

        @Override // com.stepos.agentframework.file.FileManager.a
        public void a(List<FileInfo> files) {
            kotlin.jvm.internal.p.i(files, "files");
            C4148a.d(InputLayout.this.TAG, "file selected file: " + files, false, 4, null);
            InputLayout inputLayout = InputLayout.this;
            Iterator<T> it = files.iterator();
            while (it.hasNext()) {
                inputLayout.v((FileInfo) it.next());
            }
            InputLayout.this.Y(files);
        }
    }

    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"com/stepos/agentframework/chatui/InputLayout$b", "Lcom/stepos/agentframework/file/FileManager$a;", "", "Lcom/stepos/agentframework/chatcore/file/FileInfo;", "images", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Ljava/util/List;)V", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b implements FileManager.a {
        public b() {
        }

        @Override // com.stepos.agentframework.file.FileManager.a
        public void a(List<FileInfo> images) {
            kotlin.jvm.internal.p.i(images, "images");
            C4148a.d(InputLayout.this.TAG, "file selected images: " + images, false, 4, null);
            InputLayout inputLayout = InputLayout.this;
            Iterator<T> it = images.iterator();
            while (it.hasNext()) {
                inputLayout.v((FileInfo) it.next());
            }
            InputLayout.this.Y(images);
        }
    }

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"com/stepos/agentframework/chatui/InputLayout$c", "Lt4/a;", "Lcom/stepos/agentframework/chatcore/file/FileInfo;", "fileInfo", "", "progress", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/agentframework/chatcore/file/FileInfo;I)V", Const.INTENT_KEY_PKGNAME, "(Lcom/stepos/agentframework/chatcore/file/FileInfo;)V", "Lcom/stepos/agentframework/chatcore/session/AgentError;", "e", "c", "(Lcom/stepos/agentframework/chatcore/file/FileInfo;Lcom/stepos/agentframework/chatcore/session/AgentError;)V", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class c implements InterfaceC5507a {
        public c() {
        }

        @Override // t4.InterfaceC5507a
        public void a(FileInfo fileInfo, int progress) {
            kotlin.jvm.internal.p.i(fileInfo, "fileInfo");
            C4148a.d(InputLayout.this.TAG, "file uploading process: " + fileInfo + ", progress: " + progress, false, 4, null);
            fileInfo.setUploadState(FileInfo.UploadState.UPLOADING);
            fileInfo.setProgress(progress);
            InputLayout.this.X(fileInfo);
        }

        @Override // t4.InterfaceC5507a
        public void b(FileInfo fileInfo) {
            kotlin.jvm.internal.p.i(fileInfo, "fileInfo");
            C4148a.d(InputLayout.this.TAG, "file upload onSuccess file path: " + fileInfo.getFilePath() + " fileId:" + fileInfo.getFileId(), false, 4, null);
            if (com.stepos.agentframework.chatcore.audit.k.INSTANCE.c()) {
                return;
            }
            fileInfo.setUploadState(FileInfo.UploadState.SUCCESS);
            fileInfo.setProgress(100);
            InputLayout.this.X(fileInfo);
        }

        @Override // t4.InterfaceC5507a
        public void c(FileInfo fileInfo, AgentError e10) {
            kotlin.jvm.internal.p.i(fileInfo, "fileInfo");
            kotlin.jvm.internal.p.i(e10, "e");
            C2116w1 c2116w1 = null;
            if (e10.getCode() == 10105) {
                C4148a.u(InputLayout.this.TAG, "upload audit blocked fileId=" + fileInfo.getFileId() + " msg=" + e10.getMessage(), false, 4, null);
                C2116w1 c2116w12 = InputLayout.this.chatInputImageAdapter;
                if (c2116w12 == null) {
                    kotlin.jvm.internal.p.A("chatInputImageAdapter");
                } else {
                    c2116w1 = c2116w12;
                }
                c2116w1.v(fileInfo.getFileId());
                Toast.makeText(InputLayout.this.getContext(), com.stepos.agentframework.chatcore.audit.k.INSTANCE.h(), 0).show();
                return;
            }
            C4148a.g(InputLayout.this.TAG, "upload failed fileId=" + fileInfo.getFileId() + " code=" + e10.getCode() + " msg=" + e10.getMessage(), e10, false, 8, null);
            C2116w1 c2116w13 = InputLayout.this.chatInputImageAdapter;
            if (c2116w13 == null) {
                kotlin.jvm.internal.p.A("chatInputImageAdapter");
            } else {
                c2116w1 = c2116w13;
            }
            fileInfo.setUploadState(FileInfo.UploadState.FAILED);
            fileInfo.setError(e10.getMessage());
            c2116w1.y(fileInfo);
        }
    }

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J1\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ1\u0010\f\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\nJ\u0019\u0010\u000e\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"com/stepos/agentframework/chatui/InputLayout$d", "Landroid/text/TextWatcher;", "", "s", "", "start", "count", "after", "LY8/t;", "beforeTextChanged", "(Ljava/lang/CharSequence;III)V", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "(Landroid/text/Editable;)V", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class d implements TextWatcher {
        public d() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable s10) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence s10, int start, int count, int after) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence s10, int start, int before, int count) {
            InputLayout.this.G();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public InputLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        kotlin.jvm.internal.p.i(context, "context");
    }

    public static final LinearLayout D(InputLayout inputLayout) {
        return (LinearLayout) inputLayout.findViewById(R$id.rootInput);
    }

    private final void E(String txt) {
        String string;
        this.voiceText = "";
        if (getLlEdit().getVisibility() == 0) {
            ExtKt.m(getLlEdit());
        }
        if (getEtMessage().getVisibility() == 0) {
            string = La.H.D1(String.valueOf(getEtMessage().getText())).toString();
        } else if (txt == null || txt.length() == 0) {
            return;
        } else {
            string = La.H.D1(txt).toString();
        }
        C2116w1 c2116w1 = this.chatInputImageAdapter;
        if (c2116w1 == null) {
            kotlin.jvm.internal.p.A("chatInputImageAdapter");
            c2116w1 = null;
        }
        List<FileInfo> listK = c2116w1.k();
        C2116w1 c2116w12 = this.chatInputImageAdapter;
        if (c2116w12 == null) {
            kotlin.jvm.internal.p.A("chatInputImageAdapter");
            c2116w12 = null;
        }
        if ((string + Z8.F.A0(c2116w12.n(), "", null, null, 0, null, null, 62, null)).length() > 0) {
            InterfaceC5940b.f fVar = this.onSendButtonClickedListener;
            if (fVar != null) {
                InterfaceC5940b.f.b(fVar, string.length() == 0 ? null : string, listK, null, 4, null);
            }
            d();
        }
    }

    public static /* synthetic */ void F(InputLayout inputLayout, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = null;
        }
        inputLayout.E(str);
    }

    public static final void I(InputLayout inputLayout, View view) {
        inputLayout.getClass();
        inputLayout.isBottomOptionsExpanded = !inputLayout.isBottomOptionsExpanded;
        inputLayout.getLlBottomOptions().setVisibility(inputLayout.isBottomOptionsExpanded ? 0 : 8);
        ImageView imageView = inputLayout.btnPlus;
        if (imageView == null) {
            kotlin.jvm.internal.p.A("btnPlus");
            imageView = null;
        }
        imageView.setSelected(inputLayout.getLlBottomOptions().getVisibility() == 0);
    }

    public static final void J(InputLayout inputLayout, View view) {
        C4148a.d(inputLayout.TAG, "点击发送", false, 4, null);
        F(inputLayout, null, 1, null);
    }

    public static final void K(InputLayout inputLayout, View view) {
        InterfaceC5940b.InterfaceC0556b interfaceC0556b = inputLayout.onCancelListener;
        if (interfaceC0556b != null) {
            interfaceC0556b.onCancel();
        }
    }

    public static final void L(InputLayout inputLayout, View view) {
        inputLayout.x();
        inputLayout.getLlBottomOptions().setVisibility(8);
        ImageView imageView = inputLayout.btnPlus;
        if (imageView == null) {
            kotlin.jvm.internal.p.A("btnPlus");
            imageView = null;
        }
        imageView.setSelected(inputLayout.getLlBottomOptions().getVisibility() == 0);
        inputLayout.isBottomOptionsExpanded = false;
    }

    public static final void M(InputLayout inputLayout, View view) throws Throwable {
        inputLayout.w();
        inputLayout.getLlBottomOptions().setVisibility(8);
        ImageView imageView = inputLayout.btnPlus;
        if (imageView == null) {
            kotlin.jvm.internal.p.A("btnPlus");
            imageView = null;
        }
        imageView.setSelected(inputLayout.getLlBottomOptions().getVisibility() == 0);
        inputLayout.isBottomOptionsExpanded = false;
    }

    public static final void N(InputLayout inputLayout, View view) {
        com.stepos.agentframework.util.A a10 = com.stepos.agentframework.util.A.INSTANCE;
        Context context = inputLayout.getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        a10.a(context, inputLayout);
        inputLayout.T();
    }

    public static final void O(InputLayout inputLayout, View view) {
        String str = inputLayout.voiceText;
        if (str == null) {
            str = "";
        }
        inputLayout.U();
        inputLayout.getEtMessage().setText(str, TextView.BufferType.EDITABLE);
        inputLayout.G();
    }

    public static final void P(InputLayout inputLayout, View view) {
        CheckedTextView checkedTextView = inputLayout.tvDeepThink;
        CheckedTextView checkedTextView2 = null;
        if (checkedTextView == null) {
            kotlin.jvm.internal.p.A("tvDeepThink");
            checkedTextView = null;
        }
        CheckedTextView checkedTextView3 = inputLayout.tvDeepThink;
        if (checkedTextView3 == null) {
            kotlin.jvm.internal.p.A("tvDeepThink");
            checkedTextView3 = null;
        }
        checkedTextView.setChecked(!checkedTextView3.isChecked());
        com.stepos.agentframework.util.E eA = com.stepos.agentframework.util.E.INSTANCE.a();
        Context context = inputLayout.getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        String strA = com.stepos.agentframework.util.C.INSTANCE.a();
        CheckedTextView checkedTextView4 = inputLayout.tvDeepThink;
        if (checkedTextView4 == null) {
            kotlin.jvm.internal.p.A("tvDeepThink");
        } else {
            checkedTextView2 = checkedTextView4;
        }
        com.stepos.agentframework.util.E.k(eA, context, strA, checkedTextView2.isChecked(), null, 8, null);
    }

    public static final void Q(InputLayout inputLayout, View view) {
        ExtKt.m(inputLayout.getLlEdit());
        inputLayout.getEtMessage().setText((CharSequence) null);
        com.stepos.agentframework.util.A a10 = com.stepos.agentframework.util.A.INSTANCE;
        Context context = inputLayout.getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        a10.a(context, inputLayout);
    }

    public static final Y8.t S(InputLayout inputLayout, int i10) {
        inputLayout.picAndFileReadyStatus = i10;
        inputLayout.G();
        return Y8.t.f7040a;
    }

    private final SessionHandler getSessionHandler() {
        WeakReference<SessionHandler> weakReference = this.mSessionHandlerRef;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public static final LinearLayout z(InputLayout inputLayout) {
        return (LinearLayout) inputLayout.findViewById(R$id.ll_think);
    }

    public final void A() throws Throwable {
        FileManager fileManager = this.fileManager;
        if (fileManager != null) {
            fileManager.i(new a());
        }
        FileManager fileManager2 = this.fileManager;
        if (fileManager2 != null) {
            fileManager2.g();
        }
    }

    public final void B() {
        FileManager fileManager = this.fileManager;
        if (fileManager != null) {
            fileManager.h(new b());
        }
    }

    public final void C() {
        this.fileUploadListener = new c();
    }

    public final void G() {
        CharSequence text;
        Editable text2;
        if (!this.isWaitingReply) {
            if (getEtMessage().getVisibility() != 0 ? (text = getTvVoiceOutput().getText()) == null || text.length() == 0 : (text2 = getEtMessage().getText()) == null || text2.length() == 0) {
                z = false;
            }
            W(z);
            return;
        }
        AppCompatImageView appCompatImageView = this.btnSend;
        ImageView imageView = null;
        if (appCompatImageView == null) {
            kotlin.jvm.internal.p.A("btnSend");
            appCompatImageView = null;
        }
        appCompatImageView.setVisibility(8);
        ImageView imageView2 = this.btnPlus;
        if (imageView2 == null) {
            kotlin.jvm.internal.p.A("btnPlus");
            imageView2 = null;
        }
        imageView2.setVisibility(8);
        AppCompatImageView appCompatImageView2 = this.btnCancel;
        if (appCompatImageView2 == null) {
            kotlin.jvm.internal.p.A("btnCancel");
            appCompatImageView2 = null;
        }
        appCompatImageView2.setVisibility(0);
        getLlBottomOptions().setVisibility(8);
        this.isBottomOptionsExpanded = false;
        ImageView imageView3 = this.btnPlus;
        if (imageView3 == null) {
            kotlin.jvm.internal.p.A("btnPlus");
        } else {
            imageView = imageView3;
        }
        imageView.setSelected(getLlBottomOptions().getVisibility() == 0);
    }

    public final void H() {
        ImageView imageView = this.btnPlus;
        CheckedTextView checkedTextView = null;
        if (imageView == null) {
            kotlin.jvm.internal.p.A("btnPlus");
            imageView = null;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.agentframework.chatui.Z1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InputLayout.I(this.f22841a, view);
            }
        });
        AppCompatImageView appCompatImageView = this.btnSend;
        if (appCompatImageView == null) {
            kotlin.jvm.internal.p.A("btnSend");
            appCompatImageView = null;
        }
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.agentframework.chatui.a2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InputLayout.J(this.f22845a, view);
            }
        });
        AppCompatImageView appCompatImageView2 = this.btnCancel;
        if (appCompatImageView2 == null) {
            kotlin.jvm.internal.p.A("btnCancel");
            appCompatImageView2 = null;
        }
        appCompatImageView2.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.agentframework.chatui.b2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InputLayout.K(this.f22865a, view);
            }
        });
        LinearLayout linearLayout = this.llImage;
        if (linearLayout == null) {
            kotlin.jvm.internal.p.A("llImage");
            linearLayout = null;
        }
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.agentframework.chatui.c2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InputLayout.L(this.f22870a, view);
            }
        });
        LinearLayout linearLayout2 = this.llFile;
        if (linearLayout2 == null) {
            kotlin.jvm.internal.p.A("llFile");
            linearLayout2 = null;
        }
        linearLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.agentframework.chatui.d2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws Throwable {
                InputLayout.M(this.f22875a, view);
            }
        });
        getIvVoiceInput().setOnClickListener(new View.OnClickListener() { // from class: com.stepos.agentframework.chatui.e2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InputLayout.N(this.f22951a, view);
            }
        });
        getIvKeyboard().setOnClickListener(new View.OnClickListener() { // from class: com.stepos.agentframework.chatui.f2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InputLayout.O(this.f22953a, view);
            }
        });
        getEtMessage().addTextChangedListener(new d());
        CheckedTextView checkedTextView2 = this.tvDeepThink;
        if (checkedTextView2 == null) {
            kotlin.jvm.internal.p.A("tvDeepThink");
        } else {
            checkedTextView = checkedTextView2;
        }
        checkedTextView.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.agentframework.chatui.g2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InputLayout.P(this.f22966a, view);
            }
        });
        getIvExitEdit().setOnClickListener(new View.OnClickListener() { // from class: com.stepos.agentframework.chatui.W1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InputLayout.Q(this.f22835a, view);
            }
        });
    }

    public final void R() {
        RecyclerView recyclerView = this.rvInputImages;
        C2116w1 c2116w1 = null;
        if (recyclerView == null) {
            kotlin.jvm.internal.p.A("rvInputImages");
            recyclerView = null;
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        Context context = getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        C2116w1 c2116w12 = new C2116w1(context);
        this.chatInputImageAdapter = c2116w12;
        c2116w12.x(new InterfaceC5074l() { // from class: com.stepos.agentframework.chatui.X1
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return InputLayout.S(this.f22836a, ((Integer) obj).intValue());
            }
        });
        RecyclerView recyclerView2 = this.rvInputImages;
        if (recyclerView2 == null) {
            kotlin.jvm.internal.p.A("rvInputImages");
            recyclerView2 = null;
        }
        C2116w1 c2116w13 = this.chatInputImageAdapter;
        if (c2116w13 == null) {
            kotlin.jvm.internal.p.A("chatInputImageAdapter");
        } else {
            c2116w1 = c2116w13;
        }
        recyclerView2.setAdapter(c2116w1);
    }

    public void T() {
        V();
    }

    public final void U() {
        getTvVoiceOutput().setVisibility(8);
        getIvKeyboard().setVisibility(8);
        getEtMessage().setVisibility(0);
        getIvVoiceInput().setVisibility(0);
    }

    public final void V() {
        getEtMessage().setVisibility(8);
        getIvVoiceInput().setVisibility(8);
        getTvVoiceOutput().setVisibility(0);
        getIvKeyboard().setVisibility(0);
    }

    public final void W(boolean hasText) {
        ImageView imageView = null;
        if ((!hasText || this.picAndFileReadyStatus == -1) && (hasText || this.picAndFileReadyStatus != 1)) {
            AppCompatImageView appCompatImageView = this.btnSend;
            if (appCompatImageView == null) {
                kotlin.jvm.internal.p.A("btnSend");
                appCompatImageView = null;
            }
            appCompatImageView.setVisibility(8);
            ImageView imageView2 = this.btnPlus;
            if (imageView2 == null) {
                kotlin.jvm.internal.p.A("btnPlus");
                imageView2 = null;
            }
            imageView2.setVisibility(0);
            AppCompatImageView appCompatImageView2 = this.btnCancel;
            if (appCompatImageView2 == null) {
                kotlin.jvm.internal.p.A("btnCancel");
            } else {
                imageView = appCompatImageView2;
            }
            imageView.setVisibility(8);
            return;
        }
        AppCompatImageView appCompatImageView3 = this.btnSend;
        if (appCompatImageView3 == null) {
            kotlin.jvm.internal.p.A("btnSend");
            appCompatImageView3 = null;
        }
        appCompatImageView3.setVisibility(0);
        ImageView imageView3 = this.btnPlus;
        if (imageView3 == null) {
            kotlin.jvm.internal.p.A("btnPlus");
            imageView3 = null;
        }
        imageView3.setVisibility(8);
        AppCompatImageView appCompatImageView4 = this.btnCancel;
        if (appCompatImageView4 == null) {
            kotlin.jvm.internal.p.A("btnCancel");
            appCompatImageView4 = null;
        }
        appCompatImageView4.setVisibility(8);
        getLlBottomOptions().setVisibility(8);
        ImageView imageView4 = this.btnPlus;
        if (imageView4 == null) {
            kotlin.jvm.internal.p.A("btnPlus");
        } else {
            imageView = imageView4;
        }
        imageView.setSelected(getLlBottomOptions().getVisibility() == 0);
        this.isBottomOptionsExpanded = false;
    }

    public final void X(FileInfo imageItem) {
        kotlin.jvm.internal.p.i(imageItem, "imageItem");
        C2116w1 c2116w1 = this.chatInputImageAdapter;
        if (c2116w1 == null) {
            kotlin.jvm.internal.p.A("chatInputImageAdapter");
            c2116w1 = null;
        }
        c2116w1.y(imageItem);
    }

    public final void Y(List<FileInfo> files) {
        kotlin.jvm.internal.p.i(files, "files");
        SessionHandler sessionHandler = getSessionHandler();
        String str = this.TAG;
        InterfaceC5507a interfaceC5507a = null;
        C4148a.k(str, "uploadFile called, files=" + files.size() + ", handler=" + (sessionHandler != null), false, 4, null);
        if (sessionHandler != null) {
            InterfaceC5507a interfaceC5507a2 = this.fileUploadListener;
            if (interfaceC5507a2 == null) {
                kotlin.jvm.internal.p.A("fileUploadListener");
            } else {
                interfaceC5507a = interfaceC5507a2;
            }
            sessionHandler.k4(files, interfaceC5507a);
        }
    }

    @Override // y4.InterfaceC5940b, y4.InterfaceC5939a
    public <T extends View> T a(int id) {
        T etMessage;
        if (id == R$id.iv_exit_edit) {
            etMessage = getIvExitEdit();
        } else if (id == R$id.ll_edit) {
            etMessage = getLlEdit();
        } else if (id == R$id.tv_deep_think) {
            etMessage = this.tvDeepThink;
            if (etMessage == null) {
                kotlin.jvm.internal.p.A("tvDeepThink");
            }
        } else if (id == R$id.rv_input_images) {
            etMessage = this.rvInputImages;
            if (etMessage == null) {
                kotlin.jvm.internal.p.A("rvInputImages");
            }
        } else if (id == R$id.tv_voice_input) {
            etMessage = getClVoiceInput();
        } else if (id == R$id.tv_voice_output) {
            etMessage = getTvVoiceOutput();
        } else if (id == R$id.iv_keyboard) {
            etMessage = getIvKeyboard();
        } else if (id == R$id.iv_voice_input) {
            etMessage = getIvVoiceInput();
        } else if (id == R$id.llPickFile) {
            etMessage = this.llFile;
            if (etMessage == null) {
                kotlin.jvm.internal.p.A("llFile");
            }
        } else if (id == R$id.btn_file) {
            etMessage = this.btnFile;
            if (etMessage == null) {
                kotlin.jvm.internal.p.A("btnFile");
            }
        } else if (id == R$id.llPickImg) {
            etMessage = this.llImage;
            if (etMessage == null) {
                kotlin.jvm.internal.p.A("llImage");
            }
        } else if (id == R$id.btn_image) {
            etMessage = this.btnImage;
            if (etMessage == null) {
                kotlin.jvm.internal.p.A("btnImage");
            }
        } else if (id == R$id.ll_bottom_options) {
            etMessage = getLlBottomOptions();
        } else if (id == R$id.btn_plus) {
            etMessage = this.btnPlus;
            if (etMessage == null) {
                kotlin.jvm.internal.p.A("btnPlus");
            }
        } else if (id == R$id.btn_cancel) {
            etMessage = this.btnCancel;
            if (etMessage == null) {
                kotlin.jvm.internal.p.A("btnCancel");
            }
        } else if (id == R$id.btn_send) {
            etMessage = this.btnSend;
            if (etMessage == null) {
                kotlin.jvm.internal.p.A("btnSend");
            }
        } else {
            etMessage = id == R$id.et_message ? getEtMessage() : null;
        }
        return etMessage == null ? (T) super.a(id) : etMessage;
    }

    @Override // y4.InterfaceC5939a
    public void b(SessionHandler handler) {
        this.mSessionHandlerRef = new WeakReference<>(handler);
    }

    @Override // y4.InterfaceC5939a
    public void c(Context context, AttributeSet attrs, AgentUIConfig agentUIConfig) {
        kotlin.jvm.internal.p.i(context, "context");
        this.fileManager = new FileManager(context);
        C();
        if (agentUIConfig != null) {
            setVisibility(agentUIConfig.getWithInputLayout() ? 0 : 8);
        }
    }

    @Override // y4.InterfaceC5940b
    public void d() {
        Editable text = getEtMessage().getText();
        if (text != null) {
            text.clear();
        }
        C2116w1 c2116w1 = this.chatInputImageAdapter;
        if (c2116w1 == null) {
            kotlin.jvm.internal.p.A("chatInputImageAdapter");
            c2116w1 = null;
        }
        c2116w1.w(C1173v.m());
    }

    @Override // y4.InterfaceC5939a
    public void destroy() {
        kotlinx.coroutines.d.e(this.uploadAuditScope, null, 1, null);
    }

    @Override // y4.InterfaceC5940b
    public void e() {
        G();
    }

    @Override // y4.InterfaceC5940b
    public void f(String message) {
        if (message != null) {
            if (La.H.x0(message)) {
                message = null;
            }
            if (message != null) {
                U();
            }
        }
    }

    public final String getAuditUserId() {
        return this.auditUserId;
    }

    public final ConstraintLayout getClVoiceInput() {
        ConstraintLayout constraintLayout = this.clVoiceInput;
        if (constraintLayout != null) {
            return constraintLayout;
        }
        kotlin.jvm.internal.p.A("clVoiceInput");
        return null;
    }

    public final AppCompatEditText getEtMessage() {
        AppCompatEditText appCompatEditText = this.etMessage;
        if (appCompatEditText != null) {
            return appCompatEditText;
        }
        kotlin.jvm.internal.p.A("etMessage");
        return null;
    }

    public final ImageView getIvExitEdit() {
        ImageView imageView = this.ivExitEdit;
        if (imageView != null) {
            return imageView;
        }
        kotlin.jvm.internal.p.A("ivExitEdit");
        return null;
    }

    public final ImageView getIvKeyboard() {
        ImageView imageView = this.ivKeyboard;
        if (imageView != null) {
            return imageView;
        }
        kotlin.jvm.internal.p.A("ivKeyboard");
        return null;
    }

    public final ImageView getIvVoiceInput() {
        ImageView imageView = this.ivVoiceInput;
        if (imageView != null) {
            return imageView;
        }
        kotlin.jvm.internal.p.A("ivVoiceInput");
        return null;
    }

    public final LinearLayout getLlBottomOptions() {
        LinearLayout linearLayout = this.llBottomOptions;
        if (linearLayout != null) {
            return linearLayout;
        }
        kotlin.jvm.internal.p.A("llBottomOptions");
        return null;
    }

    public final LinearLayout getLlEdit() {
        LinearLayout linearLayout = this.llEdit;
        if (linearLayout != null) {
            return linearLayout;
        }
        kotlin.jvm.internal.p.A("llEdit");
        return null;
    }

    public final LinearLayout getLlThink() {
        Object value = this.llThink.getValue();
        kotlin.jvm.internal.p.h(value, "getValue(...)");
        return (LinearLayout) value;
    }

    public final AbstractC3936b<String[]> getResult() {
        return this.result;
    }

    public final LinearLayout getRootInput() {
        Object value = this.rootInput.getValue();
        kotlin.jvm.internal.p.h(value, "getValue(...)");
        return (LinearLayout) value;
    }

    public final TextView getTvVoiceOutput() {
        TextView textView = this.tvVoiceOutput;
        if (textView != null) {
            return textView;
        }
        kotlin.jvm.internal.p.A("tvVoiceOutput");
        return null;
    }

    @Override // y4.InterfaceC5939a
    public View getView() {
        return this;
    }

    public final void setAuditUserId(String str) {
        this.auditUserId = str;
    }

    public final void setBottomOptionsExpanded(boolean z10) {
        this.isBottomOptionsExpanded = z10;
    }

    public final void setClVoiceInput(ConstraintLayout constraintLayout) {
        kotlin.jvm.internal.p.i(constraintLayout, "<set-?>");
        this.clVoiceInput = constraintLayout;
    }

    public final void setEtMessage(AppCompatEditText appCompatEditText) {
        kotlin.jvm.internal.p.i(appCompatEditText, "<set-?>");
        this.etMessage = appCompatEditText;
    }

    @Override // y4.InterfaceC5940b
    public /* bridge */ void setInputMoreBtnEnable(boolean z10) {
        super.setInputMoreBtnEnable(z10);
    }

    @Override // y4.InterfaceC5940b
    public void setInputTxt(String text) {
        kotlin.jvm.internal.p.i(text, "text");
        getEtMessage().setText(text);
        getEtMessage().requestFocus();
        getEtMessage().setSelection(text.length());
    }

    public final void setIvExitEdit(ImageView imageView) {
        kotlin.jvm.internal.p.i(imageView, "<set-?>");
        this.ivExitEdit = imageView;
    }

    public final void setIvKeyboard(ImageView imageView) {
        kotlin.jvm.internal.p.i(imageView, "<set-?>");
        this.ivKeyboard = imageView;
    }

    public final void setIvVoiceInput(ImageView imageView) {
        kotlin.jvm.internal.p.i(imageView, "<set-?>");
        this.ivVoiceInput = imageView;
    }

    public final void setLlBottomOptions(LinearLayout linearLayout) {
        kotlin.jvm.internal.p.i(linearLayout, "<set-?>");
        this.llBottomOptions = linearLayout;
    }

    public final void setLlEdit(LinearLayout linearLayout) {
        kotlin.jvm.internal.p.i(linearLayout, "<set-?>");
        this.llEdit = linearLayout;
    }

    @Override // y4.InterfaceC5940b
    public void setOnBtnPlusClickListener(InterfaceC5940b.a listener) {
    }

    @Override // y4.InterfaceC5940b
    public void setOnCancelListener(InterfaceC5940b.InterfaceC0556b listener) {
        this.onCancelListener = listener;
    }

    @Override // y4.InterfaceC5940b
    public void setOnFileClickListener(InterfaceC5940b.c listener) {
    }

    @Override // y4.InterfaceC5940b
    public void setOnImageClickListener(InterfaceC5940b.d listener) {
    }

    @Override // y4.InterfaceC5940b
    public /* bridge */ void setOnLoadingBubbleListener(InterfaceC5940b.e eVar) {
        super.setOnLoadingBubbleListener(eVar);
    }

    @Override // y4.InterfaceC5940b
    public void setOnSendMessageListener(InterfaceC5940b.f listener) {
        this.onSendButtonClickedListener = listener;
    }

    public final void setPickFileProvider(com.stepos.agentframework.file.b provider) {
        kotlin.jvm.internal.p.i(provider, "provider");
        FileManager fileManager = this.fileManager;
        if (fileManager != null) {
            fileManager.j(provider);
        }
    }

    @Override // y4.InterfaceC5940b
    public void setReplyingStatus(boolean isReplying) {
        if (this.isWaitingReply != isReplying) {
            this.isWaitingReply = isReplying;
            G();
        }
    }

    public final void setResult(AbstractC3936b<String[]> abstractC3936b) {
        this.result = abstractC3936b;
    }

    public final void setTvVoiceOutput(TextView textView) {
        kotlin.jvm.internal.p.i(textView, "<set-?>");
        this.tvVoiceOutput = textView;
    }

    public final void v(FileInfo imageItem) {
        kotlin.jvm.internal.p.i(imageItem, "imageItem");
        C2116w1 c2116w1 = this.chatInputImageAdapter;
        if (c2116w1 == null) {
            kotlin.jvm.internal.p.A("chatInputImageAdapter");
            c2116w1 = null;
        }
        c2116w1.j(imageItem);
    }

    public final void w() throws Throwable {
        A();
    }

    public final void x() {
        C4148a.d(this.TAG, "onImageClick", false, 4, null);
        B();
    }

    public final void y() {
        LayoutInflater.from(getContext()).inflate(R$layout.layout_agent_input, (ViewGroup) this, true);
        setOrientation(1);
        View viewFindViewById = findViewById(R$id.et_message);
        kotlin.jvm.internal.p.h(viewFindViewById, "findViewById(...)");
        setEtMessage((AppCompatEditText) viewFindViewById);
        View viewFindViewById2 = findViewById(R$id.btn_send);
        kotlin.jvm.internal.p.h(viewFindViewById2, "findViewById(...)");
        this.btnSend = (AppCompatImageView) viewFindViewById2;
        View viewFindViewById3 = findViewById(R$id.btn_cancel);
        kotlin.jvm.internal.p.h(viewFindViewById3, "findViewById(...)");
        this.btnCancel = (AppCompatImageView) viewFindViewById3;
        View viewFindViewById4 = findViewById(R$id.btn_plus);
        kotlin.jvm.internal.p.h(viewFindViewById4, "findViewById(...)");
        this.btnPlus = (ImageView) viewFindViewById4;
        View viewFindViewById5 = findViewById(R$id.ll_bottom_options);
        kotlin.jvm.internal.p.h(viewFindViewById5, "findViewById(...)");
        setLlBottomOptions((LinearLayout) viewFindViewById5);
        View viewFindViewById6 = findViewById(R$id.btn_image);
        kotlin.jvm.internal.p.h(viewFindViewById6, "findViewById(...)");
        this.btnImage = (AppCompatImageView) viewFindViewById6;
        View viewFindViewById7 = findViewById(R$id.llPickImg);
        kotlin.jvm.internal.p.h(viewFindViewById7, "findViewById(...)");
        this.llImage = (LinearLayout) viewFindViewById7;
        View viewFindViewById8 = findViewById(R$id.btn_file);
        kotlin.jvm.internal.p.h(viewFindViewById8, "findViewById(...)");
        this.btnFile = (AppCompatImageView) viewFindViewById8;
        View viewFindViewById9 = findViewById(R$id.llPickFile);
        kotlin.jvm.internal.p.h(viewFindViewById9, "findViewById(...)");
        this.llFile = (LinearLayout) viewFindViewById9;
        View viewFindViewById10 = findViewById(R$id.iv_voice_input);
        kotlin.jvm.internal.p.h(viewFindViewById10, "findViewById(...)");
        setIvVoiceInput((ImageView) viewFindViewById10);
        View viewFindViewById11 = findViewById(R$id.iv_keyboard);
        kotlin.jvm.internal.p.h(viewFindViewById11, "findViewById(...)");
        setIvKeyboard((ImageView) viewFindViewById11);
        View viewFindViewById12 = findViewById(R$id.tv_voice_output);
        kotlin.jvm.internal.p.h(viewFindViewById12, "findViewById(...)");
        setTvVoiceOutput((TextView) viewFindViewById12);
        View viewFindViewById13 = findViewById(R$id.tv_voice_input);
        kotlin.jvm.internal.p.h(viewFindViewById13, "findViewById(...)");
        setClVoiceInput((ConstraintLayout) viewFindViewById13);
        View viewFindViewById14 = findViewById(R$id.rv_input_images);
        kotlin.jvm.internal.p.h(viewFindViewById14, "findViewById(...)");
        this.rvInputImages = (RecyclerView) viewFindViewById14;
        View viewFindViewById15 = findViewById(R$id.tv_deep_think);
        CheckedTextView checkedTextView = (CheckedTextView) viewFindViewById15;
        com.stepos.agentframework.util.E eA = com.stepos.agentframework.util.E.INSTANCE.a();
        Context context = checkedTextView.getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        checkedTextView.setChecked(com.stepos.agentframework.util.E.e(eA, context, com.stepos.agentframework.util.C.INSTANCE.a(), false, null, 12, null));
        kotlin.jvm.internal.p.h(viewFindViewById15, "apply(...)");
        this.tvDeepThink = checkedTextView;
        View viewFindViewById16 = findViewById(R$id.ll_edit);
        kotlin.jvm.internal.p.h(viewFindViewById16, "findViewById(...)");
        setLlEdit((LinearLayout) viewFindViewById16);
        View viewFindViewById17 = findViewById(R$id.iv_exit_edit);
        kotlin.jvm.internal.p.h(viewFindViewById17, "findViewById(...)");
        setIvExitEdit((ImageView) viewFindViewById17);
        G();
        U();
        R();
        getLlBottomOptions().setVisibility(8);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InputLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.p.i(context, "context");
        this.TAG = "InputLayout";
        y();
        H();
        this.llThink = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.agentframework.chatui.V1
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return InputLayout.z(this.f22832a);
            }
        });
        this.rootInput = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.agentframework.chatui.Y1
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return InputLayout.D(this.f22839a);
            }
        });
        this.uploadAuditScope = kotlinx.coroutines.d.b();
    }

    public /* synthetic */ InputLayout(Context context, AttributeSet attributeSet, int i10, int i11, kotlin.jvm.internal.i iVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }
}
