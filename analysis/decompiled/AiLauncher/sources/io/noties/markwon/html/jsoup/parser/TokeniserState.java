package io.noties.markwon.html.jsoup.parser;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonPointer;
import io.noties.markwon.html.jsoup.parser.Token;
import java.io.IOException;

/* loaded from: classes4.dex */
enum TokeniserState {
    Data { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.1
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        public void read(c cVar, a aVar) throws IOException {
            char cQ = aVar.q();
            if (cQ == 0) {
                cVar.q(this);
                cVar.i(aVar.d());
            } else {
                if (cQ == '&') {
                    cVar.a(TokeniserState.CharacterReferenceInData);
                    return;
                }
                if (cQ == '<') {
                    cVar.a(TokeniserState.TagOpen);
                } else if (cQ != 65535) {
                    cVar.k(aVar.e());
                } else {
                    cVar.j(new Token.e());
                }
            }
        }
    },
    CharacterReferenceInData { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.2
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        public void read(c cVar, a aVar) {
            TokeniserState.readCharRef(cVar, TokeniserState.Data);
        }
    },
    Rcdata { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.3
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        public void read(c cVar, a aVar) throws IOException {
            char cQ = aVar.q();
            if (cQ == 0) {
                cVar.q(this);
                aVar.a();
                cVar.i(TokeniserState.replacementChar);
            } else {
                if (cQ == '&') {
                    cVar.a(TokeniserState.CharacterReferenceInRcdata);
                    return;
                }
                if (cQ == '<') {
                    cVar.a(TokeniserState.RcdataLessthanSign);
                } else if (cQ != 65535) {
                    cVar.k(aVar.m('&', '<', 0));
                } else {
                    cVar.j(new Token.e());
                }
            }
        }
    },
    CharacterReferenceInRcdata { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.4
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        public void read(c cVar, a aVar) {
            TokeniserState.readCharRef(cVar, TokeniserState.Rcdata);
        }
    },
    Rawtext { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.5
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        public void read(c cVar, a aVar) throws IOException {
            TokeniserState.readData(cVar, aVar, this, TokeniserState.RawtextLessthanSign);
        }
    },
    ScriptData { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.6
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        public void read(c cVar, a aVar) throws IOException {
            TokeniserState.readData(cVar, aVar, this, TokeniserState.ScriptDataLessthanSign);
        }
    },
    PLAINTEXT { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.7
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        public void read(c cVar, a aVar) throws IOException {
            char cQ = aVar.q();
            if (cQ == 0) {
                cVar.q(this);
                aVar.a();
                cVar.i(TokeniserState.replacementChar);
            } else if (cQ != 65535) {
                cVar.k(aVar.k((char) 0));
            } else {
                cVar.j(new Token.e());
            }
        }
    },
    TagOpen { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.8
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        public void read(c cVar, a aVar) throws IOException {
            char cQ = aVar.q();
            if (cQ == '!') {
                cVar.a(TokeniserState.MarkupDeclarationOpen);
                return;
            }
            if (cQ == '/') {
                cVar.a(TokeniserState.EndTagOpen);
                return;
            }
            if (cQ == '?') {
                cVar.a(TokeniserState.BogusComment);
                return;
            }
            if (aVar.C()) {
                cVar.g(true);
                cVar.u(TokeniserState.TagName);
            } else {
                cVar.q(this);
                cVar.i('<');
                cVar.u(TokeniserState.Data);
            }
        }
    },
    EndTagOpen { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.9
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        public void read(c cVar, a aVar) {
            if (aVar.r()) {
                cVar.p(this);
                cVar.k("</");
                cVar.u(TokeniserState.Data);
            } else if (aVar.C()) {
                cVar.g(false);
                cVar.u(TokeniserState.TagName);
            } else if (aVar.w('>')) {
                cVar.q(this);
                cVar.a(TokeniserState.Data);
            } else {
                cVar.q(this);
                cVar.a(TokeniserState.BogusComment);
            }
        }
    },
    TagName { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.10
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        public void read(c cVar, a aVar) throws IOException {
            cVar.f34258i.i(aVar.j());
            char cD = aVar.d();
            if (cD == 0) {
                cVar.f34258i.i(TokeniserState.replacementStr);
                return;
            }
            if (cD != ' ') {
                if (cD == '/') {
                    cVar.u(TokeniserState.SelfClosingStartTag);
                    return;
                }
                if (cD == '>') {
                    cVar.o();
                    cVar.u(TokeniserState.Data);
                    return;
                } else if (cD == 65535) {
                    cVar.p(this);
                    cVar.u(TokeniserState.Data);
                    return;
                } else if (cD != '\t' && cD != '\n' && cD != '\f' && cD != '\r') {
                    cVar.f34258i.h(cD);
                    return;
                }
            }
            cVar.u(TokeniserState.BeforeAttributeName);
        }
    },
    RcdataLessthanSign { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.11
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        public void read(c cVar, a aVar) {
            if (aVar.w(JsonPointer.SEPARATOR)) {
                cVar.h();
                cVar.a(TokeniserState.RCDATAEndTagOpen);
                return;
            }
            if (aVar.C() && cVar.b() != null) {
                if (!aVar.p("</" + cVar.b())) {
                    cVar.f34258i = cVar.g(false).l(cVar.b());
                    cVar.o();
                    aVar.I();
                    cVar.u(TokeniserState.Data);
                    return;
                }
            }
            cVar.k("<");
            cVar.u(TokeniserState.Rcdata);
        }
    },
    RCDATAEndTagOpen { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.12
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        public void read(c cVar, a aVar) {
            if (!aVar.C()) {
                cVar.k("</");
                cVar.u(TokeniserState.Rcdata);
            } else {
                cVar.g(false);
                cVar.f34258i.h(aVar.q());
                cVar.f34257h.append(aVar.q());
                cVar.a(TokeniserState.RCDATAEndTagName);
            }
        }
    },
    RCDATAEndTagName { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.13
        private void anythingElse(c cVar, a aVar) {
            cVar.k("</" + cVar.f34257h.toString());
            aVar.I();
            cVar.u(TokeniserState.Rcdata);
        }

        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        public void read(c cVar, a aVar) throws IOException {
            if (aVar.C()) {
                String strH = aVar.h();
                cVar.f34258i.i(strH);
                cVar.f34257h.append(strH);
                return;
            }
            char cD = aVar.d();
            if (cD == '\t' || cD == '\n' || cD == '\f' || cD == '\r' || cD == ' ') {
                if (cVar.s()) {
                    cVar.u(TokeniserState.BeforeAttributeName);
                    return;
                } else {
                    anythingElse(cVar, aVar);
                    return;
                }
            }
            if (cD == '/') {
                if (cVar.s()) {
                    cVar.u(TokeniserState.SelfClosingStartTag);
                    return;
                } else {
                    anythingElse(cVar, aVar);
                    return;
                }
            }
            if (cD != '>') {
                anythingElse(cVar, aVar);
            } else if (!cVar.s()) {
                anythingElse(cVar, aVar);
            } else {
                cVar.o();
                cVar.u(TokeniserState.Data);
            }
        }
    },
    RawtextLessthanSign { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.14
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        public void read(c cVar, a aVar) {
            if (aVar.w(JsonPointer.SEPARATOR)) {
                cVar.h();
                cVar.a(TokeniserState.RawtextEndTagOpen);
            } else {
                cVar.i('<');
                cVar.u(TokeniserState.Rawtext);
            }
        }
    },
    RawtextEndTagOpen { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.15
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        public void read(c cVar, a aVar) {
            TokeniserState.readEndTag(cVar, aVar, TokeniserState.RawtextEndTagName, TokeniserState.Rawtext);
        }
    },
    RawtextEndTagName { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.16
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        public void read(c cVar, a aVar) throws IOException {
            TokeniserState.handleDataEndTag(cVar, aVar, TokeniserState.Rawtext);
        }
    },
    ScriptDataLessthanSign { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.17
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        public void read(c cVar, a aVar) throws IOException {
            char cD = aVar.d();
            if (cD == '!') {
                cVar.k("<!");
                cVar.u(TokeniserState.ScriptDataEscapeStart);
            } else if (cD == '/') {
                cVar.h();
                cVar.u(TokeniserState.ScriptDataEndTagOpen);
            } else {
                cVar.k("<");
                aVar.I();
                cVar.u(TokeniserState.ScriptData);
            }
        }
    },
    ScriptDataEndTagOpen { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.18
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        public void read(c cVar, a aVar) {
            TokeniserState.readEndTag(cVar, aVar, TokeniserState.ScriptDataEndTagName, TokeniserState.ScriptData);
        }
    },
    ScriptDataEndTagName { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.19
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        public void read(c cVar, a aVar) throws IOException {
            TokeniserState.handleDataEndTag(cVar, aVar, TokeniserState.ScriptData);
        }
    },
    ScriptDataEscapeStart { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.20
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        public void read(c cVar, a aVar) {
            if (!aVar.w('-')) {
                cVar.u(TokeniserState.ScriptData);
            } else {
                cVar.i('-');
                cVar.a(TokeniserState.ScriptDataEscapeStartDash);
            }
        }
    },
    ScriptDataEscapeStartDash { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.21
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        public void read(c cVar, a aVar) {
            if (!aVar.w('-')) {
                cVar.u(TokeniserState.ScriptData);
            } else {
                cVar.i('-');
                cVar.a(TokeniserState.ScriptDataEscapedDashDash);
            }
        }
    },
    ScriptDataEscaped { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.22
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        public void read(c cVar, a aVar) throws IOException {
            if (aVar.r()) {
                cVar.p(this);
                cVar.u(TokeniserState.Data);
                return;
            }
            char cQ = aVar.q();
            if (cQ == 0) {
                cVar.q(this);
                aVar.a();
                cVar.i(TokeniserState.replacementChar);
            } else if (cQ == '-') {
                cVar.i('-');
                cVar.a(TokeniserState.ScriptDataEscapedDash);
            } else if (cQ != '<') {
                cVar.k(aVar.m('-', '<', 0));
            } else {
                cVar.a(TokeniserState.ScriptDataEscapedLessthanSign);
            }
        }
    },
    ScriptDataEscapedDash { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.23
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        public void read(c cVar, a aVar) throws IOException {
            if (aVar.r()) {
                cVar.p(this);
                cVar.u(TokeniserState.Data);
                return;
            }
            char cD = aVar.d();
            if (cD == 0) {
                cVar.q(this);
                cVar.i(TokeniserState.replacementChar);
                cVar.u(TokeniserState.ScriptDataEscaped);
            } else if (cD == '-') {
                cVar.i(cD);
                cVar.u(TokeniserState.ScriptDataEscapedDashDash);
            } else if (cD == '<') {
                cVar.u(TokeniserState.ScriptDataEscapedLessthanSign);
            } else {
                cVar.i(cD);
                cVar.u(TokeniserState.ScriptDataEscaped);
            }
        }
    },
    ScriptDataEscapedDashDash { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.24
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        public void read(c cVar, a aVar) throws IOException {
            if (aVar.r()) {
                cVar.p(this);
                cVar.u(TokeniserState.Data);
                return;
            }
            char cD = aVar.d();
            if (cD == 0) {
                cVar.q(this);
                cVar.i(TokeniserState.replacementChar);
                cVar.u(TokeniserState.ScriptDataEscaped);
            } else {
                if (cD == '-') {
                    cVar.i(cD);
                    return;
                }
                if (cD == '<') {
                    cVar.u(TokeniserState.ScriptDataEscapedLessthanSign);
                } else if (cD != '>') {
                    cVar.i(cD);
                    cVar.u(TokeniserState.ScriptDataEscaped);
                } else {
                    cVar.i(cD);
                    cVar.u(TokeniserState.ScriptData);
                }
            }
        }
    },
    ScriptDataEscapedLessthanSign { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.25
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        public void read(c cVar, a aVar) {
            if (!aVar.C()) {
                if (aVar.w(JsonPointer.SEPARATOR)) {
                    cVar.h();
                    cVar.a(TokeniserState.ScriptDataEscapedEndTagOpen);
                    return;
                } else {
                    cVar.i('<');
                    cVar.u(TokeniserState.ScriptDataEscaped);
                    return;
                }
            }
            cVar.h();
            cVar.f34257h.append(aVar.q());
            cVar.k("<" + aVar.q());
            cVar.a(TokeniserState.ScriptDataDoubleEscapeStart);
        }
    },
    ScriptDataEscapedEndTagOpen { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.26
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        public void read(c cVar, a aVar) {
            if (!aVar.C()) {
                cVar.k("</");
                cVar.u(TokeniserState.ScriptDataEscaped);
            } else {
                cVar.g(false);
                cVar.f34258i.h(aVar.q());
                cVar.f34257h.append(aVar.q());
                cVar.a(TokeniserState.ScriptDataEscapedEndTagName);
            }
        }
    },
    ScriptDataEscapedEndTagName { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.27
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        public void read(c cVar, a aVar) throws IOException {
            TokeniserState.handleDataEndTag(cVar, aVar, TokeniserState.ScriptDataEscaped);
        }
    },
    ScriptDataDoubleEscapeStart { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.28
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        public void read(c cVar, a aVar) throws IOException {
            TokeniserState.handleDataDoubleEscapeTag(cVar, aVar, TokeniserState.ScriptDataDoubleEscaped, TokeniserState.ScriptDataEscaped);
        }
    },
    ScriptDataDoubleEscaped { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.29
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        public void read(c cVar, a aVar) throws IOException {
            char cQ = aVar.q();
            if (cQ == 0) {
                cVar.q(this);
                aVar.a();
                cVar.i(TokeniserState.replacementChar);
            } else if (cQ == '-') {
                cVar.i(cQ);
                cVar.a(TokeniserState.ScriptDataDoubleEscapedDash);
            } else if (cQ == '<') {
                cVar.i(cQ);
                cVar.a(TokeniserState.ScriptDataDoubleEscapedLessthanSign);
            } else if (cQ != 65535) {
                cVar.k(aVar.m('-', '<', 0));
            } else {
                cVar.p(this);
                cVar.u(TokeniserState.Data);
            }
        }
    },
    ScriptDataDoubleEscapedDash { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.30
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        public void read(c cVar, a aVar) throws IOException {
            char cD = aVar.d();
            if (cD == 0) {
                cVar.q(this);
                cVar.i(TokeniserState.replacementChar);
                cVar.u(TokeniserState.ScriptDataDoubleEscaped);
            } else if (cD == '-') {
                cVar.i(cD);
                cVar.u(TokeniserState.ScriptDataDoubleEscapedDashDash);
            } else if (cD == '<') {
                cVar.i(cD);
                cVar.u(TokeniserState.ScriptDataDoubleEscapedLessthanSign);
            } else if (cD != 65535) {
                cVar.i(cD);
                cVar.u(TokeniserState.ScriptDataDoubleEscaped);
            } else {
                cVar.p(this);
                cVar.u(TokeniserState.Data);
            }
        }
    },
    ScriptDataDoubleEscapedDashDash { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.31
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        public void read(c cVar, a aVar) throws IOException {
            char cD = aVar.d();
            if (cD == 0) {
                cVar.q(this);
                cVar.i(TokeniserState.replacementChar);
                cVar.u(TokeniserState.ScriptDataDoubleEscaped);
                return;
            }
            if (cD == '-') {
                cVar.i(cD);
                return;
            }
            if (cD == '<') {
                cVar.i(cD);
                cVar.u(TokeniserState.ScriptDataDoubleEscapedLessthanSign);
            } else if (cD == '>') {
                cVar.i(cD);
                cVar.u(TokeniserState.ScriptData);
            } else if (cD != 65535) {
                cVar.i(cD);
                cVar.u(TokeniserState.ScriptDataDoubleEscaped);
            } else {
                cVar.p(this);
                cVar.u(TokeniserState.Data);
            }
        }
    },
    ScriptDataDoubleEscapedLessthanSign { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.32
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        public void read(c cVar, a aVar) {
            if (!aVar.w(JsonPointer.SEPARATOR)) {
                cVar.u(TokeniserState.ScriptDataDoubleEscaped);
                return;
            }
            cVar.i(JsonPointer.SEPARATOR);
            cVar.h();
            cVar.a(TokeniserState.ScriptDataDoubleEscapeEnd);
        }
    },
    ScriptDataDoubleEscapeEnd { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.33
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        public void read(c cVar, a aVar) throws IOException {
            TokeniserState.handleDataDoubleEscapeTag(cVar, aVar, TokeniserState.ScriptDataEscaped, TokeniserState.ScriptDataDoubleEscaped);
        }
    },
    BeforeAttributeName { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.34
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        public void read(c cVar, a aVar) throws IOException {
            char cD = aVar.d();
            if (cD == 0) {
                cVar.q(this);
                cVar.f34258i.n();
                aVar.I();
                cVar.u(TokeniserState.AttributeName);
                return;
            }
            if (cD != ' ') {
                if (cD != '\"' && cD != '\'') {
                    if (cD == '/') {
                        cVar.u(TokeniserState.SelfClosingStartTag);
                        return;
                    }
                    if (cD == 65535) {
                        cVar.p(this);
                        cVar.u(TokeniserState.Data);
                        return;
                    }
                    if (cD == '\t' || cD == '\n' || cD == '\f' || cD == '\r') {
                        return;
                    }
                    switch (cD) {
                        case '<':
                        case '=':
                            break;
                        case '>':
                            cVar.o();
                            cVar.u(TokeniserState.Data);
                            break;
                        default:
                            cVar.f34258i.n();
                            aVar.I();
                            cVar.u(TokeniserState.AttributeName);
                            break;
                    }
                    return;
                }
                cVar.q(this);
                cVar.f34258i.n();
                cVar.f34258i.c(cD);
                cVar.u(TokeniserState.AttributeName);
            }
        }
    },
    AttributeName { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.35
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        public void read(c cVar, a aVar) throws IOException {
            cVar.f34258i.d(aVar.n(TokeniserState.attributeNameCharsSorted));
            char cD = aVar.d();
            if (cD == 0) {
                cVar.q(this);
                cVar.f34258i.c(TokeniserState.replacementChar);
                return;
            }
            if (cD != ' ') {
                if (cD != '\"' && cD != '\'') {
                    if (cD == '/') {
                        cVar.u(TokeniserState.SelfClosingStartTag);
                        return;
                    }
                    if (cD == 65535) {
                        cVar.p(this);
                        cVar.u(TokeniserState.Data);
                        return;
                    }
                    if (cD != '\t' && cD != '\n' && cD != '\f' && cD != '\r') {
                        switch (cD) {
                            case '<':
                                break;
                            case '=':
                                cVar.u(TokeniserState.BeforeAttributeValue);
                                break;
                            case '>':
                                cVar.o();
                                cVar.u(TokeniserState.Data);
                                break;
                            default:
                                cVar.f34258i.c(cD);
                                break;
                        }
                        return;
                    }
                }
                cVar.q(this);
                cVar.f34258i.c(cD);
                return;
            }
            cVar.u(TokeniserState.AfterAttributeName);
        }
    },
    AfterAttributeName { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.36
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        public void read(c cVar, a aVar) throws IOException {
            char cD = aVar.d();
            if (cD == 0) {
                cVar.q(this);
                cVar.f34258i.c(TokeniserState.replacementChar);
                cVar.u(TokeniserState.AttributeName);
                return;
            }
            if (cD != ' ') {
                if (cD != '\"' && cD != '\'') {
                    if (cD == '/') {
                        cVar.u(TokeniserState.SelfClosingStartTag);
                        return;
                    }
                    if (cD == 65535) {
                        cVar.p(this);
                        cVar.u(TokeniserState.Data);
                        return;
                    }
                    if (cD == '\t' || cD == '\n' || cD == '\f' || cD == '\r') {
                        return;
                    }
                    switch (cD) {
                        case '<':
                            break;
                        case '=':
                            cVar.u(TokeniserState.BeforeAttributeValue);
                            break;
                        case '>':
                            cVar.o();
                            cVar.u(TokeniserState.Data);
                            break;
                        default:
                            cVar.f34258i.n();
                            aVar.I();
                            cVar.u(TokeniserState.AttributeName);
                            break;
                    }
                    return;
                }
                cVar.q(this);
                cVar.f34258i.n();
                cVar.f34258i.c(cD);
                cVar.u(TokeniserState.AttributeName);
            }
        }
    },
    BeforeAttributeValue { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.37
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        public void read(c cVar, a aVar) throws IOException {
            char cD = aVar.d();
            if (cD == 0) {
                cVar.q(this);
                cVar.f34258i.e(TokeniserState.replacementChar);
                cVar.u(TokeniserState.AttributeValue_unquoted);
                return;
            }
            if (cD != ' ') {
                if (cD == '\"') {
                    cVar.u(TokeniserState.AttributeValue_doubleQuoted);
                    return;
                }
                if (cD != '`') {
                    if (cD == 65535) {
                        cVar.p(this);
                        cVar.o();
                        cVar.u(TokeniserState.Data);
                        return;
                    }
                    if (cD == '\t' || cD == '\n' || cD == '\f' || cD == '\r') {
                        return;
                    }
                    if (cD == '&') {
                        aVar.I();
                        cVar.u(TokeniserState.AttributeValue_unquoted);
                        return;
                    }
                    if (cD == '\'') {
                        cVar.u(TokeniserState.AttributeValue_singleQuoted);
                        return;
                    }
                    switch (cD) {
                        case '<':
                        case '=':
                            break;
                        case '>':
                            cVar.q(this);
                            cVar.o();
                            cVar.u(TokeniserState.Data);
                            break;
                        default:
                            aVar.I();
                            cVar.u(TokeniserState.AttributeValue_unquoted);
                            break;
                    }
                    return;
                }
                cVar.q(this);
                cVar.f34258i.e(cD);
                cVar.u(TokeniserState.AttributeValue_unquoted);
            }
        }
    },
    AttributeValue_doubleQuoted { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.38
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        public void read(c cVar, a aVar) throws IOException {
            String strM = aVar.m(TokeniserState.attributeDoubleValueCharsSorted);
            if (strM.length() > 0) {
                cVar.f34258i.f(strM);
            } else {
                cVar.f34258i.p();
            }
            char cD = aVar.d();
            if (cD == 0) {
                cVar.q(this);
                cVar.f34258i.e(TokeniserState.replacementChar);
                return;
            }
            if (cD == '\"') {
                cVar.u(TokeniserState.AfterAttributeValue_quoted);
                return;
            }
            if (cD != '&') {
                if (cD != 65535) {
                    cVar.f34258i.e(cD);
                    return;
                } else {
                    cVar.p(this);
                    cVar.u(TokeniserState.Data);
                    return;
                }
            }
            int[] iArrD = cVar.d(Character.valueOf(JsonFactory.DEFAULT_QUOTE_CHAR), true);
            if (iArrD != null) {
                cVar.f34258i.g(iArrD);
            } else {
                cVar.f34258i.e('&');
            }
        }
    },
    AttributeValue_singleQuoted { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.39
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        public void read(c cVar, a aVar) throws IOException {
            String strM = aVar.m(TokeniserState.attributeSingleValueCharsSorted);
            if (strM.length() > 0) {
                cVar.f34258i.f(strM);
            } else {
                cVar.f34258i.p();
            }
            char cD = aVar.d();
            if (cD == 0) {
                cVar.q(this);
                cVar.f34258i.e(TokeniserState.replacementChar);
                return;
            }
            if (cD == 65535) {
                cVar.p(this);
                cVar.u(TokeniserState.Data);
                return;
            }
            if (cD != '&') {
                if (cD != '\'') {
                    cVar.f34258i.e(cD);
                    return;
                } else {
                    cVar.u(TokeniserState.AfterAttributeValue_quoted);
                    return;
                }
            }
            int[] iArrD = cVar.d('\'', true);
            if (iArrD != null) {
                cVar.f34258i.g(iArrD);
            } else {
                cVar.f34258i.e('&');
            }
        }
    },
    AttributeValue_unquoted { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.40
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        public void read(c cVar, a aVar) throws IOException {
            String strN = aVar.n(TokeniserState.attributeValueUnquoted);
            if (strN.length() > 0) {
                cVar.f34258i.f(strN);
            }
            char cD = aVar.d();
            if (cD == 0) {
                cVar.q(this);
                cVar.f34258i.e(TokeniserState.replacementChar);
                return;
            }
            if (cD != ' ') {
                if (cD != '\"' && cD != '`') {
                    if (cD == 65535) {
                        cVar.p(this);
                        cVar.u(TokeniserState.Data);
                        return;
                    }
                    if (cD != '\t' && cD != '\n' && cD != '\f' && cD != '\r') {
                        if (cD == '&') {
                            int[] iArrD = cVar.d('>', true);
                            if (iArrD != null) {
                                cVar.f34258i.g(iArrD);
                                return;
                            } else {
                                cVar.f34258i.e('&');
                                return;
                            }
                        }
                        if (cD != '\'') {
                            switch (cD) {
                                case '<':
                                case '=':
                                    break;
                                case '>':
                                    cVar.o();
                                    cVar.u(TokeniserState.Data);
                                    break;
                                default:
                                    cVar.f34258i.e(cD);
                                    break;
                            }
                            return;
                        }
                    }
                }
                cVar.q(this);
                cVar.f34258i.e(cD);
                return;
            }
            cVar.u(TokeniserState.BeforeAttributeName);
        }
    },
    AfterAttributeValue_quoted { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.41
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        public void read(c cVar, a aVar) throws IOException {
            char cD = aVar.d();
            if (cD == '\t' || cD == '\n' || cD == '\f' || cD == '\r' || cD == ' ') {
                cVar.u(TokeniserState.BeforeAttributeName);
                return;
            }
            if (cD == '/') {
                cVar.u(TokeniserState.SelfClosingStartTag);
                return;
            }
            if (cD == '>') {
                cVar.o();
                cVar.u(TokeniserState.Data);
            } else if (cD == 65535) {
                cVar.p(this);
                cVar.u(TokeniserState.Data);
            } else {
                cVar.q(this);
                aVar.I();
                cVar.u(TokeniserState.BeforeAttributeName);
            }
        }
    },
    SelfClosingStartTag { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.42
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        public void read(c cVar, a aVar) throws IOException {
            char cD = aVar.d();
            if (cD == '>') {
                cVar.f34258i.f34236i = true;
                cVar.o();
                cVar.u(TokeniserState.Data);
            } else if (cD == 65535) {
                cVar.p(this);
                cVar.u(TokeniserState.Data);
            } else {
                cVar.q(this);
                aVar.I();
                cVar.u(TokeniserState.BeforeAttributeName);
            }
        }
    },
    BogusComment { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.43
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        public void read(c cVar, a aVar) {
            aVar.I();
            Token.c cVar2 = new Token.c();
            cVar2.f34223c = true;
            cVar2.f34222b.append(aVar.k('>'));
            cVar.j(cVar2);
            cVar.a(TokeniserState.Data);
        }
    },
    MarkupDeclarationOpen { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.44
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        public void read(c cVar, a aVar) {
            if (aVar.u("--")) {
                cVar.e();
                cVar.u(TokeniserState.CommentStart);
            } else if (aVar.v("DOCTYPE")) {
                cVar.u(TokeniserState.Doctype);
            } else if (aVar.u("[CDATA[")) {
                cVar.h();
                cVar.u(TokeniserState.CdataSection);
            } else {
                cVar.q(this);
                cVar.a(TokeniserState.BogusComment);
            }
        }
    },
    CommentStart { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.45
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        public void read(c cVar, a aVar) throws IOException {
            char cD = aVar.d();
            if (cD == 0) {
                cVar.q(this);
                cVar.f34263n.f34222b.append(TokeniserState.replacementChar);
                cVar.u(TokeniserState.Comment);
                return;
            }
            if (cD == '-') {
                cVar.u(TokeniserState.CommentStartDash);
                return;
            }
            if (cD == '>') {
                cVar.q(this);
                cVar.m();
                cVar.u(TokeniserState.Data);
            } else if (cD != 65535) {
                cVar.f34263n.f34222b.append(cD);
                cVar.u(TokeniserState.Comment);
            } else {
                cVar.p(this);
                cVar.m();
                cVar.u(TokeniserState.Data);
            }
        }
    },
    CommentStartDash { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.46
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        public void read(c cVar, a aVar) throws IOException {
            char cD = aVar.d();
            if (cD == 0) {
                cVar.q(this);
                cVar.f34263n.f34222b.append(TokeniserState.replacementChar);
                cVar.u(TokeniserState.Comment);
                return;
            }
            if (cD == '-') {
                cVar.u(TokeniserState.CommentStartDash);
                return;
            }
            if (cD == '>') {
                cVar.q(this);
                cVar.m();
                cVar.u(TokeniserState.Data);
            } else if (cD != 65535) {
                cVar.f34263n.f34222b.append(cD);
                cVar.u(TokeniserState.Comment);
            } else {
                cVar.p(this);
                cVar.m();
                cVar.u(TokeniserState.Data);
            }
        }
    },
    Comment { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.47
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        public void read(c cVar, a aVar) throws IOException {
            char cQ = aVar.q();
            if (cQ == 0) {
                cVar.q(this);
                aVar.a();
                cVar.f34263n.f34222b.append(TokeniserState.replacementChar);
            } else if (cQ == '-') {
                cVar.a(TokeniserState.CommentEndDash);
            } else {
                if (cQ != 65535) {
                    cVar.f34263n.f34222b.append(aVar.m('-', 0));
                    return;
                }
                cVar.p(this);
                cVar.m();
                cVar.u(TokeniserState.Data);
            }
        }
    },
    CommentEndDash { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.48
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        public void read(c cVar, a aVar) throws IOException {
            char cD = aVar.d();
            if (cD == 0) {
                cVar.q(this);
                StringBuilder sb2 = cVar.f34263n.f34222b;
                sb2.append('-');
                sb2.append(TokeniserState.replacementChar);
                cVar.u(TokeniserState.Comment);
                return;
            }
            if (cD == '-') {
                cVar.u(TokeniserState.CommentEnd);
                return;
            }
            if (cD == 65535) {
                cVar.p(this);
                cVar.m();
                cVar.u(TokeniserState.Data);
            } else {
                StringBuilder sb3 = cVar.f34263n.f34222b;
                sb3.append('-');
                sb3.append(cD);
                cVar.u(TokeniserState.Comment);
            }
        }
    },
    CommentEnd { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.49
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        public void read(c cVar, a aVar) throws IOException {
            char cD = aVar.d();
            if (cD == 0) {
                cVar.q(this);
                StringBuilder sb2 = cVar.f34263n.f34222b;
                sb2.append("--");
                sb2.append(TokeniserState.replacementChar);
                cVar.u(TokeniserState.Comment);
                return;
            }
            if (cD == '!') {
                cVar.q(this);
                cVar.u(TokeniserState.CommentEndBang);
                return;
            }
            if (cD == '-') {
                cVar.q(this);
                cVar.f34263n.f34222b.append('-');
                return;
            }
            if (cD == '>') {
                cVar.m();
                cVar.u(TokeniserState.Data);
            } else if (cD == 65535) {
                cVar.p(this);
                cVar.m();
                cVar.u(TokeniserState.Data);
            } else {
                cVar.q(this);
                StringBuilder sb3 = cVar.f34263n.f34222b;
                sb3.append("--");
                sb3.append(cD);
                cVar.u(TokeniserState.Comment);
            }
        }
    },
    CommentEndBang { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.50
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        public void read(c cVar, a aVar) throws IOException {
            char cD = aVar.d();
            if (cD == 0) {
                cVar.q(this);
                StringBuilder sb2 = cVar.f34263n.f34222b;
                sb2.append("--!");
                sb2.append(TokeniserState.replacementChar);
                cVar.u(TokeniserState.Comment);
                return;
            }
            if (cD == '-') {
                cVar.f34263n.f34222b.append("--!");
                cVar.u(TokeniserState.CommentEndDash);
                return;
            }
            if (cD == '>') {
                cVar.m();
                cVar.u(TokeniserState.Data);
            } else if (cD == 65535) {
                cVar.p(this);
                cVar.m();
                cVar.u(TokeniserState.Data);
            } else {
                StringBuilder sb3 = cVar.f34263n.f34222b;
                sb3.append("--!");
                sb3.append(cD);
                cVar.u(TokeniserState.Comment);
            }
        }
    },
    Doctype { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.51
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        public void read(c cVar, a aVar) throws IOException {
            char cD = aVar.d();
            if (cD == '\t' || cD == '\n' || cD == '\f' || cD == '\r' || cD == ' ') {
                cVar.u(TokeniserState.BeforeDoctypeName);
                return;
            }
            if (cD != '>') {
                if (cD != 65535) {
                    cVar.q(this);
                    cVar.u(TokeniserState.BeforeDoctypeName);
                    return;
                }
                cVar.p(this);
            }
            cVar.q(this);
            cVar.f();
            cVar.f34262m.f34228f = true;
            cVar.n();
            cVar.u(TokeniserState.Data);
        }
    },
    BeforeDoctypeName { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.52
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        public void read(c cVar, a aVar) throws IOException {
            if (aVar.C()) {
                cVar.f();
                cVar.u(TokeniserState.DoctypeName);
                return;
            }
            char cD = aVar.d();
            if (cD == 0) {
                cVar.q(this);
                cVar.f();
                cVar.f34262m.f34224b.append(TokeniserState.replacementChar);
                cVar.u(TokeniserState.DoctypeName);
                return;
            }
            if (cD != ' ') {
                if (cD == 65535) {
                    cVar.p(this);
                    cVar.f();
                    cVar.f34262m.f34228f = true;
                    cVar.n();
                    cVar.u(TokeniserState.Data);
                    return;
                }
                if (cD == '\t' || cD == '\n' || cD == '\f' || cD == '\r') {
                    return;
                }
                cVar.f();
                cVar.f34262m.f34224b.append(cD);
                cVar.u(TokeniserState.DoctypeName);
            }
        }
    },
    DoctypeName { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.53
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        public void read(c cVar, a aVar) throws IOException {
            if (aVar.C()) {
                cVar.f34262m.f34224b.append(aVar.h());
                return;
            }
            char cD = aVar.d();
            if (cD == 0) {
                cVar.q(this);
                cVar.f34262m.f34224b.append(TokeniserState.replacementChar);
                return;
            }
            if (cD != ' ') {
                if (cD == '>') {
                    cVar.n();
                    cVar.u(TokeniserState.Data);
                    return;
                }
                if (cD == 65535) {
                    cVar.p(this);
                    cVar.f34262m.f34228f = true;
                    cVar.n();
                    cVar.u(TokeniserState.Data);
                    return;
                }
                if (cD != '\t' && cD != '\n' && cD != '\f' && cD != '\r') {
                    cVar.f34262m.f34224b.append(cD);
                    return;
                }
            }
            cVar.u(TokeniserState.AfterDoctypeName);
        }
    },
    AfterDoctypeName { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.54
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        public void read(c cVar, a aVar) {
            if (aVar.r()) {
                cVar.p(this);
                cVar.f34262m.f34228f = true;
                cVar.n();
                cVar.u(TokeniserState.Data);
                return;
            }
            if (aVar.y('\t', '\n', '\r', '\f', ' ')) {
                aVar.a();
                return;
            }
            if (aVar.w('>')) {
                cVar.n();
                cVar.a(TokeniserState.Data);
                return;
            }
            if (aVar.v("PUBLIC")) {
                cVar.f34262m.f34225c = "PUBLIC";
                cVar.u(TokeniserState.AfterDoctypePublicKeyword);
            } else if (aVar.v("SYSTEM")) {
                cVar.f34262m.f34225c = "SYSTEM";
                cVar.u(TokeniserState.AfterDoctypeSystemKeyword);
            } else {
                cVar.q(this);
                cVar.f34262m.f34228f = true;
                cVar.a(TokeniserState.BogusDoctype);
            }
        }
    },
    AfterDoctypePublicKeyword { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.55
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        public void read(c cVar, a aVar) throws IOException {
            char cD = aVar.d();
            if (cD == '\t' || cD == '\n' || cD == '\f' || cD == '\r' || cD == ' ') {
                cVar.u(TokeniserState.BeforeDoctypePublicIdentifier);
                return;
            }
            if (cD == '\"') {
                cVar.q(this);
                cVar.u(TokeniserState.DoctypePublicIdentifier_doubleQuoted);
                return;
            }
            if (cD == '\'') {
                cVar.q(this);
                cVar.u(TokeniserState.DoctypePublicIdentifier_singleQuoted);
                return;
            }
            if (cD == '>') {
                cVar.q(this);
                cVar.f34262m.f34228f = true;
                cVar.n();
                cVar.u(TokeniserState.Data);
                return;
            }
            if (cD != 65535) {
                cVar.q(this);
                cVar.f34262m.f34228f = true;
                cVar.u(TokeniserState.BogusDoctype);
            } else {
                cVar.p(this);
                cVar.f34262m.f34228f = true;
                cVar.n();
                cVar.u(TokeniserState.Data);
            }
        }
    },
    BeforeDoctypePublicIdentifier { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.56
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        public void read(c cVar, a aVar) throws IOException {
            char cD = aVar.d();
            if (cD == '\t' || cD == '\n' || cD == '\f' || cD == '\r' || cD == ' ') {
                return;
            }
            if (cD == '\"') {
                cVar.u(TokeniserState.DoctypePublicIdentifier_doubleQuoted);
                return;
            }
            if (cD == '\'') {
                cVar.u(TokeniserState.DoctypePublicIdentifier_singleQuoted);
                return;
            }
            if (cD == '>') {
                cVar.q(this);
                cVar.f34262m.f34228f = true;
                cVar.n();
                cVar.u(TokeniserState.Data);
                return;
            }
            if (cD != 65535) {
                cVar.q(this);
                cVar.f34262m.f34228f = true;
                cVar.u(TokeniserState.BogusDoctype);
            } else {
                cVar.p(this);
                cVar.f34262m.f34228f = true;
                cVar.n();
                cVar.u(TokeniserState.Data);
            }
        }
    },
    DoctypePublicIdentifier_doubleQuoted { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.57
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        public void read(c cVar, a aVar) throws IOException {
            char cD = aVar.d();
            if (cD == 0) {
                cVar.q(this);
                cVar.f34262m.f34226d.append(TokeniserState.replacementChar);
                return;
            }
            if (cD == '\"') {
                cVar.u(TokeniserState.AfterDoctypePublicIdentifier);
                return;
            }
            if (cD == '>') {
                cVar.q(this);
                cVar.f34262m.f34228f = true;
                cVar.n();
                cVar.u(TokeniserState.Data);
                return;
            }
            if (cD != 65535) {
                cVar.f34262m.f34226d.append(cD);
                return;
            }
            cVar.p(this);
            cVar.f34262m.f34228f = true;
            cVar.n();
            cVar.u(TokeniserState.Data);
        }
    },
    DoctypePublicIdentifier_singleQuoted { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.58
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        public void read(c cVar, a aVar) throws IOException {
            char cD = aVar.d();
            if (cD == 0) {
                cVar.q(this);
                cVar.f34262m.f34226d.append(TokeniserState.replacementChar);
                return;
            }
            if (cD == '\'') {
                cVar.u(TokeniserState.AfterDoctypePublicIdentifier);
                return;
            }
            if (cD == '>') {
                cVar.q(this);
                cVar.f34262m.f34228f = true;
                cVar.n();
                cVar.u(TokeniserState.Data);
                return;
            }
            if (cD != 65535) {
                cVar.f34262m.f34226d.append(cD);
                return;
            }
            cVar.p(this);
            cVar.f34262m.f34228f = true;
            cVar.n();
            cVar.u(TokeniserState.Data);
        }
    },
    AfterDoctypePublicIdentifier { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.59
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        public void read(c cVar, a aVar) throws IOException {
            char cD = aVar.d();
            if (cD == '\t' || cD == '\n' || cD == '\f' || cD == '\r' || cD == ' ') {
                cVar.u(TokeniserState.BetweenDoctypePublicAndSystemIdentifiers);
                return;
            }
            if (cD == '\"') {
                cVar.q(this);
                cVar.u(TokeniserState.DoctypeSystemIdentifier_doubleQuoted);
                return;
            }
            if (cD == '\'') {
                cVar.q(this);
                cVar.u(TokeniserState.DoctypeSystemIdentifier_singleQuoted);
                return;
            }
            if (cD == '>') {
                cVar.n();
                cVar.u(TokeniserState.Data);
            } else if (cD != 65535) {
                cVar.q(this);
                cVar.f34262m.f34228f = true;
                cVar.u(TokeniserState.BogusDoctype);
            } else {
                cVar.p(this);
                cVar.f34262m.f34228f = true;
                cVar.n();
                cVar.u(TokeniserState.Data);
            }
        }
    },
    BetweenDoctypePublicAndSystemIdentifiers { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.60
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        public void read(c cVar, a aVar) throws IOException {
            char cD = aVar.d();
            if (cD == '\t' || cD == '\n' || cD == '\f' || cD == '\r' || cD == ' ') {
                return;
            }
            if (cD == '\"') {
                cVar.q(this);
                cVar.u(TokeniserState.DoctypeSystemIdentifier_doubleQuoted);
                return;
            }
            if (cD == '\'') {
                cVar.q(this);
                cVar.u(TokeniserState.DoctypeSystemIdentifier_singleQuoted);
                return;
            }
            if (cD == '>') {
                cVar.n();
                cVar.u(TokeniserState.Data);
            } else if (cD != 65535) {
                cVar.q(this);
                cVar.f34262m.f34228f = true;
                cVar.u(TokeniserState.BogusDoctype);
            } else {
                cVar.p(this);
                cVar.f34262m.f34228f = true;
                cVar.n();
                cVar.u(TokeniserState.Data);
            }
        }
    },
    AfterDoctypeSystemKeyword { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.61
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        public void read(c cVar, a aVar) throws IOException {
            char cD = aVar.d();
            if (cD == '\t' || cD == '\n' || cD == '\f' || cD == '\r' || cD == ' ') {
                cVar.u(TokeniserState.BeforeDoctypeSystemIdentifier);
                return;
            }
            if (cD == '\"') {
                cVar.q(this);
                cVar.u(TokeniserState.DoctypeSystemIdentifier_doubleQuoted);
                return;
            }
            if (cD == '\'') {
                cVar.q(this);
                cVar.u(TokeniserState.DoctypeSystemIdentifier_singleQuoted);
                return;
            }
            if (cD == '>') {
                cVar.q(this);
                cVar.f34262m.f34228f = true;
                cVar.n();
                cVar.u(TokeniserState.Data);
                return;
            }
            if (cD != 65535) {
                cVar.q(this);
                cVar.f34262m.f34228f = true;
                cVar.n();
            } else {
                cVar.p(this);
                cVar.f34262m.f34228f = true;
                cVar.n();
                cVar.u(TokeniserState.Data);
            }
        }
    },
    BeforeDoctypeSystemIdentifier { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.62
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        public void read(c cVar, a aVar) throws IOException {
            char cD = aVar.d();
            if (cD == '\t' || cD == '\n' || cD == '\f' || cD == '\r' || cD == ' ') {
                return;
            }
            if (cD == '\"') {
                cVar.u(TokeniserState.DoctypeSystemIdentifier_doubleQuoted);
                return;
            }
            if (cD == '\'') {
                cVar.u(TokeniserState.DoctypeSystemIdentifier_singleQuoted);
                return;
            }
            if (cD == '>') {
                cVar.q(this);
                cVar.f34262m.f34228f = true;
                cVar.n();
                cVar.u(TokeniserState.Data);
                return;
            }
            if (cD != 65535) {
                cVar.q(this);
                cVar.f34262m.f34228f = true;
                cVar.u(TokeniserState.BogusDoctype);
            } else {
                cVar.p(this);
                cVar.f34262m.f34228f = true;
                cVar.n();
                cVar.u(TokeniserState.Data);
            }
        }
    },
    DoctypeSystemIdentifier_doubleQuoted { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.63
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        public void read(c cVar, a aVar) throws IOException {
            char cD = aVar.d();
            if (cD == 0) {
                cVar.q(this);
                cVar.f34262m.f34227e.append(TokeniserState.replacementChar);
                return;
            }
            if (cD == '\"') {
                cVar.u(TokeniserState.AfterDoctypeSystemIdentifier);
                return;
            }
            if (cD == '>') {
                cVar.q(this);
                cVar.f34262m.f34228f = true;
                cVar.n();
                cVar.u(TokeniserState.Data);
                return;
            }
            if (cD != 65535) {
                cVar.f34262m.f34227e.append(cD);
                return;
            }
            cVar.p(this);
            cVar.f34262m.f34228f = true;
            cVar.n();
            cVar.u(TokeniserState.Data);
        }
    },
    DoctypeSystemIdentifier_singleQuoted { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.64
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        public void read(c cVar, a aVar) throws IOException {
            char cD = aVar.d();
            if (cD == 0) {
                cVar.q(this);
                cVar.f34262m.f34227e.append(TokeniserState.replacementChar);
                return;
            }
            if (cD == '\'') {
                cVar.u(TokeniserState.AfterDoctypeSystemIdentifier);
                return;
            }
            if (cD == '>') {
                cVar.q(this);
                cVar.f34262m.f34228f = true;
                cVar.n();
                cVar.u(TokeniserState.Data);
                return;
            }
            if (cD != 65535) {
                cVar.f34262m.f34227e.append(cD);
                return;
            }
            cVar.p(this);
            cVar.f34262m.f34228f = true;
            cVar.n();
            cVar.u(TokeniserState.Data);
        }
    },
    AfterDoctypeSystemIdentifier { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.65
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        public void read(c cVar, a aVar) throws IOException {
            char cD = aVar.d();
            if (cD == '\t' || cD == '\n' || cD == '\f' || cD == '\r' || cD == ' ') {
                return;
            }
            if (cD == '>') {
                cVar.n();
                cVar.u(TokeniserState.Data);
            } else if (cD != 65535) {
                cVar.q(this);
                cVar.u(TokeniserState.BogusDoctype);
            } else {
                cVar.p(this);
                cVar.f34262m.f34228f = true;
                cVar.n();
                cVar.u(TokeniserState.Data);
            }
        }
    },
    BogusDoctype { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.66
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        public void read(c cVar, a aVar) throws IOException {
            char cD = aVar.d();
            if (cD == '>') {
                cVar.n();
                cVar.u(TokeniserState.Data);
            } else {
                if (cD != 65535) {
                    return;
                }
                cVar.n();
                cVar.u(TokeniserState.Data);
            }
        }
    },
    CdataSection { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.67
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        public void read(c cVar, a aVar) throws IOException {
            cVar.f34257h.append(aVar.l("]]>"));
            if (aVar.u("]]>") || aVar.r()) {
                cVar.j(new Token.a(cVar.f34257h.toString()));
                cVar.u(TokeniserState.Data);
            }
        }
    };

