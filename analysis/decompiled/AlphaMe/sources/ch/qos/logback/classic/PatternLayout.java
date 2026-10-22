package ch.qos.logback.classic;

import ch.qos.logback.classic.pattern.CallerDataConverter;
import ch.qos.logback.classic.pattern.ClassOfCallerConverter;
import ch.qos.logback.classic.pattern.ContextNameConverter;
import ch.qos.logback.classic.pattern.DateConverter;
import ch.qos.logback.classic.pattern.EnsureExceptionHandling;
import ch.qos.logback.classic.pattern.ExtendedThrowableProxyConverter;
import ch.qos.logback.classic.pattern.FileOfCallerConverter;
import ch.qos.logback.classic.pattern.LevelConverter;
import ch.qos.logback.classic.pattern.LineOfCallerConverter;
import ch.qos.logback.classic.pattern.LineSeparatorConverter;
import ch.qos.logback.classic.pattern.LocalSequenceNumberConverter;
import ch.qos.logback.classic.pattern.LoggerConverter;
import ch.qos.logback.classic.pattern.MDCConverter;
import ch.qos.logback.classic.pattern.MarkerConverter;
import ch.qos.logback.classic.pattern.MessageConverter;
import ch.qos.logback.classic.pattern.MethodOfCallerConverter;
import ch.qos.logback.classic.pattern.NopThrowableInformationConverter;
import ch.qos.logback.classic.pattern.PropertyConverter;
import ch.qos.logback.classic.pattern.RelativeTimeConverter;
import ch.qos.logback.classic.pattern.RootCauseFirstThrowableProxyConverter;
import ch.qos.logback.classic.pattern.ThreadConverter;
import ch.qos.logback.classic.pattern.ThrowableProxyConverter;
import ch.qos.logback.classic.pattern.color.HighlightingCompositeConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.joran.action.Action;
import ch.qos.logback.core.pattern.PatternLayoutBase;
import ch.qos.logback.core.pattern.color.ANSIConstants;
import ch.qos.logback.core.pattern.color.BlackCompositeConverter;
import ch.qos.logback.core.pattern.color.BlueCompositeConverter;
import ch.qos.logback.core.pattern.color.BoldBlueCompositeConverter;
import ch.qos.logback.core.pattern.color.BoldCyanCompositeConverter;
import ch.qos.logback.core.pattern.color.BoldGreenCompositeConverter;
import ch.qos.logback.core.pattern.color.BoldMagentaCompositeConverter;
import ch.qos.logback.core.pattern.color.BoldRedCompositeConverter;
import ch.qos.logback.core.pattern.color.BoldWhiteCompositeConverter;
import ch.qos.logback.core.pattern.color.BoldYellowCompositeConverter;
import ch.qos.logback.core.pattern.color.CyanCompositeConverter;
import ch.qos.logback.core.pattern.color.GrayCompositeConverter;
import ch.qos.logback.core.pattern.color.GreenCompositeConverter;
import ch.qos.logback.core.pattern.color.MagentaCompositeConverter;
import ch.qos.logback.core.pattern.color.RedCompositeConverter;
import ch.qos.logback.core.pattern.color.WhiteCompositeConverter;
import ch.qos.logback.core.pattern.color.YellowCompositeConverter;
import ch.qos.logback.core.pattern.parser.Parser;
import ch.qos.logback.core.rolling.helper.DateTokenConverter;
import com.stepos.alphame.utils.Property;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class PatternLayout extends PatternLayoutBase<ILoggingEvent> {
    public static final String HEADER_PREFIX = "#logback.classic pattern: ";
    public static final Map<String, String> defaultConverterMap;

    static {
        HashMap map = new HashMap();
        defaultConverterMap = map;
        map.putAll(Parser.DEFAULT_COMPOSITE_CONVERTER_MAP);
        map.put(DateTokenConverter.CONVERTER_KEY, DateConverter.class.getName());
        map.put("date", DateConverter.class.getName());
        map.put("r", RelativeTimeConverter.class.getName());
        map.put("relative", RelativeTimeConverter.class.getName());
        map.put("level", LevelConverter.class.getName());
        map.put("le", LevelConverter.class.getName());
        map.put("p", LevelConverter.class.getName());
        map.put("t", ThreadConverter.class.getName());
        map.put("thread", ThreadConverter.class.getName());
        map.put("lo", LoggerConverter.class.getName());
        map.put("logger", LoggerConverter.class.getName());
        map.put("c", LoggerConverter.class.getName());
        map.put(ANSIConstants.ESC_END, MessageConverter.class.getName());
        map.put("msg", MessageConverter.class.getName());
        map.put("message", MessageConverter.class.getName());
        map.put("C", ClassOfCallerConverter.class.getName());
        map.put(Action.CLASS_ATTRIBUTE, ClassOfCallerConverter.class.getName());
        map.put("M", MethodOfCallerConverter.class.getName());
        map.put("method", MethodOfCallerConverter.class.getName());
        map.put("L", LineOfCallerConverter.class.getName());
        map.put("line", LineOfCallerConverter.class.getName());
        map.put("F", FileOfCallerConverter.class.getName());
        map.put(Action.FILE_ATTRIBUTE, FileOfCallerConverter.class.getName());
        map.put("X", MDCConverter.class.getName());
        map.put("mdc", MDCConverter.class.getName());
        map.put("ex", ThrowableProxyConverter.class.getName());
        map.put("exception", ThrowableProxyConverter.class.getName());
        map.put("rEx", RootCauseFirstThrowableProxyConverter.class.getName());
        map.put("rootException", RootCauseFirstThrowableProxyConverter.class.getName());
        map.put("throwable", ThrowableProxyConverter.class.getName());
        map.put("xEx", ExtendedThrowableProxyConverter.class.getName());
        map.put("xException", ExtendedThrowableProxyConverter.class.getName());
        map.put("xThrowable", ExtendedThrowableProxyConverter.class.getName());
        map.put("nopex", NopThrowableInformationConverter.class.getName());
        map.put("nopexception", NopThrowableInformationConverter.class.getName());
        map.put("cn", ContextNameConverter.class.getName());
        map.put("contextName", ContextNameConverter.class.getName());
        map.put("caller", CallerDataConverter.class.getName());
        map.put("marker", MarkerConverter.class.getName());
        map.put(Property.SHARED_PREFERENCES_NAME, PropertyConverter.class.getName());
        map.put("n", LineSeparatorConverter.class.getName());
        map.put("black", BlackCompositeConverter.class.getName());
        map.put("red", RedCompositeConverter.class.getName());
        map.put("green", GreenCompositeConverter.class.getName());
        map.put("yellow", YellowCompositeConverter.class.getName());
        map.put("blue", BlueCompositeConverter.class.getName());
        map.put("magenta", MagentaCompositeConverter.class.getName());
        map.put("cyan", CyanCompositeConverter.class.getName());
        map.put("white", WhiteCompositeConverter.class.getName());
        map.put("gray", GrayCompositeConverter.class.getName());
        map.put("boldRed", BoldRedCompositeConverter.class.getName());
        map.put("boldGreen", BoldGreenCompositeConverter.class.getName());
        map.put("boldYellow", BoldYellowCompositeConverter.class.getName());
        map.put("boldBlue", BoldBlueCompositeConverter.class.getName());
        map.put("boldMagenta", BoldMagentaCompositeConverter.class.getName());
        map.put("boldCyan", BoldCyanCompositeConverter.class.getName());
        map.put("boldWhite", BoldWhiteCompositeConverter.class.getName());
        map.put("highlight", HighlightingCompositeConverter.class.getName());
        map.put("lsn", LocalSequenceNumberConverter.class.getName());
    }

    public PatternLayout() {
        this.postCompileProcessor = new EnsureExceptionHandling();
    }

    @Override // ch.qos.logback.core.pattern.PatternLayoutBase
    public Map<String, String> getDefaultConverterMap() {
        return defaultConverterMap;
    }

    @Override // ch.qos.logback.core.pattern.PatternLayoutBase
    public String getPresentationHeaderPrefix() {
        return HEADER_PREFIX;
    }

    @Override // ch.qos.logback.core.Layout
    public String doLayout(ILoggingEvent iLoggingEvent) {
        return !isStarted() ? "" : writeLoopOnConverters(iLoggingEvent);
    }
}
