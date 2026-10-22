package com.networknt.org.apache.commons.validator.routines;

import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.aps.amapapi.utils.ReportUtil;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.networknt.schema.keyword.PropertiesValidator;
import com.stepos.aiengine.args.ExecutionBundle;
import com.stepos.aiengine.args.MultiFilesBundle;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.ailauncher.chat.trace.f;
import com.stepos.ailauncher.chat.view.GlassAttachment;
import com.stepos.ailauncher.chat.voice.support.C3081a;
import com.stepos.ailauncher.sla.G;
import com.stepos.ailauncher.task.space.credential.P;
import com.stepos.core.ability.AbilityType;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import io.modelcontextprotocol.spec.McpSchema;
import java.io.Serializable;
import java.net.IDN;
import java.util.Arrays;
import java.util.Locale;

/* loaded from: classes2.dex */
public class DomainValidator implements Serializable {

    /* renamed from: j, reason: collision with root package name */
    public static final String[] f21932j;

    /* renamed from: k, reason: collision with root package name */
    public static final String[] f21933k = {"arpa"};

    /* renamed from: l, reason: collision with root package name */
    public static final String[] f21934l = {"aaa", "aarp", "abarth", "abb", "abbott", "abbvie", "abc", "able", "abogado", "abudhabi", "academy", "accenture", "accountant", "accountants", "aco", "actor", "ads", "adult", "aeg", "aero", "aetna", "afl", "africa", "agakhan", "agency", "aig", "airbus", "airforce", "airtel", "akdn", "alfaromeo", "alibaba", "alipay", "allfinanz", "allstate", "ally", "alsace", "alstom", "amazon", "americanexpress", "americanfamily", "amex", "amfam", "amica", "amsterdam", "analytics", UxipConstants.f30662a, "anquan", "anz", "aol", "apartments", "app", "apple", "aquarelle", "arab", "aramco", "archi", "army", "art", "arte", "asda", "asia", "associates", "athleta", "attorney", "auction", "audi", "audible", "audio", "auspost", "author", "auto", "autos", "avianca", "aws", "axa", "azure", "baby", "baidu", "banamex", "bananarepublic", "band", "bank", "bar", "barcelona", "barclaycard", "barclays", "barefoot", "bargains", "baseball", "basketball", "bauhaus", "bayern", "bbc", "bbt", "bbva", "bcg", "bcn", "beats", "beauty", "beer", "bentley", "berlin", "best", "bestbuy", "bet", "bharti", "bible", "bid", "bike", "bing", "bingo", "bio", "biz", "black", "blackfriday", "blockbuster", "blog", "bloomberg", "blue", "bms", "bmw", "bnpparibas", "boats", "boehringer", "bofa", "bom", "bond", "boo", "book", "booking", "bosch", "bostik", "boston", "bot", "boutique", "box", "bradesco", "bridgestone", "broadway", "broker", "brother", "brussels", JsonPOJOBuilder.DEFAULT_BUILD_METHOD, "builders", "business", "buy", "buzz", "bzh", "cab", "cafe", "cal", "call", "calvinklein", "cam", C3081a.CAMERA_FOCUS, "camp", "canon", "capetown", "capital", "capitalone", "car", "caravan", "cards", "care", "career", "careers", "cars", "casa", "case", "cash", "casino", "cat", "catering", "catholic", "cba", "cbn", "cbre", "cbs", "center", "ceo", "cern", "cfa", "cfd", "chanel", "channel", "charity", "chase", AbilityType.CHAT, "cheap", "chintai", "christmas", "chrome", "church", "cipriani", "circle", "cisco", "citadel", "citi", "citic", "city", "cityeats", "claims", "cleaning", "click", "clinic", "clinique", "clothing", ExecutionBundle.PREF_CLOUD, "club", "clubmed", "coach", "codes", "coffee", "college", "cologne", "com", "comcast", "commbank", "community", "company", "compare", "computer", "comsec", "condos", "construction", "consulting", "contact", "contractors", "cooking", "cookingchannel", "cool", "coop", "corsica", "country", "coupon", "coupons", "courses", "cpa", "credit", "creditcard", "creditunion", "cricket", "crown", "crs", "cruise", "cruises", "cuisinella", "cymru", "cyou", "dabur", "dad", "dance", "data", "date", "dating", "datsun", "day", "dclk", "dds", "deal", "dealer", "deals", "degree", "delivery", "dell", "deloitte", "delta", "democrat", "dental", "dentist", "desi", "design", "dev", "dhl", "diamonds", "diet", "digital", "direct", "directory", "discount", "discover", "dish", "diy", "dnp", "docs", "doctor", "dog", "domains", "dot", com.stepos.ailauncher.chat.trace.a.BUTTON_DOWNLOAD, "drive", "dtv", "dubai", "dunlop", "dupont", "durban", "dvag", "dvr", "earth", "eat", "eco", "edeka", "edu", "education", "email", "emerck", "energy", "engineer", "engineering", "enterprises", "epson", "equipment", "ericsson", "erni", "esq", "estate", "etisalat", "eurovision", "eus", "events", "exchange", "expert", "exposed", "express", "extraspace", "fage", "fail", "fairwinds", "faith", "family", "fan", "fans", "farm", "farmers", "fashion", "fast", "fedex", "feedback", "ferrari", "ferrero", "fiat", "fidelity", "fido", "film", MultiFilesBundle.EVENT_FINAL, "finance", "financial", "fire", "firestone", "firmdale", "fish", "fishing", "fit", "fitness", "flickr", "flights", "flir", "florist", "flowers", "fly", "foo", "food", "foodnetwork", "football", "ford", "forex", "forsale", "forum", "foundation", "fox", "free", "fresenius", "frl", "frogans", "frontdoor", "frontier", "ftr", "fujitsu", "fun", "fund", "furniture", "futbol", "fyi", "gal", "gallery", "gallo", "gallup", "game", "games", "gap", "garden", "gay", "gbiz", "gdn", "gea", "gent", "genting", "george", "ggee", "gift", "gifts", "gives", "giving", GlassAttachment.GPU_KIND, "gle", "global", "globo", "gmail", "gmbh", "gmo", "gmx", "godaddy", "gold", "goldpoint", "golf", "goo", "goodyear", "goog", "google", "gop", "got", "gov", "grainger", "graphics", "gratis", "green", "gripe", "grocery", "group", "guardian", "gucci", "guge", "guide", "guitars", "guru", "hair", "hamburg", "hangout", "haus", "hbo", "hdfc", "hdfcbank", "health", "healthcare", "help", "helsinki", "here", "hermes", "hgtv", "hiphop", "hisamitsu", "hitachi", "hiv", "hkt", "hockey", "holdings", "holiday", "homedepot", "homegoods", "homes", "homesense", "honda", "horse", "hospital", "host", "hosting", "hot", "hoteles", "hotels", "hotmail", "house", "how", "hsbc", "hughes", "hyatt", "hyundai", "ibm", "icbc", "ice", "icu", "ieee", "ifm", "ikano", "imamat", "imdb", "immo", "immobilien", "inc", "industries", "infiniti", "info", "ing", "ink", "institute", "insurance", "insure", "int", Parameters.INTERNATIONAL, "intuit", "investments", "ipiranga", "irish", "ismaili", "ist", "istanbul", "itau", "itv", "jaguar", "java", "jcb", "jeep", "jetzt", "jewelry", "jio", "jll", "jmp", "jnj", "jobs", "joburg", "jot", "joy", "jpmorgan", "jprs", "juegos", "juniper", "kaufen", "kddi", "kerryhotels", "kerrylogistics", "kerryproperties", "kfh", "kia", "kids", "kim", "kinder", "kindle", "kitchen", "kiwi", "koeln", "komatsu", "kosher", "kpmg", "kpn", "krd", "kred", "kuokgroup", "kyoto", "lacaixa", "lamborghini", "lamer", "lancaster", "lancia", "land", "landrover", "lanxess", "lasalle", Const.JSON_KEY_LAT, "latino", "latrobe", "law", "lawyer", "lds", "lease", "leclerc", "lefrak", "legal", "lego", "lexus", "lgbt", "lidl", "life", "lifeinsurance", "lifestyle", "lighting", "like", "lilly", "limited", "limo", "lincoln", "linde", "link", "lipsy", "live", "living", "llc", "llp", "loan", "loans", "locker", "locus", "lol", "london", "lotte", "lotto", "love", "lpl", "lplfinancial", "ltd", "ltda", "lundbeck", "luxe", "luxury", "macys", "madrid", "maif", "maison", "makeup", "man", "management", "mango", C3081a.FOCUS_MAP_NAME, com.stepos.ailauncher.chat.trace.c.POSITION_MARKET, "marketing", "markets", "marriott", "marshalls", "maserati", "mattel", "mba", "mckinsey", "med", "media", "meet", "melbourne", "meme", "memorial", "men", ChatTracker.TOPBAR_MENU, "merckmsd", "miami", "microsoft", "mil", "mini", "mint", "mit", "mitsubishi", "mlb", "mls", "mma", "mobi", "mobile", "moda", "moe", "moi", "mom", "monash", "money", "monster", "mormon", "mortgage", "moscow", "moto", "motorcycles", "mov", "movie", "msd", "mtn", "mtr", "museum", "music", "mutual", "nab", "nagoya", "name", "natura", "navy", "nba", "nec", ReportUtil.STATISTICS_LOCTYPE_NET, "netbank", "netflix", "network", "neustar", Const.STR_NEW, "news", "next", "nextdirect", "nexus", "nfl", "ngo", "nhk", "nico", "nike", "nikon", "ninja", "nissan", "nissay", "nokia", "northwesternmutual", "norton", "now", "nowruz", "nowtv", "nra", "nrw", "ntt", "nyc", "obi", "observer", "office", "okinawa", "olayan", "olayangroup", "oldnavy", "ollo", "omega", "one", "ong", "onl", G.NETWORK_ONLINE, "ooo", "open", "oracle", "orange", "org", "organic", "origins", "osaka", "otsuka", "ott", "ovh", "page", "panasonic", "paris", "pars", "partners", "parts", "party", "passagens", "pay", "pccw", "pet", "pfizer", "pharmacy", "phd", "philips", "phone", "photo", "photography", "photos", "physio", "pics", "pictet", "pictures", "pid", f.ACTION_PIN, McpSchema.METHOD_PING, "pink", "pioneer", "pizza", "place", "play", "playstation", "plumbing", "plus", "pnc", "pohl", "poker", "politie", "porn", "post", "pramerica", "praxi", "press", "prime", "pro", "prod", "productions", "prof", "progressive", "promo", PropertiesValidator.PROPERTY, "property", "protection", "pru", "prudential", "pub", "pwc", "qpon", "quebec", "quest", "racing", "radio", "read", "realestate", "realtor", "realty", "recipes", "red", "redstone", "redumbrella", "rehab", "reise", "reisen", "reit", "reliance", "ren", "rent", "rentals", P.ENTRY_REPAIR, "report", "republican", "rest", C3081a.FOCUS_RESTAURANT_NAME, "review", "reviews", "rexroth", "rich", "richardli", "ricoh", "ril", "rio", "rip", "rocher", "rocks", "rodeo", "rogers", "room", "rsvp", "rugby", "ruhr", "run", "rwe", "ryukyu", "saarland", "safe", "safety", "sakura", "sale", "salon", "samsclub", "samsung", "sandvik", "sandvikcoromant", "sanofi", "sap", "sarl", "sas", "save", "saxo", "sbi", "sbs", "sca", "scb", "schaeffler", "schmidt", "scholarships", "school", "schule", "schwarz", "science", "scot", "search", "seat", "secure", "security", "seek", M5.c.ACTION_SELECT, "sener", "services", "seven", "sew", "sex", "sexy", "sfr", "shangrila", "sharp", "shaw", "shell", "shia", "shiksha", "shoes", "shop", "shopping", "shouji", "show", "showtime", "silk", "sina", "singles", "site", "ski", "skin", "sky", "skype", "sling", "smart", "smile", "sncf", "soccer", "social", "softbank", "software", "sohu", "solar", "solutions", "song", "sony", "soy", "spa", "space", "sport", "spot", "srl", "stada", "staples", "star", "statebank", "statefarm", "stc", "stcgroup", "stockholm", "storage", "store", "stream", "studio", "study", "style", "sucks", "supplies", "supply", "support", "surf", "surgery", "suzuki", "swatch", "swiss", "sydney", "systems", "tab", "taipei", "talk", "taobao", "target", "tatamotors", "tatar", "tattoo", "tax", O5.c.DIDI, "tci", "tdk", "team", "tech", "technology", "tel", "temasek", "tennis", "teva", "thd", "theater", "theatre", "tiaa", "tickets", "tienda", "tiffany", "tips", "tires", "tirol", "tjmaxx", "tjx", "tkmaxx", "tmall", "today", "tokyo", "tools", "top", "toray", "toshiba", "total", "tours", "town", "toyota", "toys", "trade", "trading", "training", "travel", "travelchannel", "travelers", "travelersinsurance", "trust", "trv", "tube", "tui", "tunes", "tushu", "tvs", "ubank", "ubs", "unicom", "university", "uno", "uol", "ups", "vacations", "vana", "vanguard", "vegas", "ventures", 
    "verisign", "versicherung", "vet", "viajes", "video", "vig", "viking", "villas", "vin", "vip", "virgin", "visa", "vision", "viva", Const.BRAND_VIVO, "vlaanderen", "vodka", "volkswagen", "volvo", "vote", "voting", "voto", "voyage", "vuelos", "wales", "walmart", "walter", "wang", "wanggou", "watch", "watches", O5.c.WEATHER, "weatherchannel", "webcam", "weber", "website", "wed", "wedding", "weibo", "weir", "whoswho", "wien", "wiki", "williamhill", "win", "windows", "wine", "winners", "wme", "wolterskluwer", "woodside", "work", "works", "world", "wow", "wtc", "wtf", "xbox", "xerox", "xfinity", "xihuan", "xin", "xn--11b4c3d", "xn--1ck2e1b", "xn--1qqw23a", "xn--30rr7y", "xn--3bst00m", "xn--3ds443g", "xn--3pxu8k", "xn--42c2d9a", "xn--45q11c", "xn--4gbrim", "xn--55qw42g", "xn--55qx5d", "xn--5su34j936bgsg", "xn--5tzm5g", "xn--6frz82g", "xn--6qq986b3xl", "xn--80adxhks", "xn--80aqecdr1a", "xn--80asehdb", "xn--80aswg", "xn--8y0a063a", "xn--90ae", "xn--9dbq2a", "xn--9et52u", "xn--9krt00a", "xn--9t4b11yi5a", "xn--b4w605ferd", "xn--bck1b9a5dre4c", "xn--c1avg", "xn--c2br7g", "xn--cck2b3b", "xn--cckwcxetd", "xn--cg4bki", "xn--czr694b", "xn--czrs0t", "xn--czru2d", "xn--d1acj3b", "xn--eckvdtc9d", "xn--efvy88h", "xn--fct429k", "xn--fhbei", "xn--fiq228c5hs", "xn--fiq64b", "xn--fjq720a", "xn--flw351e", "xn--fzys8d69uvgm", "xn--g2xx48c", "xn--gckr3f0f", "xn--gk3at1e", "xn--hxt814e", "xn--i1b6b1a6a2e", "xn--imr513n", "xn--io0a7i", "xn--j1aef", "xn--jlq480n2rg", "xn--jvr189m", "xn--kcrx77d1x4a", "xn--kput3i", "xn--mgba3a3ejt", "xn--mgba7c0bbn0a", "xn--mgbaakc7dvf", "xn--mgbab2bd", "xn--mgbca7dzdo", "xn--mgbi4ecexp", "xn--mgbt3dhd", "xn--mk1bu44c", "xn--mxtq1m", "xn--ngbc5azd", "xn--ngbe9e0a", "xn--ngbrx", "xn--nqv7f", "xn--nqv7fs00ema", "xn--nyqy26a", "xn--otu796d", "xn--p1acf", "xn--pssy2u", "xn--q9jyb4c", "xn--qcka1pmc", "xn--rhqv96g", "xn--rovu88b", "xn--ses554g", "xn--t60b56a", "xn--tckwe", "xn--tiq49xqyj", "xn--unup4y", "xn--vermgensberater-ctb", "xn--vermgensberatung-pwb", "xn--vhquv", "xn--vuq861b", "xn--w4r85el8fhu5dnra", "xn--w4rs40l", "xn--xhq521b", "xn--zfr164b", "xxx", "xyz", "yachts", "yahoo", "yamaxun", "yandex", "yodobashi", "yoga", "yokohama", "you", "youtube", "yun", "zappos", "zara", "zero", "zip", "zone", "zuerich"};

