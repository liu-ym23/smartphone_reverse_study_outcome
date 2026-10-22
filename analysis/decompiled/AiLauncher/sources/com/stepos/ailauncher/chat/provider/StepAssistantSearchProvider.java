package com.stepos.ailauncher.chat.provider;

import Z8.C1173v;
import android.annotation.SuppressLint;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.content.pm.ProviderInfo;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.R$string;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.ailauncher.chat.trace.a;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import t5.C5512e;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 .2\u00020\u0001:\u0001'B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\t\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJQ\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u000f\u001a\u00020\u000e2\u0010\u0010\u0012\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0011\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00112\u0010\u0010\u0014\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0011\u0018\u00010\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ#\u0010\u001d\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ3\u0010 \u001a\u00020\u001f2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00112\u0010\u0010\u0014\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0011\u0018\u00010\u0010H\u0016¢\u0006\u0004\b \u0010!J=\u0010\"\u001a\u00020\u001f2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00112\u0010\u0010\u0014\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0011\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\"\u0010#J\u0011\u0010$\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b$\u0010%J\u0019\u0010'\u001a\u0004\u0018\u00010\u001f2\u0006\u0010&\u001a\u00020\u0011H\u0003¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020\u0016H\u0002¢\u0006\u0004\b)\u0010*R\u0016\u0010,\u001a\u00020+8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b,\u0010-¨\u0006/"}, d2 = {"Lcom/stepos/ailauncher/chat/provider/StepAssistantSearchProvider;", "Landroid/content/ContentProvider;", "<init>", "()V", "Landroid/content/Context;", "context", "Landroid/content/pm/ProviderInfo;", "info", "LY8/t;", "attachInfo", "(Landroid/content/Context;Landroid/content/pm/ProviderInfo;)V", "", "onCreate", "()Z", "Landroid/net/Uri;", "uri", "", "", "projection", "selection", "selectionArgs", "sortOrder", "Landroid/database/Cursor;", "query", "(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", "getType", "(Landroid/net/Uri;)Ljava/lang/String;", "Landroid/content/ContentValues;", "values", "insert", "(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;", "", ChatTracker.CLICK_DELETE, "(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I", a.BUTTON_UPDATE, "(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I", Const.INTENT_KEY_PKGNAME, "()Landroid/content/Context;", "drawableName", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)Ljava/lang/Integer;", "c", "()Landroid/database/Cursor;", "Landroid/content/UriMatcher;", "uriMatcher", "Landroid/content/UriMatcher;", "Companion", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class StepAssistantSearchProvider extends ContentProvider {
    private static final String ACTION_STEP_ASSISTANT = "com.stepos.ailauncher.action.STEP_ASSISTANT";
    private static final int MATCH_DYNAMIC_RAW = 6;
    private static final int MATCH_NON_INDEXABLE_KEYS = 3;
    private static final int MATCH_RAW = 2;
    private static final int MATCH_SITE_MAP_PAIRS = 4;
    private static final int MATCH_SLICE_URI_PAIRS = 5;
    private static final int MATCH_XML_RES = 1;
    private static final String PACKAGE_NAME = "com.stepos.ailauncher";
    private static final String PATH_DYNAMIC_RAW = "settings/dynamic_indexables_raw";
    private static final String PATH_NON_INDEXABLE_KEYS = "settings/non_indexables_key";
    private static final String PATH_RAW = "settings/indexables_raw";
    private static final String PATH_SITE_MAP_PAIRS = "settings/site_map_pairs";
    private static final String PATH_SLICE_URI_PAIRS = "settings/slice_uri_pairs";
    private static final String PATH_XML_RES = "settings/indexables_xml_res";
    private static final String SETTINGS_ICON_AMOO = "stepos_function_list_ic_aicy";
    private static final String SETTINGS_PACKAGE = "com.android.settings";
    private static final String TARGET_CLASS = "com.stepos.ailauncher.chat.activity.StepAssistantActivity";
    private UriMatcher uriMatcher;
    private static final String[] RAW_COLUMNS = {"rank", "title", "summaryOn", "summaryOff", "entries", "keywords", "screenTitle", "className", "iconResId", "intentAction", "intentTargetPackage", "intentTargetClass", "key", "user_id", "payload_type", "payload"};
    private static final String[] XML_RES_COLUMNS = {"rank", "xmlResId", "className", "iconResId", "intentAction", "intentTargetPackage", "intentTargetClass"};
    private static final String[] NON_INDEXABLE_KEYS_COLUMNS = {"key"};

    @SuppressLint({"DiscouragedApi"})
    public final Integer a(String drawableName) {
        Resources resources;
        try {
            Context context = getContext();
            Context contextCreatePackageContext = context != null ? context.createPackageContext(SETTINGS_PACKAGE, 0) : null;
            if (contextCreatePackageContext != null && (resources = contextCreatePackageContext.getResources()) != null) {
                Integer numValueOf = Integer.valueOf(resources.getIdentifier(drawableName, "drawable", SETTINGS_PACKAGE));
                if (numValueOf.intValue() != 0) {
                    return numValueOf;
                }
            }
        } catch (Exception unused) {
        }
        return null;
    }

    @Override // android.content.ContentProvider
    public void attachInfo(Context context, ProviderInfo info) {
        String str;
        super.attachInfo(context, info);
        if (info == null || (str = info.authority) == null) {
            return;
        }
        UriMatcher uriMatcher = new UriMatcher(-1);
        uriMatcher.addURI(str, PATH_XML_RES, 1);
        uriMatcher.addURI(str, PATH_RAW, 2);
        uriMatcher.addURI(str, PATH_NON_INDEXABLE_KEYS, 3);
        uriMatcher.addURI(str, PATH_SITE_MAP_PAIRS, 4);
        uriMatcher.addURI(str, PATH_SLICE_URI_PAIRS, 5);
        uriMatcher.addURI(str, PATH_DYNAMIC_RAW, 6);
        this.uriMatcher = uriMatcher;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Context b() {
        Context contextB;
        Context context = getContext();
        if (context == null) {
            return null;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            contextB = Result.b(context.createConfigurationContext(context.getResources().getConfiguration()));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            contextB = Result.b(C4849c.a(th));
        }
        if (!Result.g(contextB)) {
            context = contextB;
        }
        return context;
    }

    public final Cursor c() {
        MatrixCursor matrixCursor = new MatrixCursor(RAW_COLUMNS);
        Context contextB = b();
        if (contextB != null) {
            int i10 = R$string.step_assistant_title;
            String string = contextB.getString(i10);
            p.h(string, "getString(...)");
            Integer numA = a(SETTINGS_ICON_AMOO);
            int iIntValue = numA != null ? numA.intValue() : 0;
            String string2 = contextB.getString(i10);
            p.h(string2, "getString(...)");
            String string3 = contextB.getString(R$string.search_keywords_step_assistant_main);
            p.h(string3, "getString(...)");
            int i11 = 4;
            i iVar = null;
            String str = null;
            Item item = new Item(C5512e.MAIN, string2, str, string3, i11, iVar);
            String string4 = contextB.getString(R$string.step_assistant_amoo_space_title);
            p.h(string4, "getString(...)");
            String string5 = contextB.getString(R$string.search_keywords_step_assistant_amoo_space);
            p.h(string5, "getString(...)");
            Item item2 = new Item(C5512e.AMOO_SPACE, string4, str, string5, i11, iVar);
            String string6 = contextB.getString(R$string.voice_setting_voice_wakeup);
            p.h(string6, "getString(...)");
            String string7 = contextB.getString(R$string.search_keywords_step_assistant_voice_wakeup);
            p.h(string7, "getString(...)");
            Item item3 = new Item(C5512e.VOICE_WAKEUP, string6, str, string7, i11, iVar);
            String string8 = contextB.getString(R$string.voice_setting_navigation_key);
            p.h(string8, "getString(...)");
            String string9 = contextB.getString(R$string.voice_setting_navigation_key_desc);
            String string10 = contextB.getString(R$string.search_keywords_step_assistant_navigation_key);
            p.h(string10, "getString(...)");
            Item item4 = new Item(C5512e.NAVIGATION_KEY, string8, string9, string10);
            String string11 = contextB.getString(R$string.voice_setting_headset_key);
            p.h(string11, "getString(...)");
            String string12 = contextB.getString(R$string.voice_setting_headset_key_desc);
            String string13 = contextB.getString(R$string.search_keywords_step_assistant_headset_key);
            p.h(string13, "getString(...)");
            Item item5 = new Item(C5512e.HEADSET_KEY, string11, string12, string13);
            String string14 = contextB.getString(R$string.voice_setting_amoo_express);
            p.h(string14, "getString(...)");
            String string15 = contextB.getString(R$string.voice_setting_amoo_express_desc);
            String string16 = contextB.getString(R$string.search_keywords_step_assistant_amoo_express);
            p.h(string16, "getString(...)");
            Item item6 = new Item(C5512e.AMOO_EXPRESS, string14, string15, string16);
            String string17 = contextB.getString(R$string.voice_setting_supported_apps);
            p.h(string17, "getString(...)");
            String string18 = contextB.getString(R$string.voice_setting_supported_apps_desc);
            String string19 = contextB.getString(R$string.search_keywords_step_assistant_supported_apps);
            p.h(string19, "getString(...)");
            Item item7 = new Item(C5512e.SUPPORTED_APPS, string17, string18, string19);
            String string20 = contextB.getString(R$string.voice_setting_sound);
            p.h(string20, "getString(...)");
            String string21 = contextB.getString(R$string.search_keywords_step_assistant_sound);
            p.h(string21, "getString(...)");
            Item item8 = new Item(C5512e.SOUND, string20, null, string21, 4, null);
            String string22 = contextB.getString(R$string.step_assistant_ai_safety);
            p.h(string22, "getString(...)");
            String string23 = contextB.getString(R$string.search_keywords_step_assistant_ai_safety);
            p.h(string23, "getString(...)");
            Item item9 = new Item(C5512e.AI_SAFETY, string22, null, string23, 4, null);
            String string24 = contextB.getString(R$string.step_assistant_privacy_setting);
            p.h(string24, "getString(...)");
            String string25 = contextB.getString(R$string.search_keywords_step_assistant_privacy);
            p.h(string25, "getString(...)");
            Item item10 = new Item(C5512e.PRIVACY, string24, null, string25, 4, null);
            String string26 = contextB.getString(R$string.step_assistant_personal_info);
            p.h(string26, "getString(...)");
            String string27 = contextB.getString(R$string.search_keywords_step_assistant_personal_info);
            p.h(string27, "getString(...)");
            Item item11 = new Item(C5512e.PERSONAL_INFO, string26, null, string27, 4, null);
            String string28 = contextB.getString(R$string.step_assistant_third_party);
            p.h(string28, "getString(...)");
            String string29 = contextB.getString(R$string.search_keywords_step_assistant_third_party);
            p.h(string29, "getString(...)");
            Item item12 = new Item(C5512e.THIRD_PARTY, string28, null, string29, 4, null);
            String string30 = contextB.getString(R$string.step_assistant_improve_title);
            p.h(string30, "getString(...)");
            String string31 = contextB.getString(R$string.search_keywords_step_assistant_improve);
            p.h(string31, "getString(...)");
            Item item13 = new Item("step_assistant_improve", string30, null, string31, 4, null);
            String string32 = contextB.getString(R$string.step_assistant_check_update);
            p.h(string32, "getString(...)");
            String string33 = contextB.getString(R$string.search_keywords_step_assistant_check_update);
            p.h(string33, "getString(...)");
            for (Item item14 : C1173v.p(item, item2, item3, item4, item5, item6, item7, item8, item9, item10, item11, item12, item13, new Item(C5512e.CHECK_UPDATE, string32, null, string33, 4, null))) {
                matrixCursor.addRow(new Object[]{0, item14.getTitle(), item14.getSummaryOn(), null, null, item14.getKeywords(), string, null, Integer.valueOf(iIntValue), ACTION_STEP_ASSISTANT, PACKAGE_NAME, TARGET_CLASS, item14.getKey(), -1, null, null});
            }
        }
        return matrixCursor;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        p.i(uri, "uri");
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        p.i(uri, "uri");
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues values) {
        p.i(uri, "uri");
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        p.i(uri, "uri");
        UriMatcher uriMatcher = this.uriMatcher;
        if (uriMatcher == null) {
            p.A("uriMatcher");
            uriMatcher = null;
        }
        int iMatch = uriMatcher.match(uri);
        if (iMatch == 1) {
            return new MatrixCursor(XML_RES_COLUMNS);
        }
        if (iMatch == 2) {
            return c();
        }
        if (iMatch == 3) {
            return new MatrixCursor(NON_INDEXABLE_KEYS_COLUMNS);
        }
        if (iMatch != 6) {
            return null;
        }
        return c();
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        p.i(uri, "uri");
        return 0;
    }

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b*\u0001\u0000\b\u008a\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\nR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0012\u001a\u0004\b\u0014\u0010\nR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0015\u0010\nR\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0016\u0010\n¨\u0006\u0017"}, d2 = {"com/stepos/ailauncher/chat/provider/StepAssistantSearchProvider$b", "", "", "key", "title", "summaryOn", "keywords", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_UMID, "c", Const.INTENT_KEY_PKGNAME, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.provider.StepAssistantSearchProvider$b, reason: from toString */
    public static final /* data */ class Item {
        private final String key;
        private final String keywords;
        private final String summaryOn;
        private final String title;

        public Item(String key, String title, String str, String keywords) {
            p.i(key, "key");
            p.i(title, "title");
            p.i(keywords, "keywords");
            this.key = key;
            this.title = title;
            this.summaryOn = str;
            this.keywords = keywords;
        }

        /* renamed from: a, reason: from getter */
        public final String getKey() {
            return this.key;
        }

        /* renamed from: b, reason: from getter */
        public final String getKeywords() {
            return this.keywords;
        }

        /* renamed from: c, reason: from getter */
        public final String getSummaryOn() {
            return this.summaryOn;
        }

        /* renamed from: d, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Item)) {
                return false;
            }
            Item item = (Item) other;
            return p.d(this.key, item.key) && p.d(this.title, item.title) && p.d(this.summaryOn, item.summaryOn) && p.d(this.keywords, item.keywords);
        }

        public int hashCode() {
            int iHashCode = ((this.key.hashCode() * 31) + this.title.hashCode()) * 31;
            String str = this.summaryOn;
            return ((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.keywords.hashCode();
        }

        public String toString() {
            return "Item(key=" + this.key + ", title=" + this.title + ", summaryOn=" + this.summaryOn + ", keywords=" + this.keywords + ")";
        }

        public /* synthetic */ Item(String str, String str2, String str3, String str4, int i10, i iVar) {
            this(str, str2, (i10 & 4) != 0 ? null : str3, str4);
        }
    }
}
