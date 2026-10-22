package P8;

import O8.h;
import com.autonavi.aps.amapapi.config.Const;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public abstract class t {
    public static h.a a(O8.h hVar) {
        h.f fVarL = O8.h.l(Const.LBS_FAIL_BD_ENTITY, O8.h.g(Pattern.compile("&#?[\\da-z]{1,8};", 2)));
        return O8.h.c("markup", O8.h.l("comment", O8.h.g(Pattern.compile("<!--[\\s\\S]*?-->"))), O8.h.l("prolog", O8.h.g(Pattern.compile("<\\?[\\s\\S]+?\\?>"))), O8.h.l("doctype", O8.h.g(Pattern.compile("<!DOCTYPE[\\s\\S]+?>", 2))), O8.h.l("cdata", O8.h.g(Pattern.compile("<!\\[CDATA\\[[\\s\\S]*?]]>", 2))), O8.h.l("tag", O8.h.k(Pattern.compile("<\\/?(?!\\d)[^\\s>\\/=$<%]+(?:\\s+[^\\s>\\/=]+(?:=(?:(\"|')(?:\\\\[\\s\\S]|(?!\\1)[^\\\\])*\\1|[^\\s'\">=]+))?)*\\s*\\/?>", 2), false, true, null, O8.h.c("inside", O8.h.l("tag", O8.h.k(Pattern.compile("^<\\/?[^\\s>\\/]+", 2), false, false, null, O8.h.c("inside", O8.h.l("punctuation", O8.h.g(Pattern.compile("^<\\/?"))), O8.h.l("namespace", O8.h.g(Pattern.compile("^[^\\s>\\/:]+:")))))), O8.h.l("attr-value", O8.h.k(Pattern.compile("=(?:(\"|')(?:\\\\[\\s\\S]|(?!\\1)[^\\\\])*\\1|[^\\s'\">=]+)", 2), false, false, null, O8.h.c("inside", O8.h.l("punctuation", O8.h.g(Pattern.compile("^=")), O8.h.h(Pattern.compile("(^|[^\\\\])[\"']"), true)), fVarL))), O8.h.l("punctuation", O8.h.g(Pattern.compile("\\/?>"))), O8.h.l("attr-name", O8.h.k(Pattern.compile("[^\\s>\\/]+"), false, false, null, O8.h.c("inside", O8.h.l("namespace", O8.h.g(Pattern.compile("^[^\\s>\\/:]+:"))))))))), fVarL);
    }
}