    /* renamed from: m, reason: collision with root package name */
    public static final String[] f21935m = {"ac", "ad", "ae", "af", "ag", "ai", "al", "am", "ao", "aq", "ar", "as", "at", "au", "aw", "ax", "az", "ba", "bb", "bd", "be", "bf", "bg", "bh", "bi", "bj", "bm", "bn", "bo", "br", Const.SP_KEY_BATTERY_SAVING, "bt", "bv", "bw", "by", "bz", Const.SP_KEY_CACHEABLE, "cc", "cd", "cf", "cg", "ch", "ci", "ck", Const.SP_KEY_CONTINUE_LOCATION, "cm", "cn", "co", "cr", "cu", "cv", "cw", "cx", "cy", "cz", "de", "dj", "dk", "dm", "do", "dz", "ec", "ee", "eg", "er", "es", "et", "eu", "fi", "fj", "fk", "fm", "fo", Const.SP_KEY_FIRSTLOC_RELOC, "ga", "gb", "gd", "ge", "gf", "gg", "gh", "gi", Const.SP_KEY_GEOFEN_LOCATION, "gm", "gn", "gp", "gq", "gr", "gs", "gt", "gu", "gw", "gy", "hk", Const.STR_TAB_HM, "hn", "hr", "ht", "hu", "id", "ie", "il", "im", "in", "io", "iq", "ir", "is", "it", "je", "jm", "jo", "jp", "ke", "kg", "kh", "ki", "km", "kn", "kp", "kr", "kw", "ky", "kz", "la", "lb", "lc", "li", "lk", "lr", "ls", "lt", "lu", "lv", "ly", "ma", "mc", "md", "me", "mg", "mh", "mk", "ml", "mm", "mn", "mo", "mp", "mq", "mr", Const.SP_KEY_GSM_UPLOAD_MXSIZE, "mt", "mu", "mv", "mw", "mx", "my", "mz", "na", "nc", "ne", "nf", "ng", "ni", "nl", "no", "np", "nr", "nu", "nz", "om", "pa", "pe", "pf", "pg", "ph", "pk", "pl", "pm", "pn", "pr", "ps", "pt", "pw", "py", AbilityType.QA, "re", "ro", "rs", "ru", "rw", "sa", "sb", "sc", "sd", "se", "sg", "sh", "si", "sj", "sk", "sl", "sm", Parameters.SN, "so", "sr", "ss", "st", "su", "sv", "sx", "sy", "sz", "tc", "td", "tf", "tg", "th", "tj", "tk", "tl", "tm", "tn", "to", "tr", "tt", "tv", "tw", "tz", "ua", "ug", "uk", "us", "uy", "uz", "va", "vc", "ve", "vg", "vi", "vn", "vu", "wf", "ws", "xn--2scrj9c", "xn--3e0b707e", "xn--3hcrj9c", "xn--45br5cyl", "xn--45brj9c", "xn--4dbrk0ce", "xn--54b7fta0cc", "xn--80ao21a", "xn--90a3ac", "xn--90ais", "xn--clchc0ea0b2g2a9gcd", "xn--d1alf", "xn--e1a4c", "xn--fiqs8s", "xn--fiqz9s", "xn--fpcrj9c3d", "xn--fzc2c9e2c", "xn--gecrj9c", "xn--h2breg3eve", "xn--h2brj9c", "xn--h2brj9c8c", "xn--j1amh", "xn--j6w193g", "xn--kprw13d", "xn--kpry57d", "xn--l1acc", "xn--lgbbat1ad8j", "xn--mgb9awbf", "xn--mgba3a4f16a", "xn--mgbaam7a8h", "xn--mgbah1a3hjkrd", "xn--mgbai9azgqp6j", "xn--mgbayh7gpa", "xn--mgbbh1a", "xn--mgbbh1a71e", "xn--mgbc0a9azcg", "xn--mgbcpq6gpa1a", "xn--mgberp4a5d4ar", "xn--mgbgu82a", "xn--mgbpl2fh", "xn--mgbtx2b", "xn--mgbx4cd0ab", "xn--mix891f", "xn--node", "xn--o3cw4h", "xn--ogbpf8fl", "xn--p1ai", "xn--pgbs0dh", "xn--q7ce6a", "xn--qxa6a", "xn--qxam", "xn--rvc1e0am3e", "xn--s9brj9c", "xn--wgbh1c", "xn--wgbl6a", "xn--xkc2al3hye2a", "xn--xkc2dl3a5ee0h", "xn--y9a3aq", "xn--yfro4i67o", "xn--ygbi2ammx", "ye", "yt", "za", "zm", "zw"};

