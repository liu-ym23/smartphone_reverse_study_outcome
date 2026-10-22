package cg5;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.text.TextUtils;
import com.bytedance.ee.bear.middleground.feed.export.bean.panelv2.TextContext;
import com.bytedance.mira.core.opt.res.NewMiraResourcesManager;
import com.larus.nova.R;
import eu5.b;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes18.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap<String, Context> f23672a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, Integer> f23673b = null;

    static {
        f23672a = new HashMap();
        f23673b = MapsKt.mapOf(new Pair[]{TuplesKt.to("LarkCCM_Docs_Feed_VersionCompatibility", Integer.valueOf(R.string.LarkCCM_Docs_Feed_VersionCompatibility)), TuplesKt.to("LarkCCM_Notifications_commentDeleted_content", Integer.valueOf(R.string.LarkCCM_Notifications_commentDeleted_content)), TuplesKt.to("LarkCCM_Notifications_CommentDeleted", Integer.valueOf(R.string.LarkCCM_Notifications_CommentDeleted)), TuplesKt.to("LarkCCM_Docs_CommentPerm_NotifNoPerm_Text", Integer.valueOf(R.string.LarkCCM_Docs_CommentPerm_NotifNoPerm_Text)), TuplesKt.to("LarkCCM_Docs_CommentPerm_AccessRemoved_Toast", Integer.valueOf(R.string.LarkCCM_Docs_CommentPerm_AccessRemoved_Toast)), TuplesKt.to("LarkCCM_Notifications_CommentResolved", Integer.valueOf(R.string.LarkCCM_Notifications_CommentResolved)), TuplesKt.to("LarkCCM_Notifications_CommentResolved_toast", Integer.valueOf(R.string.LarkCCM_Notifications_CommentResolved_toast)), TuplesKt.to("LarkCCM_image_placeholder", Integer.valueOf(R.string.LarkCCM_image_placeholder)), TuplesKt.to("LarkCCM_Notifications_RepliedCommentSolved", Integer.valueOf(R.string.LarkCCM_Notifications_RepliedCommentSolved)), TuplesKt.to("LarkCCM_Notifications_DocCommentResolved", Integer.valueOf(R.string.LarkCCM_Notifications_DocCommentResolved)), TuplesKt.to("LarkCCM_Docs_OriginalTextDeleted_Toast", Integer.valueOf(R.string.LarkCCM_Docs_OriginalTextDeleted_Toast)), TuplesKt.to("LarkCCM_Notifications_ReactionRecalled", Integer.valueOf(R.string.LarkCCM_Notifications_ReactionRecalled)), TuplesKt.to("LarkCCM_Notifications_ReactionCanceled_toast", Integer.valueOf(R.string.LarkCCM_Notifications_ReactionCanceled_toast)), TuplesKt.to("LarkCCM_Notifications_ResolveDocsComment_Desc", Integer.valueOf(R.string.LarkCCM_Notifications_ResolveDocsComment_Desc)), TuplesKt.to("LarkCCM_Common_Notifications_ResolveComment_Reopened_PC", Integer.valueOf(R.string.LarkCCM_Common_Notifications_ResolveComment_Reopened_PC)), TuplesKt.to("LarkCCM_Notifications_ReopenComment_Desc", Integer.valueOf(R.string.LarkCCM_Notifications_ReopenComment_Desc)), TuplesKt.to("LarkCCM_Notifications_ReopenDocsComment_Desc", Integer.valueOf(R.string.LarkCCM_Notifications_ReopenDocsComment_Desc)), TuplesKt.to("LarkCCM_Common_Notifications_ReopenComment_Resolved_PC", Integer.valueOf(R.string.LarkCCM_Common_Notifications_ReopenComment_Resolved_PC)), TuplesKt.to("LarkCCM_Docs_Suggest_Delete_Title", Integer.valueOf(R.string.LarkCCM_Docs_Suggest_Delete_Title)), TuplesKt.to("LarkCCM_Docs_Suggest_Replace_Title", Integer.valueOf(R.string.LarkCCM_Docs_Suggest_Replace_Title)), TuplesKt.to("LarkCCM_Docs_Suggest_Format_Title", Integer.valueOf(R.string.LarkCCM_Docs_Suggest_Format_Title)), TuplesKt.to("LarkCCM_Docs_Suggest_Add_Title", Integer.valueOf(R.string.LarkCCM_Docs_Suggest_Add_Title)), TuplesKt.to("LarkCCM_GPE_Bold_Common", Integer.valueOf(R.string.LarkCCM_GPE_Bold_Common)), TuplesKt.to("LarkCCM_GPE_Italic_Common", Integer.valueOf(R.string.LarkCCM_GPE_Italic_Common)), TuplesKt.to("LarkCCM_GPE_Underline_Common", Integer.valueOf(R.string.LarkCCM_GPE_Underline_Common)), TuplesKt.to("LarkCCM_GPE_Strikethrough_Common", Integer.valueOf(R.string.LarkCCM_GPE_Strikethrough_Common)), TuplesKt.to("LarkCCM_GPE_Bullet_Common", Integer.valueOf(R.string.LarkCCM_GPE_Bullet_Common)), TuplesKt.to("LarkCCM_GPE_Ordered_Common", Integer.valueOf(R.string.LarkCCM_GPE_Ordered_Common)), TuplesKt.to("LarkCCM_GPE_Todo_Common", Integer.valueOf(R.string.LarkCCM_GPE_Todo_Common)), TuplesKt.to("LarkCCM_GPE_Text_Common", Integer.valueOf(R.string.LarkCCM_GPE_Text_Common)), TuplesKt.to("LarkCCM_GPE_Heading1_Common", Integer.valueOf(R.string.LarkCCM_GPE_Heading1_Common)), TuplesKt.to("LarkCCM_GPE_Heading2_Common", Integer.valueOf(R.string.LarkCCM_GPE_Heading2_Common)), TuplesKt.to("LarkCCM_GPE_Heading3_Common", Integer.valueOf(R.string.LarkCCM_GPE_Heading3_Common)), TuplesKt.to("LarkCCM_GPE_Heading4_Common", Integer.valueOf(R.string.LarkCCM_GPE_Heading4_Common)), TuplesKt.to("LarkCCM_GPE_Heading5_Common", Integer.valueOf(R.string.LarkCCM_GPE_Heading5_Common)), TuplesKt.to("LarkCCM_GPE_Heading6_Common", Integer.valueOf(R.string.LarkCCM_GPE_Heading6_Common)), TuplesKt.to("LarkCCM_GPE_Heading7_Common", Integer.valueOf(R.string.LarkCCM_GPE_Heading7_Common)), TuplesKt.to("LarkCCM_GPE_Heading8_Common", Integer.valueOf(R.string.LarkCCM_GPE_Heading8_Common)), TuplesKt.to("LarkCCM_GPE_Heading9_Common", Integer.valueOf(R.string.LarkCCM_GPE_Heading9_Common)), TuplesKt.to("LarkCCM_GPE_InlineCode_Common", Integer.valueOf(R.string.LarkCCM_GPE_InlineCode_Common)), TuplesKt.to("LarkCCM_GPE_CodeBlock_Common", Integer.valueOf(R.string.LarkCCM_GPE_CodeBlock_Common)), TuplesKt.to("LarkCCM_GPE_TextHighlight_Common", Integer.valueOf(R.string.LarkCCM_GPE_TextHighlight_Common)), TuplesKt.to("LarkCCM_GPE_Background_Common", Integer.valueOf(R.string.LarkCCM_GPE_Background_Common)), TuplesKt.to("LarkCCM_Docs_Suggest_ReplaceWith_Descrip", Integer.valueOf(R.string.LarkCCM_Docs_Suggest_ReplaceWith_Descrip)), TuplesKt.to("LarkCCM_Docs_Suggest_UsersRejected_Title", Integer.valueOf(R.string.LarkCCM_Docs_Suggest_UsersRejected_Title)), TuplesKt.to("LarkCCM_Docs_Suggest_UsersAccepted_Title", Integer.valueOf(R.string.LarkCCM_Docs_Suggest_UsersAccepted_Title)), TuplesKt.to("LarkCCM_Docs_Suggest_Accepted_Toast", Integer.valueOf(R.string.LarkCCM_Docs_Suggest_Accepted_Toast)), TuplesKt.to("LarkCCM_Docs_Suggest_Rejected_Toast", Integer.valueOf(R.string.LarkCCM_Docs_Suggest_Rejected_Toast)), TuplesKt.to("LarkCCM_Notifications_comment_content", Integer.valueOf(R.string.LarkCCM_Notifications_comment_content)), TuplesKt.to("LarkCCM_Docs_PrivateComment_Added_Descrip", Integer.valueOf(R.string.LarkCCM_Docs_PrivateComment_Added_Descrip)), TuplesKt.to("LarkCCM_Notifications_ReplyToYourComment", Integer.valueOf(R.string.LarkCCM_Notifications_ReplyToYourComment)), TuplesKt.to("LarkCCM_Notifications_commentAll_content", Integer.valueOf(R.string.LarkCCM_Notifications_commentAll_content)), TuplesKt.to("LarkCCM_Notifications_ResolveComment_Desc", Integer.valueOf(R.string.LarkCCM_Notifications_ResolveComment_Desc)), TuplesKt.to("LarkCCM_Notifications_mention_content", Integer.valueOf(R.string.LarkCCM_Notifications_mention_content)), TuplesKt.to("LarkCCM_Docs_Notificattion_SuggestAdded_Title", Integer.valueOf(R.string.LarkCCM_Docs_Notificattion_SuggestAdded_Title)), TuplesKt.to("LarkCCM_Docs_Suggestion_Title", Integer.valueOf(R.string.LarkCCM_Docs_Suggestion_Title)), TuplesKt.to("LarkCCM_Docs_Notificattion_SuggestAccepted_Title", Integer.valueOf(R.string.LarkCCM_Docs_Notificattion_SuggestAccepted_Title)), TuplesKt.to("LarkCCM_Docs_Notificattion_SuggestRejected_Title", Integer.valueOf(R.string.LarkCCM_Docs_Notificattion_SuggestRejected_Title)), TuplesKt.to("LarkCCM_Notifications_reply_content", Integer.valueOf(R.string.LarkCCM_Notifications_reply_content)), TuplesKt.to("LarkCCM_Docs_PrivateComment_Replied_Descrip", Integer.valueOf(R.string.LarkCCM_Docs_PrivateComment_Replied_Descrip)), TuplesKt.to("LarkCCM_Docs_Comments_SyncBlock_Title", Integer.valueOf(R.string.LarkCCM_Docs_Comments_SyncBlock_Title)), TuplesKt.to("LarkCCM_Feed_SharedDocWithYou", Integer.valueOf(R.string.LarkCCM_Feed_SharedDocWithYou)), TuplesKt.to("LarkCCM_Docs_Suggest_ReplaceWith_New_Descrip", Integer.valueOf(R.string.LarkCCM_Docs_Suggest_ReplaceWith_New_Descrip)), TuplesKt.to("LarkCCM_Docs_Suggest_UserRepliedSuggestion_Desc", Integer.valueOf(R.string.LarkCCM_Docs_Suggest_UserRepliedSuggestion_Desc)), TuplesKt.to("LarkCCM_Docs_Suggest_UserAcceptReponseToSuggest_Desc", Integer.valueOf(R.string.LarkCCM_Docs_Suggest_UserAcceptReponseToSuggest_Desc)), TuplesKt.to("LarkCCM_Docs_Suggest_UserRejectReponseToSuggest_Desc", Integer.valueOf(R.string.LarkCCM_Docs_Suggest_UserRejectReponseToSuggest_Desc)), TuplesKt.to("LarkCCM_Docs_Suggest_UserReactToYourSuggest_Desc", Integer.valueOf(R.string.LarkCCM_Docs_Suggest_UserReactToYourSuggest_Desc)), TuplesKt.to("LarkCCM_Docs_Suggest_ReactionToSuggestAccepted_Desc", Integer.valueOf(R.string.LarkCCM_Docs_Suggest_ReactionToSuggestAccepted_Desc)), TuplesKt.to("LarkCCM_Docs_Suggest_ReactionToReplyAccepted_Desc", Integer.valueOf(R.string.LarkCCM_Docs_Suggest_ReactionToReplyAccepted_Desc)), TuplesKt.to("LarkCCM_Docs_Suggest_ReactionToSuggestRejected_Desc", Integer.valueOf(R.string.LarkCCM_Docs_Suggest_ReactionToSuggestRejected_Desc)), TuplesKt.to("LarkCCM_Docs_Suggest_ReactionToReplyRejected_Desc", Integer.valueOf(R.string.LarkCCM_Docs_Suggest_ReactionToReplyRejected_Desc)), TuplesKt.to("LarkCCM_Docs_Suggest_UserReactToYourCmt_Desc", Integer.valueOf(R.string.LarkCCM_Docs_Suggest_UserReactToYourCmt_Desc)), TuplesKt.to("LarkCCM_Docs_Suggest_ChangeNumber_Text", Integer.valueOf(R.string.LarkCCM_Docs_Suggest_ChangeNumber_Text)), TuplesKt.to("LarkCCM_Docs_Suggest_TaskStatus_Text", Integer.valueOf(R.string.LarkCCM_Docs_Suggest_TaskStatus_Text)), TuplesKt.to("LarkCCM_Docs_Notifications_DocsAiSugComputerOnly_Text", Integer.valueOf(R.string.LarkCCM_Docs_Notifications_DocsAiSugComputerOnly_Text)), TuplesKt.to("LarkCCM_Docs_AiSugComputerOnly_Toast", Integer.valueOf(R.string.LarkCCM_Docs_AiSugComputerOnly_Toast))});
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public static String a(TextContext r110) {
        if (r110 != null) goto L5;
        return "";
    L5:
        List<TextContext.I18nData> r100 = r110.getI18nDatas();
        if (r100 != null) goto L8;
    L11:
        boolean r101 = true;
    L12:
        if (r101 == true) goto L14;
        String r102 = r110.getText();
        List<TextContext.I18nData> r111 = r110.getI18nDatas();
        if (r111 == null) goto L70;
        Iterator<T> r112 = r111.iterator();
        String r103 = r102;
    L19:
        if (r112.hasNext() == false) goto L63;
        TextContext.I18nData r104 = (TextContext.I18nData) r112.next();
        String r105 = "{{" + r104.getKey() + "}}";
        Intrinsics.checkNotNullParameter(r104, "i18nData");
        Integer r106 = f23673b.get(r104.getKey());
        if (r106 != null) goto L23;
        r106 = Integer.valueOf(R.string.LarkCCM_Docs_Feed_VersionCompatibility);
    L23:
        String r107 = r104.getLang();
        if (r107 != null) goto L26;
        r107 = b.f474075a.getResources().getConfiguration().locale.getLanguage();
    L26:
        Intrinsics.checkNotNull(r107);
        Application r108 = b.f474075a;
        if (TextUtils.equals(r108.getResources().getConfiguration().locale.getLanguage(), r107) == false) goto L29;
        Intrinsics.checkNotNull(r108);
        Context r109 = r108;
    L36:
        List<TextContext.ReplaceInfo> r113 = r104.getReplaceMap();
        if (r113 != null) goto L39;
    L41:
        boolean r114 = false;
    L42:
        if (r114 == true) goto L45;
        String r115 = r109.getString(r106.intValue());
    L53:
        String r116 = r115;
    L61:
        r103 = StringsKt.replace$default(r103, r105, r116, false, 4, null);
        goto L19
    L45:
        if (r104.getType() != 1) goto L54;
        LinkedHashMap r117 = new LinkedHashMap();
        List<TextContext.ReplaceInfo> r118 = r104.getReplaceMap();
        if (r118 == null) goto L52;
        Iterator<T> r119 = r118.iterator();
    L50:
        if (r119.hasNext() == false) goto L52;
        TextContext.ReplaceInfo r120 = (TextContext.ReplaceInfo) r119.next();
        r117.put(r120.getKey(), r120.getValue());
    L52:
        r115 = xo5.a.d(r109, r106.intValue(), r117);
        goto L53
    L54:
        r116 = r109.getString(r106.intValue());
        List<TextContext.ReplaceInfo> r121 = r104.getReplaceMap();
        if (r121 == null) goto L61;
        Iterator<T> r122 = r121.iterator();
        String r123 = r116;
    L58:
        if (r122.hasNext() == false) goto L60;
        TextContext.ReplaceInfo r124 = (TextContext.ReplaceInfo) r122.next();
        r123 = StringsKt.replaceFirst$default(r123, r124.getKey(), r124.getValue(), false, 4, null);
        goto L58
    L60:
        r116 = r123;
        goto L61
    L39:
        if (r113.isEmpty() == true) goto L41;
        r114 = true;
        goto L42
    L29:
        HashMap<String, Context> r125 = f23672a;
        if (r125.containsKey(r107) == false) goto L32;
        Context r126 = r125.get(r107);
    L33:
        if (r126 == null) goto L35;
        r109 = r126;
        goto L36
    L35:
        Configuration r127 = new Configuration(r108.getResources().getConfiguration());
        r127.setLocale(new Locale(r107));
        Context r128 = r108.createConfigurationContext(r127);
        NewMiraResourcesManager.getInstance().install(r128);
        r125.put(r107, r128);
        Intrinsics.checkNotNull(r128);
        r109 = r128;
        goto L36
    L32:
        r126 = null;
        goto L33
    L63:
        return r103;
    L70:
        return r102;
    L14:
        return r110.getText();
    L8:
        if (r100.isEmpty() == true) goto L11;
        r101 = false;
        goto L12
    }
}