    private static final char eof = 65535;
    static final char nullChar = 0;
    static final char[] attributeSingleValueCharsSorted = {0, '&', '\''};
    static final char[] attributeDoubleValueCharsSorted = {0, JsonFactory.DEFAULT_QUOTE_CHAR, '&'};
    static final char[] attributeNameCharsSorted = {0, '\t', '\n', '\f', '\r', ' ', JsonFactory.DEFAULT_QUOTE_CHAR, '\'', JsonPointer.SEPARATOR, '<', '=', '>'};
    static final char[] attributeValueUnquoted = {0, '\t', '\n', '\f', '\r', ' ', JsonFactory.DEFAULT_QUOTE_CHAR, '&', '\'', '<', '=', '>', '`'};
    private static final char replacementChar = 65533;
    private static final String replacementStr = String.valueOf(replacementChar);

    /* JADX INFO: Access modifiers changed from: private */
    public static void handleDataDoubleEscapeTag(c cVar, a aVar, TokeniserState tokeniserState, TokeniserState tokeniserState2) throws IOException {
        if (aVar.C()) {
            String strH = aVar.h();
            cVar.f34257h.append(strH);
            cVar.k(strH);
            return;
        }
        char cD = aVar.d();
        if (cD != '\t' && cD != '\n' && cD != '\f' && cD != '\r' && cD != ' ' && cD != '/' && cD != '>') {
            aVar.I();
            cVar.u(tokeniserState2);
        } else {
            if (cVar.f34257h.toString().equals("script")) {
                cVar.u(tokeniserState);
            } else {
                cVar.u(tokeniserState2);
            }
            cVar.i(cD);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void handleDataEndTag(c cVar, a aVar, TokeniserState tokeniserState) throws IOException {
        if (aVar.C()) {
            String strH = aVar.h();
            cVar.f34258i.i(strH);
            cVar.f34257h.append(strH);
            return;
        }
        if (cVar.s() && !aVar.r()) {
            char cD = aVar.d();
            if (cD == '\t' || cD == '\n' || cD == '\f' || cD == '\r' || cD == ' ') {
                cVar.u(BeforeAttributeName);
                return;
            }
            if (cD == '/') {
                cVar.u(SelfClosingStartTag);
                return;
            } else {
                if (cD == '>') {
                    cVar.o();
                    cVar.u(Data);
                    return;
                }
                cVar.f34257h.append(cD);
            }
        }
        cVar.k("</" + cVar.f34257h.toString());
        cVar.u(tokeniserState);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void readCharRef(c cVar, TokeniserState tokeniserState) {
        int[] iArrD = cVar.d(null, false);
        if (iArrD == null) {
            cVar.i('&');
        } else {
            cVar.l(iArrD);
        }
        cVar.u(tokeniserState);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void readData(c cVar, a aVar, TokeniserState tokeniserState, TokeniserState tokeniserState2) throws IOException {
        char cQ = aVar.q();
        if (cQ == 0) {
            cVar.q(tokeniserState);
            aVar.a();
            cVar.i(replacementChar);
        } else if (cQ == '<') {
            cVar.a(tokeniserState2);
        } else if (cQ != 65535) {
            cVar.k(aVar.m('<', 0));
        } else {
            cVar.j(new Token.e());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void readEndTag(c cVar, a aVar, TokeniserState tokeniserState, TokeniserState tokeniserState2) {
        if (aVar.C()) {
            cVar.g(false);
            cVar.u(tokeniserState);
        } else {
            cVar.k("</");
            cVar.u(tokeniserState2);
        }
    }

    public abstract void read(c cVar, a aVar);
}