    /* renamed from: n, reason: collision with root package name */
    public static final String[] f21936n = {"localdomain", "localhost"};

    /* renamed from: o, reason: collision with root package name */
    public static boolean f21937o;

    /* renamed from: p, reason: collision with root package name */
    public static String[] f21938p;

    /* renamed from: q, reason: collision with root package name */
    public static String[] f21939q;

    /* renamed from: r, reason: collision with root package name */
    public static String[] f21940r;

    /* renamed from: s, reason: collision with root package name */
    public static String[] f21941s;

    /* renamed from: t, reason: collision with root package name */
    public static String[] f21942t;

    /* renamed from: u, reason: collision with root package name */
    public static String[] f21943u;

    /* renamed from: a, reason: collision with root package name */
    public final boolean f21944a;

    /* renamed from: b, reason: collision with root package name */
    public final RegexValidator f21945b;

    /* renamed from: c, reason: collision with root package name */
    public final RegexValidator f21946c;

    /* renamed from: d, reason: collision with root package name */
    public final String[] f21947d;

    /* renamed from: e, reason: collision with root package name */
    public final String[] f21948e;

    /* renamed from: f, reason: collision with root package name */
    public final String[] f21949f;

    /* renamed from: g, reason: collision with root package name */
    public final String[] f21950g;

