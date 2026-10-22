package org.yaml.snakeyaml.tokens;

import O6.l;
import com.autonavi.aps.amapapi.config.Const;
import io.ktor.sse.ServerSentEventKt;
import org.yaml.snakeyaml.error.Mark;
import org.yaml.snakeyaml.error.YAMLException;

/* loaded from: classes5.dex */
public abstract class Token {
    private final Mark endMark;
    private final Mark startMark;

    public enum ID {
        Alias("<alias>"),
        Anchor("<anchor>"),
        BlockEnd("<block end>"),
        BlockEntry(l.DATE_SEPARATOR),
        BlockMappingStart("<block mapping start>"),
        BlockSequenceStart("<block sequence start>"),
        Directive("<directive>"),
        DocumentEnd("<document end>"),
        DocumentStart("<document start>"),
        FlowEntry(Const.STR_MART_COMMA),
        FlowMappingEnd("}"),
        FlowMappingStart(Const.STR_MART_JSON_BEGIN),
        FlowSequenceEnd("]"),
        FlowSequenceStart("["),
        Key("?"),
        Scalar("<scalar>"),
        StreamEnd("<stream end>"),
        StreamStart("<stream start>"),
        Tag("<tag>"),
        Value(ServerSentEventKt.COLON),
        Whitespace("<whitespace>"),
        Comment(Const.STR_MART_WELL),
        Error("<error>");

        private final String description;

        ID(String str) {
            this.description = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.description;
        }
    }

    public Token(Mark mark, Mark mark2) {
        if (mark == null || mark2 == null) {
            throw new YAMLException("Token requires marks.");
        }
        this.startMark = mark;
        this.endMark = mark2;
    }

    public Mark getEndMark() {
        return this.endMark;
    }

    public Mark getStartMark() {
        return this.startMark;
    }

    public abstract ID getTokenId();
}
