package com.stepos.agentframework.uikit;

import O8.h;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class A implements O8.e {
    private static final h.a NULL = new a();
    private final Map<String, h.a> cache = new HashMap(3);

    public class a implements h.a {
        @Override // O8.h.a
        public List<h.f> a() {
            return null;
        }

        @Override // O8.h.a
        public String name() {
            return null;
        }
    }

    @Override // O8.e
    public h.a a(O8.h hVar, String str) {
        String strC = c(str);
        h.a aVar = this.cache.get(strC);
        if (aVar != null) {
            if (NULL == aVar) {
                return null;
            }
            return aVar;
        }
        h.a aVarB = b(hVar, strC);
        if (aVarB == null) {
            this.cache.put(strC, NULL);
            return aVarB;
        }
        this.cache.put(strC, aVarB);
        d(hVar, strC);
        return aVarB;
    }

    public h.a b(O8.h hVar, String str) {
        str.getClass();
        switch (str) {
            case "csharp":
                return P8.f.a(hVar);
            case "groovy":
                return P8.l.a(hVar);
            case "kotlin":
                return P8.p.a(hVar);
            case "css-extras":
                return P8.h.a(hVar);
            case "markup":
                return P8.t.a(hVar);
            case "python":
                return P8.u.a(hVar);
            case "brainfuck":
                return P8.a.a(hVar);
            case "c":
                return P8.b.a(hVar);
            case "go":
                return P8.k.a(hVar);
            case "cpp":
                return P8.e.a(hVar);
            case "css":
                return P8.g.a(hVar);
            case "git":
                return P8.j.a(hVar);
            case "sql":
                return P8.w.a(hVar);
            case "dart":
                return P8.i.a(hVar);
            case "java":
                return P8.m.a(hVar);
            case "json":
                return P8.o.a(hVar);
            case "yaml":
                return P8.y.a(hVar);
            case "makefile":
                return P8.r.a(hVar);
            case "clike":
                return P8.c.a(hVar);
            case "latex":
                return P8.q.a(hVar);
            case "scala":
                return P8.v.a(hVar);
            case "swift":
                return P8.x.a(hVar);
            case "javascript":
                return P8.n.a(hVar);
            case "markdown":
                return P8.s.b(hVar);
            case "clojure":
                return P8.d.a(hVar);
            default:
                return null;
        }
    }

    public String c(String str) {
        str.getClass();
        switch (str) {
            case "dotnet":
                return "csharp";
            case "mathml":
            case "svg":
            case "xml":
            case "html":
                return "markup";
            case "js":
                return "javascript";
            case "jsonp":
                return "json";
            default:
                return str;
        }
    }

    public void d(O8.h hVar, String str) {
        str.getClass();
        if (str.equals("markup")) {
            hVar.a("css");
            hVar.a("javascript");
        } else if (str.equals("css")) {
            hVar.a("css-extras");
        }
    }
}