    /* renamed from: h, reason: collision with root package name */
    public final String[] f21951h;

    /* renamed from: i, reason: collision with root package name */
    public final String[] f21952i;

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public static final boolean f21953a = b();

        public static boolean b() {
            return "a.".equals(IDN.toASCII("a."));
        }
    }

    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public static final DomainValidator f21954a;

        /* renamed from: b, reason: collision with root package name */
        public static final DomainValidator f21955b;

        static {
            f21954a = new DomainValidator(false);
            f21955b = new DomainValidator(true);
        }
    }

    static {
        String[] strArr = new String[0];
        f21932j = strArr;
        f21938p = strArr;
        f21939q = strArr;
        f21940r = strArr;
        f21941s = strArr;
        f21942t = strArr;
        f21943u = strArr;
    }

    public static boolean a(String[] strArr, String str) {
        return Arrays.binarySearch(strArr, str) >= 0;
    }

    public static synchronized DomainValidator c(boolean z10) {
        f21937o = true;
        if (z10) {
            return c.f21955b;
        }
        return c.f21954a;
    }

    public static boolean e(String str) {
        if (str == null) {
            return true;
        }
        for (int i10 = 0; i10 < str.length(); i10++) {
            if (str.charAt(i10) > 127) {
                return false;
            }
        }
        return true;
    }

    public static String l(String str) {
        if (e(str)) {
            return str;
        }
        try {
            String ascii = IDN.toASCII(str);
            if (!b.f21953a) {
                int length = str.length();
                if (length == 0) {
                    return str;
                }
                char cCharAt = str.charAt(length - 1);
                if (cCharAt == '.' || cCharAt == 12290 || cCharAt == 65294 || cCharAt == 65377) {
                    return ascii + ".";
                }
            }
            return ascii;
        } catch (IllegalArgumentException unused) {
            return str;
        }
    }

    public final String b(String str) {
        return str.startsWith(".") ? str.substring(1) : str;
    }

    public boolean d() {
        return this.f21944a;
    }

    public boolean f(String str) {
        if (str == null) {
            return false;
        }
        String strL = l(str);
        if (strL.length() > 253) {
            return false;
        }
        String[] strArrB = this.f21945b.b(strL);
        return (strArrB == null || strArrB.length <= 0) ? this.f21944a && this.f21946c.a(strL) : k(strArrB[0]);
    }

    public boolean g(String str) {
        String strB = b(l(str).toLowerCase(Locale.ENGLISH));
        return (a(f21935m, strB) || a(this.f21948e, strB)) && !a(this.f21947d, strB);
    }

    public boolean h(String str) {
        String strB = b(l(str).toLowerCase(Locale.ENGLISH));
        return (a(f21934l, strB) || a(this.f21949f, strB)) && !a(this.f21950g, strB);
    }

    public boolean i(String str) {
        return a(f21933k, b(l(str).toLowerCase(Locale.ENGLISH)));
    }

    public boolean j(String str) {
        String strB = b(l(str).toLowerCase(Locale.ENGLISH));
        return (a(f21936n, strB) || a(this.f21951h, strB)) && !a(this.f21952i, strB);
    }

    public boolean k(String str) {
        return (this.f21944a && j(str)) || i(str) || h(str) || g(str);
    }

    public DomainValidator(boolean z10) {
        this.f21945b = new RegexValidator("^(?:\\p{Alnum}(?>[\\p{Alnum}-]{0,61}\\p{Alnum})?\\.)+(\\p{Alpha}(?>[\\p{Alnum}-]{0,61}\\p{Alnum})?)\\.?$");
        this.f21946c = new RegexValidator("\\p{Alnum}(?>[\\p{Alnum}-]{0,61}\\p{Alnum})?");
        this.f21944a = z10;
        this.f21947d = f21940r;
        this.f21948e = f21938p;
        this.f21949f = f21939q;
        this.f21950g = f21941s;
        this.f21951h = f21943u;
        this.f21952i = f21942t;
    }
}
